package com.avito.android.photo_picker.legacy.di;

import com.avito.android.photo_picker.legacy.RotationProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CameraItemPresenterModule_ProvideRotationProvider$photo_picker_releaseFactory implements Factory<RotationProvider> {
    public final CameraItemPresenterModule a;

    public CameraItemPresenterModule_ProvideRotationProvider$photo_picker_releaseFactory(CameraItemPresenterModule cameraItemPresenterModule) {
        this.a = cameraItemPresenterModule;
    }

    public static CameraItemPresenterModule_ProvideRotationProvider$photo_picker_releaseFactory create(CameraItemPresenterModule cameraItemPresenterModule) {
        return new CameraItemPresenterModule_ProvideRotationProvider$photo_picker_releaseFactory(cameraItemPresenterModule);
    }

    public static RotationProvider provideRotationProvider$photo_picker_release(CameraItemPresenterModule cameraItemPresenterModule) {
        return (RotationProvider) Preconditions.checkNotNullFromProvides(cameraItemPresenterModule.provideRotationProvider$photo_picker_release());
    }

    @Override // javax.inject.Provider
    public RotationProvider get() {
        return provideRotationProvider$photo_picker_release(this.a);
    }
}
