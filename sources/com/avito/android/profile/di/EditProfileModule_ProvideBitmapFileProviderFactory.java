package com.avito.android.profile.di;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.util.PrivatePhotosStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideBitmapFileProviderFactory implements Factory<BitmapFileProvider> {
    public final Provider<Application> a;
    public final Provider<Analytics> b;
    public final Provider<PrivatePhotosStorage> c;

    public EditProfileModule_ProvideBitmapFileProviderFactory(Provider<Application> provider, Provider<Analytics> provider2, Provider<PrivatePhotosStorage> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static EditProfileModule_ProvideBitmapFileProviderFactory create(Provider<Application> provider, Provider<Analytics> provider2, Provider<PrivatePhotosStorage> provider3) {
        return new EditProfileModule_ProvideBitmapFileProviderFactory(provider, provider2, provider3);
    }

    public static BitmapFileProvider provideBitmapFileProvider(Application application, Analytics analytics, PrivatePhotosStorage privatePhotosStorage) {
        return (BitmapFileProvider) Preconditions.checkNotNullFromProvides(EditProfileModule.provideBitmapFileProvider(application, analytics, privatePhotosStorage));
    }

    @Override // javax.inject.Provider
    public BitmapFileProvider get() {
        return provideBitmapFileProvider(this.a.get(), this.b.get(), this.c.get());
    }
}
