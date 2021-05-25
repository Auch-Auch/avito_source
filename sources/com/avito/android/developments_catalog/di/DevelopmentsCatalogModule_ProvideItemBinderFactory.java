package com.avito.android.developments_catalog.di;

import com.avito.android.advert_core.map.MapBlueprint;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class DevelopmentsCatalogModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<Set<ItemBlueprint<?, ?>>> a;
    public final Provider<MapBlueprint> b;

    public DevelopmentsCatalogModule_ProvideItemBinderFactory(Provider<Set<ItemBlueprint<?, ?>>> provider, Provider<MapBlueprint> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DevelopmentsCatalogModule_ProvideItemBinderFactory create(Provider<Set<ItemBlueprint<?, ?>>> provider, Provider<MapBlueprint> provider2) {
        return new DevelopmentsCatalogModule_ProvideItemBinderFactory(provider, provider2);
    }

    public static ItemBinder provideItemBinder(Set<ItemBlueprint<?, ?>> set, MapBlueprint mapBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(DevelopmentsCatalogModule.provideItemBinder(set, mapBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get());
    }
}
