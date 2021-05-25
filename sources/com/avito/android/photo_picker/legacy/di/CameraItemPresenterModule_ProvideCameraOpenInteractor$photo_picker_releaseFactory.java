package com.avito.android.photo_picker.legacy.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.CameraSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CameraItemPresenterModule_ProvideCameraOpenInteractor$photo_picker_releaseFactory implements Factory<CameraOpenInteractor> {
    public final CameraItemPresenterModule a;
    public final Provider<CameraSource> b;
    public final Provider<Analytics> c;

    public CameraItemPresenterModule_ProvideCameraOpenInteractor$photo_picker_releaseFactory(CameraItemPresenterModule cameraItemPresenterModule, Provider<CameraSource> provider, Provider<Analytics> provider2) {
        this.a = cameraItemPresenterModule;
        this.b = provider;
        this.c = provider2;
    }

    public static CameraItemPresenterModule_ProvideCameraOpenInteractor$photo_picker_releaseFactory create(CameraItemPresenterModule cameraItemPresenterModule, Provider<CameraSource> provider, Provider<Analytics> provider2) {
        return new CameraItemPresenterModule_ProvideCameraOpenInteractor$photo_picker_releaseFactory(cameraItemPresenterModule, provider, provider2);
    }

    public static CameraOpenInteractor provideCameraOpenInteractor$photo_picker_release(CameraItemPresenterModule cameraItemPresenterModule, CameraSource cameraSource, Analytics analytics) {
        return (CameraOpenInteractor) Preconditions.checkNotNullFromProvides(cameraItemPresenterModule.provideCameraOpenInteractor$photo_picker_release(cameraSource, analytics));
    }

    @Override // javax.inject.Provider
    public CameraOpenInteractor get() {
        return provideCameraOpenInteractor$photo_picker_release(this.a, this.b.get(), this.c.get());
    }
}
