package com.avito.android;

import com.avito.android.categories.remote.CategoriesApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoriesInteractorImpl_Factory implements Factory<CategoriesInteractorImpl> {
    public final Provider<CategoriesApi> a;

    public CategoriesInteractorImpl_Factory(Provider<CategoriesApi> provider) {
        this.a = provider;
    }

    public static CategoriesInteractorImpl_Factory create(Provider<CategoriesApi> provider) {
        return new CategoriesInteractorImpl_Factory(provider);
    }

    public static CategoriesInteractorImpl newInstance(CategoriesApi categoriesApi) {
        return new CategoriesInteractorImpl(categoriesApi);
    }

    @Override // javax.inject.Provider
    public CategoriesInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
