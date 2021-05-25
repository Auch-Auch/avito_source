package com.avito.android.photo_picker.legacy.di;

import com.avito.android.photo_picker.legacy.CameraPresenterResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CameraItemPresenterModule_ProvideCameraPresenterResourceProvider$photo_picker_releaseFactory implements Factory<CameraPresenterResourceProvider> {
    public final CameraItemPresenterModule a;

    public CameraItemPresenterModule_ProvideCameraPresenterResourceProvider$photo_picker_releaseFactory(CameraItemPresenterModule cameraItemPresenterModule) {
        this.a = cameraItemPresenterModule;
    }

    public static CameraItemPresenterModule_ProvideCameraPresenterResourceProvider$photo_picker_releaseFactory create(CameraItemPresenterModule cameraItemPresenterModule) {
        return new CameraItemPresenterModule_ProvideCameraPresenterResourceProvider$photo_picker_releaseFactory(cameraItemPresenterModule);
    }

    public static CameraPresenterResourceProvider provideCameraPresenterResourceProvider$photo_picker_release(CameraItemPresenterModule cameraItemPresenterModule) {
        return (CameraPresenterResourceProvider) Preconditions.checkNotNullFromProvides(cameraItemPresenterModule.provideCameraPresenterResourceProvider$photo_picker_release());
    }

    @Override // javax.inject.Provider
    public CameraPresenterResourceProvider get() {
        return provideCameraPresenterResourceProvider$photo_picker_release(this.a);
    }
}
