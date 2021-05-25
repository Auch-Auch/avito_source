package com.avito.android.photo_gallery.di;

import android.app.Application;
import com.avito.android.advert_core.contactbar.AdvertActionIconFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LegacyPhotoGalleryModule_ProvideAdvertActionIconFactoryFactory implements Factory<AdvertActionIconFactory> {
    public final Provider<Application> a;

    public LegacyPhotoGalleryModule_ProvideAdvertActionIconFactoryFactory(Provider<Application> provider) {
        this.a = provider;
    }

    public static LegacyPhotoGalleryModule_ProvideAdvertActionIconFactoryFactory create(Provider<Application> provider) {
        return new LegacyPhotoGalleryModule_ProvideAdvertActionIconFactoryFactory(provider);
    }

    public static AdvertActionIconFactory provideAdvertActionIconFactory(Application application) {
        return (AdvertActionIconFactory) Preconditions.checkNotNullFromProvides(LegacyPhotoGalleryModule.INSTANCE.provideAdvertActionIconFactory(application));
    }

    @Override // javax.inject.Provider
    public AdvertActionIconFactory get() {
        return provideAdvertActionIconFactory(this.a.get());
    }
}
