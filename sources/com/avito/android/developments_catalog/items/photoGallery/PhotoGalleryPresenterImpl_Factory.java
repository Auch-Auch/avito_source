package com.avito.android.developments_catalog.items.photoGallery;

import com.avito.android.developments_catalog.DevelopmentsCatalogFragmentManagerDelegate;
import com.avito.android.photo_gallery.common.GalleryPageListener;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhotoGalleryPresenterImpl_Factory implements Factory<PhotoGalleryPresenterImpl> {
    public final Provider<String> a;
    public final Provider<DevelopmentsCatalogFragmentManagerDelegate> b;
    public final Provider<GalleryPageListener> c;

    public PhotoGalleryPresenterImpl_Factory(Provider<String> provider, Provider<DevelopmentsCatalogFragmentManagerDelegate> provider2, Provider<GalleryPageListener> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PhotoGalleryPresenterImpl_Factory create(Provider<String> provider, Provider<DevelopmentsCatalogFragmentManagerDelegate> provider2, Provider<GalleryPageListener> provider3) {
        return new PhotoGalleryPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static PhotoGalleryPresenterImpl newInstance(String str, DevelopmentsCatalogFragmentManagerDelegate developmentsCatalogFragmentManagerDelegate, GalleryPageListener galleryPageListener) {
        return new PhotoGalleryPresenterImpl(str, developmentsCatalogFragmentManagerDelegate, galleryPageListener);
    }

    @Override // javax.inject.Provider
    public PhotoGalleryPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
