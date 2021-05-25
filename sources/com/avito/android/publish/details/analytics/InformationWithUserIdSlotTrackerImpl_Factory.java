package com.avito.android.publish.details.analytics;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InformationWithUserIdSlotTrackerImpl_Factory implements Factory<InformationWithUserIdSlotTrackerImpl> {
    public final Provider<ScreenFlowTrackerProvider> a;

    public InformationWithUserIdSlotTrackerImpl_Factory(Provider<ScreenFlowTrackerProvider> provider) {
        this.a = provider;
    }

    public static InformationWithUserIdSlotTrackerImpl_Factory create(Provider<ScreenFlowTrackerProvider> provider) {
        return new InformationWithUserIdSlotTrackerImpl_Factory(provider);
    }

    public static InformationWithUserIdSlotTrackerImpl newInstance(ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return new InformationWithUserIdSlotTrackerImpl(screenFlowTrackerProvider);
    }

    @Override // javax.inject.Provider
    public InformationWithUserIdSlotTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
