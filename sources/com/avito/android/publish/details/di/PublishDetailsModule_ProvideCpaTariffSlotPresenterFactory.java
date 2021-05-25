package com.avito.android.publish.details.di;

import com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishDetailsModule_ProvideCpaTariffSlotPresenterFactory implements Factory<CpaTariffSlotItemPresenter> {
    public final PublishDetailsModule a;

    public PublishDetailsModule_ProvideCpaTariffSlotPresenterFactory(PublishDetailsModule publishDetailsModule) {
        this.a = publishDetailsModule;
    }

    public static PublishDetailsModule_ProvideCpaTariffSlotPresenterFactory create(PublishDetailsModule publishDetailsModule) {
        return new PublishDetailsModule_ProvideCpaTariffSlotPresenterFactory(publishDetailsModule);
    }

    public static CpaTariffSlotItemPresenter provideCpaTariffSlotPresenter(PublishDetailsModule publishDetailsModule) {
        return (CpaTariffSlotItemPresenter) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideCpaTariffSlotPresenter());
    }

    @Override // javax.inject.Provider
    public CpaTariffSlotItemPresenter get() {
        return provideCpaTariffSlotPresenter(this.a);
    }
}
