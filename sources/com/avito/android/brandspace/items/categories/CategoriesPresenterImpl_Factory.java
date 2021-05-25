package com.avito.android.brandspace.items.categories;

import com.avito.android.brandspace.presenter.BrandspacePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoriesPresenterImpl_Factory implements Factory<CategoriesPresenterImpl> {
    public final Provider<BrandspacePresenter> a;

    public CategoriesPresenterImpl_Factory(Provider<BrandspacePresenter> provider) {
        this.a = provider;
    }

    public static CategoriesPresenterImpl_Factory create(Provider<BrandspacePresenter> provider) {
        return new CategoriesPresenterImpl_Factory(provider);
    }

    public static CategoriesPresenterImpl newInstance(BrandspacePresenter brandspacePresenter) {
        return new CategoriesPresenterImpl(brandspacePresenter);
    }

    @Override // javax.inject.Provider
    public CategoriesPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
