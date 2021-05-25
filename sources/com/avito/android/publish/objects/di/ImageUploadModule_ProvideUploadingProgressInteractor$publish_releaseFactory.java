package com.avito.android.publish.objects.di;

import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ImageUploadModule_ProvideUploadingProgressInteractor$publish_releaseFactory implements Factory<UploadingProgressInteractor> {
    public final ImageUploadModule a;
    public final Provider<PhotoInteractor> b;
    public final Provider<SchedulersFactory> c;

    public ImageUploadModule_ProvideUploadingProgressInteractor$publish_releaseFactory(ImageUploadModule imageUploadModule, Provider<PhotoInteractor> provider, Provider<SchedulersFactory> provider2) {
        this.a = imageUploadModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ImageUploadModule_ProvideUploadingProgressInteractor$publish_releaseFactory create(ImageUploadModule imageUploadModule, Provider<PhotoInteractor> provider, Provider<SchedulersFactory> provider2) {
        return new ImageUploadModule_ProvideUploadingProgressInteractor$publish_releaseFactory(imageUploadModule, provider, provider2);
    }

    public static UploadingProgressInteractor provideUploadingProgressInteractor$publish_release(ImageUploadModule imageUploadModule, PhotoInteractor photoInteractor, SchedulersFactory schedulersFactory) {
        return (UploadingProgressInteractor) Preconditions.checkNotNullFromProvides(imageUploadModule.provideUploadingProgressInteractor$publish_release(photoInteractor, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public UploadingProgressInteractor get() {
        return provideUploadingProgressInteractor$publish_release(this.a, this.b.get(), this.c.get());
    }
}
