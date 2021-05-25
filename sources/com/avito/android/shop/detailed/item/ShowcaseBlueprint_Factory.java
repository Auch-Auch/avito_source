package com.avito.android.shop.detailed.item;

import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShowcaseBlueprint_Factory implements Factory<ShowcaseBlueprint> {
    public final Provider<ShowcaseItemPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<FavoriteAdvertsPresenter> c;
    public final Provider<ViewedAdvertsPresenter> d;
    public final Provider<ItemBinder> e;

    public ShowcaseBlueprint_Factory(Provider<ShowcaseItemPresenter> provider, Provider<AdapterPresenter> provider2, Provider<FavoriteAdvertsPresenter> provider3, Provider<ViewedAdvertsPresenter> provider4, Provider<ItemBinder> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static ShowcaseBlueprint_Factory create(Provider<ShowcaseItemPresenter> provider, Provider<AdapterPresenter> provider2, Provider<FavoriteAdvertsPresenter> provider3, Provider<ViewedAdvertsPresenter> provider4, Provider<ItemBinder> provider5) {
        return new ShowcaseBlueprint_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ShowcaseBlueprint newInstance(ShowcaseItemPresenter showcaseItemPresenter, AdapterPresenter adapterPresenter, FavoriteAdvertsPresenter favoriteAdvertsPresenter, ViewedAdvertsPresenter viewedAdvertsPresenter, ItemBinder itemBinder) {
        return new ShowcaseBlueprint(showcaseItemPresenter, adapterPresenter, favoriteAdvertsPresenter, viewedAdvertsPresenter, itemBinder);
    }

    @Override // javax.inject.Provider
    public ShowcaseBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
