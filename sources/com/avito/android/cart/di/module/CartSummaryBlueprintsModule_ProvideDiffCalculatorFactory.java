package com.avito.android.cart.di.module;

import com.avito.android.recycler.data_aware.DiffCalculator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CartSummaryBlueprintsModule_ProvideDiffCalculatorFactory implements Factory<DiffCalculator> {

    public static final class a {
        public static final CartSummaryBlueprintsModule_ProvideDiffCalculatorFactory a = new CartSummaryBlueprintsModule_ProvideDiffCalculatorFactory();
    }

    public static CartSummaryBlueprintsModule_ProvideDiffCalculatorFactory create() {
        return a.a;
    }

    public static DiffCalculator provideDiffCalculator() {
        return (DiffCalculator) Preconditions.checkNotNullFromProvides(CartSummaryBlueprintsModule.INSTANCE.provideDiffCalculator());
    }

    @Override // javax.inject.Provider
    public DiffCalculator get() {
        return provideDiffCalculator();
    }
}
