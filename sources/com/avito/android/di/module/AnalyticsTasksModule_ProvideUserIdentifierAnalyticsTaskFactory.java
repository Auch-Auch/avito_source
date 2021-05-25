package com.avito.android.di.module;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics;
import com.avito.android.analytics_adjust.Adjust;
import com.avito.android.app.task.UserIdentifierAnalyticsTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ProvideUserIdentifierAnalyticsTaskFactory implements Factory<UserIdentifierAnalyticsTask> {
    public final Provider<FirebaseCrashlytics> a;
    public final Provider<Adjust> b;
    public final Provider<AccountStateProvider> c;

    public AnalyticsTasksModule_ProvideUserIdentifierAnalyticsTaskFactory(Provider<FirebaseCrashlytics> provider, Provider<Adjust> provider2, Provider<AccountStateProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AnalyticsTasksModule_ProvideUserIdentifierAnalyticsTaskFactory create(Provider<FirebaseCrashlytics> provider, Provider<Adjust> provider2, Provider<AccountStateProvider> provider3) {
        return new AnalyticsTasksModule_ProvideUserIdentifierAnalyticsTaskFactory(provider, provider2, provider3);
    }

    public static UserIdentifierAnalyticsTask provideUserIdentifierAnalyticsTask(FirebaseCrashlytics firebaseCrashlytics, Adjust adjust, AccountStateProvider accountStateProvider) {
        return (UserIdentifierAnalyticsTask) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.INSTANCE.provideUserIdentifierAnalyticsTask(firebaseCrashlytics, adjust, accountStateProvider));
    }

    @Override // javax.inject.Provider
    public UserIdentifierAnalyticsTask get() {
        return provideUserIdentifierAnalyticsTask(this.a.get(), this.b.get(), this.c.get());
    }
}
