package com.avito.android.remote.di;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class AbTestJsonModule_ProvideAbTestTypeAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {

    public static final class a {
        public static final AbTestJsonModule_ProvideAbTestTypeAdapterFactoriesFactory a = new AbTestJsonModule_ProvideAbTestTypeAdapterFactoriesFactory();
    }

    public static AbTestJsonModule_ProvideAbTestTypeAdapterFactoriesFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterFactory> provideAbTestTypeAdapterFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(AbTestJsonModule.provideAbTestTypeAdapterFactories());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideAbTestTypeAdapterFactories();
    }
}
