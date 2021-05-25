package com.avito.android.publish.details.analytics;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketPriceSlotTrackerImpl_Factory implements Factory<MarketPriceSlotTrackerImpl> {
    public final Provider<ScreenFlowTrackerProvider> a;

    public MarketPriceSlotTrackerImpl_Factory(Provider<ScreenFlowTrackerProvider> provider) {
        this.a = provider;
    }

    public static MarketPriceSlotTrackerImpl_Factory create(Provider<ScreenFlowTrackerProvider> provider) {
        return new MarketPriceSlotTrackerImpl_Factory(provider);
    }

    public static MarketPriceSlotTrackerImpl newInstance(ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return new MarketPriceSlotTrackerImpl(screenFlowTrackerProvider);
    }

    @Override // javax.inject.Provider
    public MarketPriceSlotTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
