package com.avito.android.photo_picker.legacy.di;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.util.PrivatePhotosStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UploadConverterModule_ProvideBitmapFileProvider$photo_picker_releaseFactory implements Factory<BitmapFileProvider> {
    public final UploadConverterModule a;
    public final Provider<Application> b;
    public final Provider<Analytics> c;
    public final Provider<PrivatePhotosStorage> d;

    public UploadConverterModule_ProvideBitmapFileProvider$photo_picker_releaseFactory(UploadConverterModule uploadConverterModule, Provider<Application> provider, Provider<Analytics> provider2, Provider<PrivatePhotosStorage> provider3) {
        this.a = uploadConverterModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static UploadConverterModule_ProvideBitmapFileProvider$photo_picker_releaseFactory create(UploadConverterModule uploadConverterModule, Provider<Application> provider, Provider<Analytics> provider2, Provider<PrivatePhotosStorage> provider3) {
        return new UploadConverterModule_ProvideBitmapFileProvider$photo_picker_releaseFactory(uploadConverterModule, provider, provider2, provider3);
    }

    public static BitmapFileProvider provideBitmapFileProvider$photo_picker_release(UploadConverterModule uploadConverterModule, Application application, Analytics analytics, PrivatePhotosStorage privatePhotosStorage) {
        return (BitmapFileProvider) Preconditions.checkNotNullFromProvides(uploadConverterModule.provideBitmapFileProvider$photo_picker_release(application, analytics, privatePhotosStorage));
    }

    @Override // javax.inject.Provider
    public BitmapFileProvider get() {
        return provideBitmapFileProvider$photo_picker_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
