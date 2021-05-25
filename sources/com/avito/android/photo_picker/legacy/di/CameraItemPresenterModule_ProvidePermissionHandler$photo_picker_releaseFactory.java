package com.avito.android.photo_picker.legacy.di;

import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CameraItemPresenterModule_ProvidePermissionHandler$photo_picker_releaseFactory implements Factory<CameraItemPermissionHandler> {
    public final CameraItemPresenterModule a;
    public final Provider<PermissionHelper> b;

    public CameraItemPresenterModule_ProvidePermissionHandler$photo_picker_releaseFactory(CameraItemPresenterModule cameraItemPresenterModule, Provider<PermissionHelper> provider) {
        this.a = cameraItemPresenterModule;
        this.b = provider;
    }

    public static CameraItemPresenterModule_ProvidePermissionHandler$photo_picker_releaseFactory create(CameraItemPresenterModule cameraItemPresenterModule, Provider<PermissionHelper> provider) {
        return new CameraItemPresenterModule_ProvidePermissionHandler$photo_picker_releaseFactory(cameraItemPresenterModule, provider);
    }

    public static CameraItemPermissionHandler providePermissionHandler$photo_picker_release(CameraItemPresenterModule cameraItemPresenterModule, PermissionHelper permissionHelper) {
        return (CameraItemPermissionHandler) Preconditions.checkNotNullFromProvides(cameraItemPresenterModule.providePermissionHandler$photo_picker_release(permissionHelper));
    }

    @Override // javax.inject.Provider
    public CameraItemPermissionHandler get() {
        return providePermissionHandler$photo_picker_release(this.a, this.b.get());
    }
}
