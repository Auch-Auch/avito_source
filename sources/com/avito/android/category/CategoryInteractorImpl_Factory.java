package com.avito.android.category;

import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.model.SearchParamsConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoryInteractorImpl_Factory implements Factory<CategoryInteractorImpl> {
    public final Provider<CategoryInteractorState> a;
    public final Provider<SavedLocationInteractor> b;
    public final Provider<SearchApi> c;
    public final Provider<SearchParamsConverter> d;

    public CategoryInteractorImpl_Factory(Provider<CategoryInteractorState> provider, Provider<SavedLocationInteractor> provider2, Provider<SearchApi> provider3, Provider<SearchParamsConverter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static CategoryInteractorImpl_Factory create(Provider<CategoryInteractorState> provider, Provider<SavedLocationInteractor> provider2, Provider<SearchApi> provider3, Provider<SearchParamsConverter> provider4) {
        return new CategoryInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static CategoryInteractorImpl newInstance(CategoryInteractorState categoryInteractorState, SavedLocationInteractor savedLocationInteractor, SearchApi searchApi, SearchParamsConverter searchParamsConverter) {
        return new CategoryInteractorImpl(categoryInteractorState, savedLocationInteractor, searchApi, searchParamsConverter);
    }

    @Override // javax.inject.Provider
    public CategoryInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
