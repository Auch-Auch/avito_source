package com.avito.android.di.module;

import com.avito.android.service.ServiceCountdownHandler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ImageUploadServiceModule_ProvideServiceCountdownHandlerFactory implements Factory<ServiceCountdownHandler> {

    public static final class a {
        public static final ImageUploadServiceModule_ProvideServiceCountdownHandlerFactory a = new ImageUploadServiceModule_ProvideServiceCountdownHandlerFactory();
    }

    public static ImageUploadServiceModule_ProvideServiceCountdownHandlerFactory create() {
        return a.a;
    }

    public static ServiceCountdownHandler provideServiceCountdownHandler() {
        return (ServiceCountdownHandler) Preconditions.checkNotNullFromProvides(ImageUploadServiceModule.provideServiceCountdownHandler());
    }

    @Override // javax.inject.Provider
    public ServiceCountdownHandler get() {
        return provideServiceCountdownHandler();
    }
}
