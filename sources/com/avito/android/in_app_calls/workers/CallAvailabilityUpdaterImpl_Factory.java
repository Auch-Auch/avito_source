package com.avito.android.in_app_calls.workers;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.calls.CallClientAvailabilityNotifier;
import com.avito.android.in_app_calls.CallManager;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallAvailabilityUpdaterImpl_Factory implements Factory<CallAvailabilityUpdaterImpl> {
    public final Provider<Features> a;
    public final Provider<CallManager> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<PermissionChecker> d;
    public final Provider<CallClientAvailabilityNotifier> e;
    public final Provider<SchedulersFactory3> f;

    public CallAvailabilityUpdaterImpl_Factory(Provider<Features> provider, Provider<CallManager> provider2, Provider<AccountStateProvider> provider3, Provider<PermissionChecker> provider4, Provider<CallClientAvailabilityNotifier> provider5, Provider<SchedulersFactory3> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static CallAvailabilityUpdaterImpl_Factory create(Provider<Features> provider, Provider<CallManager> provider2, Provider<AccountStateProvider> provider3, Provider<PermissionChecker> provider4, Provider<CallClientAvailabilityNotifier> provider5, Provider<SchedulersFactory3> provider6) {
        return new CallAvailabilityUpdaterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CallAvailabilityUpdaterImpl newInstance(Features features, CallManager callManager, AccountStateProvider accountStateProvider, PermissionChecker permissionChecker, CallClientAvailabilityNotifier callClientAvailabilityNotifier, SchedulersFactory3 schedulersFactory3) {
        return new CallAvailabilityUpdaterImpl(features, callManager, accountStateProvider, permissionChecker, callClientAvailabilityNotifier, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public CallAvailabilityUpdaterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
