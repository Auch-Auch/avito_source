package com.yandex.metrica;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.as;
import com.yandex.metrica.impl.ob.dl;
import com.yandex.metrica.impl.ob.du;
import com.yandex.metrica.impl.ob.dv;
import com.yandex.metrica.impl.ob.ke;
import com.yandex.metrica.impl.ob.ki;
import com.yandex.metrica.impl.ob.km;
import com.yandex.metrica.impl.ob.kp;
import com.yandex.metrica.impl.ob.kq;
import com.yandex.metrica.impl.ob.kr;
import java.util.HashMap;
import java.util.Map;
public class ConfigurationService extends Service {
    @NonNull
    public Map<String, kp> a = new HashMap();
    public ki b;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        as.a(getApplicationContext());
        String.format("[ConfigurationService:%s]", getPackageName());
        this.b = new ki();
        Context applicationContext = getApplicationContext();
        km kmVar = new km(applicationContext, this.b.a(), new ke(applicationContext));
        this.a.put("com.yandex.metrica.configuration.ACTION_INIT", new kr(getApplicationContext(), kmVar, dl.a(21) ? new du(applicationContext, new dv(applicationContext)) : null));
        this.a.put("com.yandex.metrica.configuration.ACTION_SCHEDULED_START", new kq(getApplicationContext(), kmVar));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Bundle bundle = null;
        kp kpVar = this.a.get(intent == null ? null : intent.getAction());
        if (kpVar == null) {
            return 2;
        }
        ki kiVar = this.b;
        if (intent != null) {
            bundle = intent.getExtras();
        }
        kiVar.a(kpVar, bundle);
        return 2;
    }
}
