package com.avito.android.photo_picker.legacy.di;

import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PhotoPickerModule_ProvideExifExtraDataSerializerFactory implements Factory<ExifExtraDataSerializer> {
    public final PhotoPickerModule a;
    public final Provider<ExifExtraDataSerializerImpl> b;

    public PhotoPickerModule_ProvideExifExtraDataSerializerFactory(PhotoPickerModule photoPickerModule, Provider<ExifExtraDataSerializerImpl> provider) {
        this.a = photoPickerModule;
        this.b = provider;
    }

    public static PhotoPickerModule_ProvideExifExtraDataSerializerFactory create(PhotoPickerModule photoPickerModule, Provider<ExifExtraDataSerializerImpl> provider) {
        return new PhotoPickerModule_ProvideExifExtraDataSerializerFactory(photoPickerModule, provider);
    }

    public static ExifExtraDataSerializer provideExifExtraDataSerializer(PhotoPickerModule photoPickerModule, ExifExtraDataSerializerImpl exifExtraDataSerializerImpl) {
        return (ExifExtraDataSerializer) Preconditions.checkNotNullFromProvides(photoPickerModule.provideExifExtraDataSerializer(exifExtraDataSerializerImpl));
    }

    @Override // javax.inject.Provider
    public ExifExtraDataSerializer get() {
        return provideExifExtraDataSerializer(this.a, this.b.get());
    }
}
