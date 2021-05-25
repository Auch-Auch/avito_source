package com.avito.android.calls_shared.tracker.errors;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallsErrorTracker_Factory implements Factory<CallsErrorTracker> {
    public final Provider<Analytics> a;

    public CallsErrorTracker_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static CallsErrorTracker_Factory create(Provider<Analytics> provider) {
        return new CallsErrorTracker_Factory(provider);
    }

    public static CallsErrorTracker newInstance(Analytics analytics) {
        return new CallsErrorTracker(analytics);
    }

    @Override // javax.inject.Provider
    public CallsErrorTracker get() {
        return newInstance(this.a.get());
    }
}
