package com.avito.android.publish.objects.di;

import android.app.Application;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ImageUploadModule_ProvidePhotoInteractor$publish_releaseFactory implements Factory<PhotoInteractor> {
    public final ImageUploadModule a;
    public final Provider<Application> b;
    public final Provider<BuildInfo> c;
    public final Provider<ComputerVisionInteractor> d;

    public ImageUploadModule_ProvidePhotoInteractor$publish_releaseFactory(ImageUploadModule imageUploadModule, Provider<Application> provider, Provider<BuildInfo> provider2, Provider<ComputerVisionInteractor> provider3) {
        this.a = imageUploadModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ImageUploadModule_ProvidePhotoInteractor$publish_releaseFactory create(ImageUploadModule imageUploadModule, Provider<Application> provider, Provider<BuildInfo> provider2, Provider<ComputerVisionInteractor> provider3) {
        return new ImageUploadModule_ProvidePhotoInteractor$publish_releaseFactory(imageUploadModule, provider, provider2, provider3);
    }

    public static PhotoInteractor providePhotoInteractor$publish_release(ImageUploadModule imageUploadModule, Application application, BuildInfo buildInfo, ComputerVisionInteractor computerVisionInteractor) {
        return (PhotoInteractor) Preconditions.checkNotNullFromProvides(imageUploadModule.providePhotoInteractor$publish_release(application, buildInfo, computerVisionInteractor));
    }

    @Override // javax.inject.Provider
    public PhotoInteractor get() {
        return providePhotoInteractor$publish_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
