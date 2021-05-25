package com.avito.android.cart.summary.konveyor.product;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class ProductItemBlueprint_Factory implements Factory<ProductItemBlueprint> {
    public final Provider<ProductItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;
    public final Provider<Observable<Integer>> c;

    public ProductItemBlueprint_Factory(Provider<ProductItemPresenter> provider, Provider<AttributedTextFormatter> provider2, Provider<Observable<Integer>> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ProductItemBlueprint_Factory create(Provider<ProductItemPresenter> provider, Provider<AttributedTextFormatter> provider2, Provider<Observable<Integer>> provider3) {
        return new ProductItemBlueprint_Factory(provider, provider2, provider3);
    }

    public static ProductItemBlueprint newInstance(ProductItemPresenter productItemPresenter, AttributedTextFormatter attributedTextFormatter, Observable<Integer> observable) {
        return new ProductItemBlueprint(productItemPresenter, attributedTextFormatter, observable);
    }

    @Override // javax.inject.Provider
    public ProductItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
