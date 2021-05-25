package com.avito.android.photo_picker.gallery.data;

import android.content.ContentResolver;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GalleryPickerRepositoryImpl_Factory implements Factory<GalleryPickerRepositoryImpl> {
    public final Provider<ContentResolver> a;

    public GalleryPickerRepositoryImpl_Factory(Provider<ContentResolver> provider) {
        this.a = provider;
    }

    public static GalleryPickerRepositoryImpl_Factory create(Provider<ContentResolver> provider) {
        return new GalleryPickerRepositoryImpl_Factory(provider);
    }

    public static GalleryPickerRepositoryImpl newInstance(ContentResolver contentResolver) {
        return new GalleryPickerRepositoryImpl(contentResolver);
    }

    @Override // javax.inject.Provider
    public GalleryPickerRepositoryImpl get() {
        return newInstance(this.a.get());
    }
}
