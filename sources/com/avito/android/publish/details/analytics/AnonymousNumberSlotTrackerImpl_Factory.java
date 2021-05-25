package com.avito.android.publish.details.analytics;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AnonymousNumberSlotTrackerImpl_Factory implements Factory<AnonymousNumberSlotTrackerImpl> {
    public final Provider<ScreenFlowTrackerProvider> a;

    public AnonymousNumberSlotTrackerImpl_Factory(Provider<ScreenFlowTrackerProvider> provider) {
        this.a = provider;
    }

    public static AnonymousNumberSlotTrackerImpl_Factory create(Provider<ScreenFlowTrackerProvider> provider) {
        return new AnonymousNumberSlotTrackerImpl_Factory(provider);
    }

    public static AnonymousNumberSlotTrackerImpl newInstance(ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return new AnonymousNumberSlotTrackerImpl(screenFlowTrackerProvider);
    }

    @Override // javax.inject.Provider
    public AnonymousNumberSlotTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
