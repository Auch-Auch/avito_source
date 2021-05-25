package com.avito.android.brandspace.items.mainbanner;

import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MainBannerBlueprint_Factory implements Factory<MainBannerBlueprint> {
    public final Provider<CarouselPresenter> a;
    public final Provider<ItemBinder> b;

    public MainBannerBlueprint_Factory(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MainBannerBlueprint_Factory create(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        return new MainBannerBlueprint_Factory(provider, provider2);
    }

    public static MainBannerBlueprint newInstance(CarouselPresenter carouselPresenter, ItemBinder itemBinder) {
        return new MainBannerBlueprint(carouselPresenter, itemBinder);
    }

    @Override // javax.inject.Provider
    public MainBannerBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
