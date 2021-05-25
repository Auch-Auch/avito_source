package com.avito.android.photo_picker.legacy.di;

import com.avito.android.photo_picker.legacy.CameraSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CameraItemPresenterModule_ProvideCameraSource$photo_picker_releaseFactory implements Factory<CameraSource> {
    public final CameraItemPresenterModule a;

    public CameraItemPresenterModule_ProvideCameraSource$photo_picker_releaseFactory(CameraItemPresenterModule cameraItemPresenterModule) {
        this.a = cameraItemPresenterModule;
    }

    public static CameraItemPresenterModule_ProvideCameraSource$photo_picker_releaseFactory create(CameraItemPresenterModule cameraItemPresenterModule) {
        return new CameraItemPresenterModule_ProvideCameraSource$photo_picker_releaseFactory(cameraItemPresenterModule);
    }

    public static CameraSource provideCameraSource$photo_picker_release(CameraItemPresenterModule cameraItemPresenterModule) {
        return (CameraSource) Preconditions.checkNotNullFromProvides(cameraItemPresenterModule.provideCameraSource$photo_picker_release());
    }

    @Override // javax.inject.Provider
    public CameraSource get() {
        return provideCameraSource$photo_picker_release(this.a);
    }
}
