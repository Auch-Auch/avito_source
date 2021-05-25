package com.avito.android.brandspace.items.productcomparison;

import com.avito.android.brandspace.presenter.BrandspacePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProductComparisonItemPresenterImpl_Factory implements Factory<ProductComparisonItemPresenterImpl> {
    public final Provider<BrandspacePresenter> a;

    public ProductComparisonItemPresenterImpl_Factory(Provider<BrandspacePresenter> provider) {
        this.a = provider;
    }

    public static ProductComparisonItemPresenterImpl_Factory create(Provider<BrandspacePresenter> provider) {
        return new ProductComparisonItemPresenterImpl_Factory(provider);
    }

    public static ProductComparisonItemPresenterImpl newInstance(BrandspacePresenter brandspacePresenter) {
        return new ProductComparisonItemPresenterImpl(brandspacePresenter);
    }

    @Override // javax.inject.Provider
    public ProductComparisonItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
