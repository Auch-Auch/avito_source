package com.yandex.metrica;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import com.yandex.metrica.impl.ob.kn;
public class m implements kn {
    public final /* synthetic */ JobParameters a;
    public final /* synthetic */ JobWorkItem b;
    public final /* synthetic */ ConfigurationJobService c;

    public m(ConfigurationJobService configurationJobService, JobParameters jobParameters, JobWorkItem jobWorkItem) {
        this.c = configurationJobService;
        this.a = jobParameters;
        this.b = jobWorkItem;
    }

    @Override // com.yandex.metrica.impl.ob.kn
    public void a() {
        try {
            this.a.completeWork(this.b);
            ConfigurationJobService configurationJobService = this.c;
            configurationJobService.a.a().a(new k(configurationJobService, this.a));
        } catch (Throwable unused) {
        }
    }
}
