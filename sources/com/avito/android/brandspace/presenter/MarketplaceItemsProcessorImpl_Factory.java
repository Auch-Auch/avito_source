package com.avito.android.brandspace.presenter;

import dagger.internal.Factory;
public final class MarketplaceItemsProcessorImpl_Factory implements Factory<MarketplaceItemsProcessorImpl> {

    public static final class a {
        public static final MarketplaceItemsProcessorImpl_Factory a = new MarketplaceItemsProcessorImpl_Factory();
    }

    public static MarketplaceItemsProcessorImpl_Factory create() {
        return a.a;
    }

    public static MarketplaceItemsProcessorImpl newInstance() {
        return new MarketplaceItemsProcessorImpl();
    }

    @Override // javax.inject.Provider
    public MarketplaceItemsProcessorImpl get() {
        return newInstance();
    }
}
