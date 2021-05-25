package com.avito.android.brandspace.items.productcomparison;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProductComparisonItemPropertyMeasurer_Factory implements Factory<ProductComparisonItemPropertyMeasurer> {
    public final Provider<ProductComparisonPropertyMeasurer> a;

    public ProductComparisonItemPropertyMeasurer_Factory(Provider<ProductComparisonPropertyMeasurer> provider) {
        this.a = provider;
    }

    public static ProductComparisonItemPropertyMeasurer_Factory create(Provider<ProductComparisonPropertyMeasurer> provider) {
        return new ProductComparisonItemPropertyMeasurer_Factory(provider);
    }

    public static ProductComparisonItemPropertyMeasurer newInstance(Lazy<ProductComparisonPropertyMeasurer> lazy) {
        return new ProductComparisonItemPropertyMeasurer(lazy);
    }

    @Override // javax.inject.Provider
    public ProductComparisonItemPropertyMeasurer get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
