package com.yandex.metrica;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.yandex.metrica.impl.ob.as;
import com.yandex.metrica.impl.ob.du;
import com.yandex.metrica.impl.ob.dw;
import com.yandex.metrica.impl.ob.kc;
import com.yandex.metrica.impl.ob.ki;
import com.yandex.metrica.impl.ob.km;
import com.yandex.metrica.impl.ob.ko;
import com.yandex.metrica.impl.ob.kp;
import com.yandex.metrica.impl.ob.kq;
import com.yandex.metrica.impl.ob.kr;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
@TargetApi(26)
public class ConfigurationJobService extends JobService {
    public static final /* synthetic */ int d = 0;
    public ki a;
    @NonNull
    public SparseArray<kp> b = new SparseArray<>();
    @NonNull
    public Map<String, kp> c = new HashMap();

    public boolean complexJob(int i) {
        return i == 1512302347;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        as.a(getApplicationContext());
        Context applicationContext = getApplicationContext();
        String.format(Locale.US, "[ConfigurationJobService:%s]", applicationContext.getPackageName());
        this.a = new ki();
        km kmVar = new km(getApplicationContext(), this.a.a(), new kc(applicationContext));
        du duVar = new du(applicationContext, new dw(applicationContext));
        this.b.append(1512302345, new kq(getApplicationContext(), kmVar));
        this.b.append(1512302346, new kr(getApplicationContext(), kmVar, duVar));
        this.c.put("com.yandex.metrica.configuration.service.PLC", new ko(applicationContext, this.a.a()));
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(@Nullable JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        try {
            if (complexJob(jobParameters.getJobId())) {
                this.a.a().a(new k(this, jobParameters));
            } else {
                kp kpVar = this.b.get(jobParameters.getJobId());
                if (kpVar == null) {
                    return false;
                }
                this.a.a(kpVar, jobParameters.getTransientExtras(), new l(this, jobParameters));
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(@Nullable JobParameters jobParameters) {
        return jobParameters != null && complexJob(jobParameters.getJobId());
    }
}
