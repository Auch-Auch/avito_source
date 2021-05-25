package com.avito.android.in_app_calls;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MicAccessPermissionTrackerImpl_Factory implements Factory<MicAccessPermissionTrackerImpl> {
    public final Provider<Preferences> a;
    public final Provider<Analytics> b;

    public MicAccessPermissionTrackerImpl_Factory(Provider<Preferences> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MicAccessPermissionTrackerImpl_Factory create(Provider<Preferences> provider, Provider<Analytics> provider2) {
        return new MicAccessPermissionTrackerImpl_Factory(provider, provider2);
    }

    public static MicAccessPermissionTrackerImpl newInstance(Preferences preferences, Analytics analytics) {
        return new MicAccessPermissionTrackerImpl(preferences, analytics);
    }

    @Override // javax.inject.Provider
    public MicAccessPermissionTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
