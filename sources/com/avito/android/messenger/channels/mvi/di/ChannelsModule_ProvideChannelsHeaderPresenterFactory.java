package com.avito.android.messenger.channels.mvi.di;

import androidx.fragment.app.Fragment;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsModule_ProvideChannelsHeaderPresenterFactory implements Factory<ChannelsHeaderPresenter> {
    public final Provider<ViewModelFactory> a;
    public final Provider<Fragment> b;

    public ChannelsModule_ProvideChannelsHeaderPresenterFactory(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChannelsModule_ProvideChannelsHeaderPresenterFactory create(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        return new ChannelsModule_ProvideChannelsHeaderPresenterFactory(provider, provider2);
    }

    public static ChannelsHeaderPresenter provideChannelsHeaderPresenter(ViewModelFactory viewModelFactory, Fragment fragment) {
        return (ChannelsHeaderPresenter) Preconditions.checkNotNullFromProvides(ChannelsModule.INSTANCE.provideChannelsHeaderPresenter(viewModelFactory, fragment));
    }

    @Override // javax.inject.Provider
    public ChannelsHeaderPresenter get() {
        return provideChannelsHeaderPresenter(this.a.get(), this.b.get());
    }
}
