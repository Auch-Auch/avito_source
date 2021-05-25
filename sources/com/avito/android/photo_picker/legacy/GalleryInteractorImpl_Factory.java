package com.avito.android.photo_picker.legacy;

import android.content.ContentResolver;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GalleryInteractorImpl_Factory implements Factory<GalleryInteractorImpl> {
    public final Provider<ContentResolver> a;

    public GalleryInteractorImpl_Factory(Provider<ContentResolver> provider) {
        this.a = provider;
    }

    public static GalleryInteractorImpl_Factory create(Provider<ContentResolver> provider) {
        return new GalleryInteractorImpl_Factory(provider);
    }

    public static GalleryInteractorImpl newInstance(ContentResolver contentResolver) {
        return new GalleryInteractorImpl(contentResolver);
    }

    @Override // javax.inject.Provider
    public GalleryInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
