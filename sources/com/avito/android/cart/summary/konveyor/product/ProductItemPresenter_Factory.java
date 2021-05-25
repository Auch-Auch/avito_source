package com.avito.android.cart.summary.konveyor.product;

import com.avito.android.cart.analytics.summary.StepperUsageType;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
import kotlin.Pair;
public final class ProductItemPresenter_Factory implements Factory<ProductItemPresenter> {
    public final Provider<Consumer<Pair<ProductItem, Integer>>> a;
    public final Provider<Consumer<ProductItem>> b;
    public final Provider<Consumer<String>> c;
    public final Provider<Consumer<Integer>> d;
    public final Provider<Consumer<Pair<ProductItem, StepperUsageType>>> e;

    public ProductItemPresenter_Factory(Provider<Consumer<Pair<ProductItem, Integer>>> provider, Provider<Consumer<ProductItem>> provider2, Provider<Consumer<String>> provider3, Provider<Consumer<Integer>> provider4, Provider<Consumer<Pair<ProductItem, StepperUsageType>>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static ProductItemPresenter_Factory create(Provider<Consumer<Pair<ProductItem, Integer>>> provider, Provider<Consumer<ProductItem>> provider2, Provider<Consumer<String>> provider3, Provider<Consumer<Integer>> provider4, Provider<Consumer<Pair<ProductItem, StepperUsageType>>> provider5) {
        return new ProductItemPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ProductItemPresenter newInstance(Consumer<Pair<ProductItem, Integer>> consumer, Consumer<ProductItem> consumer2, Consumer<String> consumer3, Consumer<Integer> consumer4, Consumer<Pair<ProductItem, StepperUsageType>> consumer5) {
        return new ProductItemPresenter(consumer, consumer2, consumer3, consumer4, consumer5);
    }

    @Override // javax.inject.Provider
    public ProductItemPresenter get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
