package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ImageUploadServiceModule_ProvidePhotoInteractorFactory implements Factory<PhotoInteractor> {
    public final Provider<Application> a;
    public final Provider<BuildInfo> b;

    public ImageUploadServiceModule_ProvidePhotoInteractorFactory(Provider<Application> provider, Provider<BuildInfo> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ImageUploadServiceModule_ProvidePhotoInteractorFactory create(Provider<Application> provider, Provider<BuildInfo> provider2) {
        return new ImageUploadServiceModule_ProvidePhotoInteractorFactory(provider, provider2);
    }

    public static PhotoInteractor providePhotoInteractor(Application application, BuildInfo buildInfo) {
        return (PhotoInteractor) Preconditions.checkNotNullFromProvides(ImageUploadServiceModule.INSTANCE.providePhotoInteractor(application, buildInfo));
    }

    @Override // javax.inject.Provider
    public PhotoInteractor get() {
        return providePhotoInteractor(this.a.get(), this.b.get());
    }
}
