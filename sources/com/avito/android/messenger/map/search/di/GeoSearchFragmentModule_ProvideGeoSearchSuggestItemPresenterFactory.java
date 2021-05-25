package com.avito.android.messenger.map.search.di;

import com.avito.android.messenger.map.search.GeoSearchPresenter;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GeoSearchFragmentModule_ProvideGeoSearchSuggestItemPresenterFactory implements Factory<GeoSearchSuggestItemPresenter> {
    public final Provider<GeoSearchPresenter> a;

    public GeoSearchFragmentModule_ProvideGeoSearchSuggestItemPresenterFactory(Provider<GeoSearchPresenter> provider) {
        this.a = provider;
    }

    public static GeoSearchFragmentModule_ProvideGeoSearchSuggestItemPresenterFactory create(Provider<GeoSearchPresenter> provider) {
        return new GeoSearchFragmentModule_ProvideGeoSearchSuggestItemPresenterFactory(provider);
    }

    public static GeoSearchSuggestItemPresenter provideGeoSearchSuggestItemPresenter(GeoSearchPresenter geoSearchPresenter) {
        return (GeoSearchSuggestItemPresenter) Preconditions.checkNotNullFromProvides(GeoSearchFragmentModule.provideGeoSearchSuggestItemPresenter(geoSearchPresenter));
    }

    @Override // javax.inject.Provider
    public GeoSearchSuggestItemPresenter get() {
        return provideGeoSearchSuggestItemPresenter(this.a.get());
    }
}
