package com.avito.android.messenger.search.di;

import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ChannelsSearchModule_ProvidePaginationItemBlueprintFactory implements Factory<ItemBlueprint<?, ?>> {

    public static final class a {
        public static final ChannelsSearchModule_ProvidePaginationItemBlueprintFactory a = new ChannelsSearchModule_ProvidePaginationItemBlueprintFactory();
    }

    public static ChannelsSearchModule_ProvidePaginationItemBlueprintFactory create() {
        return a.a;
    }

    public static ItemBlueprint<?, ?> providePaginationItemBlueprint() {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(ChannelsSearchModule.providePaginationItemBlueprint());
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return providePaginationItemBlueprint();
    }
}
