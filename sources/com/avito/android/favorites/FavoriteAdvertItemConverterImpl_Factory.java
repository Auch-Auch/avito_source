package com.avito.android.favorites;

import com.avito.android.Features;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteAdvertItemConverterImpl_Factory implements Factory<FavoriteAdvertItemConverterImpl> {
    public final Provider<Formatter<AdvertPrice>> a;
    public final Provider<FavoriteAdvertItemConverterResourceProvider> b;
    public final Provider<Features> c;

    public FavoriteAdvertItemConverterImpl_Factory(Provider<Formatter<AdvertPrice>> provider, Provider<FavoriteAdvertItemConverterResourceProvider> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FavoriteAdvertItemConverterImpl_Factory create(Provider<Formatter<AdvertPrice>> provider, Provider<FavoriteAdvertItemConverterResourceProvider> provider2, Provider<Features> provider3) {
        return new FavoriteAdvertItemConverterImpl_Factory(provider, provider2, provider3);
    }

    public static FavoriteAdvertItemConverterImpl newInstance(Formatter<AdvertPrice> formatter, FavoriteAdvertItemConverterResourceProvider favoriteAdvertItemConverterResourceProvider, Features features) {
        return new FavoriteAdvertItemConverterImpl(formatter, favoriteAdvertItemConverterResourceProvider, features);
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertItemConverterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
