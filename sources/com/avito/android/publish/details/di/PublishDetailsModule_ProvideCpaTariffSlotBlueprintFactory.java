package com.avito.android.publish.details.di;

import com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotBlueprint;
import com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideCpaTariffSlotBlueprintFactory implements Factory<CpaTariffSlotBlueprint> {
    public final PublishDetailsModule a;
    public final Provider<CpaTariffSlotItemPresenter> b;

    public PublishDetailsModule_ProvideCpaTariffSlotBlueprintFactory(PublishDetailsModule publishDetailsModule, Provider<CpaTariffSlotItemPresenter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideCpaTariffSlotBlueprintFactory create(PublishDetailsModule publishDetailsModule, Provider<CpaTariffSlotItemPresenter> provider) {
        return new PublishDetailsModule_ProvideCpaTariffSlotBlueprintFactory(publishDetailsModule, provider);
    }

    public static CpaTariffSlotBlueprint provideCpaTariffSlotBlueprint(PublishDetailsModule publishDetailsModule, CpaTariffSlotItemPresenter cpaTariffSlotItemPresenter) {
        return (CpaTariffSlotBlueprint) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideCpaTariffSlotBlueprint(cpaTariffSlotItemPresenter));
    }

    @Override // javax.inject.Provider
    public CpaTariffSlotBlueprint get() {
        return provideCpaTariffSlotBlueprint(this.a, this.b.get());
    }
}
