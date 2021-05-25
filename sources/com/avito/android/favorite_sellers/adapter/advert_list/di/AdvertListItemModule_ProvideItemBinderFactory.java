package com.avito.android.favorite_sellers.adapter.advert_list.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class AdvertListItemModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<Set<ItemBlueprint<?, ?>>> a;

    public AdvertListItemModule_ProvideItemBinderFactory(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        this.a = provider;
    }

    public static AdvertListItemModule_ProvideItemBinderFactory create(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        return new AdvertListItemModule_ProvideItemBinderFactory(provider);
    }

    public static ItemBinder provideItemBinder(Set<ItemBlueprint<?, ?>> set) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(AdvertListItemModule.provideItemBinder(set));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get());
    }
}
