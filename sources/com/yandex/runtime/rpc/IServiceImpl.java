package com.yandex.runtime.rpc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.yandex.runtime.Runtime;
import com.yandex.runtime.logging.Logger;
import com.yandex.runtime.rpc.IService;
import com.yandex.runtime.rpc.internal.ServiceManagerFactory;
public class IServiceImpl extends Service {
    private final IService.Stub binder_ = new IService.Stub() { // from class: com.yandex.runtime.rpc.IServiceImpl.1
        private boolean checkSignatures() {
            int i;
            Context applicationContext = Runtime.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            int checkSignatures = packageManager.checkSignatures(packageName, getCallerPackageName());
            try {
                i = packageManager.getApplicationInfo(packageName, 0).flags;
            } catch (PackageManager.NameNotFoundException unused) {
                i = 0;
            }
            if (((i & 2) != 0) || checkSignatures == 0) {
                return true;
            }
            return false;
        }

        private String getCallerPackageName() {
            return Runtime.getApplicationContext().getPackageManager().getNameForUid(Binder.getCallingUid());
        }

        @Override // com.yandex.runtime.rpc.IService
        public void addClient(final IClient iClient, String str) {
            final String callerPackageName = getCallerPackageName();
            AnonymousClass1 r1 = new ServiceClient() { // from class: com.yandex.runtime.rpc.IServiceImpl.1.1
                @Override // com.yandex.runtime.rpc.ServiceClient
                public String clientId() {
                    return callerPackageName;
                }

                @Override // com.yandex.runtime.rpc.ServiceClient
                public boolean handle(byte[] bArr) {
                    try {
                        iClient.handle(bArr);
                        return true;
                    } catch (RemoteException unused) {
                        return false;
                    }
                }
            };
            if (!checkSignatures()) {
                Logger.error("Client has a different signature");
            } else {
                ServiceManagerFactory.getServiceManager().addClientToService(r1, str);
            }
        }

        @Override // com.yandex.runtime.rpc.IService
        public void sendData(byte[] bArr, String str) {
            if (!checkSignatures()) {
                Logger.error("Client has a different signature");
            } else {
                ServiceManagerFactory.getServiceManager().sendDataToService(bArr, str, getCallerPackageName());
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        RPC.notifyOnFirstConnect();
        return this.binder_;
    }
}
