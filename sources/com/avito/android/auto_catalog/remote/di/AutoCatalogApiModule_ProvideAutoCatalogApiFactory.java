package com.avito.android.auto_catalog.remote.di;

import com.avito.android.auto_catalog.remote.AutoCatalogApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AutoCatalogApiModule_ProvideAutoCatalogApiFactory implements Factory<AutoCatalogApi> {
    public final Provider<RetrofitFactory> a;

    public AutoCatalogApiModule_ProvideAutoCatalogApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static AutoCatalogApiModule_ProvideAutoCatalogApiFactory create(Provider<RetrofitFactory> provider) {
        return new AutoCatalogApiModule_ProvideAutoCatalogApiFactory(provider);
    }

    public static AutoCatalogApi provideAutoCatalogApi(RetrofitFactory retrofitFactory) {
        return (AutoCatalogApi) Preconditions.checkNotNullFromProvides(AutoCatalogApiModule.INSTANCE.provideAutoCatalogApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public AutoCatalogApi get() {
        return provideAutoCatalogApi(this.a.get());
    }
}
