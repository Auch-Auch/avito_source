package com.avito.android.categories.remote;

import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CategoriesApiModule_ProvideCategoriesApiFactory implements Factory<CategoriesApi> {
    public final Provider<RetrofitFactory> a;

    public CategoriesApiModule_ProvideCategoriesApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static CategoriesApiModule_ProvideCategoriesApiFactory create(Provider<RetrofitFactory> provider) {
        return new CategoriesApiModule_ProvideCategoriesApiFactory(provider);
    }

    public static CategoriesApi provideCategoriesApi(RetrofitFactory retrofitFactory) {
        return (CategoriesApi) Preconditions.checkNotNullFromProvides(CategoriesApiModule.INSTANCE.provideCategoriesApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public CategoriesApi get() {
        return provideCategoriesApi(this.a.get());
    }
}
