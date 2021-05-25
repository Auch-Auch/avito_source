package com.avito.android.messenger.map.search.di;

import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItemBlueprint;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GeoSearchFragmentModule_ProvideGeoSearchSuggestItemBlueprintFactory implements Factory<GeoSearchSuggestItemBlueprint> {
    public final Provider<GeoSearchSuggestItemPresenter> a;

    public GeoSearchFragmentModule_ProvideGeoSearchSuggestItemBlueprintFactory(Provider<GeoSearchSuggestItemPresenter> provider) {
        this.a = provider;
    }

    public static GeoSearchFragmentModule_ProvideGeoSearchSuggestItemBlueprintFactory create(Provider<GeoSearchSuggestItemPresenter> provider) {
        return new GeoSearchFragmentModule_ProvideGeoSearchSuggestItemBlueprintFactory(provider);
    }

    public static GeoSearchSuggestItemBlueprint provideGeoSearchSuggestItemBlueprint(GeoSearchSuggestItemPresenter geoSearchSuggestItemPresenter) {
        return (GeoSearchSuggestItemBlueprint) Preconditions.checkNotNullFromProvides(GeoSearchFragmentModule.provideGeoSearchSuggestItemBlueprint(geoSearchSuggestItemPresenter));
    }

    @Override // javax.inject.Provider
    public GeoSearchSuggestItemBlueprint get() {
        return provideGeoSearchSuggestItemBlueprint(this.a.get());
    }
}
