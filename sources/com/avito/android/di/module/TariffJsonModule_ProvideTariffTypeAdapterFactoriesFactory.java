package com.avito.android.di.module;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class TariffJsonModule_ProvideTariffTypeAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {

    public static final class a {
        public static final TariffJsonModule_ProvideTariffTypeAdapterFactoriesFactory a = new TariffJsonModule_ProvideTariffTypeAdapterFactoriesFactory();
    }

    public static TariffJsonModule_ProvideTariffTypeAdapterFactoriesFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterFactory> provideTariffTypeAdapterFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(TariffJsonModule.provideTariffTypeAdapterFactories());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideTariffTypeAdapterFactories();
    }
}
