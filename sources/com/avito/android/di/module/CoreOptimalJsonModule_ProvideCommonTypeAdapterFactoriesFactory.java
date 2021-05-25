package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.remote.parse.adapter.stream_gson.TypedResultTypeAdapterFactory;
import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class CoreOptimalJsonModule_ProvideCommonTypeAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {
    public final Provider<TypedResultTypeAdapterFactory> a;
    public final Provider<Features> b;

    public CoreOptimalJsonModule_ProvideCommonTypeAdapterFactoriesFactory(Provider<TypedResultTypeAdapterFactory> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CoreOptimalJsonModule_ProvideCommonTypeAdapterFactoriesFactory create(Provider<TypedResultTypeAdapterFactory> provider, Provider<Features> provider2) {
        return new CoreOptimalJsonModule_ProvideCommonTypeAdapterFactoriesFactory(provider, provider2);
    }

    public static Set<TypeAdapterFactory> provideCommonTypeAdapterFactories(TypedResultTypeAdapterFactory typedResultTypeAdapterFactory, Features features) {
        return (Set) Preconditions.checkNotNullFromProvides(CoreOptimalJsonModule.provideCommonTypeAdapterFactories(typedResultTypeAdapterFactory, features));
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideCommonTypeAdapterFactories(this.a.get(), this.b.get());
    }
}
