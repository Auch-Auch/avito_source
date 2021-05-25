package com.avito.android.brandspace.items.marketplace;

import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UniversalCarouselsBlueprint_Factory implements Factory<UniversalCarouselsBlueprint> {
    public final Provider<CarouselPresenter> a;
    public final Provider<UniversalCarouselItemsBlueprints> b;

    public UniversalCarouselsBlueprint_Factory(Provider<CarouselPresenter> provider, Provider<UniversalCarouselItemsBlueprints> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UniversalCarouselsBlueprint_Factory create(Provider<CarouselPresenter> provider, Provider<UniversalCarouselItemsBlueprints> provider2) {
        return new UniversalCarouselsBlueprint_Factory(provider, provider2);
    }

    public static UniversalCarouselsBlueprint newInstance(CarouselPresenter carouselPresenter, UniversalCarouselItemsBlueprints universalCarouselItemsBlueprints) {
        return new UniversalCarouselsBlueprint(carouselPresenter, universalCarouselItemsBlueprints);
    }

    @Override // javax.inject.Provider
    public UniversalCarouselsBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
