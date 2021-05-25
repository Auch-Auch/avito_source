package com.avito.android.favorites.remote;

import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoritesApiModule_ProvideFavoritesApiFactory implements Factory<FavoritesApi> {
    public final Provider<RetrofitFactory> a;

    public FavoritesApiModule_ProvideFavoritesApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static FavoritesApiModule_ProvideFavoritesApiFactory create(Provider<RetrofitFactory> provider) {
        return new FavoritesApiModule_ProvideFavoritesApiFactory(provider);
    }

    public static FavoritesApi provideFavoritesApi(RetrofitFactory retrofitFactory) {
        return (FavoritesApi) Preconditions.checkNotNullFromProvides(FavoritesApiModule.INSTANCE.provideFavoritesApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public FavoritesApi get() {
        return provideFavoritesApi(this.a.get());
    }
}
