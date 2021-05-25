package com.avito.android.brandspace.items.marketplace.snippet;

import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceSnippetCarouselBlueprint_Factory implements Factory<MarketplaceSnippetCarouselBlueprint> {
    public final Provider<CarouselPresenter> a;
    public final Provider<MarketplaceSnippetBlueprint> b;

    public MarketplaceSnippetCarouselBlueprint_Factory(Provider<CarouselPresenter> provider, Provider<MarketplaceSnippetBlueprint> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MarketplaceSnippetCarouselBlueprint_Factory create(Provider<CarouselPresenter> provider, Provider<MarketplaceSnippetBlueprint> provider2) {
        return new MarketplaceSnippetCarouselBlueprint_Factory(provider, provider2);
    }

    public static MarketplaceSnippetCarouselBlueprint newInstance(CarouselPresenter carouselPresenter, MarketplaceSnippetBlueprint marketplaceSnippetBlueprint) {
        return new MarketplaceSnippetCarouselBlueprint(carouselPresenter, marketplaceSnippetBlueprint);
    }

    @Override // javax.inject.Provider
    public MarketplaceSnippetCarouselBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
