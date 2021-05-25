package com.avito.android.photo_picker.legacy.di;

import com.avito.android.util.shared_image_files_storage.LegacySharedPhotosStorage;
import com.avito.android.util.shared_image_files_storage.MediaStoreSharedPhotosStorage;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PhotoPickerStorageModule_ProvideSharedFilesStorageFactory implements Factory<SharedPhotosStorage> {
    public final Provider<LegacySharedPhotosStorage> a;
    public final Provider<MediaStoreSharedPhotosStorage> b;

    public PhotoPickerStorageModule_ProvideSharedFilesStorageFactory(Provider<LegacySharedPhotosStorage> provider, Provider<MediaStoreSharedPhotosStorage> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PhotoPickerStorageModule_ProvideSharedFilesStorageFactory create(Provider<LegacySharedPhotosStorage> provider, Provider<MediaStoreSharedPhotosStorage> provider2) {
        return new PhotoPickerStorageModule_ProvideSharedFilesStorageFactory(provider, provider2);
    }

    public static SharedPhotosStorage provideSharedFilesStorage(LegacySharedPhotosStorage legacySharedPhotosStorage, MediaStoreSharedPhotosStorage mediaStoreSharedPhotosStorage) {
        return (SharedPhotosStorage) Preconditions.checkNotNullFromProvides(PhotoPickerStorageModule.provideSharedFilesStorage(legacySharedPhotosStorage, mediaStoreSharedPhotosStorage));
    }

    @Override // javax.inject.Provider
    public SharedPhotosStorage get() {
        return provideSharedFilesStorage(this.a.get(), this.b.get());
    }
}
