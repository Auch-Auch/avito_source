package com.avito.android.calls_shared.tracker.events;

import com.avito.android.analytics.Analytics;
import com.avito.android.calls_shared.analytics.mapping.CallEventFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallEventClickstreamInterceptor_Factory implements Factory<CallEventClickstreamInterceptor> {
    public final Provider<CallEventFactory> a;
    public final Provider<Analytics> b;

    public CallEventClickstreamInterceptor_Factory(Provider<CallEventFactory> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CallEventClickstreamInterceptor_Factory create(Provider<CallEventFactory> provider, Provider<Analytics> provider2) {
        return new CallEventClickstreamInterceptor_Factory(provider, provider2);
    }

    public static CallEventClickstreamInterceptor newInstance(CallEventFactory callEventFactory, Analytics analytics) {
        return new CallEventClickstreamInterceptor(callEventFactory, analytics);
    }

    @Override // javax.inject.Provider
    public CallEventClickstreamInterceptor get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
