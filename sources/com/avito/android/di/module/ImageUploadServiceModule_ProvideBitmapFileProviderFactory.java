package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.util.PrivatePhotosStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ImageUploadServiceModule_ProvideBitmapFileProviderFactory implements Factory<BitmapFileProvider> {
    public final Provider<Application> a;
    public final Provider<Analytics> b;
    public final Provider<PrivatePhotosStorage> c;

    public ImageUploadServiceModule_ProvideBitmapFileProviderFactory(Provider<Application> provider, Provider<Analytics> provider2, Provider<PrivatePhotosStorage> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ImageUploadServiceModule_ProvideBitmapFileProviderFactory create(Provider<Application> provider, Provider<Analytics> provider2, Provider<PrivatePhotosStorage> provider3) {
        return new ImageUploadServiceModule_ProvideBitmapFileProviderFactory(provider, provider2, provider3);
    }

    public static BitmapFileProvider provideBitmapFileProvider(Application application, Analytics analytics, PrivatePhotosStorage privatePhotosStorage) {
        return (BitmapFileProvider) Preconditions.checkNotNullFromProvides(ImageUploadServiceModule.provideBitmapFileProvider(application, analytics, privatePhotosStorage));
    }

    @Override // javax.inject.Provider
    public BitmapFileProvider get() {
        return provideBitmapFileProvider(this.a.get(), this.b.get(), this.c.get());
    }
}
