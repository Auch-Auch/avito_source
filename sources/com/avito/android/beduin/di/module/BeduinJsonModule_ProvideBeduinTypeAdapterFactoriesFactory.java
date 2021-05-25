package com.avito.android.beduin.di.module;

import com.avito.android.beduin.core.registry.BeduinRegistry;
import com.avito.android.beduin.parse.BeduinActionParamsTypeAdapter;
import com.avito.android.beduin.parse.BeduinModelTypeAdapter;
import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class BeduinJsonModule_ProvideBeduinTypeAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {
    public final Provider<BeduinRegistry> a;
    public final Provider<BeduinModelTypeAdapter> b;
    public final Provider<BeduinActionParamsTypeAdapter> c;

    public BeduinJsonModule_ProvideBeduinTypeAdapterFactoriesFactory(Provider<BeduinRegistry> provider, Provider<BeduinModelTypeAdapter> provider2, Provider<BeduinActionParamsTypeAdapter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static BeduinJsonModule_ProvideBeduinTypeAdapterFactoriesFactory create(Provider<BeduinRegistry> provider, Provider<BeduinModelTypeAdapter> provider2, Provider<BeduinActionParamsTypeAdapter> provider3) {
        return new BeduinJsonModule_ProvideBeduinTypeAdapterFactoriesFactory(provider, provider2, provider3);
    }

    public static Set<TypeAdapterFactory> provideBeduinTypeAdapterFactories(BeduinRegistry beduinRegistry, BeduinModelTypeAdapter beduinModelTypeAdapter, BeduinActionParamsTypeAdapter beduinActionParamsTypeAdapter) {
        return (Set) Preconditions.checkNotNullFromProvides(BeduinJsonModule.INSTANCE.provideBeduinTypeAdapterFactories(beduinRegistry, beduinModelTypeAdapter, beduinActionParamsTypeAdapter));
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideBeduinTypeAdapterFactories(this.a.get(), this.b.get(), this.c.get());
    }
}
