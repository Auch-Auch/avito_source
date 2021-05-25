package com.avito.android.delivery.summary.change_contacts;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryRdsEditContactsResourceProviderImpl_Factory implements Factory<DeliveryRdsEditContactsResourceProviderImpl> {
    public final Provider<Resources> a;

    public DeliveryRdsEditContactsResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DeliveryRdsEditContactsResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DeliveryRdsEditContactsResourceProviderImpl_Factory(provider);
    }

    public static DeliveryRdsEditContactsResourceProviderImpl newInstance(Resources resources) {
        return new DeliveryRdsEditContactsResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DeliveryRdsEditContactsResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
