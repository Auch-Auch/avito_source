package com.yandex.metrica;

import android.app.job.JobParameters;
import com.yandex.metrica.impl.ob.kn;
public class l implements kn {
    public final /* synthetic */ JobParameters a;
    public final /* synthetic */ ConfigurationJobService b;

    public l(ConfigurationJobService configurationJobService, JobParameters jobParameters) {
        this.b = configurationJobService;
        this.a = jobParameters;
    }

    @Override // com.yandex.metrica.impl.ob.kn
    public void a() {
        try {
            this.b.jobFinished(this.a, false);
        } catch (Throwable unused) {
        }
    }
}
