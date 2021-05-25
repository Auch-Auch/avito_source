package com.avito.android.brandspace.items.productcomparison;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProductComparisonItemBlueprint_Factory implements Factory<ProductComparisonItemBlueprint> {
    public final Provider<ProductComparisonItemPresenter> a;

    public ProductComparisonItemBlueprint_Factory(Provider<ProductComparisonItemPresenter> provider) {
        this.a = provider;
    }

    public static ProductComparisonItemBlueprint_Factory create(Provider<ProductComparisonItemPresenter> provider) {
        return new ProductComparisonItemBlueprint_Factory(provider);
    }

    public static ProductComparisonItemBlueprint newInstance(ProductComparisonItemPresenter productComparisonItemPresenter) {
        return new ProductComparisonItemBlueprint(productComparisonItemPresenter);
    }

    @Override // javax.inject.Provider
    public ProductComparisonItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
