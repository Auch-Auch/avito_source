package com.avito.android.analytics.provider.crashlytics;

import com.avito.android.server_time.TimeSource;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CrashRecorderImpl_Factory implements Factory<CrashRecorderImpl> {
    public final Provider<TimeSource> a;
    public final Provider<Preferences> b;

    public CrashRecorderImpl_Factory(Provider<TimeSource> provider, Provider<Preferences> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CrashRecorderImpl_Factory create(Provider<TimeSource> provider, Provider<Preferences> provider2) {
        return new CrashRecorderImpl_Factory(provider, provider2);
    }

    public static CrashRecorderImpl newInstance(TimeSource timeSource, Preferences preferences) {
        return new CrashRecorderImpl(timeSource, preferences);
    }

    @Override // javax.inject.Provider
    public CrashRecorderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
