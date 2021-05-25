package com.avito.android.photo_picker.legacy.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.CameraPresenterResourceProvider;
import com.avito.android.photo_picker.legacy.DescriptionProvider;
import com.avito.android.photo_picker.legacy.GalleryInteractor;
import com.avito.android.photo_picker.legacy.PhotoResizer;
import com.avito.android.photo_picker.legacy.RotationInteractor;
import com.avito.android.photo_picker.legacy.RotationProvider;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandler;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CameraItemPresenterModule_ProvideCameraPresenter$photo_picker_releaseFactory implements Factory<CameraItemPresenter> {
    public final CameraItemPresenterModule a;
    public final Provider<CameraOpenInteractor> b;
    public final Provider<GalleryInteractor> c;
    public final Provider<RotationInteractor> d;
    public final Provider<CameraItemPresenter.Listener> e;
    public final Provider<SchedulersFactory> f;
    public final Provider<CameraItemPermissionHandler> g;
    public final Provider<CameraPresenterResourceProvider> h;
    public final Provider<Analytics> i;
    public final Provider<RotationProvider> j;
    public final Provider<DescriptionProvider> k;
    public final Provider<CallableResponsiveItemPresenterRegistry> l;
    public final Provider<PhotoResizer> m;
    public final Provider<SharedPhotosStorage> n;

    public CameraItemPresenterModule_ProvideCameraPresenter$photo_picker_releaseFactory(CameraItemPresenterModule cameraItemPresenterModule, Provider<CameraOpenInteractor> provider, Provider<GalleryInteractor> provider2, Provider<RotationInteractor> provider3, Provider<CameraItemPresenter.Listener> provider4, Provider<SchedulersFactory> provider5, Provider<CameraItemPermissionHandler> provider6, Provider<CameraPresenterResourceProvider> provider7, Provider<Analytics> provider8, Provider<RotationProvider> provider9, Provider<DescriptionProvider> provider10, Provider<CallableResponsiveItemPresenterRegistry> provider11, Provider<PhotoResizer> provider12, Provider<SharedPhotosStorage> provider13) {
        this.a = cameraItemPresenterModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
        this.k = provider10;
        this.l = provider11;
        this.m = provider12;
        this.n = provider13;
    }

    public static CameraItemPresenterModule_ProvideCameraPresenter$photo_picker_releaseFactory create(CameraItemPresenterModule cameraItemPresenterModule, Provider<CameraOpenInteractor> provider, Provider<GalleryInteractor> provider2, Provider<RotationInteractor> provider3, Provider<CameraItemPresenter.Listener> provider4, Provider<SchedulersFactory> provider5, Provider<CameraItemPermissionHandler> provider6, Provider<CameraPresenterResourceProvider> provider7, Provider<Analytics> provider8, Provider<RotationProvider> provider9, Provider<DescriptionProvider> provider10, Provider<CallableResponsiveItemPresenterRegistry> provider11, Provider<PhotoResizer> provider12, Provider<SharedPhotosStorage> provider13) {
        return new CameraItemPresenterModule_ProvideCameraPresenter$photo_picker_releaseFactory(cameraItemPresenterModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static CameraItemPresenter provideCameraPresenter$photo_picker_release(CameraItemPresenterModule cameraItemPresenterModule, CameraOpenInteractor cameraOpenInteractor, GalleryInteractor galleryInteractor, RotationInteractor rotationInteractor, Lazy<CameraItemPresenter.Listener> lazy, SchedulersFactory schedulersFactory, CameraItemPermissionHandler cameraItemPermissionHandler, CameraPresenterResourceProvider cameraPresenterResourceProvider, Analytics analytics, RotationProvider rotationProvider, DescriptionProvider descriptionProvider, CallableResponsiveItemPresenterRegistry callableResponsiveItemPresenterRegistry, PhotoResizer photoResizer, SharedPhotosStorage sharedPhotosStorage) {
        return (CameraItemPresenter) Preconditions.checkNotNullFromProvides(cameraItemPresenterModule.provideCameraPresenter$photo_picker_release(cameraOpenInteractor, galleryInteractor, rotationInteractor, lazy, schedulersFactory, cameraItemPermissionHandler, cameraPresenterResourceProvider, analytics, rotationProvider, descriptionProvider, callableResponsiveItemPresenterRegistry, photoResizer, sharedPhotosStorage));
    }

    @Override // javax.inject.Provider
    public CameraItemPresenter get() {
        return provideCameraPresenter$photo_picker_release(this.a, this.b.get(), this.c.get(), this.d.get(), DoubleCheck.lazy(this.e), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get());
    }
}
