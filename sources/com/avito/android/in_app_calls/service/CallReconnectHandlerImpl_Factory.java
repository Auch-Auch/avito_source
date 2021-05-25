package com.avito.android.in_app_calls.service;

import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallReconnectHandlerImpl_Factory implements Factory<CallReconnectHandlerImpl> {
    public final Provider<ReconnectClient> a;
    public final Provider<TimeSource> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<CallAnalyticsTracker> d;

    public CallReconnectHandlerImpl_Factory(Provider<ReconnectClient> provider, Provider<TimeSource> provider2, Provider<SchedulersFactory> provider3, Provider<CallAnalyticsTracker> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static CallReconnectHandlerImpl_Factory create(Provider<ReconnectClient> provider, Provider<TimeSource> provider2, Provider<SchedulersFactory> provider3, Provider<CallAnalyticsTracker> provider4) {
        return new CallReconnectHandlerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static CallReconnectHandlerImpl newInstance(ReconnectClient reconnectClient, TimeSource timeSource, SchedulersFactory schedulersFactory, CallAnalyticsTracker callAnalyticsTracker) {
        return new CallReconnectHandlerImpl(reconnectClient, timeSource, schedulersFactory, callAnalyticsTracker);
    }

    @Override // javax.inject.Provider
    public CallReconnectHandlerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
