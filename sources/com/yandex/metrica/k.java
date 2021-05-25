package com.yandex.metrica;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;
import com.yandex.metrica.impl.ob.kp;
import java.util.Objects;
public class k implements Runnable {
    public final /* synthetic */ JobParameters a;
    public final /* synthetic */ ConfigurationJobService b;

    public k(ConfigurationJobService configurationJobService, JobParameters jobParameters) {
        this.b = configurationJobService;
        this.a = jobParameters;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConfigurationJobService configurationJobService = this.b;
        JobParameters jobParameters = this.a;
        int i = ConfigurationJobService.d;
        Objects.requireNonNull(configurationJobService);
        while (true) {
            try {
                JobWorkItem dequeueWork = jobParameters.dequeueWork();
                if (dequeueWork != null) {
                    Intent intent = dequeueWork.getIntent();
                    if (intent != null) {
                        kp kpVar = configurationJobService.c.get(intent.getAction());
                        if (kpVar != null) {
                            configurationJobService.a.a(kpVar, intent.getExtras(), new m(configurationJobService, jobParameters, dequeueWork));
                        } else {
                            jobParameters.completeWork(dequeueWork);
                        }
                    } else {
                        jobParameters.completeWork(dequeueWork);
                    }
                } else {
                    return;
                }
            } catch (Throwable unused) {
                configurationJobService.jobFinished(jobParameters, true);
                return;
            }
        }
    }
}
