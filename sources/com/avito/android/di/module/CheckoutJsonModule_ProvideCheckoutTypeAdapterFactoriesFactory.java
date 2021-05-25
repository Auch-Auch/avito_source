package com.avito.android.di.module;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class CheckoutJsonModule_ProvideCheckoutTypeAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {

    public static final class a {
        public static final CheckoutJsonModule_ProvideCheckoutTypeAdapterFactoriesFactory a = new CheckoutJsonModule_ProvideCheckoutTypeAdapterFactoriesFactory();
    }

    public static CheckoutJsonModule_ProvideCheckoutTypeAdapterFactoriesFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterFactory> provideCheckoutTypeAdapterFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(CheckoutJsonModule.provideCheckoutTypeAdapterFactories());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideCheckoutTypeAdapterFactories();
    }
}
