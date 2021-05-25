package com.avito.android.brandspace.items.categories.categoryitem;

import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoryItemsBlueprint_Factory implements Factory<CategoryItemsBlueprint> {
    public final Provider<CarouselPresenter> a;
    public final Provider<ItemBinder> b;

    public CategoryItemsBlueprint_Factory(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CategoryItemsBlueprint_Factory create(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        return new CategoryItemsBlueprint_Factory(provider, provider2);
    }

    public static CategoryItemsBlueprint newInstance(CarouselPresenter carouselPresenter, ItemBinder itemBinder) {
        return new CategoryItemsBlueprint(carouselPresenter, itemBinder);
    }

    @Override // javax.inject.Provider
    public CategoryItemsBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
