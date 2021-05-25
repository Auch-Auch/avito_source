package com.avito.android.photo_picker.camera;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class CameraFragment_MembersInjector implements MembersInjector<CameraFragment> {
    public final Provider<CameraViewModelFactory> a;

    public CameraFragment_MembersInjector(Provider<CameraViewModelFactory> provider) {
        this.a = provider;
    }

    public static MembersInjector<CameraFragment> create(Provider<CameraViewModelFactory> provider) {
        return new CameraFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.camera.CameraFragment.viewModelFactory")
    public static void injectViewModelFactory(CameraFragment cameraFragment, CameraViewModelFactory cameraViewModelFactory) {
        cameraFragment.viewModelFactory = cameraViewModelFactory;
    }

    public void injectMembers(CameraFragment cameraFragment) {
        injectViewModelFactory(cameraFragment, this.a.get());
    }
}
