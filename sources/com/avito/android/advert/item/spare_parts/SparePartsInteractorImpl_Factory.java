package com.avito.android.advert.item.spare_parts;

import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.spare_parts.remote.SparePartsApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SparePartsInteractorImpl_Factory implements Factory<SparePartsInteractorImpl> {
    public final Provider<SparePartsApi> a;
    public final Provider<TypedErrorThrowableConverter> b;

    public SparePartsInteractorImpl_Factory(Provider<SparePartsApi> provider, Provider<TypedErrorThrowableConverter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SparePartsInteractorImpl_Factory create(Provider<SparePartsApi> provider, Provider<TypedErrorThrowableConverter> provider2) {
        return new SparePartsInteractorImpl_Factory(provider, provider2);
    }

    public static SparePartsInteractorImpl newInstance(SparePartsApi sparePartsApi, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new SparePartsInteractorImpl(sparePartsApi, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public SparePartsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
