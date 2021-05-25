package com.avito.android.photo_picker.legacy.api;

import com.avito.android.Features;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UploadConverterProviderImpl_Factory implements Factory<UploadConverterProviderImpl> {
    public final Provider<BitmapFileProvider> a;
    public final Provider<ExifExtraDataSerializer> b;
    public final Provider<Features> c;

    public UploadConverterProviderImpl_Factory(Provider<BitmapFileProvider> provider, Provider<ExifExtraDataSerializer> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static UploadConverterProviderImpl_Factory create(Provider<BitmapFileProvider> provider, Provider<ExifExtraDataSerializer> provider2, Provider<Features> provider3) {
        return new UploadConverterProviderImpl_Factory(provider, provider2, provider3);
    }

    public static UploadConverterProviderImpl newInstance(BitmapFileProvider bitmapFileProvider, ExifExtraDataSerializer exifExtraDataSerializer, Features features) {
        return new UploadConverterProviderImpl(bitmapFileProvider, exifExtraDataSerializer, features);
    }

    @Override // javax.inject.Provider
    public UploadConverterProviderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
