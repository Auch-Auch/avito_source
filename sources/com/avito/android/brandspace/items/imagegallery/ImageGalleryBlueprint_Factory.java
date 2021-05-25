package com.avito.android.brandspace.items.imagegallery;

import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ImageGalleryBlueprint_Factory implements Factory<ImageGalleryBlueprint> {
    public final Provider<CarouselPresenter> a;
    public final Provider<ItemBinder> b;

    public ImageGalleryBlueprint_Factory(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ImageGalleryBlueprint_Factory create(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        return new ImageGalleryBlueprint_Factory(provider, provider2);
    }

    public static ImageGalleryBlueprint newInstance(CarouselPresenter carouselPresenter, ItemBinder itemBinder) {
        return new ImageGalleryBlueprint(carouselPresenter, itemBinder);
    }

    @Override // javax.inject.Provider
    public ImageGalleryBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
