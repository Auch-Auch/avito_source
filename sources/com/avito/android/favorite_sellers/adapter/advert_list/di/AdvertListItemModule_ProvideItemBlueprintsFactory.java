package com.avito.android.favorite_sellers.adapter.advert_list.di;

import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class AdvertListItemModule_ProvideItemBlueprintsFactory implements Factory<Set<ItemBlueprint<?, ?>>> {

    public static final class a {
        public static final AdvertListItemModule_ProvideItemBlueprintsFactory a = new AdvertListItemModule_ProvideItemBlueprintsFactory();
    }

    public static AdvertListItemModule_ProvideItemBlueprintsFactory create() {
        return a.a;
    }

    public static Set<ItemBlueprint<?, ?>> provideItemBlueprints() {
        return (Set) Preconditions.checkNotNullFromProvides(AdvertListItemModule.provideItemBlueprints());
    }

    @Override // javax.inject.Provider
    public Set<ItemBlueprint<?, ?>> get() {
        return provideItemBlueprints();
    }
}
