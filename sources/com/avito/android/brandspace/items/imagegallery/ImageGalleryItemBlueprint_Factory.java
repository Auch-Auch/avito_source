package com.avito.android.brandspace.items.imagegallery;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ImageGalleryItemBlueprint_Factory implements Factory<ImageGalleryItemBlueprint> {
    public final Provider<ImageGalleryItemPresenter> a;

    public ImageGalleryItemBlueprint_Factory(Provider<ImageGalleryItemPresenter> provider) {
        this.a = provider;
    }

    public static ImageGalleryItemBlueprint_Factory create(Provider<ImageGalleryItemPresenter> provider) {
        return new ImageGalleryItemBlueprint_Factory(provider);
    }

    public static ImageGalleryItemBlueprint newInstance(ImageGalleryItemPresenter imageGalleryItemPresenter) {
        return new ImageGalleryItemBlueprint(imageGalleryItemPresenter);
    }

    @Override // javax.inject.Provider
    public ImageGalleryItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
