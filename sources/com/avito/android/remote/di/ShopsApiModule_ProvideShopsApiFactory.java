package com.avito.android.remote.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.shop.remote.ShopsApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShopsApiModule_ProvideShopsApiFactory implements Factory<ShopsApi> {
    public final Provider<RetrofitFactory> a;

    public ShopsApiModule_ProvideShopsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static ShopsApiModule_ProvideShopsApiFactory create(Provider<RetrofitFactory> provider) {
        return new ShopsApiModule_ProvideShopsApiFactory(provider);
    }

    public static ShopsApi provideShopsApi(RetrofitFactory retrofitFactory) {
        return (ShopsApi) Preconditions.checkNotNullFromProvides(ShopsApiModule.INSTANCE.provideShopsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public ShopsApi get() {
        return provideShopsApi(this.a.get());
    }
}
