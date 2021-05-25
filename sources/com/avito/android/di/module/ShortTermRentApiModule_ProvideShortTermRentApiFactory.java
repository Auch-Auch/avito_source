package com.avito.android.di.module;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.ShortTermRentApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShortTermRentApiModule_ProvideShortTermRentApiFactory implements Factory<ShortTermRentApi> {
    public final Provider<RetrofitFactory> a;

    public ShortTermRentApiModule_ProvideShortTermRentApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static ShortTermRentApiModule_ProvideShortTermRentApiFactory create(Provider<RetrofitFactory> provider) {
        return new ShortTermRentApiModule_ProvideShortTermRentApiFactory(provider);
    }

    public static ShortTermRentApi provideShortTermRentApi(RetrofitFactory retrofitFactory) {
        return (ShortTermRentApi) Preconditions.checkNotNullFromProvides(ShortTermRentApiModule.INSTANCE.provideShortTermRentApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public ShortTermRentApi get() {
        return provideShortTermRentApi(this.a.get());
    }
}
