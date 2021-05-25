package com.avito.android.in_app_calls.analytics;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallQualityIssueTracker_Factory implements Factory<CallQualityIssueTracker> {
    public final Provider<Analytics> a;

    public CallQualityIssueTracker_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static CallQualityIssueTracker_Factory create(Provider<Analytics> provider) {
        return new CallQualityIssueTracker_Factory(provider);
    }

    public static CallQualityIssueTracker newInstance(Analytics analytics) {
        return new CallQualityIssueTracker(analytics);
    }

    @Override // javax.inject.Provider
    public CallQualityIssueTracker get() {
        return newInstance(this.a.get());
    }
}
