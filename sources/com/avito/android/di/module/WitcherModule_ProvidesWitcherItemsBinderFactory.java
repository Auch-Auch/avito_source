package com.avito.android.di.module;

import com.avito.android.serp.adapter.AdvertItemGridBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class WitcherModule_ProvidesWitcherItemsBinderFactory implements Factory<ItemBinder> {
    public final Provider<AdvertItemGridBlueprint> a;

    public WitcherModule_ProvidesWitcherItemsBinderFactory(Provider<AdvertItemGridBlueprint> provider) {
        this.a = provider;
    }

    public static WitcherModule_ProvidesWitcherItemsBinderFactory create(Provider<AdvertItemGridBlueprint> provider) {
        return new WitcherModule_ProvidesWitcherItemsBinderFactory(provider);
    }

    public static ItemBinder providesWitcherItemsBinder(AdvertItemGridBlueprint advertItemGridBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(WitcherModule.INSTANCE.providesWitcherItemsBinder(advertItemGridBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return providesWitcherItemsBinder(this.a.get());
    }
}
