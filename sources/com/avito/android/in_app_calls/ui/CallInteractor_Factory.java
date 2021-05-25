package com.avito.android.in_app_calls.ui;

import com.avito.android.Features;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.calls.auth.UsernameProvider;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallInteractor_Factory implements Factory<CallInteractor> {
    public final Provider<CallsApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<NetworkTypeProvider> c;
    public final Provider<UsernameProvider> d;
    public final Provider<Features> e;
    public final Provider<ErrorTracker> f;

    public CallInteractor_Factory(Provider<CallsApi> provider, Provider<SchedulersFactory3> provider2, Provider<NetworkTypeProvider> provider3, Provider<UsernameProvider> provider4, Provider<Features> provider5, Provider<ErrorTracker> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static CallInteractor_Factory create(Provider<CallsApi> provider, Provider<SchedulersFactory3> provider2, Provider<NetworkTypeProvider> provider3, Provider<UsernameProvider> provider4, Provider<Features> provider5, Provider<ErrorTracker> provider6) {
        return new CallInteractor_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CallInteractor newInstance(CallsApi callsApi, SchedulersFactory3 schedulersFactory3, NetworkTypeProvider networkTypeProvider, UsernameProvider usernameProvider, Features features, ErrorTracker errorTracker) {
        return new CallInteractor(callsApi, schedulersFactory3, networkTypeProvider, usernameProvider, features, errorTracker);
    }

    @Override // javax.inject.Provider
    public CallInteractor get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
