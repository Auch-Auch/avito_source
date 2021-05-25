package com.avito.android.brandspace.items.marketplace.categories;

import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoryPresenterImpl_Factory implements Factory<CategoryPresenterImpl> {
    public final Provider<BrandspacePresenter> a;
    public final Provider<BrandspaceAnalyticsInteractor> b;

    public CategoryPresenterImpl_Factory(Provider<BrandspacePresenter> provider, Provider<BrandspaceAnalyticsInteractor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CategoryPresenterImpl_Factory create(Provider<BrandspacePresenter> provider, Provider<BrandspaceAnalyticsInteractor> provider2) {
        return new CategoryPresenterImpl_Factory(provider, provider2);
    }

    public static CategoryPresenterImpl newInstance(BrandspacePresenter brandspacePresenter, BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor) {
        return new CategoryPresenterImpl(brandspacePresenter, brandspaceAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public CategoryPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
