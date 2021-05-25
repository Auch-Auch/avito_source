package com.avito.android.brandspace.items.productdescriptions;

import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProductDescriptionBlueprint_Factory implements Factory<ProductDescriptionBlueprint> {
    public final Provider<CarouselPresenter> a;
    public final Provider<ItemBinder> b;

    public ProductDescriptionBlueprint_Factory(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ProductDescriptionBlueprint_Factory create(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        return new ProductDescriptionBlueprint_Factory(provider, provider2);
    }

    public static ProductDescriptionBlueprint newInstance(CarouselPresenter carouselPresenter, ItemBinder itemBinder) {
        return new ProductDescriptionBlueprint(carouselPresenter, itemBinder);
    }

    @Override // javax.inject.Provider
    public ProductDescriptionBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
