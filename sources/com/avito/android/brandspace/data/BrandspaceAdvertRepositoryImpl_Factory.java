package com.avito.android.brandspace.data;

import com.avito.android.brandspace.presenter.MarketplaceItemsProcessor;
import com.avito.android.brandspace.remote.BrandspaceApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandspaceAdvertRepositoryImpl_Factory implements Factory<BrandspaceAdvertRepositoryImpl> {
    public final Provider<BrandspaceApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<MarketplaceItemsProcessor> c;
    public final Provider<BuildInfo> d;

    public BrandspaceAdvertRepositoryImpl_Factory(Provider<BrandspaceApi> provider, Provider<SchedulersFactory3> provider2, Provider<MarketplaceItemsProcessor> provider3, Provider<BuildInfo> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static BrandspaceAdvertRepositoryImpl_Factory create(Provider<BrandspaceApi> provider, Provider<SchedulersFactory3> provider2, Provider<MarketplaceItemsProcessor> provider3, Provider<BuildInfo> provider4) {
        return new BrandspaceAdvertRepositoryImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static BrandspaceAdvertRepositoryImpl newInstance(BrandspaceApi brandspaceApi, SchedulersFactory3 schedulersFactory3, MarketplaceItemsProcessor marketplaceItemsProcessor, BuildInfo buildInfo) {
        return new BrandspaceAdvertRepositoryImpl(brandspaceApi, schedulersFactory3, marketplaceItemsProcessor, buildInfo);
    }

    @Override // javax.inject.Provider
    public BrandspaceAdvertRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
