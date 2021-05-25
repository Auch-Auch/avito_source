package com.avito.android.di.module;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class CoreOptimalJsonModule_ProvideCaseTextTypeAdapterFactoryFactory implements Factory<Set<TypeAdapterFactory>> {

    public static final class a {
        public static final CoreOptimalJsonModule_ProvideCaseTextTypeAdapterFactoryFactory a = new CoreOptimalJsonModule_ProvideCaseTextTypeAdapterFactoryFactory();
    }

    public static CoreOptimalJsonModule_ProvideCaseTextTypeAdapterFactoryFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterFactory> provideCaseTextTypeAdapterFactory() {
        return (Set) Preconditions.checkNotNullFromProvides(CoreOptimalJsonModule.INSTANCE.provideCaseTextTypeAdapterFactory());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideCaseTextTypeAdapterFactory();
    }
}
