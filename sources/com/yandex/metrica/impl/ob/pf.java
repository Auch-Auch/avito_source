package com.yandex.metrica.impl.ob;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.pc;
import com.yandex.metrica.impl.ob.pg;
import java.util.concurrent.CountDownLatch;
public class pf implements pd {
    private static final Intent a = new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid");
    private final ado b = new ado();

    public class a implements ServiceConnection {
        private pg b;
        private final CountDownLatch c;

        public pg a() throws InterruptedException {
            this.c.await();
            return this.b;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.b = pg.a.a(iBinder);
            this.c.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
            this.c = new CountDownLatch(1);
        }
    }

    @Override // com.yandex.metrica.impl.ob.pd
    @Nullable
    public pc a(@NonNull Context context) {
        a aVar = new a();
        ado ado = this.b;
        Intent intent = a;
        if (ado.c(context, intent, 0) != null && context.bindService(intent, aVar, 1)) {
            try {
                pg a3 = aVar.a();
                pc pcVar = new pc(pc.a.HMS, a3.a(), Boolean.valueOf(a3.b()));
                context.unbindService(aVar);
                return pcVar;
            } catch (Throwable unused) {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
