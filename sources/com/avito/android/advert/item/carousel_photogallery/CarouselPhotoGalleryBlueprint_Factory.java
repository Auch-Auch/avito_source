package com.avito.android.advert.item.carousel_photogallery;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CarouselPhotoGalleryBlueprint_Factory implements Factory<CarouselPhotoGalleryBlueprint> {
    public final Provider<CarouselPhotoGalleryPresenter> a;
    public final Provider<ImplicitIntentFactory> b;
    public final Provider<Analytics> c;

    public CarouselPhotoGalleryBlueprint_Factory(Provider<CarouselPhotoGalleryPresenter> provider, Provider<ImplicitIntentFactory> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CarouselPhotoGalleryBlueprint_Factory create(Provider<CarouselPhotoGalleryPresenter> provider, Provider<ImplicitIntentFactory> provider2, Provider<Analytics> provider3) {
        return new CarouselPhotoGalleryBlueprint_Factory(provider, provider2, provider3);
    }

    public static CarouselPhotoGalleryBlueprint newInstance(CarouselPhotoGalleryPresenter carouselPhotoGalleryPresenter, ImplicitIntentFactory implicitIntentFactory, Analytics analytics) {
        return new CarouselPhotoGalleryBlueprint(carouselPhotoGalleryPresenter, implicitIntentFactory, analytics);
    }

    @Override // javax.inject.Provider
    public CarouselPhotoGalleryBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
