package com.avito.android.short_term_rent.hotels.data;

import com.avito.android.remote.ShortTermRentApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HotelsRepositoryImpl_Factory implements Factory<HotelsRepositoryImpl> {
    public final Provider<ShortTermRentApi> a;

    public HotelsRepositoryImpl_Factory(Provider<ShortTermRentApi> provider) {
        this.a = provider;
    }

    public static HotelsRepositoryImpl_Factory create(Provider<ShortTermRentApi> provider) {
        return new HotelsRepositoryImpl_Factory(provider);
    }

    public static HotelsRepositoryImpl newInstance(ShortTermRentApi shortTermRentApi) {
        return new HotelsRepositoryImpl(shortTermRentApi);
    }

    @Override // javax.inject.Provider
    public HotelsRepositoryImpl get() {
        return newInstance(this.a.get());
    }
}
