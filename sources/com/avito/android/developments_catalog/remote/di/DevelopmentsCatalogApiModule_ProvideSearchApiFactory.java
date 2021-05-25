package com.avito.android.developments_catalog.remote.di;

import com.avito.android.developments_catalog.remote.DevelopmentsCatalogApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DevelopmentsCatalogApiModule_ProvideSearchApiFactory implements Factory<DevelopmentsCatalogApi> {
    public final Provider<RetrofitFactory> a;

    public DevelopmentsCatalogApiModule_ProvideSearchApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static DevelopmentsCatalogApiModule_ProvideSearchApiFactory create(Provider<RetrofitFactory> provider) {
        return new DevelopmentsCatalogApiModule_ProvideSearchApiFactory(provider);
    }

    public static DevelopmentsCatalogApi provideSearchApi(RetrofitFactory retrofitFactory) {
        return (DevelopmentsCatalogApi) Preconditions.checkNotNullFromProvides(DevelopmentsCatalogApiModule.INSTANCE.provideSearchApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public DevelopmentsCatalogApi get() {
        return provideSearchApi(this.a.get());
    }
}
