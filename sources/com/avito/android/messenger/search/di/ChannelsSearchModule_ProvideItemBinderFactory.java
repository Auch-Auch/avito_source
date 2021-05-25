package com.avito.android.messenger.search.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class ChannelsSearchModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<Set<ItemBlueprint<?, ?>>> a;

    public ChannelsSearchModule_ProvideItemBinderFactory(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        this.a = provider;
    }

    public static ChannelsSearchModule_ProvideItemBinderFactory create(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        return new ChannelsSearchModule_ProvideItemBinderFactory(provider);
    }

    public static ItemBinder provideItemBinder(Set<ItemBlueprint<?, ?>> set) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(ChannelsSearchModule.provideItemBinder(set));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get());
    }
}
