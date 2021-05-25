package com.avito.android.profile.di;

import com.avito.android.Features;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.legacy.api.UploadConverterProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideUploadConverterFactory implements Factory<UploadConverterProvider> {
    public final Provider<BitmapFileProvider> a;
    public final Provider<ExifExtraDataSerializer> b;
    public final Provider<Features> c;

    public EditProfileModule_ProvideUploadConverterFactory(Provider<BitmapFileProvider> provider, Provider<ExifExtraDataSerializer> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static EditProfileModule_ProvideUploadConverterFactory create(Provider<BitmapFileProvider> provider, Provider<ExifExtraDataSerializer> provider2, Provider<Features> provider3) {
        return new EditProfileModule_ProvideUploadConverterFactory(provider, provider2, provider3);
    }

    public static UploadConverterProvider provideUploadConverter(BitmapFileProvider bitmapFileProvider, ExifExtraDataSerializer exifExtraDataSerializer, Features features) {
        return (UploadConverterProvider) Preconditions.checkNotNullFromProvides(EditProfileModule.provideUploadConverter(bitmapFileProvider, exifExtraDataSerializer, features));
    }

    @Override // javax.inject.Provider
    public UploadConverterProvider get() {
        return provideUploadConverter(this.a.get(), this.b.get(), this.c.get());
    }
}
