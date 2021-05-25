package com.avito.android.photo_picker.legacy.di;

import android.app.Application;
import com.avito.android.photo.ThumbnailProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PhotoPickerModule_ProvideThumbnailProviderFactory implements Factory<ThumbnailProvider> {
    public final PhotoPickerModule a;
    public final Provider<Application> b;

    public PhotoPickerModule_ProvideThumbnailProviderFactory(PhotoPickerModule photoPickerModule, Provider<Application> provider) {
        this.a = photoPickerModule;
        this.b = provider;
    }

    public static PhotoPickerModule_ProvideThumbnailProviderFactory create(PhotoPickerModule photoPickerModule, Provider<Application> provider) {
        return new PhotoPickerModule_ProvideThumbnailProviderFactory(photoPickerModule, provider);
    }

    public static ThumbnailProvider provideThumbnailProvider(PhotoPickerModule photoPickerModule, Application application) {
        return (ThumbnailProvider) Preconditions.checkNotNullFromProvides(photoPickerModule.provideThumbnailProvider(application));
    }

    @Override // javax.inject.Provider
    public ThumbnailProvider get() {
        return provideThumbnailProvider(this.a, this.b.get());
    }
}
