package com.avito.android.photo_picker.legacy.di;

import android.app.Application;
import com.avito.android.photo_picker.legacy.GalleryInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CameraItemPresenterModule_ProvideGalleryInteractor$photo_picker_releaseFactory implements Factory<GalleryInteractor> {
    public final CameraItemPresenterModule a;
    public final Provider<Application> b;

    public CameraItemPresenterModule_ProvideGalleryInteractor$photo_picker_releaseFactory(CameraItemPresenterModule cameraItemPresenterModule, Provider<Application> provider) {
        this.a = cameraItemPresenterModule;
        this.b = provider;
    }

    public static CameraItemPresenterModule_ProvideGalleryInteractor$photo_picker_releaseFactory create(CameraItemPresenterModule cameraItemPresenterModule, Provider<Application> provider) {
        return new CameraItemPresenterModule_ProvideGalleryInteractor$photo_picker_releaseFactory(cameraItemPresenterModule, provider);
    }

    public static GalleryInteractor provideGalleryInteractor$photo_picker_release(CameraItemPresenterModule cameraItemPresenterModule, Application application) {
        return (GalleryInteractor) Preconditions.checkNotNullFromProvides(cameraItemPresenterModule.provideGalleryInteractor$photo_picker_release(application));
    }

    @Override // javax.inject.Provider
    public GalleryInteractor get() {
        return provideGalleryInteractor$photo_picker_release(this.a, this.b.get());
    }
}
