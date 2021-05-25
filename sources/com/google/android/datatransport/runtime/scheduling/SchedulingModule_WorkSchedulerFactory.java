package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SchedulingModule_WorkSchedulerFactory implements Factory<WorkScheduler> {
    public final Provider<Context> a;
    public final Provider<EventStore> b;
    public final Provider<SchedulerConfig> c;
    public final Provider<Clock> d;

    public SchedulingModule_WorkSchedulerFactory(Provider<Context> provider, Provider<EventStore> provider2, Provider<SchedulerConfig> provider3, Provider<Clock> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SchedulingModule_WorkSchedulerFactory create(Provider<Context> provider, Provider<EventStore> provider2, Provider<SchedulerConfig> provider3, Provider<Clock> provider4) {
        return new SchedulingModule_WorkSchedulerFactory(provider, provider2, provider3, provider4);
    }

    public static WorkScheduler workScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, Clock clock) {
        return (WorkScheduler) Preconditions.checkNotNull(new JobInfoScheduler(context, eventStore, schedulerConfig), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public WorkScheduler get() {
        return workScheduler(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
