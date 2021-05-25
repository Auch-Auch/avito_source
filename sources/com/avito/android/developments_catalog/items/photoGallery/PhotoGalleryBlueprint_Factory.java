package com.avito.android.developments_catalog.items.photoGallery;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhotoGalleryBlueprint_Factory implements Factory<PhotoGalleryBlueprint> {
    public final Provider<PhotoGalleryPresenter> a;
    public final Provider<ImplicitIntentFactory> b;
    public final Provider<Analytics> c;

    public PhotoGalleryBlueprint_Factory(Provider<PhotoGalleryPresenter> provider, Provider<ImplicitIntentFactory> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PhotoGalleryBlueprint_Factory create(Provider<PhotoGalleryPresenter> provider, Provider<ImplicitIntentFactory> provider2, Provider<Analytics> provider3) {
        return new PhotoGalleryBlueprint_Factory(provider, provider2, provider3);
    }

    public static PhotoGalleryBlueprint newInstance(PhotoGalleryPresenter photoGalleryPresenter, ImplicitIntentFactory implicitIntentFactory, Analytics analytics) {
        return new PhotoGalleryBlueprint(photoGalleryPresenter, implicitIntentFactory, analytics);
    }

    @Override // javax.inject.Provider
    public PhotoGalleryBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
