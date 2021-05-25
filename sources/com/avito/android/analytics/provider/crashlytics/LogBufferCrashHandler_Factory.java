package com.avito.android.analytics.provider.crashlytics;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LogBufferCrashHandler_Factory implements Factory<LogBufferCrashHandler> {
    public final Provider<FirebaseCrashlyticsEventTracker> a;

    public LogBufferCrashHandler_Factory(Provider<FirebaseCrashlyticsEventTracker> provider) {
        this.a = provider;
    }

    public static LogBufferCrashHandler_Factory create(Provider<FirebaseCrashlyticsEventTracker> provider) {
        return new LogBufferCrashHandler_Factory(provider);
    }

    public static LogBufferCrashHandler newInstance(Lazy<FirebaseCrashlyticsEventTracker> lazy) {
        return new LogBufferCrashHandler(lazy);
    }

    @Override // javax.inject.Provider
    public LogBufferCrashHandler get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
