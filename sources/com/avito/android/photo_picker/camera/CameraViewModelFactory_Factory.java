package com.avito.android.photo_picker.camera;

import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.GalleryInteractor;
import com.avito.android.photo_picker.legacy.PhotoResizer;
import com.avito.android.photo_picker.legacy.RotationProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CameraViewModelFactory_Factory implements Factory<CameraViewModelFactory> {
    public final Provider<GalleryInteractor> a;
    public final Provider<PermissionHelper> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<CameraOpenInteractor> d;
    public final Provider<RotationProvider> e;
    public final Provider<ExifExtraDataSerializer> f;
    public final Provider<SharedPhotosStorage> g;
    public final Provider<PhotoResizer> h;

    public CameraViewModelFactory_Factory(Provider<GalleryInteractor> provider, Provider<PermissionHelper> provider2, Provider<SchedulersFactory> provider3, Provider<CameraOpenInteractor> provider4, Provider<RotationProvider> provider5, Provider<ExifExtraDataSerializer> provider6, Provider<SharedPhotosStorage> provider7, Provider<PhotoResizer> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static CameraViewModelFactory_Factory create(Provider<GalleryInteractor> provider, Provider<PermissionHelper> provider2, Provider<SchedulersFactory> provider3, Provider<CameraOpenInteractor> provider4, Provider<RotationProvider> provider5, Provider<ExifExtraDataSerializer> provider6, Provider<SharedPhotosStorage> provider7, Provider<PhotoResizer> provider8) {
        return new CameraViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static CameraViewModelFactory newInstance(GalleryInteractor galleryInteractor, PermissionHelper permissionHelper, SchedulersFactory schedulersFactory, CameraOpenInteractor cameraOpenInteractor, RotationProvider rotationProvider, ExifExtraDataSerializer exifExtraDataSerializer, SharedPhotosStorage sharedPhotosStorage, PhotoResizer photoResizer) {
        return new CameraViewModelFactory(galleryInteractor, permissionHelper, schedulersFactory, cameraOpenInteractor, rotationProvider, exifExtraDataSerializer, sharedPhotosStorage, photoResizer);
    }

    @Override // javax.inject.Provider
    public CameraViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
