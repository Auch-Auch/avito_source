package com.avito.android.brandspace.items.categories.categoryitem;

import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoryItemPresenterImpl_Factory implements Factory<CategoryItemPresenterImpl> {
    public final Provider<BrandspacePresenter> a;
    public final Provider<BrandspaceAnalyticsInteractor> b;

    public CategoryItemPresenterImpl_Factory(Provider<BrandspacePresenter> provider, Provider<BrandspaceAnalyticsInteractor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CategoryItemPresenterImpl_Factory create(Provider<BrandspacePresenter> provider, Provider<BrandspaceAnalyticsInteractor> provider2) {
        return new CategoryItemPresenterImpl_Factory(provider, provider2);
    }

    public static CategoryItemPresenterImpl newInstance(BrandspacePresenter brandspacePresenter, BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor) {
        return new CategoryItemPresenterImpl(brandspacePresenter, brandspaceAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public CategoryItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
