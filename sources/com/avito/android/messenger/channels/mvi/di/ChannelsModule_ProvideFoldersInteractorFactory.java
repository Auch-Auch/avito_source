package com.avito.android.messenger.channels.mvi.di;

import androidx.fragment.app.Fragment;
import com.avito.android.messenger.channels.mvi.interactor.FoldersInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsModule_ProvideFoldersInteractorFactory implements Factory<FoldersInteractor> {
    public final Provider<ViewModelFactory> a;
    public final Provider<Fragment> b;

    public ChannelsModule_ProvideFoldersInteractorFactory(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChannelsModule_ProvideFoldersInteractorFactory create(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        return new ChannelsModule_ProvideFoldersInteractorFactory(provider, provider2);
    }

    public static FoldersInteractor provideFoldersInteractor(ViewModelFactory viewModelFactory, Fragment fragment) {
        return (FoldersInteractor) Preconditions.checkNotNullFromProvides(ChannelsModule.INSTANCE.provideFoldersInteractor(viewModelFactory, fragment));
    }

    @Override // javax.inject.Provider
    public FoldersInteractor get() {
        return provideFoldersInteractor(this.a.get(), this.b.get());
    }
}
