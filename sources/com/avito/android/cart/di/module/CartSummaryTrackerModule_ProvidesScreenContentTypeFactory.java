package com.avito.android.cart.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CartSummaryTrackerModule_ProvidesScreenContentTypeFactory implements Factory<String> {

    public static final class a {
        public static final CartSummaryTrackerModule_ProvidesScreenContentTypeFactory a = new CartSummaryTrackerModule_ProvidesScreenContentTypeFactory();
    }

    public static CartSummaryTrackerModule_ProvidesScreenContentTypeFactory create() {
        return a.a;
    }

    public static String providesScreenContentType() {
        return (String) Preconditions.checkNotNullFromProvides(CartSummaryTrackerModule.INSTANCE.providesScreenContentType());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesScreenContentType();
    }
}
