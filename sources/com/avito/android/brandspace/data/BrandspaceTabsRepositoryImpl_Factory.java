package com.avito.android.brandspace.data;

import com.avito.android.IdProvider;
import com.avito.android.brandspace.presenter.MarketplaceItemsProcessor;
import com.avito.android.brandspace.remote.BrandspaceApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandspaceTabsRepositoryImpl_Factory implements Factory<BrandspaceTabsRepositoryImpl> {
    public final Provider<BrandspaceApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<MarketplaceItemsProcessor> c;
    public final Provider<IdProvider> d;
    public final Provider<BuildInfo> e;

    public BrandspaceTabsRepositoryImpl_Factory(Provider<BrandspaceApi> provider, Provider<SchedulersFactory3> provider2, Provider<MarketplaceItemsProcessor> provider3, Provider<IdProvider> provider4, Provider<BuildInfo> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static BrandspaceTabsRepositoryImpl_Factory create(Provider<BrandspaceApi> provider, Provider<SchedulersFactory3> provider2, Provider<MarketplaceItemsProcessor> provider3, Provider<IdProvider> provider4, Provider<BuildInfo> provider5) {
        return new BrandspaceTabsRepositoryImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static BrandspaceTabsRepositoryImpl newInstance(BrandspaceApi brandspaceApi, SchedulersFactory3 schedulersFactory3, MarketplaceItemsProcessor marketplaceItemsProcessor, IdProvider idProvider, BuildInfo buildInfo) {
        return new BrandspaceTabsRepositoryImpl(brandspaceApi, schedulersFactory3, marketplaceItemsProcessor, idProvider, buildInfo);
    }

    @Override // javax.inject.Provider
    public BrandspaceTabsRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
