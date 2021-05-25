package com.avito.android.di;

import com.avito.android.CategoriesInteractor;
import com.avito.android.categories.remote.CategoriesApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CategoriesModule_ProvideCategoriesInteractorFactory implements Factory<CategoriesInteractor> {
    public final Provider<CategoriesApi> a;

    public CategoriesModule_ProvideCategoriesInteractorFactory(Provider<CategoriesApi> provider) {
        this.a = provider;
    }

    public static CategoriesModule_ProvideCategoriesInteractorFactory create(Provider<CategoriesApi> provider) {
        return new CategoriesModule_ProvideCategoriesInteractorFactory(provider);
    }

    public static CategoriesInteractor provideCategoriesInteractor(CategoriesApi categoriesApi) {
        return (CategoriesInteractor) Preconditions.checkNotNullFromProvides(CategoriesModule.provideCategoriesInteractor(categoriesApi));
    }

    @Override // javax.inject.Provider
    public CategoriesInteractor get() {
        return provideCategoriesInteractor(this.a.get());
    }
}
