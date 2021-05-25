package com.avito.android.serp.adapter.witcher;

import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class WitcherItemBlueprint_Factory implements Factory<WitcherItemBlueprint> {
    public final Provider<WitcherItemPresenter> a;
    public final Provider<ItemBinder> b;
    public final Provider<WitcherResourceProvider> c;
    public final Provider<ViewedAdvertsPresenter> d;
    public final Provider<FavoriteAdvertsPresenter> e;
    public final Provider<SimpleAdapterPresenter> f;
    public final Provider<DeviceMetrics> g;

    public WitcherItemBlueprint_Factory(Provider<WitcherItemPresenter> provider, Provider<ItemBinder> provider2, Provider<WitcherResourceProvider> provider3, Provider<ViewedAdvertsPresenter> provider4, Provider<FavoriteAdvertsPresenter> provider5, Provider<SimpleAdapterPresenter> provider6, Provider<DeviceMetrics> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static WitcherItemBlueprint_Factory create(Provider<WitcherItemPresenter> provider, Provider<ItemBinder> provider2, Provider<WitcherResourceProvider> provider3, Provider<ViewedAdvertsPresenter> provider4, Provider<FavoriteAdvertsPresenter> provider5, Provider<SimpleAdapterPresenter> provider6, Provider<DeviceMetrics> provider7) {
        return new WitcherItemBlueprint_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static WitcherItemBlueprint newInstance(WitcherItemPresenter witcherItemPresenter, ItemBinder itemBinder, WitcherResourceProvider witcherResourceProvider, ViewedAdvertsPresenter viewedAdvertsPresenter, FavoriteAdvertsPresenter favoriteAdvertsPresenter, SimpleAdapterPresenter simpleAdapterPresenter, DeviceMetrics deviceMetrics) {
        return new WitcherItemBlueprint(witcherItemPresenter, itemBinder, witcherResourceProvider, viewedAdvertsPresenter, favoriteAdvertsPresenter, simpleAdapterPresenter, deviceMetrics);
    }

    @Override // javax.inject.Provider
    public WitcherItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
