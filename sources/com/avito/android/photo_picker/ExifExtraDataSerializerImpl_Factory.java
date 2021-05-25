package com.avito.android.photo_picker;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExifExtraDataSerializerImpl_Factory implements Factory<ExifExtraDataSerializerImpl> {
    public final Provider<Gson> a;

    public ExifExtraDataSerializerImpl_Factory(Provider<Gson> provider) {
        this.a = provider;
    }

    public static ExifExtraDataSerializerImpl_Factory create(Provider<Gson> provider) {
        return new ExifExtraDataSerializerImpl_Factory(provider);
    }

    public static ExifExtraDataSerializerImpl newInstance(Gson gson) {
        return new ExifExtraDataSerializerImpl(gson);
    }

    @Override // javax.inject.Provider
    public ExifExtraDataSerializerImpl get() {
        return newInstance(this.a.get());
    }
}
