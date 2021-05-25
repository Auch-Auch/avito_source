package com.avito.android.hints;

import androidx.lifecycle.ViewModelProvider;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class HintsDialogFragment_MembersInjector implements MembersInjector<HintsDialogFragment> {
    public final Provider<ViewModelProvider.Factory> a;
    public final Provider<ItemBinder> b;
    public final Provider<AdapterPresenter> c;

    public HintsDialogFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<ItemBinder> provider2, Provider<AdapterPresenter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<HintsDialogFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<ItemBinder> provider2, Provider<AdapterPresenter> provider3) {
        return new HintsDialogFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.hints.HintsDialogFragment.adapterPresenter")
    public static void injectAdapterPresenter(HintsDialogFragment hintsDialogFragment, AdapterPresenter adapterPresenter) {
        hintsDialogFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.hints.HintsDialogFragment.itemBinder")
    public static void injectItemBinder(HintsDialogFragment hintsDialogFragment, ItemBinder itemBinder) {
        hintsDialogFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.hints.HintsDialogFragment.viewModelFactory")
    public static void injectViewModelFactory(HintsDialogFragment hintsDialogFragment, ViewModelProvider.Factory factory) {
        hintsDialogFragment.viewModelFactory = factory;
    }

    public void injectMembers(HintsDialogFragment hintsDialogFragment) {
        injectViewModelFactory(hintsDialogFragment, this.a.get());
        injectItemBinder(hintsDialogFragment, this.b.get());
        injectAdapterPresenter(hintsDialogFragment, this.c.get());
    }
}
