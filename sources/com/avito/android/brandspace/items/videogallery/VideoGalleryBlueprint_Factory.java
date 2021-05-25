package com.avito.android.brandspace.items.videogallery;

import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VideoGalleryBlueprint_Factory implements Factory<VideoGalleryBlueprint> {
    public final Provider<CarouselPresenter> a;
    public final Provider<ItemBinder> b;

    public VideoGalleryBlueprint_Factory(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static VideoGalleryBlueprint_Factory create(Provider<CarouselPresenter> provider, Provider<ItemBinder> provider2) {
        return new VideoGalleryBlueprint_Factory(provider, provider2);
    }

    public static VideoGalleryBlueprint newInstance(CarouselPresenter carouselPresenter, ItemBinder itemBinder) {
        return new VideoGalleryBlueprint(carouselPresenter, itemBinder);
    }

    @Override // javax.inject.Provider
    public VideoGalleryBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
