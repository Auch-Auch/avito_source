package com.avito.android.delivery.summary.change_contacts;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryRdsEditContactsKonveyorResourceProviderImpl_Factory implements Factory<DeliveryRdsEditContactsKonveyorResourceProviderImpl> {
    public final Provider<Resources> a;

    public DeliveryRdsEditContactsKonveyorResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DeliveryRdsEditContactsKonveyorResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DeliveryRdsEditContactsKonveyorResourceProviderImpl_Factory(provider);
    }

    public static DeliveryRdsEditContactsKonveyorResourceProviderImpl newInstance(Resources resources) {
        return new DeliveryRdsEditContactsKonveyorResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DeliveryRdsEditContactsKonveyorResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
