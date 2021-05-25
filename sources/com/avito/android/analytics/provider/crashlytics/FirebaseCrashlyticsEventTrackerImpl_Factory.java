package com.avito.android.analytics.provider.crashlytics;

import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FirebaseCrashlyticsEventTrackerImpl_Factory implements Factory<FirebaseCrashlyticsEventTrackerImpl> {
    public final Provider<FirebaseCrashlytics> a;
    public final Provider<LogBufferProvider> b;
    public final Provider<SchedulersFactory3> c;

    public FirebaseCrashlyticsEventTrackerImpl_Factory(Provider<FirebaseCrashlytics> provider, Provider<LogBufferProvider> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FirebaseCrashlyticsEventTrackerImpl_Factory create(Provider<FirebaseCrashlytics> provider, Provider<LogBufferProvider> provider2, Provider<SchedulersFactory3> provider3) {
        return new FirebaseCrashlyticsEventTrackerImpl_Factory(provider, provider2, provider3);
    }

    public static FirebaseCrashlyticsEventTrackerImpl newInstance(FirebaseCrashlytics firebaseCrashlytics, LogBufferProvider logBufferProvider, SchedulersFactory3 schedulersFactory3) {
        return new FirebaseCrashlyticsEventTrackerImpl(firebaseCrashlytics, logBufferProvider, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public FirebaseCrashlyticsEventTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
