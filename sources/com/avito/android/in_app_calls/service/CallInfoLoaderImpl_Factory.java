package com.avito.android.in_app_calls.service;

import com.avito.android.analytics.Analytics;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallInfoLoaderImpl_Factory implements Factory<CallInfoLoaderImpl> {
    public final Provider<CallsApi> a;
    public final Provider<Analytics> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<ErrorTracker> d;

    public CallInfoLoaderImpl_Factory(Provider<CallsApi> provider, Provider<Analytics> provider2, Provider<SchedulersFactory3> provider3, Provider<ErrorTracker> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static CallInfoLoaderImpl_Factory create(Provider<CallsApi> provider, Provider<Analytics> provider2, Provider<SchedulersFactory3> provider3, Provider<ErrorTracker> provider4) {
        return new CallInfoLoaderImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static CallInfoLoaderImpl newInstance(CallsApi callsApi, Analytics analytics, SchedulersFactory3 schedulersFactory3, ErrorTracker errorTracker) {
        return new CallInfoLoaderImpl(callsApi, analytics, schedulersFactory3, errorTracker);
    }

    @Override // javax.inject.Provider
    public CallInfoLoaderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
