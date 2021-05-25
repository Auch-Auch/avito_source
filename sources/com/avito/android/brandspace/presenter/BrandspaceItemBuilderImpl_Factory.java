package com.avito.android.brandspace.presenter;

import com.avito.android.IdProvider;
import com.avito.android.brandspace.items.textmeasurement.ItemsMeasurer;
import com.avito.android.brandspace.presenter.mappers.BrandspaceElementMapper;
import com.avito.android.brandspace.remote.model.MarketplaceTabsModule;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandspaceItemBuilderImpl_Factory implements Factory<BrandspaceItemBuilderImpl> {
    public final Provider<IdProvider> a;
    public final Provider<ItemsMeasurer> b;
    public final Provider<FavoriteStatusResolver> c;
    public final Provider<BrandspaceResourcesProvider> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<BrandspaceElementMapper<MarketplaceTabsModule>> f;

    public BrandspaceItemBuilderImpl_Factory(Provider<IdProvider> provider, Provider<ItemsMeasurer> provider2, Provider<FavoriteStatusResolver> provider3, Provider<BrandspaceResourcesProvider> provider4, Provider<SchedulersFactory3> provider5, Provider<BrandspaceElementMapper<MarketplaceTabsModule>> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static BrandspaceItemBuilderImpl_Factory create(Provider<IdProvider> provider, Provider<ItemsMeasurer> provider2, Provider<FavoriteStatusResolver> provider3, Provider<BrandspaceResourcesProvider> provider4, Provider<SchedulersFactory3> provider5, Provider<BrandspaceElementMapper<MarketplaceTabsModule>> provider6) {
        return new BrandspaceItemBuilderImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static BrandspaceItemBuilderImpl newInstance(IdProvider idProvider, ItemsMeasurer itemsMeasurer, FavoriteStatusResolver favoriteStatusResolver, BrandspaceResourcesProvider brandspaceResourcesProvider, SchedulersFactory3 schedulersFactory3, BrandspaceElementMapper<MarketplaceTabsModule> brandspaceElementMapper) {
        return new BrandspaceItemBuilderImpl(idProvider, itemsMeasurer, favoriteStatusResolver, brandspaceResourcesProvider, schedulersFactory3, brandspaceElementMapper);
    }

    @Override // javax.inject.Provider
    public BrandspaceItemBuilderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
