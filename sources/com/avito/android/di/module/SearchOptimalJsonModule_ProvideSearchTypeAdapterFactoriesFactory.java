package com.avito.android.di.module;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class SearchOptimalJsonModule_ProvideSearchTypeAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {

    public static final class a {
        public static final SearchOptimalJsonModule_ProvideSearchTypeAdapterFactoriesFactory a = new SearchOptimalJsonModule_ProvideSearchTypeAdapterFactoriesFactory();
    }

    public static SearchOptimalJsonModule_ProvideSearchTypeAdapterFactoriesFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterFactory> provideSearchTypeAdapterFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(SearchOptimalJsonModule.provideSearchTypeAdapterFactories());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideSearchTypeAdapterFactories();
    }
}
