package com.avito.android.publish.details.analytics;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoPublishSlotTrackerImpl_Factory implements Factory<AutoPublishSlotTrackerImpl> {
    public final Provider<ScreenFlowTrackerProvider> a;

    public AutoPublishSlotTrackerImpl_Factory(Provider<ScreenFlowTrackerProvider> provider) {
        this.a = provider;
    }

    public static AutoPublishSlotTrackerImpl_Factory create(Provider<ScreenFlowTrackerProvider> provider) {
        return new AutoPublishSlotTrackerImpl_Factory(provider);
    }

    public static AutoPublishSlotTrackerImpl newInstance(ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return new AutoPublishSlotTrackerImpl(screenFlowTrackerProvider);
    }

    @Override // javax.inject.Provider
    public AutoPublishSlotTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
