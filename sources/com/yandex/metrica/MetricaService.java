package com.yandex.metrica;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.impl.ob.abe;
import com.yandex.metrica.impl.ob.as;
import com.yandex.metrica.impl.ob.bo;
import com.yandex.metrica.impl.ob.bp;
import com.yandex.metrica.impl.ob.bq;
import com.yandex.metrica.impl.ob.cg;
import com.yandex.metrica.impl.ob.da;
import com.yandex.metrica.impl.ob.eh;
import com.yandex.metrica.impl.ob.ep;
public class MetricaService extends Service {
    public c a = new a();
    public bo b;
    public final IMetricaService.a c = new b();

    public class a implements c {
        public a() {
        }

        @Override // com.yandex.metrica.MetricaService.c
        public void a(int i) {
            MetricaService.this.stopSelfResult(i);
        }
    }

    public interface c {
        void a(int i);
    }

    public static class d extends Binder {
    }

    public static class e extends Binder {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder;
        String action = intent.getAction();
        if ("com.yandex.metrica.ACTION_BIND_TO_LOCAL_SERVER".equals(action)) {
            iBinder = new e();
        } else if ("com.yandex.metrica.ACTION_C_BG_L".equals(action)) {
            iBinder = new d();
        } else {
            iBinder = this.c;
        }
        this.b.a(intent);
        return iBinder;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        eh.a().b(new ep(cg.a(configuration.locale)));
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        as.a(getApplicationContext());
        eh.a().b(new ep(cg.a(getResources().getConfiguration().locale)));
        abe.a(getApplicationContext());
        bp bpVar = new bp(new bq(getApplicationContext(), this.a));
        this.b = bpVar;
        bpVar.a();
        as.a().a(new da(this.b));
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.b.b();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        this.b.b(intent);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        this.b.a(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.b.a(intent, i, i2);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        this.b.c(intent);
        String action = intent.getAction();
        if ("com.yandex.metrica.ACTION_BIND_TO_LOCAL_SERVER".equals(action)) {
            return false;
        }
        if ("com.yandex.metrica.ACTION_C_BG_L".equals(action)) {
            return true;
        }
        if (intent.getData() == null) {
            return false;
        }
        return true;
    }

    public class b extends IMetricaService.a {
        public b() {
        }

        @Override // com.yandex.metrica.IMetricaService
        @Deprecated
        public void a(String str, int i, String str2, Bundle bundle) throws RemoteException {
            MetricaService.this.b.a(str, i, str2, bundle);
        }

        @Override // com.yandex.metrica.IMetricaService
        public void b(@NonNull Bundle bundle) throws RemoteException {
            MetricaService.this.b.b(bundle);
        }

        @Override // com.yandex.metrica.IMetricaService
        public void c(@NonNull Bundle bundle) throws RemoteException {
            MetricaService.this.b.c(bundle);
        }

        @Override // com.yandex.metrica.IMetricaService
        public void a(Bundle bundle) throws RemoteException {
            MetricaService.this.b.a(bundle);
        }
    }
}
