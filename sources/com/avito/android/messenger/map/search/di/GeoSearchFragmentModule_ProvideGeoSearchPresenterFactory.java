package com.avito.android.messenger.map.search.di;

import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.map.search.GeoSearchFragment;
import com.avito.android.messenger.map.search.GeoSearchPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GeoSearchFragmentModule_ProvideGeoSearchPresenterFactory implements Factory<GeoSearchPresenter> {
    public final Provider<GeoSearchFragment> a;
    public final Provider<ViewModelFactory> b;

    public GeoSearchFragmentModule_ProvideGeoSearchPresenterFactory(Provider<GeoSearchFragment> provider, Provider<ViewModelFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static GeoSearchFragmentModule_ProvideGeoSearchPresenterFactory create(Provider<GeoSearchFragment> provider, Provider<ViewModelFactory> provider2) {
        return new GeoSearchFragmentModule_ProvideGeoSearchPresenterFactory(provider, provider2);
    }

    public static GeoSearchPresenter provideGeoSearchPresenter(GeoSearchFragment geoSearchFragment, ViewModelFactory viewModelFactory) {
        return (GeoSearchPresenter) Preconditions.checkNotNullFromProvides(GeoSearchFragmentModule.provideGeoSearchPresenter(geoSearchFragment, viewModelFactory));
    }

    @Override // javax.inject.Provider
    public GeoSearchPresenter get() {
        return provideGeoSearchPresenter(this.a.get(), this.b.get());
    }
}
