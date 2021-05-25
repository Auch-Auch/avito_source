package com.avito.android.publish.objects.di;

import android.app.Application;
import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ImageUploadModule_ProvideUploadingInteractor$publish_releaseFactory implements Factory<UploadingInteractor> {
    public final ImageUploadModule a;
    public final Provider<Application> b;

    public ImageUploadModule_ProvideUploadingInteractor$publish_releaseFactory(ImageUploadModule imageUploadModule, Provider<Application> provider) {
        this.a = imageUploadModule;
        this.b = provider;
    }

    public static ImageUploadModule_ProvideUploadingInteractor$publish_releaseFactory create(ImageUploadModule imageUploadModule, Provider<Application> provider) {
        return new ImageUploadModule_ProvideUploadingInteractor$publish_releaseFactory(imageUploadModule, provider);
    }

    public static UploadingInteractor provideUploadingInteractor$publish_release(ImageUploadModule imageUploadModule, Application application) {
        return (UploadingInteractor) Preconditions.checkNotNullFromProvides(imageUploadModule.provideUploadingInteractor$publish_release(application));
    }

    @Override // javax.inject.Provider
    public UploadingInteractor get() {
        return provideUploadingInteractor$publish_release(this.a, this.b.get());
    }
}
