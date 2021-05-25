package com.avito.android.brandspace.presenter.mappers;

import com.avito.android.IdProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceTabsModuleMapper_Factory implements Factory<MarketplaceTabsModuleMapper> {
    public final Provider<IdProvider> a;

    public MarketplaceTabsModuleMapper_Factory(Provider<IdProvider> provider) {
        this.a = provider;
    }

    public static MarketplaceTabsModuleMapper_Factory create(Provider<IdProvider> provider) {
        return new MarketplaceTabsModuleMapper_Factory(provider);
    }

    public static MarketplaceTabsModuleMapper newInstance(IdProvider idProvider) {
        return new MarketplaceTabsModuleMapper(idProvider);
    }

    @Override // javax.inject.Provider
    public MarketplaceTabsModuleMapper get() {
        return newInstance(this.a.get());
    }
}
