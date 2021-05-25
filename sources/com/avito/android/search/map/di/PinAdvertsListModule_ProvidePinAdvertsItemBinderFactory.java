package com.avito.android.search.map.di;

import com.avito.android.serp.adapter.AdvertItemListBlueprint;
import com.avito.android.serp.adapter.SellerPinItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichSmallItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PinAdvertsListModule_ProvidePinAdvertsItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<AdvertItemListBlueprint> a;
    public final Provider<AdvertRichSmallItemBlueprint> b;
    public final Provider<SellerPinItemBlueprint> c;

    public PinAdvertsListModule_ProvidePinAdvertsItemBinderFactory(Provider<AdvertItemListBlueprint> provider, Provider<AdvertRichSmallItemBlueprint> provider2, Provider<SellerPinItemBlueprint> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PinAdvertsListModule_ProvidePinAdvertsItemBinderFactory create(Provider<AdvertItemListBlueprint> provider, Provider<AdvertRichSmallItemBlueprint> provider2, Provider<SellerPinItemBlueprint> provider3) {
        return new PinAdvertsListModule_ProvidePinAdvertsItemBinderFactory(provider, provider2, provider3);
    }

    public static ItemBinder providePinAdvertsItemBinder(AdvertItemListBlueprint advertItemListBlueprint, AdvertRichSmallItemBlueprint advertRichSmallItemBlueprint, SellerPinItemBlueprint sellerPinItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(PinAdvertsListModule.providePinAdvertsItemBinder(advertItemListBlueprint, advertRichSmallItemBlueprint, sellerPinItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return providePinAdvertsItemBinder(this.a.get(), this.b.get(), this.c.get());
    }
}
