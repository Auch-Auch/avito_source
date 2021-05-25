package com.avito.android.di.module;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class PublishJsonModule_ProvideTypeAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {

    public static final class a {
        public static final PublishJsonModule_ProvideTypeAdapterFactoriesFactory a = new PublishJsonModule_ProvideTypeAdapterFactoriesFactory();
    }

    public static PublishJsonModule_ProvideTypeAdapterFactoriesFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterFactory> provideTypeAdapterFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(PublishJsonModule.provideTypeAdapterFactories());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideTypeAdapterFactories();
    }
}
