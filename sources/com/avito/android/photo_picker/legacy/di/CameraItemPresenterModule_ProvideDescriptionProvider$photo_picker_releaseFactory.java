package com.avito.android.photo_picker.legacy.di;

import com.avito.android.photo_picker.legacy.DescriptionProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CameraItemPresenterModule_ProvideDescriptionProvider$photo_picker_releaseFactory implements Factory<DescriptionProvider> {
    public final CameraItemPresenterModule a;

    public CameraItemPresenterModule_ProvideDescriptionProvider$photo_picker_releaseFactory(CameraItemPresenterModule cameraItemPresenterModule) {
        this.a = cameraItemPresenterModule;
    }

    public static CameraItemPresenterModule_ProvideDescriptionProvider$photo_picker_releaseFactory create(CameraItemPresenterModule cameraItemPresenterModule) {
        return new CameraItemPresenterModule_ProvideDescriptionProvider$photo_picker_releaseFactory(cameraItemPresenterModule);
    }

    public static DescriptionProvider provideDescriptionProvider$photo_picker_release(CameraItemPresenterModule cameraItemPresenterModule) {
        return (DescriptionProvider) Preconditions.checkNotNullFromProvides(cameraItemPresenterModule.provideDescriptionProvider$photo_picker_release());
    }

    @Override // javax.inject.Provider
    public DescriptionProvider get() {
        return provideDescriptionProvider$photo_picker_release(this.a);
    }
}
