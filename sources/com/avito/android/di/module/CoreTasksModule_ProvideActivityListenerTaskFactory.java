package com.avito.android.di.module;

import com.avito.android.app.ActivityProvider;
import com.avito.android.app.task.ActivityListenerTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreTasksModule_ProvideActivityListenerTaskFactory implements Factory<ActivityListenerTask> {
    public final Provider<ActivityProvider> a;

    public CoreTasksModule_ProvideActivityListenerTaskFactory(Provider<ActivityProvider> provider) {
        this.a = provider;
    }

    public static CoreTasksModule_ProvideActivityListenerTaskFactory create(Provider<ActivityProvider> provider) {
        return new CoreTasksModule_ProvideActivityListenerTaskFactory(provider);
    }

    public static ActivityListenerTask provideActivityListenerTask(ActivityProvider activityProvider) {
        return (ActivityListenerTask) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.provideActivityListenerTask(activityProvider));
    }

    @Override // javax.inject.Provider
    public ActivityListenerTask get() {
        return provideActivityListenerTask(this.a.get());
    }
}
