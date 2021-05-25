package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
public abstract class PlatformServiceClient implements ServiceConnection {
    public final Context a;
    public final Handler b;
    public CompletedListener c;
    public boolean d;
    public Messenger e;
    public int f;
    public int g;
    public final String h;
    public final int i;

    public interface CompletedListener {
        void completed(Bundle bundle);
    }

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PlatformServiceClient.this.handleMessage(message);
        }
    }

    public PlatformServiceClient(Context context, int i2, int i3, int i4, String str) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext != null ? applicationContext : context;
        this.f = i2;
        this.g = i3;
        this.h = str;
        this.i = i4;
        this.b = new a();
    }

    public final void a(Bundle bundle) {
        if (this.d) {
            this.d = false;
            CompletedListener completedListener = this.c;
            if (completedListener != null) {
                completedListener.completed(bundle);
            }
        }
    }

    public void cancel() {
        this.d = false;
    }

    public Context getContext() {
        return this.a;
    }

    public void handleMessage(Message message) {
        if (message.what == this.g) {
            Bundle data = message.getData();
            if (data.getString(NativeProtocol.STATUS_ERROR_TYPE) != null) {
                a(null);
            } else {
                a(data);
            }
            try {
                this.a.unbindService(this);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.e = new Messenger(iBinder);
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.EXTRA_APPLICATION_ID, this.h);
        populateRequestBundle(bundle);
        Message obtain = Message.obtain((Handler) null, this.f);
        obtain.arg1 = this.i;
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(this.b);
        try {
            this.e.send(obtain);
        } catch (RemoteException unused) {
            a(null);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.e = null;
        try {
            this.a.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        a(null);
    }

    public abstract void populateRequestBundle(Bundle bundle);

    public void setCompletedListener(CompletedListener completedListener) {
        this.c = completedListener;
    }

    public boolean start() {
        Intent createPlatformServiceIntent;
        if (this.d || NativeProtocol.getLatestAvailableProtocolVersionForService(this.i) == -1 || (createPlatformServiceIntent = NativeProtocol.createPlatformServiceIntent(this.a)) == null) {
            return false;
        }
        this.d = true;
        this.a.bindService(createPlatformServiceIntent, this, 1);
        return true;
    }
}
