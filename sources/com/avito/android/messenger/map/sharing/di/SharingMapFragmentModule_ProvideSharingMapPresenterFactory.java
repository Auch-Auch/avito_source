package com.avito.android.messenger.map.sharing.di;

import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.map.sharing.SharingMapFragment;
import com.avito.android.messenger.map.sharing.SharingMapPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SharingMapFragmentModule_ProvideSharingMapPresenterFactory implements Factory<SharingMapPresenter> {
    public final Provider<SharingMapFragment> a;
    public final Provider<ViewModelFactory> b;

    public SharingMapFragmentModule_ProvideSharingMapPresenterFactory(Provider<SharingMapFragment> provider, Provider<ViewModelFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SharingMapFragmentModule_ProvideSharingMapPresenterFactory create(Provider<SharingMapFragment> provider, Provider<ViewModelFactory> provider2) {
        return new SharingMapFragmentModule_ProvideSharingMapPresenterFactory(provider, provider2);
    }

    public static SharingMapPresenter provideSharingMapPresenter(SharingMapFragment sharingMapFragment, ViewModelFactory viewModelFactory) {
        return (SharingMapPresenter) Preconditions.checkNotNullFromProvides(SharingMapFragmentModule.provideSharingMapPresenter(sharingMapFragment, viewModelFactory));
    }

    @Override // javax.inject.Provider
    public SharingMapPresenter get() {
        return provideSharingMapPresenter(this.a.get(), this.b.get());
    }
}
