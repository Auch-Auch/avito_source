package com.avito.android.in_app_calls.task;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.workers.CallAvailabilityUpdater;
import com.avito.android.permissions.PermissionStateProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InitCallClientTask_Factory implements Factory<InitCallClientTask> {
    public final Provider<CallAvailabilityUpdater> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<PermissionStateProvider> c;
    public final Provider<AccountStateProvider> d;
    public final Provider<Features> e;
    public final Provider<ErrorTracker> f;

    public InitCallClientTask_Factory(Provider<CallAvailabilityUpdater> provider, Provider<SchedulersFactory3> provider2, Provider<PermissionStateProvider> provider3, Provider<AccountStateProvider> provider4, Provider<Features> provider5, Provider<ErrorTracker> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static InitCallClientTask_Factory create(Provider<CallAvailabilityUpdater> provider, Provider<SchedulersFactory3> provider2, Provider<PermissionStateProvider> provider3, Provider<AccountStateProvider> provider4, Provider<Features> provider5, Provider<ErrorTracker> provider6) {
        return new InitCallClientTask_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static InitCallClientTask newInstance(CallAvailabilityUpdater callAvailabilityUpdater, SchedulersFactory3 schedulersFactory3, PermissionStateProvider permissionStateProvider, AccountStateProvider accountStateProvider, Features features, ErrorTracker errorTracker) {
        return new InitCallClientTask(callAvailabilityUpdater, schedulersFactory3, permissionStateProvider, accountStateProvider, features, errorTracker);
    }

    @Override // javax.inject.Provider
    public InitCallClientTask get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
