package com.avito.android.brandspace.items.news;

import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NewsBlueprint_Factory implements Factory<NewsBlueprint> {
    public final Provider<CarouselPresenter> a;
    public final Provider<ItemBinder> b;

    public NewsBlueprint_Factory(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NewsBlueprint_Factory create(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        return new NewsBlueprint_Factory(provider, provider2);
    }

    public static NewsBlueprint newInstance(CarouselPresenter carouselPresenter, ItemBinder itemBinder) {
        return new NewsBlueprint(carouselPresenter, itemBinder);
    }

    @Override // javax.inject.Provider
    public NewsBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
