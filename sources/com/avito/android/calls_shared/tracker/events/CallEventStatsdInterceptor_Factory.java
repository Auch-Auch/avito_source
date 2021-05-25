package com.avito.android.calls_shared.tracker.events;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallEventStatsdInterceptor_Factory implements Factory<CallEventStatsdInterceptor> {
    public final Provider<Analytics> a;

    public CallEventStatsdInterceptor_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static CallEventStatsdInterceptor_Factory create(Provider<Analytics> provider) {
        return new CallEventStatsdInterceptor_Factory(provider);
    }

    public static CallEventStatsdInterceptor newInstance(Analytics analytics) {
        return new CallEventStatsdInterceptor(analytics);
    }

    @Override // javax.inject.Provider
    public CallEventStatsdInterceptor get() {
        return newInstance(this.a.get());
    }
}
