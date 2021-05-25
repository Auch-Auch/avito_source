package com.avito.android.advert.item.marketplace_delivery;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceDeliveryBlueprint_Factory implements Factory<MarketplaceDeliveryBlueprint> {
    public final Provider<MarketplaceDeliveryPresenter> a;
    public final Provider<Features> b;
    public final Provider<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> c;

    public MarketplaceDeliveryBlueprint_Factory(Provider<MarketplaceDeliveryPresenter> provider, Provider<Features> provider2, Provider<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MarketplaceDeliveryBlueprint_Factory create(Provider<MarketplaceDeliveryPresenter> provider, Provider<Features> provider2, Provider<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> provider3) {
        return new MarketplaceDeliveryBlueprint_Factory(provider, provider2, provider3);
    }

    public static MarketplaceDeliveryBlueprint newInstance(MarketplaceDeliveryPresenter marketplaceDeliveryPresenter, Features features, ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> manuallyExposedAbTestGroup) {
        return new MarketplaceDeliveryBlueprint(marketplaceDeliveryPresenter, features, manuallyExposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public MarketplaceDeliveryBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
