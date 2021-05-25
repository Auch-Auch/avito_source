package com.avito.android.photo_picker.legacy.di;

import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.PrivatePhotosStorageImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PhotoPickerStorageModule_ProvidePhotoFilesStorageFactory implements Factory<PrivatePhotosStorage> {
    public final Provider<PrivatePhotosStorageImpl> a;

    public PhotoPickerStorageModule_ProvidePhotoFilesStorageFactory(Provider<PrivatePhotosStorageImpl> provider) {
        this.a = provider;
    }

    public static PhotoPickerStorageModule_ProvidePhotoFilesStorageFactory create(Provider<PrivatePhotosStorageImpl> provider) {
        return new PhotoPickerStorageModule_ProvidePhotoFilesStorageFactory(provider);
    }

    public static PrivatePhotosStorage providePhotoFilesStorage(PrivatePhotosStorageImpl privatePhotosStorageImpl) {
        return (PrivatePhotosStorage) Preconditions.checkNotNullFromProvides(PhotoPickerStorageModule.providePhotoFilesStorage(privatePhotosStorageImpl));
    }

    @Override // javax.inject.Provider
    public PrivatePhotosStorage get() {
        return providePhotoFilesStorage(this.a.get());
    }
}
