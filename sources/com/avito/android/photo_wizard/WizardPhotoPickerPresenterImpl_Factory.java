package com.avito.android.photo_wizard;

import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class WizardPhotoPickerPresenterImpl_Factory implements Factory<WizardPhotoPickerPresenterImpl> {
    public final Provider<CameraOpenInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<PermissionHelper> c;
    public final Provider<PhotoWizardResourceProvider> d;
    public final Provider<PhotoWizardImageResizer> e;
    public final Provider<SharedPhotosStorage> f;

    public WizardPhotoPickerPresenterImpl_Factory(Provider<CameraOpenInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<PermissionHelper> provider3, Provider<PhotoWizardResourceProvider> provider4, Provider<PhotoWizardImageResizer> provider5, Provider<SharedPhotosStorage> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static WizardPhotoPickerPresenterImpl_Factory create(Provider<CameraOpenInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<PermissionHelper> provider3, Provider<PhotoWizardResourceProvider> provider4, Provider<PhotoWizardImageResizer> provider5, Provider<SharedPhotosStorage> provider6) {
        return new WizardPhotoPickerPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static WizardPhotoPickerPresenterImpl newInstance(CameraOpenInteractor cameraOpenInteractor, SchedulersFactory3 schedulersFactory3, PermissionHelper permissionHelper, PhotoWizardResourceProvider photoWizardResourceProvider, PhotoWizardImageResizer photoWizardImageResizer, SharedPhotosStorage sharedPhotosStorage) {
        return new WizardPhotoPickerPresenterImpl(cameraOpenInteractor, schedulersFactory3, permissionHelper, photoWizardResourceProvider, photoWizardImageResizer, sharedPhotosStorage);
    }

    @Override // javax.inject.Provider
    public WizardPhotoPickerPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
