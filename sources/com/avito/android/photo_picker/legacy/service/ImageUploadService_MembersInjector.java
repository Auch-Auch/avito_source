package com.avito.android.photo_picker.legacy.service;

import com.avito.android.service.ServiceCountdownHandler;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ImageUploadService_MembersInjector implements MembersInjector<ImageUploadService> {
    public final Provider<ImageUploadServiceDelegate> a;
    public final Provider<ServiceCountdownHandler> b;

    public ImageUploadService_MembersInjector(Provider<ImageUploadServiceDelegate> provider, Provider<ServiceCountdownHandler> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<ImageUploadService> create(Provider<ImageUploadServiceDelegate> provider, Provider<ServiceCountdownHandler> provider2) {
        return new ImageUploadService_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.legacy.service.ImageUploadService.countdownHandler")
    public static void injectCountdownHandler(ImageUploadService imageUploadService, ServiceCountdownHandler serviceCountdownHandler) {
        imageUploadService.countdownHandler = serviceCountdownHandler;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.legacy.service.ImageUploadService.delegate")
    public static void injectDelegate(ImageUploadService imageUploadService, ImageUploadServiceDelegate imageUploadServiceDelegate) {
        imageUploadService.delegate = imageUploadServiceDelegate;
    }

    public void injectMembers(ImageUploadService imageUploadService) {
        injectDelegate(imageUploadService, this.a.get());
        injectCountdownHandler(imageUploadService, this.b.get());
    }
}
