package com.avito.android.photo_picker.gallery.gallery_list;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class GalleryItemBluePrint_Factory implements Factory<GalleryItemBluePrint> {
    public final Provider<GalleryItemPresenter> a;

    public GalleryItemBluePrint_Factory(Provider<GalleryItemPresenter> provider) {
        this.a = provider;
    }

    public static GalleryItemBluePrint_Factory create(Provider<GalleryItemPresenter> provider) {
        return new GalleryItemBluePrint_Factory(provider);
    }

    public static GalleryItemBluePrint newInstance(GalleryItemPresenter galleryItemPresenter) {
        return new GalleryItemBluePrint(galleryItemPresenter);
    }

    @Override // javax.inject.Provider
    public GalleryItemBluePrint get() {
        return newInstance(this.a.get());
    }
}
