package com.avito.android.in_app_calls.di;

import com.avito.android.Features;
import com.avito.android.TypedLazy;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.in_app_calls.logging.DeleteCallLogsTask;
import com.avito.android.in_app_calls.task.InitCallClientTask;
import com.avito.android.in_app_calls.task.MicAccessTrackingTask;
import com.avito.android.in_app_calls.task.SetupCallNotificationChannelTask;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class InAppCallsTasksModule_ProviderInAppCallsTasksFactory implements Factory<Set<TypedLazy<? extends ApplicationBackgroundStartupTask>>> {
    public final InAppCallsTasksModule a;
    public final Provider<MicAccessTrackingTask> b;
    public final Provider<InitCallClientTask> c;
    public final Provider<SetupCallNotificationChannelTask> d;
    public final Provider<DeleteCallLogsTask> e;
    public final Provider<Features> f;

    public InAppCallsTasksModule_ProviderInAppCallsTasksFactory(InAppCallsTasksModule inAppCallsTasksModule, Provider<MicAccessTrackingTask> provider, Provider<InitCallClientTask> provider2, Provider<SetupCallNotificationChannelTask> provider3, Provider<DeleteCallLogsTask> provider4, Provider<Features> provider5) {
        this.a = inAppCallsTasksModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
    }

    public static InAppCallsTasksModule_ProviderInAppCallsTasksFactory create(InAppCallsTasksModule inAppCallsTasksModule, Provider<MicAccessTrackingTask> provider, Provider<InitCallClientTask> provider2, Provider<SetupCallNotificationChannelTask> provider3, Provider<DeleteCallLogsTask> provider4, Provider<Features> provider5) {
        return new InAppCallsTasksModule_ProviderInAppCallsTasksFactory(inAppCallsTasksModule, provider, provider2, provider3, provider4, provider5);
    }

    public static Set<TypedLazy<? extends ApplicationBackgroundStartupTask>> providerInAppCallsTasks(InAppCallsTasksModule inAppCallsTasksModule, Lazy<MicAccessTrackingTask> lazy, Lazy<InitCallClientTask> lazy2, Lazy<SetupCallNotificationChannelTask> lazy3, Lazy<DeleteCallLogsTask> lazy4, Features features) {
        return (Set) Preconditions.checkNotNullFromProvides(inAppCallsTasksModule.providerInAppCallsTasks(lazy, lazy2, lazy3, lazy4, features));
    }

    @Override // javax.inject.Provider
    public Set<TypedLazy<? extends ApplicationBackgroundStartupTask>> get() {
        return providerInAppCallsTasks(this.a, DoubleCheck.lazy(this.b), DoubleCheck.lazy(this.c), DoubleCheck.lazy(this.d), DoubleCheck.lazy(this.e), this.f.get());
    }
}
