package com.avito.android.brandspace.items.marketplace;

import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class WrapUniversalCarouselsBlueprint_Factory implements Factory<WrapUniversalCarouselsBlueprint> {
    public final Provider<CarouselPresenter> a;
    public final Provider<WrapUniversalCarouselItemsBlueprints> b;

    public WrapUniversalCarouselsBlueprint_Factory(Provider<CarouselPresenter> provider, Provider<WrapUniversalCarouselItemsBlueprints> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static WrapUniversalCarouselsBlueprint_Factory create(Provider<CarouselPresenter> provider, Provider<WrapUniversalCarouselItemsBlueprints> provider2) {
        return new WrapUniversalCarouselsBlueprint_Factory(provider, provider2);
    }

    public static WrapUniversalCarouselsBlueprint newInstance(CarouselPresenter carouselPresenter, WrapUniversalCarouselItemsBlueprints wrapUniversalCarouselItemsBlueprints) {
        return new WrapUniversalCarouselsBlueprint(carouselPresenter, wrapUniversalCarouselItemsBlueprints);
    }

    @Override // javax.inject.Provider
    public WrapUniversalCarouselsBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
