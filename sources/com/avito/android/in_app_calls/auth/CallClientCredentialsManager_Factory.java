package com.avito.android.in_app_calls.auth;

import com.avito.android.analytics.Analytics;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallClientCredentialsManager_Factory implements Factory<CallClientCredentialsManager> {
    public final Provider<Preferences> a;
    public final Provider<Analytics> b;
    public final Provider<TimeSource> c;

    public CallClientCredentialsManager_Factory(Provider<Preferences> provider, Provider<Analytics> provider2, Provider<TimeSource> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CallClientCredentialsManager_Factory create(Provider<Preferences> provider, Provider<Analytics> provider2, Provider<TimeSource> provider3) {
        return new CallClientCredentialsManager_Factory(provider, provider2, provider3);
    }

    public static CallClientCredentialsManager newInstance(Preferences preferences, Analytics analytics, TimeSource timeSource) {
        return new CallClientCredentialsManager(preferences, analytics, timeSource);
    }

    @Override // javax.inject.Provider
    public CallClientCredentialsManager get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
