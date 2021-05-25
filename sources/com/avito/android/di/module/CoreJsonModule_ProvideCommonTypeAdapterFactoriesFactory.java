package com.avito.android.di.module;

import com.avito.android.Features;
import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class CoreJsonModule_ProvideCommonTypeAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {
    public final Provider<Features> a;

    public CoreJsonModule_ProvideCommonTypeAdapterFactoriesFactory(Provider<Features> provider) {
        this.a = provider;
    }

    public static CoreJsonModule_ProvideCommonTypeAdapterFactoriesFactory create(Provider<Features> provider) {
        return new CoreJsonModule_ProvideCommonTypeAdapterFactoriesFactory(provider);
    }

    public static Set<TypeAdapterFactory> provideCommonTypeAdapterFactories(Features features) {
        return (Set) Preconditions.checkNotNullFromProvides(CoreJsonModule.provideCommonTypeAdapterFactories(features));
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideCommonTypeAdapterFactories(this.a.get());
    }
}
