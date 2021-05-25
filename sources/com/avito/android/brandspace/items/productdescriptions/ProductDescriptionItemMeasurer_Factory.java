package com.avito.android.brandspace.items.productdescriptions;

import com.avito.android.brandspace.items.news.NewsItemView;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProductDescriptionItemMeasurer_Factory implements Factory<ProductDescriptionItemMeasurer> {
    public final Provider<NewsItemView.Measurer> a;

    public ProductDescriptionItemMeasurer_Factory(Provider<NewsItemView.Measurer> provider) {
        this.a = provider;
    }

    public static ProductDescriptionItemMeasurer_Factory create(Provider<NewsItemView.Measurer> provider) {
        return new ProductDescriptionItemMeasurer_Factory(provider);
    }

    public static ProductDescriptionItemMeasurer newInstance(Lazy<NewsItemView.Measurer> lazy) {
        return new ProductDescriptionItemMeasurer(lazy);
    }

    @Override // javax.inject.Provider
    public ProductDescriptionItemMeasurer get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
