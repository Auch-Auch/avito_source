package com.avito.android.messenger.map.search.di;

import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GeoSearchFragmentModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<GeoSearchSuggestItemBlueprint> a;

    public GeoSearchFragmentModule_ProvideItemBinderFactory(Provider<GeoSearchSuggestItemBlueprint> provider) {
        this.a = provider;
    }

    public static GeoSearchFragmentModule_ProvideItemBinderFactory create(Provider<GeoSearchSuggestItemBlueprint> provider) {
        return new GeoSearchFragmentModule_ProvideItemBinderFactory(provider);
    }

    public static ItemBinder provideItemBinder(GeoSearchSuggestItemBlueprint geoSearchSuggestItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(GeoSearchFragmentModule.provideItemBinder(geoSearchSuggestItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get());
    }
}
