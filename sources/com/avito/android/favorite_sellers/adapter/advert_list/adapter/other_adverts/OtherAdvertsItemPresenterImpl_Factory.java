package com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts;

import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.section.item.SectionItemWidthProvider;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class OtherAdvertsItemPresenterImpl_Factory implements Factory<OtherAdvertsItemPresenterImpl> {
    public final Provider<Consumer<FavoriteSellersItemAction>> a;
    public final Provider<SectionItemWidthProvider> b;

    public OtherAdvertsItemPresenterImpl_Factory(Provider<Consumer<FavoriteSellersItemAction>> provider, Provider<SectionItemWidthProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static OtherAdvertsItemPresenterImpl_Factory create(Provider<Consumer<FavoriteSellersItemAction>> provider, Provider<SectionItemWidthProvider> provider2) {
        return new OtherAdvertsItemPresenterImpl_Factory(provider, provider2);
    }

    public static OtherAdvertsItemPresenterImpl newInstance(Consumer<FavoriteSellersItemAction> consumer, SectionItemWidthProvider sectionItemWidthProvider) {
        return new OtherAdvertsItemPresenterImpl(consumer, sectionItemWidthProvider);
    }

    @Override // javax.inject.Provider
    public OtherAdvertsItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
