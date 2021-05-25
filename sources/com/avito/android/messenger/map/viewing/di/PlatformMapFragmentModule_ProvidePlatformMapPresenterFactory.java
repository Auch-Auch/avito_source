package com.avito.android.messenger.map.viewing.di;

import androidx.fragment.app.Fragment;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.map.viewing.PlatformMapPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PlatformMapFragmentModule_ProvidePlatformMapPresenterFactory implements Factory<PlatformMapPresenter> {
    public final Provider<ViewModelFactory> a;
    public final Provider<Fragment> b;

    public PlatformMapFragmentModule_ProvidePlatformMapPresenterFactory(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PlatformMapFragmentModule_ProvidePlatformMapPresenterFactory create(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        return new PlatformMapFragmentModule_ProvidePlatformMapPresenterFactory(provider, provider2);
    }

    public static PlatformMapPresenter providePlatformMapPresenter(ViewModelFactory viewModelFactory, Fragment fragment) {
        return (PlatformMapPresenter) Preconditions.checkNotNullFromProvides(PlatformMapFragmentModule.providePlatformMapPresenter(viewModelFactory, fragment));
    }

    @Override // javax.inject.Provider
    public PlatformMapPresenter get() {
        return providePlatformMapPresenter(this.a.get(), this.b.get());
    }
}
