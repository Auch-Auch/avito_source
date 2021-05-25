package com.avito.android.profile.di;

import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideExifExtraDataSerializerFactory implements Factory<ExifExtraDataSerializer> {
    public final Provider<ExifExtraDataSerializerImpl> a;

    public EditProfileModule_ProvideExifExtraDataSerializerFactory(Provider<ExifExtraDataSerializerImpl> provider) {
        this.a = provider;
    }

    public static EditProfileModule_ProvideExifExtraDataSerializerFactory create(Provider<ExifExtraDataSerializerImpl> provider) {
        return new EditProfileModule_ProvideExifExtraDataSerializerFactory(provider);
    }

    public static ExifExtraDataSerializer provideExifExtraDataSerializer(ExifExtraDataSerializerImpl exifExtraDataSerializerImpl) {
        return (ExifExtraDataSerializer) Preconditions.checkNotNullFromProvides(EditProfileModule.provideExifExtraDataSerializer(exifExtraDataSerializerImpl));
    }

    @Override // javax.inject.Provider
    public ExifExtraDataSerializer get() {
        return provideExifExtraDataSerializer(this.a.get());
    }
}
