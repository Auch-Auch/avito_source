package com.avito.android.advert.item.marketplace_faq;

import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceImprovingContentItemsTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceFaqBlueprint_Factory implements Factory<MarketplaceFaqBlueprint> {
    public final Provider<MarketplaceFaqPresenter> a;
    public final Provider<ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup>> b;

    public MarketplaceFaqBlueprint_Factory(Provider<MarketplaceFaqPresenter> provider, Provider<ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MarketplaceFaqBlueprint_Factory create(Provider<MarketplaceFaqPresenter> provider, Provider<ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup>> provider2) {
        return new MarketplaceFaqBlueprint_Factory(provider, provider2);
    }

    public static MarketplaceFaqBlueprint newInstance(MarketplaceFaqPresenter marketplaceFaqPresenter, ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup> exposedAbTestGroup) {
        return new MarketplaceFaqBlueprint(marketplaceFaqPresenter, exposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public MarketplaceFaqBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
