package com.avito.android.messenger.support.di;

import androidx.fragment.app.Fragment;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.support.SupportChatFormPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SupportChatFormModule_ProvideSupportChatFormPresenterFactory implements Factory<SupportChatFormPresenter> {
    public final Provider<ViewModelFactory> a;
    public final Provider<Fragment> b;

    public SupportChatFormModule_ProvideSupportChatFormPresenterFactory(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SupportChatFormModule_ProvideSupportChatFormPresenterFactory create(Provider<ViewModelFactory> provider, Provider<Fragment> provider2) {
        return new SupportChatFormModule_ProvideSupportChatFormPresenterFactory(provider, provider2);
    }

    public static SupportChatFormPresenter provideSupportChatFormPresenter(ViewModelFactory viewModelFactory, Fragment fragment) {
        return (SupportChatFormPresenter) Preconditions.checkNotNullFromProvides(SupportChatFormModule.INSTANCE.provideSupportChatFormPresenter(viewModelFactory, fragment));
    }

    @Override // javax.inject.Provider
    public SupportChatFormPresenter get() {
        return provideSupportChatFormPresenter(this.a.get(), this.b.get());
    }
}
