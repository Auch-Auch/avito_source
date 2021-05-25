package com.avito.android.photo_picker.legacy.di;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.util.PrivatePhotosStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PhotoPickerModule_ProvideBitmapFileProviderFactory implements Factory<BitmapFileProvider> {
    public final PhotoPickerModule a;
    public final Provider<Application> b;
    public final Provider<Analytics> c;
    public final Provider<PrivatePhotosStorage> d;

    public PhotoPickerModule_ProvideBitmapFileProviderFactory(PhotoPickerModule photoPickerModule, Provider<Application> provider, Provider<Analytics> provider2, Provider<PrivatePhotosStorage> provider3) {
        this.a = photoPickerModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static PhotoPickerModule_ProvideBitmapFileProviderFactory create(PhotoPickerModule photoPickerModule, Provider<Application> provider, Provider<Analytics> provider2, Provider<PrivatePhotosStorage> provider3) {
        return new PhotoPickerModule_ProvideBitmapFileProviderFactory(photoPickerModule, provider, provider2, provider3);
    }

    public static BitmapFileProvider provideBitmapFileProvider(PhotoPickerModule photoPickerModule, Application application, Analytics analytics, PrivatePhotosStorage privatePhotosStorage) {
        return (BitmapFileProvider) Preconditions.checkNotNullFromProvides(photoPickerModule.provideBitmapFileProvider(application, analytics, privatePhotosStorage));
    }

    @Override // javax.inject.Provider
    public BitmapFileProvider get() {
        return provideBitmapFileProvider(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
