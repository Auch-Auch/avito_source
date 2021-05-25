package com.avito.android.di.module;

import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoriteSellersApiModule_ProvideFavoriteSellersApiFactory implements Factory<FavoriteSellersApi> {
    public final Provider<RetrofitFactory> a;

    public FavoriteSellersApiModule_ProvideFavoriteSellersApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static FavoriteSellersApiModule_ProvideFavoriteSellersApiFactory create(Provider<RetrofitFactory> provider) {
        return new FavoriteSellersApiModule_ProvideFavoriteSellersApiFactory(provider);
    }

    public static FavoriteSellersApi provideFavoriteSellersApi(RetrofitFactory retrofitFactory) {
        return (FavoriteSellersApi) Preconditions.checkNotNullFromProvides(FavoriteSellersApiModule.INSTANCE.provideFavoriteSellersApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public FavoriteSellersApi get() {
        return provideFavoriteSellersApi(this.a.get());
    }
}
