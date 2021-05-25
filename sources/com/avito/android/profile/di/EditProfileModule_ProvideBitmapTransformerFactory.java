package com.avito.android.profile.di;

import android.app.Application;
import com.avito.android.photo_picker.BitmapTransformer;
import com.avito.android.util.PrivatePhotosStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideBitmapTransformerFactory implements Factory<BitmapTransformer> {
    public final Provider<Application> a;
    public final Provider<PrivatePhotosStorage> b;

    public EditProfileModule_ProvideBitmapTransformerFactory(Provider<Application> provider, Provider<PrivatePhotosStorage> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static EditProfileModule_ProvideBitmapTransformerFactory create(Provider<Application> provider, Provider<PrivatePhotosStorage> provider2) {
        return new EditProfileModule_ProvideBitmapTransformerFactory(provider, provider2);
    }

    public static BitmapTransformer provideBitmapTransformer(Application application, PrivatePhotosStorage privatePhotosStorage) {
        return (BitmapTransformer) Preconditions.checkNotNullFromProvides(EditProfileModule.provideBitmapTransformer(application, privatePhotosStorage));
    }

    @Override // javax.inject.Provider
    public BitmapTransformer get() {
        return provideBitmapTransformer(this.a.get(), this.b.get());
    }
}
