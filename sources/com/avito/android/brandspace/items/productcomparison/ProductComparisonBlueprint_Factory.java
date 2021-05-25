package com.avito.android.brandspace.items.productcomparison;

import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProductComparisonBlueprint_Factory implements Factory<ProductComparisonBlueprint> {
    public final Provider<CarouselPresenter> a;
    public final Provider<ItemBinder> b;

    public ProductComparisonBlueprint_Factory(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ProductComparisonBlueprint_Factory create(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        return new ProductComparisonBlueprint_Factory(provider, provider2);
    }

    public static ProductComparisonBlueprint newInstance(CarouselPresenter carouselPresenter, ItemBinder itemBinder) {
        return new ProductComparisonBlueprint(carouselPresenter, itemBinder);
    }

    @Override // javax.inject.Provider
    public ProductComparisonBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
