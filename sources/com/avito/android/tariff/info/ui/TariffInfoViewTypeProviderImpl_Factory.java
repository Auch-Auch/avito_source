package com.avito.android.tariff.info.ui;

import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
public final class TariffInfoViewTypeProviderImpl_Factory implements Factory<TariffInfoViewTypeProviderImpl> {
    public final Provider<Set<ItemBlueprint<?, ?>>> a;

    public TariffInfoViewTypeProviderImpl_Factory(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        this.a = provider;
    }

    public static TariffInfoViewTypeProviderImpl_Factory create(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        return new TariffInfoViewTypeProviderImpl_Factory(provider);
    }

    public static TariffInfoViewTypeProviderImpl newInstance(Set<ItemBlueprint<?, ?>> set) {
        return new TariffInfoViewTypeProviderImpl(set);
    }

    @Override // javax.inject.Provider
    public TariffInfoViewTypeProviderImpl get() {
        return newInstance(this.a.get());
    }
}
