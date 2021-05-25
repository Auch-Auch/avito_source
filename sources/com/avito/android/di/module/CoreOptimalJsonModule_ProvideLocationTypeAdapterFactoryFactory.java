package com.avito.android.di.module;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class CoreOptimalJsonModule_ProvideLocationTypeAdapterFactoryFactory implements Factory<Set<TypeAdapterFactory>> {

    public static final class a {
        public static final CoreOptimalJsonModule_ProvideLocationTypeAdapterFactoryFactory a = new CoreOptimalJsonModule_ProvideLocationTypeAdapterFactoryFactory();
    }

    public static CoreOptimalJsonModule_ProvideLocationTypeAdapterFactoryFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterFactory> provideLocationTypeAdapterFactory() {
        return (Set) Preconditions.checkNotNullFromProvides(CoreOptimalJsonModule.INSTANCE.provideLocationTypeAdapterFactory());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideLocationTypeAdapterFactory();
    }
}
