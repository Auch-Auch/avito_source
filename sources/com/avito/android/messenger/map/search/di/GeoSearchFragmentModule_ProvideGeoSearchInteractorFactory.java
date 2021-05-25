package com.avito.android.messenger.map.search.di;

import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.map.search.GeoSearchFragment;
import com.avito.android.messenger.map.search.GeoSearchInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GeoSearchFragmentModule_ProvideGeoSearchInteractorFactory implements Factory<GeoSearchInteractor> {
    public final Provider<GeoSearchFragment> a;
    public final Provider<ViewModelFactory> b;

    public GeoSearchFragmentModule_ProvideGeoSearchInteractorFactory(Provider<GeoSearchFragment> provider, Provider<ViewModelFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static GeoSearchFragmentModule_ProvideGeoSearchInteractorFactory create(Provider<GeoSearchFragment> provider, Provider<ViewModelFactory> provider2) {
        return new GeoSearchFragmentModule_ProvideGeoSearchInteractorFactory(provider, provider2);
    }

    public static GeoSearchInteractor provideGeoSearchInteractor(GeoSearchFragment geoSearchFragment, ViewModelFactory viewModelFactory) {
        return (GeoSearchInteractor) Preconditions.checkNotNullFromProvides(GeoSearchFragmentModule.provideGeoSearchInteractor(geoSearchFragment, viewModelFactory));
    }

    @Override // javax.inject.Provider
    public GeoSearchInteractor get() {
        return provideGeoSearchInteractor(this.a.get(), this.b.get());
    }
}
