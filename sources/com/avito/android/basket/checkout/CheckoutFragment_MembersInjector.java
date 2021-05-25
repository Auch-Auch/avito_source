package com.avito.android.basket.checkout;

import com.avito.android.basket.checkout.viewmodel.CheckoutViewModel;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class CheckoutFragment_MembersInjector implements MembersInjector<CheckoutFragment> {
    public final Provider<AdapterPresenter> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<Set<ItemPresenter<?, ?>>> c;
    public final Provider<CheckoutViewModel> d;

    public CheckoutFragment_MembersInjector(Provider<AdapterPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<CheckoutViewModel> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<CheckoutFragment> create(Provider<AdapterPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<CheckoutViewModel> provider4) {
        return new CheckoutFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.basket.checkout.CheckoutFragment.adapterPresenter")
    public static void injectAdapterPresenter(CheckoutFragment checkoutFragment, AdapterPresenter adapterPresenter) {
        checkoutFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.basket.checkout.CheckoutFragment.itemPresenterSet")
    public static void injectItemPresenterSet(CheckoutFragment checkoutFragment, Set<ItemPresenter<?, ?>> set) {
        checkoutFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.basket.checkout.CheckoutFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(CheckoutFragment checkoutFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        checkoutFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.basket.checkout.CheckoutFragment.viewModel")
    public static void injectViewModel(CheckoutFragment checkoutFragment, CheckoutViewModel checkoutViewModel) {
        checkoutFragment.viewModel = checkoutViewModel;
    }

    public void injectMembers(CheckoutFragment checkoutFragment) {
        injectAdapterPresenter(checkoutFragment, this.a.get());
        injectRecyclerAdapter(checkoutFragment, this.b.get());
        injectItemPresenterSet(checkoutFragment, this.c.get());
        injectViewModel(checkoutFragment, this.d.get());
    }
}
