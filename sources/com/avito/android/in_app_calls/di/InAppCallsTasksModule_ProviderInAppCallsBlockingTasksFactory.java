package com.avito.android.in_app_calls.di;

import com.avito.android.Features;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.in_app_calls.task.InitCallsTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class InAppCallsTasksModule_ProviderInAppCallsBlockingTasksFactory implements Factory<Set<ApplicationBlockingStartupTask>> {
    public final InAppCallsTasksModule a;
    public final Provider<InitCallsTask> b;
    public final Provider<Features> c;

    public InAppCallsTasksModule_ProviderInAppCallsBlockingTasksFactory(InAppCallsTasksModule inAppCallsTasksModule, Provider<InitCallsTask> provider, Provider<Features> provider2) {
        this.a = inAppCallsTasksModule;
        this.b = provider;
        this.c = provider2;
    }

    public static InAppCallsTasksModule_ProviderInAppCallsBlockingTasksFactory create(InAppCallsTasksModule inAppCallsTasksModule, Provider<InitCallsTask> provider, Provider<Features> provider2) {
        return new InAppCallsTasksModule_ProviderInAppCallsBlockingTasksFactory(inAppCallsTasksModule, provider, provider2);
    }

    public static Set<ApplicationBlockingStartupTask> providerInAppCallsBlockingTasks(InAppCallsTasksModule inAppCallsTasksModule, InitCallsTask initCallsTask, Features features) {
        return (Set) Preconditions.checkNotNullFromProvides(inAppCallsTasksModule.providerInAppCallsBlockingTasks(initCallsTask, features));
    }

    @Override // javax.inject.Provider
    public Set<ApplicationBlockingStartupTask> get() {
        return providerInAppCallsBlockingTasks(this.a, this.b.get(), this.c.get());
    }
}
