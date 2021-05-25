package com.avito.android.di.module;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class CoreOptimalJsonModule_ProvideSerpElementAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {

    public static final class a {
        public static final CoreOptimalJsonModule_ProvideSerpElementAdapterFactoriesFactory a = new CoreOptimalJsonModule_ProvideSerpElementAdapterFactoriesFactory();
    }

    public static CoreOptimalJsonModule_ProvideSerpElementAdapterFactoriesFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterFactory> provideSerpElementAdapterFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(CoreOptimalJsonModule.provideSerpElementAdapterFactories());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideSerpElementAdapterFactories();
    }
}
