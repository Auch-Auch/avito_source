package com.avito.android.delivery.summary.change_contacts;

import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractor;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryRdsEditContactsViewModelFactory_Factory implements Factory<DeliveryRdsEditContactsViewModelFactory> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<DeliveryRdsSummaryItemsConverter> b;
    public final Provider<DeliveryRdsEditContactsResourceProvider> c;
    public final Provider<DeliveryRdsContactsFieldsInteractor> d;

    public DeliveryRdsEditContactsViewModelFactory_Factory(Provider<SchedulersFactory3> provider, Provider<DeliveryRdsSummaryItemsConverter> provider2, Provider<DeliveryRdsEditContactsResourceProvider> provider3, Provider<DeliveryRdsContactsFieldsInteractor> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DeliveryRdsEditContactsViewModelFactory_Factory create(Provider<SchedulersFactory3> provider, Provider<DeliveryRdsSummaryItemsConverter> provider2, Provider<DeliveryRdsEditContactsResourceProvider> provider3, Provider<DeliveryRdsContactsFieldsInteractor> provider4) {
        return new DeliveryRdsEditContactsViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static DeliveryRdsEditContactsViewModelFactory newInstance(SchedulersFactory3 schedulersFactory3, DeliveryRdsSummaryItemsConverter deliveryRdsSummaryItemsConverter, DeliveryRdsEditContactsResourceProvider deliveryRdsEditContactsResourceProvider, DeliveryRdsContactsFieldsInteractor deliveryRdsContactsFieldsInteractor) {
        return new DeliveryRdsEditContactsViewModelFactory(schedulersFactory3, deliveryRdsSummaryItemsConverter, deliveryRdsEditContactsResourceProvider, deliveryRdsContactsFieldsInteractor);
    }

    @Override // javax.inject.Provider
    public DeliveryRdsEditContactsViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
