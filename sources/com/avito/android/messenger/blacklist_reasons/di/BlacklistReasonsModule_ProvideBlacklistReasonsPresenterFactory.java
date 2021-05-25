package com.avito.android.messenger.blacklist_reasons.di;

import androidx.fragment.app.Fragment;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsPresenter;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BlacklistReasonsModule_ProvideBlacklistReasonsPresenterFactory implements Factory<BlacklistReasonsPresenter> {
    public final Provider<ViewModelFactory> a;
    public final Provider<Fragment> b;

    public BlacklistReasonsModule_ProvideBlacklistReasonsPresenterFactory(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static BlacklistReasonsModule_ProvideBlacklistReasonsPresenterFactory create(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        return new BlacklistReasonsModule_ProvideBlacklistReasonsPresenterFactory(provider, provider2);
    }

    public static BlacklistReasonsPresenter provideBlacklistReasonsPresenter(ViewModelFactory viewModelFactory, Fragment fragment) {
        return (BlacklistReasonsPresenter) Preconditions.checkNotNullFromProvides(BlacklistReasonsModule.provideBlacklistReasonsPresenter(viewModelFactory, fragment));
    }

    @Override // javax.inject.Provider
    public BlacklistReasonsPresenter get() {
        return provideBlacklistReasonsPresenter(this.a.get(), this.b.get());
    }
}
