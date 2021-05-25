package com.avito.android.messenger.channels.mvi.di;

import androidx.fragment.app.Fragment;
import com.avito.android.messenger.channels.mvi.presenter.FoldersPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsModule_ProvideFoldersPresenterFactory implements Factory<FoldersPresenter> {
    public final Provider<ViewModelFactory> a;
    public final Provider<Fragment> b;

    public ChannelsModule_ProvideFoldersPresenterFactory(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChannelsModule_ProvideFoldersPresenterFactory create(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        return new ChannelsModule_ProvideFoldersPresenterFactory(provider, provider2);
    }

    public static FoldersPresenter provideFoldersPresenter(ViewModelFactory viewModelFactory, Fragment fragment) {
        return (FoldersPresenter) Preconditions.checkNotNullFromProvides(ChannelsModule.INSTANCE.provideFoldersPresenter(viewModelFactory, fragment));
    }

    @Override // javax.inject.Provider
    public FoldersPresenter get() {
        return provideFoldersPresenter(this.a.get(), this.b.get());
    }
}
