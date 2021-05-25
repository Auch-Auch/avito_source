package com.avito.android;

import android.app.Application;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PendingMessageHandlerModule_ProvidePhotoInteractorFactory implements Factory<PhotoInteractor> {
    public final Provider<BuildInfo> a;
    public final Provider<Application> b;

    public PendingMessageHandlerModule_ProvidePhotoInteractorFactory(Provider<BuildInfo> provider, Provider<Application> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PendingMessageHandlerModule_ProvidePhotoInteractorFactory create(Provider<BuildInfo> provider, Provider<Application> provider2) {
        return new PendingMessageHandlerModule_ProvidePhotoInteractorFactory(provider, provider2);
    }

    public static PhotoInteractor providePhotoInteractor(BuildInfo buildInfo, Application application) {
        return (PhotoInteractor) Preconditions.checkNotNullFromProvides(PendingMessageHandlerModule.providePhotoInteractor(buildInfo, application));
    }

    @Override // javax.inject.Provider
    public PhotoInteractor get() {
        return providePhotoInteractor(this.a.get(), this.b.get());
    }
}
