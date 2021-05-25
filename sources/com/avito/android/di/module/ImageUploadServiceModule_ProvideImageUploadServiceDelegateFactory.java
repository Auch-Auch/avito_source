package com.avito.android.di.module;

import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.api.UploadConverterProvider;
import com.avito.android.photo_picker.legacy.api.UploadInteractorProvider;
import com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegate;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ImageUploadServiceModule_ProvideImageUploadServiceDelegateFactory implements Factory<ImageUploadServiceDelegate> {
    public final Provider<PhotoInteractor> a;
    public final Provider<UploadInteractorProvider> b;
    public final Provider<UploadConverterProvider> c;
    public final Provider<SchedulersFactory> d;

    public ImageUploadServiceModule_ProvideImageUploadServiceDelegateFactory(Provider<PhotoInteractor> provider, Provider<UploadInteractorProvider> provider2, Provider<UploadConverterProvider> provider3, Provider<SchedulersFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ImageUploadServiceModule_ProvideImageUploadServiceDelegateFactory create(Provider<PhotoInteractor> provider, Provider<UploadInteractorProvider> provider2, Provider<UploadConverterProvider> provider3, Provider<SchedulersFactory> provider4) {
        return new ImageUploadServiceModule_ProvideImageUploadServiceDelegateFactory(provider, provider2, provider3, provider4);
    }

    public static ImageUploadServiceDelegate provideImageUploadServiceDelegate(PhotoInteractor photoInteractor, UploadInteractorProvider uploadInteractorProvider, UploadConverterProvider uploadConverterProvider, SchedulersFactory schedulersFactory) {
        return (ImageUploadServiceDelegate) Preconditions.checkNotNullFromProvides(ImageUploadServiceModule.provideImageUploadServiceDelegate(photoInteractor, uploadInteractorProvider, uploadConverterProvider, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public ImageUploadServiceDelegate get() {
        return provideImageUploadServiceDelegate(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
