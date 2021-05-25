package com.avito.android.advert.item.carousel_photogallery;

import com.avito.android.advert.item.AdvertDetailsItemsPresenter;
import com.avito.android.advert.item.AdvertDetailsPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CarouselPhotoGalleryPresenterImpl_Factory implements Factory<CarouselPhotoGalleryPresenterImpl> {
    public final Provider<AdvertDetailsPresenter> a;
    public final Provider<AdvertDetailsItemsPresenter> b;

    public CarouselPhotoGalleryPresenterImpl_Factory(Provider<AdvertDetailsPresenter> provider, Provider<AdvertDetailsItemsPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CarouselPhotoGalleryPresenterImpl_Factory create(Provider<AdvertDetailsPresenter> provider, Provider<AdvertDetailsItemsPresenter> provider2) {
        return new CarouselPhotoGalleryPresenterImpl_Factory(provider, provider2);
    }

    public static CarouselPhotoGalleryPresenterImpl newInstance(AdvertDetailsPresenter advertDetailsPresenter, AdvertDetailsItemsPresenter advertDetailsItemsPresenter) {
        return new CarouselPhotoGalleryPresenterImpl(advertDetailsPresenter, advertDetailsItemsPresenter);
    }

    @Override // javax.inject.Provider
    public CarouselPhotoGalleryPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
