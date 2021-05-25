package com.avito.android.photo_picker.edit.di;

import android.content.Context;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.edit.ExifProvider;
import com.avito.android.util.PrivatePhotosStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditPhotoModule_ProvideExifProviderFactory implements Factory<ExifProvider> {
    public final EditPhotoModule a;
    public final Provider<Context> b;
    public final Provider<PrivatePhotosStorage> c;
    public final Provider<ExifExtraDataSerializer> d;

    public EditPhotoModule_ProvideExifProviderFactory(EditPhotoModule editPhotoModule, Provider<Context> provider, Provider<PrivatePhotosStorage> provider2, Provider<ExifExtraDataSerializer> provider3) {
        this.a = editPhotoModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static EditPhotoModule_ProvideExifProviderFactory create(EditPhotoModule editPhotoModule, Provider<Context> provider, Provider<PrivatePhotosStorage> provider2, Provider<ExifExtraDataSerializer> provider3) {
        return new EditPhotoModule_ProvideExifProviderFactory(editPhotoModule, provider, provider2, provider3);
    }

    public static ExifProvider provideExifProvider(EditPhotoModule editPhotoModule, Context context, PrivatePhotosStorage privatePhotosStorage, ExifExtraDataSerializer exifExtraDataSerializer) {
        return (ExifProvider) Preconditions.checkNotNullFromProvides(editPhotoModule.provideExifProvider(context, privatePhotosStorage, exifExtraDataSerializer));
    }

    @Override // javax.inject.Provider
    public ExifProvider get() {
        return provideExifProvider(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
