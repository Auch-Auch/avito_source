package com.avito.android.basket_legacy.ui;

import com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class LegacyCheckoutFragment_MembersInjector implements MembersInjector<LegacyCheckoutFragment> {
    public final Provider<LegacyCheckoutViewModel> a;
    public final Provider<ItemBinder> b;
    public final Provider<AdapterPresenter> c;

    public LegacyCheckoutFragment_MembersInjector(Provider<LegacyCheckoutViewModel> provider, Provider<ItemBinder> provider2, Provider<AdapterPresenter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<LegacyCheckoutFragment> create(Provider<LegacyCheckoutViewModel> provider, Provider<ItemBinder> provider2, Provider<AdapterPresenter> provider3) {
        return new LegacyCheckoutFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.basket_legacy.ui.LegacyCheckoutFragment.adapterPresenter")
    public static void injectAdapterPresenter(LegacyCheckoutFragment legacyCheckoutFragment, AdapterPresenter adapterPresenter) {
        legacyCheckoutFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.basket_legacy.ui.LegacyCheckoutFragment.itemBinder")
    public static void injectItemBinder(LegacyCheckoutFragment legacyCheckoutFragment, ItemBinder itemBinder) {
        legacyCheckoutFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.basket_legacy.ui.LegacyCheckoutFragment.viewModel")
    public static void injectViewModel(LegacyCheckoutFragment legacyCheckoutFragment, LegacyCheckoutViewModel legacyCheckoutViewModel) {
        legacyCheckoutFragment.viewModel = legacyCheckoutViewModel;
    }

    public void injectMembers(LegacyCheckoutFragment legacyCheckoutFragment) {
        injectViewModel(legacyCheckoutFragment, this.a.get());
        injectItemBinder(legacyCheckoutFragment, this.b.get());
        injectAdapterPresenter(legacyCheckoutFragment, this.c.get());
    }
}
