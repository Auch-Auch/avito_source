package com.avito.android.messenger.channels.mvi.di;

import androidx.fragment.app.Fragment;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsModule_ProvideChannelsErrorInteractorFactory implements Factory<ChannelsErrorInteractor> {
    public final Provider<ViewModelFactory> a;
    public final Provider<Fragment> b;

    public ChannelsModule_ProvideChannelsErrorInteractorFactory(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChannelsModule_ProvideChannelsErrorInteractorFactory create(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        return new ChannelsModule_ProvideChannelsErrorInteractorFactory(provider, provider2);
    }

    public static ChannelsErrorInteractor provideChannelsErrorInteractor(ViewModelFactory viewModelFactory, Fragment fragment) {
        return (ChannelsErrorInteractor) Preconditions.checkNotNullFromProvides(ChannelsModule.INSTANCE.provideChannelsErrorInteractor(viewModelFactory, fragment));
    }

    @Override // javax.inject.Provider
    public ChannelsErrorInteractor get() {
        return provideChannelsErrorInteractor(this.a.get(), this.b.get());
    }
}
