package com.avito.android.calls_shared;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AppCallsUsageTrackerImpl_Factory implements Factory<AppCallsUsageTrackerImpl> {
    public final Provider<Preferences> a;

    public AppCallsUsageTrackerImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static AppCallsUsageTrackerImpl_Factory create(Provider<Preferences> provider) {
        return new AppCallsUsageTrackerImpl_Factory(provider);
    }

    public static AppCallsUsageTrackerImpl newInstance(Preferences preferences) {
        return new AppCallsUsageTrackerImpl(preferences);
    }

    @Override // javax.inject.Provider
    public AppCallsUsageTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
