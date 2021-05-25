package com.avito.android.brandspace.items.productdescriptions;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProductDescriptionItemBlueprint_Factory implements Factory<ProductDescriptionItemBlueprint> {
    public final Provider<ProductDescriptionPresenter> a;

    public ProductDescriptionItemBlueprint_Factory(Provider<ProductDescriptionPresenter> provider) {
        this.a = provider;
    }

    public static ProductDescriptionItemBlueprint_Factory create(Provider<ProductDescriptionPresenter> provider) {
        return new ProductDescriptionItemBlueprint_Factory(provider);
    }

    public static ProductDescriptionItemBlueprint newInstance(ProductDescriptionPresenter productDescriptionPresenter) {
        return new ProductDescriptionItemBlueprint(productDescriptionPresenter);
    }

    @Override // javax.inject.Provider
    public ProductDescriptionItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
