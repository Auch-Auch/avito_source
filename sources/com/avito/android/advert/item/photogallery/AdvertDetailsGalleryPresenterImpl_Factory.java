package com.avito.android.advert.item.photogallery;

import com.avito.android.advert.item.AdvertDetailsFragmentDelegate;
import com.avito.android.advert.item.AdvertDetailsItemsPresenter;
import com.avito.android.advert.item.AdvertDetailsPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsGalleryPresenterImpl_Factory implements Factory<AdvertDetailsGalleryPresenterImpl> {
    public final Provider<AdvertDetailsPresenter> a;
    public final Provider<AdvertDetailsItemsPresenter> b;
    public final Provider<AdvertDetailsFragmentDelegate> c;

    public AdvertDetailsGalleryPresenterImpl_Factory(Provider<AdvertDetailsPresenter> provider, Provider<AdvertDetailsItemsPresenter> provider2, Provider<AdvertDetailsFragmentDelegate> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertDetailsGalleryPresenterImpl_Factory create(Provider<AdvertDetailsPresenter> provider, Provider<AdvertDetailsItemsPresenter> provider2, Provider<AdvertDetailsFragmentDelegate> provider3) {
        return new AdvertDetailsGalleryPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static AdvertDetailsGalleryPresenterImpl newInstance(AdvertDetailsPresenter advertDetailsPresenter, AdvertDetailsItemsPresenter advertDetailsItemsPresenter, AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate) {
        return new AdvertDetailsGalleryPresenterImpl(advertDetailsPresenter, advertDetailsItemsPresenter, advertDetailsFragmentDelegate);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsGalleryPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
