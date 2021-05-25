package com.avito.android.publish.objects.di;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.util.PrivatePhotosStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ImageUploadModule_ProvideBitmapFileProvider$publish_releaseFactory implements Factory<BitmapFileProvider> {
    public final ImageUploadModule a;
    public final Provider<Application> b;
    public final Provider<Analytics> c;
    public final Provider<PrivatePhotosStorage> d;

    public ImageUploadModule_ProvideBitmapFileProvider$publish_releaseFactory(ImageUploadModule imageUploadModule, Provider<Application> provider, Provider<Analytics> provider2, Provider<PrivatePhotosStorage> provider3) {
        this.a = imageUploadModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ImageUploadModule_ProvideBitmapFileProvider$publish_releaseFactory create(ImageUploadModule imageUploadModule, Provider<Application> provider, Provider<Analytics> provider2, Provider<PrivatePhotosStorage> provider3) {
        return new ImageUploadModule_ProvideBitmapFileProvider$publish_releaseFactory(imageUploadModule, provider, provider2, provider3);
    }

    public static BitmapFileProvider provideBitmapFileProvider$publish_release(ImageUploadModule imageUploadModule, Application application, Analytics analytics, PrivatePhotosStorage privatePhotosStorage) {
        return (BitmapFileProvider) Preconditions.checkNotNullFromProvides(imageUploadModule.provideBitmapFileProvider$publish_release(application, analytics, privatePhotosStorage));
    }

    @Override // javax.inject.Provider
    public BitmapFileProvider get() {
        return provideBitmapFileProvider$publish_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
