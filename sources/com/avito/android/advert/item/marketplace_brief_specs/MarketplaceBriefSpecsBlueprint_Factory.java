package com.avito.android.advert.item.marketplace_brief_specs;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceBriefSpecsBlueprint_Factory implements Factory<MarketplaceBriefSpecsBlueprint> {
    public final Provider<MarketplaceBriefSpecsPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public MarketplaceBriefSpecsBlueprint_Factory(Provider<MarketplaceBriefSpecsPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MarketplaceBriefSpecsBlueprint_Factory create(Provider<MarketplaceBriefSpecsPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new MarketplaceBriefSpecsBlueprint_Factory(provider, provider2);
    }

    public static MarketplaceBriefSpecsBlueprint newInstance(MarketplaceBriefSpecsPresenter marketplaceBriefSpecsPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new MarketplaceBriefSpecsBlueprint(marketplaceBriefSpecsPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public MarketplaceBriefSpecsBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
