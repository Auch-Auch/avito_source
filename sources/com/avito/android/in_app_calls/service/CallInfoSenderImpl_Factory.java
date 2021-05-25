package com.avito.android.in_app_calls.service;

import com.avito.android.analytics.Analytics;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallInfoSenderImpl_Factory implements Factory<CallInfoSenderImpl> {
    public final Provider<CallsApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<Analytics> c;
    public final Provider<ErrorTracker> d;

    public CallInfoSenderImpl_Factory(Provider<CallsApi> provider, Provider<SchedulersFactory3> provider2, Provider<Analytics> provider3, Provider<ErrorTracker> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static CallInfoSenderImpl_Factory create(Provider<CallsApi> provider, Provider<SchedulersFactory3> provider2, Provider<Analytics> provider3, Provider<ErrorTracker> provider4) {
        return new CallInfoSenderImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static CallInfoSenderImpl newInstance(CallsApi callsApi, SchedulersFactory3 schedulersFactory3, Analytics analytics, ErrorTracker errorTracker) {
        return new CallInfoSenderImpl(callsApi, schedulersFactory3, analytics, errorTracker);
    }

    @Override // javax.inject.Provider
    public CallInfoSenderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
