package com.avito.android.publish.details.analytics;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileLoadTrackerImpl_Factory implements Factory<ProfileLoadTrackerImpl> {
    public final Provider<ScreenFlowTrackerProvider> a;

    public ProfileLoadTrackerImpl_Factory(Provider<ScreenFlowTrackerProvider> provider) {
        this.a = provider;
    }

    public static ProfileLoadTrackerImpl_Factory create(Provider<ScreenFlowTrackerProvider> provider) {
        return new ProfileLoadTrackerImpl_Factory(provider);
    }

    public static ProfileLoadTrackerImpl newInstance(ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return new ProfileLoadTrackerImpl(screenFlowTrackerProvider);
    }

    @Override // javax.inject.Provider
    public ProfileLoadTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
