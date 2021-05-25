package com.avito.android.publish.details.di;

import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.publish.details.PhotoInteractorWrapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideInsertPhotoInteractorFactory implements Factory<PhotoInteractorWrapper> {
    public final PublishDetailsModule a;
    public final Provider<PhotoInteractor> b;

    public PublishDetailsModule_ProvideInsertPhotoInteractorFactory(PublishDetailsModule publishDetailsModule, Provider<PhotoInteractor> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideInsertPhotoInteractorFactory create(PublishDetailsModule publishDetailsModule, Provider<PhotoInteractor> provider) {
        return new PublishDetailsModule_ProvideInsertPhotoInteractorFactory(publishDetailsModule, provider);
    }

    public static PhotoInteractorWrapper provideInsertPhotoInteractor(PublishDetailsModule publishDetailsModule, PhotoInteractor photoInteractor) {
        return (PhotoInteractorWrapper) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideInsertPhotoInteractor(photoInteractor));
    }

    @Override // javax.inject.Provider
    public PhotoInteractorWrapper get() {
        return provideInsertPhotoInteractor(this.a, this.b.get());
    }
}
