package com.avito.android.photo_gallery;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhotoGalleryIntentFactoryImpl_Factory implements Factory<PhotoGalleryIntentFactoryImpl> {
    public final Provider<Application> a;

    public PhotoGalleryIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static PhotoGalleryIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new PhotoGalleryIntentFactoryImpl_Factory(provider);
    }

    public static PhotoGalleryIntentFactoryImpl newInstance(Application application) {
        return new PhotoGalleryIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public PhotoGalleryIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
