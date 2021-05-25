package com.avito.android.app_rater.fragment;

import com.avito.android.util.SchedulersFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AppRaterDialogFragment_MembersInjector implements MembersInjector<AppRaterDialogFragment> {
    public final Provider<AppRaterDialogFragmentViewModelFactory> a;
    public final Provider<SchedulersFactory> b;

    public AppRaterDialogFragment_MembersInjector(Provider<AppRaterDialogFragmentViewModelFactory> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<AppRaterDialogFragment> create(Provider<AppRaterDialogFragmentViewModelFactory> provider, Provider<SchedulersFactory> provider2) {
        return new AppRaterDialogFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.app_rater.fragment.AppRaterDialogFragment.schedulersFactory")
    public static void injectSchedulersFactory(AppRaterDialogFragment appRaterDialogFragment, SchedulersFactory schedulersFactory) {
        appRaterDialogFragment.schedulersFactory = schedulersFactory;
    }

    @InjectedFieldSignature("com.avito.android.app_rater.fragment.AppRaterDialogFragment.viewModelFactory")
    public static void injectViewModelFactory(AppRaterDialogFragment appRaterDialogFragment, AppRaterDialogFragmentViewModelFactory appRaterDialogFragmentViewModelFactory) {
        appRaterDialogFragment.viewModelFactory = appRaterDialogFragmentViewModelFactory;
    }

    public void injectMembers(AppRaterDialogFragment appRaterDialogFragment) {
        injectViewModelFactory(appRaterDialogFragment, this.a.get());
        injectSchedulersFactory(appRaterDialogFragment, this.b.get());
    }
}
