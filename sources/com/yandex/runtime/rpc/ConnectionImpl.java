package com.yandex.runtime.rpc;

import a2.b.a.a.a;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.yandex.runtime.Runtime;
import com.yandex.runtime.logging.Logger;
import com.yandex.runtime.rpc.IClient;
import com.yandex.runtime.rpc.IService;
import com.yandex.runtime.rpc.internal.Connection;
public class ConnectionImpl implements Connection {
    private static final long CALLBACK_WAIT_DELAY = 30000;
    private static final long DELAY_BEFORE_RECONNECT = 5000;
    private static final int RECONNECT_ATTEMPT_LIMIT = 60;
    private String appPackage_;
    private Handler callbackIsNotCalledHandler_ = new Handler();
    private ServiceConnection connection_ = null;
    private IService iService_ = null;
    private Handler reconnectHandler_ = new Handler();
    private String serviceName_;

    public ConnectionImpl(String str, String str2) {
        this.appPackage_ = str;
        this.serviceName_ = str2;
    }

    private void checkUIThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AssertionError("Non-UI thread");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reconnect(final Client client, final ConnectionStateListener connectionStateListener, final int i) {
        if (i != 60 && !connect(client, connectionStateListener)) {
            disconnect();
            this.reconnectHandler_.postDelayed(new Runnable() { // from class: com.yandex.runtime.rpc.ConnectionImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionImpl.this.reconnect(client, connectionStateListener, i + 1);
                }
            }, 5000);
        }
    }

    @Override // com.yandex.runtime.rpc.internal.Connection
    public boolean connect(final Client client, final ConnectionStateListener connectionStateListener) {
        checkUIThread();
        if (this.connection_ != null) {
            throw new AssertionError("Attempt to connect RPC client more than once");
        } else if (connectionStateListener != null) {
            this.connection_ = new ServiceConnection() { // from class: com.yandex.runtime.rpc.ConnectionImpl.1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    ConnectionImpl.this.callbackIsNotCalledHandler_.removeCallbacksAndMessages(null);
                    ConnectionImpl.this.iService_ = IService.Stub.asInterface(iBinder);
                    try {
                        ConnectionImpl.this.iService_.addClient(new IClient.Stub() { // from class: com.yandex.runtime.rpc.ConnectionImpl.1.1
                            @Override // com.yandex.runtime.rpc.IClient
                            public void handle(byte[] bArr) {
                                client.handle(bArr);
                            }
                        }, ConnectionImpl.this.serviceName_);
                        connectionStateListener.onConnectionStateChanged(true);
                    } catch (TransactionTooLargeException e) {
                        Logger.error(e.getMessage());
                    } catch (RemoteException unused) {
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    ConnectionImpl.this.callbackIsNotCalledHandler_.removeCallbacksAndMessages(null);
                    connectionStateListener.onConnectionStateChanged(false);
                    ConnectionImpl.this.disconnect();
                    ConnectionImpl.this.reconnect(client, connectionStateListener, 0);
                }
            };
            Intent intent = new Intent();
            intent.setClassName(this.appPackage_, IServiceImpl.class.getName());
            try {
                boolean bindService = Runtime.getApplicationContext().bindService(intent, this.connection_, 1);
                if (bindService) {
                    this.callbackIsNotCalledHandler_.postDelayed(new Runnable() { // from class: com.yandex.runtime.rpc.ConnectionImpl.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ConnectionImpl.this.disconnect();
                            ConnectionImpl.this.reconnect(client, connectionStateListener, 0);
                        }
                    }, 30000);
                }
                return bindService;
            } catch (SecurityException unused) {
                StringBuilder L = a.L("Service ");
                L.append(IServiceImpl.class.getName());
                L.append(" is not found");
                Logger.error(L.toString());
                return false;
            }
        } else {
            throw new AssertionError("Connection state listener can't be null");
        }
    }

    @Override // com.yandex.runtime.rpc.internal.Connection
    public void disconnect() {
        checkUIThread();
        if (this.connection_ != null) {
            Runtime.getApplicationContext().unbindService(this.connection_);
            this.connection_ = null;
            this.iService_ = null;
        }
    }

    @Override // com.yandex.runtime.rpc.internal.Connection
    public SendDataResult sendData(byte[] bArr) {
        checkUIThread();
        IService iService = this.iService_;
        if (iService == null) {
            return SendDataResult.NO_CONNECTION;
        }
        try {
            iService.sendData(bArr, this.serviceName_);
            return SendDataResult.SUCCESS;
        } catch (TransactionTooLargeException e) {
            Logger.error(e.getMessage());
            return SendDataResult.TOO_LARGE_DATA;
        } catch (RemoteException unused) {
            return SendDataResult.REMOTE_ERROR;
        }
    }
}
