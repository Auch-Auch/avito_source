package com.avito.android.tariff.fees_methods.recycler;

import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
public final class FeeMethodsViewTypeProviderImpl_Factory implements Factory<FeeMethodsViewTypeProviderImpl> {
    public final Provider<Set<ItemBlueprint<?, ?>>> a;

    public FeeMethodsViewTypeProviderImpl_Factory(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        this.a = provider;
    }

    public static FeeMethodsViewTypeProviderImpl_Factory create(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        return new FeeMethodsViewTypeProviderImpl_Factory(provider);
    }

    public static FeeMethodsViewTypeProviderImpl newInstance(Set<ItemBlueprint<?, ?>> set) {
        return new FeeMethodsViewTypeProviderImpl(set);
    }

    @Override // javax.inject.Provider
    public FeeMethodsViewTypeProviderImpl get() {
        return newInstance(this.a.get());
    }
}
