package com.avito.android.brandspace.di;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class BrandspaceOptimalJsonModule_ProvideBrandspaceTypeAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {

    public static final class a {
        public static final BrandspaceOptimalJsonModule_ProvideBrandspaceTypeAdapterFactoriesFactory a = new BrandspaceOptimalJsonModule_ProvideBrandspaceTypeAdapterFactoriesFactory();
    }

    public static BrandspaceOptimalJsonModule_ProvideBrandspaceTypeAdapterFactoriesFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterFactory> provideBrandspaceTypeAdapterFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(BrandspaceOptimalJsonModule.provideBrandspaceTypeAdapterFactories());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideBrandspaceTypeAdapterFactories();
    }
}
