package com.avito.android.photo_gallery.di;

import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LegacyPhotoGalleryModule_ProvidePhoneNumberFormatterProviderFactory implements Factory<Formatter<String>> {
    public final Provider<Formatter<String>> a;

    public LegacyPhotoGalleryModule_ProvidePhoneNumberFormatterProviderFactory(Provider<Formatter<String>> provider) {
        this.a = provider;
    }

    public static LegacyPhotoGalleryModule_ProvidePhoneNumberFormatterProviderFactory create(Provider<Formatter<String>> provider) {
        return new LegacyPhotoGalleryModule_ProvidePhoneNumberFormatterProviderFactory(provider);
    }

    public static Formatter<String> providePhoneNumberFormatterProvider(Formatter<String> formatter) {
        return (Formatter) Preconditions.checkNotNullFromProvides(LegacyPhotoGalleryModule.INSTANCE.providePhoneNumberFormatterProvider(formatter));
    }

    @Override // javax.inject.Provider
    public Formatter<String> get() {
        return providePhoneNumberFormatterProvider(this.a.get());
    }
}
