package com.avito.android.brandspace.items.marketplace.snippet;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceSnippetBlueprint_Factory implements Factory<MarketplaceSnippetBlueprint> {
    public final Provider<MarketplaceSnippetPresenter> a;

    public MarketplaceSnippetBlueprint_Factory(Provider<MarketplaceSnippetPresenter> provider) {
        this.a = provider;
    }

    public static MarketplaceSnippetBlueprint_Factory create(Provider<MarketplaceSnippetPresenter> provider) {
        return new MarketplaceSnippetBlueprint_Factory(provider);
    }

    public static MarketplaceSnippetBlueprint newInstance(MarketplaceSnippetPresenter marketplaceSnippetPresenter) {
        return new MarketplaceSnippetBlueprint(marketplaceSnippetPresenter);
    }

    @Override // javax.inject.Provider
    public MarketplaceSnippetBlueprint get() {
        return newInstance(this.a.get());
    }
}
