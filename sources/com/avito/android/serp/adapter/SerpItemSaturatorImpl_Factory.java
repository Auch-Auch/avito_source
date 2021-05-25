package com.avito.android.serp.adapter;

import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.serp.adapter.closable.ClosedItemInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpItemSaturatorImpl_Factory implements Factory<SerpItemSaturatorImpl> {
    public final Provider<FavoritesSyncDao> a;
    public final Provider<ViewedAdvertsInteractor> b;
    public final Provider<ClosedItemInteractor> c;

    public SerpItemSaturatorImpl_Factory(Provider<FavoritesSyncDao> provider, Provider<ViewedAdvertsInteractor> provider2, Provider<ClosedItemInteractor> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SerpItemSaturatorImpl_Factory create(Provider<FavoritesSyncDao> provider, Provider<ViewedAdvertsInteractor> provider2, Provider<ClosedItemInteractor> provider3) {
        return new SerpItemSaturatorImpl_Factory(provider, provider2, provider3);
    }

    public static SerpItemSaturatorImpl newInstance(FavoritesSyncDao favoritesSyncDao, ViewedAdvertsInteractor viewedAdvertsInteractor, ClosedItemInteractor closedItemInteractor) {
        return new SerpItemSaturatorImpl(favoritesSyncDao, viewedAdvertsInteractor, closedItemInteractor);
    }

    @Override // javax.inject.Provider
    public SerpItemSaturatorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
