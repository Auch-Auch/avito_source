package com.avito.android.favorite_sellers.adapter.advert_list;

import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertListItemBlueprint_Factory implements Factory<AdvertListItemBlueprint> {
    public final Provider<AdvertListItemPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<FavoriteAdvertsPresenter> c;
    public final Provider<ViewedAdvertsPresenter> d;
    public final Provider<ItemBinder> e;

    public AdvertListItemBlueprint_Factory(Provider<AdvertListItemPresenter> provider, Provider<AdapterPresenter> provider2, Provider<FavoriteAdvertsPresenter> provider3, Provider<ViewedAdvertsPresenter> provider4, Provider<ItemBinder> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AdvertListItemBlueprint_Factory create(Provider<AdvertListItemPresenter> provider, Provider<AdapterPresenter> provider2, Provider<FavoriteAdvertsPresenter> provider3, Provider<ViewedAdvertsPresenter> provider4, Provider<ItemBinder> provider5) {
        return new AdvertListItemBlueprint_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AdvertListItemBlueprint newInstance(AdvertListItemPresenter advertListItemPresenter, Provider<AdapterPresenter> provider, Provider<FavoriteAdvertsPresenter> provider2, Provider<ViewedAdvertsPresenter> provider3, ItemBinder itemBinder) {
        return new AdvertListItemBlueprint(advertListItemPresenter, provider, provider2, provider3, itemBinder);
    }

    @Override // javax.inject.Provider
    public AdvertListItemBlueprint get() {
        return newInstance(this.a.get(), this.b, this.c, this.d, this.e.get());
    }
}
