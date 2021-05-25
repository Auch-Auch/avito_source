package com.avito.android.publish.details.analytics;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ContactInfoSlotTrackerImpl_Factory implements Factory<ContactInfoSlotTrackerImpl> {
    public final Provider<ScreenFlowTrackerProvider> a;

    public ContactInfoSlotTrackerImpl_Factory(Provider<ScreenFlowTrackerProvider> provider) {
        this.a = provider;
    }

    public static ContactInfoSlotTrackerImpl_Factory create(Provider<ScreenFlowTrackerProvider> provider) {
        return new ContactInfoSlotTrackerImpl_Factory(provider);
    }

    public static ContactInfoSlotTrackerImpl newInstance(ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return new ContactInfoSlotTrackerImpl(screenFlowTrackerProvider);
    }

    @Override // javax.inject.Provider
    public ContactInfoSlotTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
