package com.avito.android.photo_picker.legacy;

import com.avito.android.util.PrivatePhotosStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhotoStorageCleanerImpl_Factory implements Factory<PhotoStorageCleanerImpl> {
    public final Provider<PhotoInteractor> a;
    public final Provider<PrivatePhotosStorage> b;

    public PhotoStorageCleanerImpl_Factory(Provider<PhotoInteractor> provider, Provider<PrivatePhotosStorage> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PhotoStorageCleanerImpl_Factory create(Provider<PhotoInteractor> provider, Provider<PrivatePhotosStorage> provider2) {
        return new PhotoStorageCleanerImpl_Factory(provider, provider2);
    }

    public static PhotoStorageCleanerImpl newInstance(PhotoInteractor photoInteractor, PrivatePhotosStorage privatePhotosStorage) {
        return new PhotoStorageCleanerImpl(photoInteractor, privatePhotosStorage);
    }

    @Override // javax.inject.Provider
    public PhotoStorageCleanerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
