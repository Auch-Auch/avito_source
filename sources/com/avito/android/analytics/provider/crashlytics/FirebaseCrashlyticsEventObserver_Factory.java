package com.avito.android.analytics.provider.crashlytics;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class FirebaseCrashlyticsEventObserver_Factory implements Factory<FirebaseCrashlyticsEventObserver> {
    public final Provider<FirebaseCrashlyticsEventTracker> a;

    public FirebaseCrashlyticsEventObserver_Factory(Provider<FirebaseCrashlyticsEventTracker> provider) {
        this.a = provider;
    }

    public static FirebaseCrashlyticsEventObserver_Factory create(Provider<FirebaseCrashlyticsEventTracker> provider) {
        return new FirebaseCrashlyticsEventObserver_Factory(provider);
    }

    public static FirebaseCrashlyticsEventObserver newInstance(FirebaseCrashlyticsEventTracker firebaseCrashlyticsEventTracker) {
        return new FirebaseCrashlyticsEventObserver(firebaseCrashlyticsEventTracker);
    }

    @Override // javax.inject.Provider
    public FirebaseCrashlyticsEventObserver get() {
        return newInstance(this.a.get());
    }
}
