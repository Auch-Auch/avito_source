package com.avito.android.calls_shared.tracker.events;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallEventTrackerImpl_Factory implements Factory<CallEventTrackerImpl> {
    public final Provider<CallEventClickstreamInterceptor> a;
    public final Provider<CallEventStatsdInterceptor> b;

    public CallEventTrackerImpl_Factory(Provider<CallEventClickstreamInterceptor> provider, Provider<CallEventStatsdInterceptor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CallEventTrackerImpl_Factory create(Provider<CallEventClickstreamInterceptor> provider, Provider<CallEventStatsdInterceptor> provider2) {
        return new CallEventTrackerImpl_Factory(provider, provider2);
    }

    public static CallEventTrackerImpl newInstance(CallEventClickstreamInterceptor callEventClickstreamInterceptor, CallEventStatsdInterceptor callEventStatsdInterceptor) {
        return new CallEventTrackerImpl(callEventClickstreamInterceptor, callEventStatsdInterceptor);
    }

    @Override // javax.inject.Provider
    public CallEventTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
