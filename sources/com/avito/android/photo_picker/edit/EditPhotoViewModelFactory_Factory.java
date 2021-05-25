package com.avito.android.photo_picker.edit;

import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class EditPhotoViewModelFactory_Factory implements Factory<EditPhotoViewModelFactory> {
    public final Provider<SharedPhotosStorage> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<PhotoPickerEventTracker> c;
    public final Provider<ExifProvider> d;

    public EditPhotoViewModelFactory_Factory(Provider<SharedPhotosStorage> provider, Provider<SchedulersFactory3> provider2, Provider<PhotoPickerEventTracker> provider3, Provider<ExifProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static EditPhotoViewModelFactory_Factory create(Provider<SharedPhotosStorage> provider, Provider<SchedulersFactory3> provider2, Provider<PhotoPickerEventTracker> provider3, Provider<ExifProvider> provider4) {
        return new EditPhotoViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static EditPhotoViewModelFactory newInstance(SharedPhotosStorage sharedPhotosStorage, SchedulersFactory3 schedulersFactory3, PhotoPickerEventTracker photoPickerEventTracker, ExifProvider exifProvider) {
        return new EditPhotoViewModelFactory(sharedPhotosStorage, schedulersFactory3, photoPickerEventTracker, exifProvider);
    }

    @Override // javax.inject.Provider
    public EditPhotoViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
