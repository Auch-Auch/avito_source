package com.avito.android.brandspace.items.productcomparison;

import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemView;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProductComparisonItemMeasurer_Factory implements Factory<ProductComparisonItemMeasurer> {
    public final Provider<ProductComparisonItemView.Measurer> a;

    public ProductComparisonItemMeasurer_Factory(Provider<ProductComparisonItemView.Measurer> provider) {
        this.a = provider;
    }

    public static ProductComparisonItemMeasurer_Factory create(Provider<ProductComparisonItemView.Measurer> provider) {
        return new ProductComparisonItemMeasurer_Factory(provider);
    }

    public static ProductComparisonItemMeasurer newInstance(Lazy<ProductComparisonItemView.Measurer> lazy) {
        return new ProductComparisonItemMeasurer(lazy);
    }

    @Override // javax.inject.Provider
    public ProductComparisonItemMeasurer get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
