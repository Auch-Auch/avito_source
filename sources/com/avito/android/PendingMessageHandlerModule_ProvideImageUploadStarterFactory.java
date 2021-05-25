package com.avito.android;

import android.app.Application;
import com.avito.android.messenger.service.ImageUploadStarter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PendingMessageHandlerModule_ProvideImageUploadStarterFactory implements Factory<ImageUploadStarter> {
    public final Provider<Application> a;
    public final Provider<ServiceIntentFactory> b;

    public PendingMessageHandlerModule_ProvideImageUploadStarterFactory(Provider<Application> provider, Provider<ServiceIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PendingMessageHandlerModule_ProvideImageUploadStarterFactory create(Provider<Application> provider, Provider<ServiceIntentFactory> provider2) {
        return new PendingMessageHandlerModule_ProvideImageUploadStarterFactory(provider, provider2);
    }

    public static ImageUploadStarter provideImageUploadStarter(Application application, ServiceIntentFactory serviceIntentFactory) {
        return (ImageUploadStarter) Preconditions.checkNotNullFromProvides(PendingMessageHandlerModule.provideImageUploadStarter(application, serviceIntentFactory));
    }

    @Override // javax.inject.Provider
    public ImageUploadStarter get() {
        return provideImageUploadStarter(this.a.get(), this.b.get());
    }
}
