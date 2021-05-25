package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.ConfigurationJobService;
@TargetApi(26)
public class kc implements kd, kg {
    @NonNull
    private final Context a;
    @Nullable
    private final JobScheduler b;

    public kc(@NonNull Context context) {
        this(context, (JobScheduler) context.getSystemService("jobscheduler"));
    }

    @Override // com.yandex.metrica.impl.ob.kg
    public void a(long j, boolean z) {
        final JobInfo.Builder minimumLatency = new JobInfo.Builder(1512302345, new ComponentName(this.a.getPackageName(), ConfigurationJobService.class.getName())).setMinimumLatency(j);
        if (z) {
            minimumLatency.setOverrideDeadline(j);
        }
        dl.a(new abz<JobScheduler>() { // from class: com.yandex.metrica.impl.ob.kc.1
            public void a(@NonNull JobScheduler jobScheduler) throws Throwable {
                jobScheduler.schedule(minimumLatency.build());
            }
        }, this.b, "scheduling wakeup in [ConfigurationJobServiceController]", "JobScheduler");
    }

    public void b(@Nullable Bundle bundle) {
        Intent intent = new Intent("com.yandex.metrica.configuration.service.PLC");
        if (bundle == null) {
            bundle = new Bundle();
        }
        final JobWorkItem jobWorkItem = new JobWorkItem(intent.putExtras(bundle));
        final JobInfo build = new JobInfo.Builder(1512302347, new ComponentName(this.a.getPackageName(), ConfigurationJobService.class.getName())).setOverrideDeadline(10).build();
        dl.a(new abz<JobScheduler>() { // from class: com.yandex.metrica.impl.ob.kc.4
            public void a(@NonNull JobScheduler jobScheduler) {
                jobScheduler.enqueue(build, jobWorkItem);
            }
        }, this.b, "ble callback", "JobScheduler");
    }

    @VisibleForTesting
    public kc(@NonNull Context context, @Nullable JobScheduler jobScheduler) {
        this.a = context;
        this.b = jobScheduler;
    }

    @Override // com.yandex.metrica.impl.ob.kg
    public void a() {
        dl.a(new abz<JobScheduler>() { // from class: com.yandex.metrica.impl.ob.kc.2
            public void a(@NonNull JobScheduler jobScheduler) {
                jobScheduler.cancel(1512302345);
            }
        }, this.b, "cancelling scheduled wakeup in [ConfigurationJobServiceController]", "JobScheduler");
    }

    @Override // com.yandex.metrica.impl.ob.kd
    public void a(@NonNull Bundle bundle) {
        final JobInfo build = new JobInfo.Builder(1512302346, new ComponentName(this.a.getPackageName(), ConfigurationJobService.class.getName())).setTransientExtras(bundle).setOverrideDeadline(10).build();
        dl.a(new abz<JobScheduler>() { // from class: com.yandex.metrica.impl.ob.kc.3
            public void a(@NonNull JobScheduler jobScheduler) throws Throwable {
                jobScheduler.schedule(build);
            }
        }, this.b, "launching [ConfigurationJobServiceController] command", "JobScheduler");
    }
}
