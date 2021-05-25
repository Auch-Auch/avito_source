package com.avito.android.tariff.landing;

import com.avito.android.tariff.landing.viewmodel.TariffLandingViewModel;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class TariffLandingFragment_MembersInjector implements MembersInjector<TariffLandingFragment> {
    public final Provider<SimpleRecyclerAdapter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<Set<ItemPresenter<?, ?>>> c;
    public final Provider<TariffLandingViewModel> d;

    public TariffLandingFragment_MembersInjector(Provider<SimpleRecyclerAdapter> provider, Provider<AdapterPresenter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<TariffLandingViewModel> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<TariffLandingFragment> create(Provider<SimpleRecyclerAdapter> provider, Provider<AdapterPresenter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<TariffLandingViewModel> provider4) {
        return new TariffLandingFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.tariff.landing.TariffLandingFragment.adapterPresenter")
    public static void injectAdapterPresenter(TariffLandingFragment tariffLandingFragment, AdapterPresenter adapterPresenter) {
        tariffLandingFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.landing.TariffLandingFragment.itemPresenterSet")
    public static void injectItemPresenterSet(TariffLandingFragment tariffLandingFragment, Set<ItemPresenter<?, ?>> set) {
        tariffLandingFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.tariff.landing.TariffLandingFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(TariffLandingFragment tariffLandingFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        tariffLandingFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.landing.TariffLandingFragment.viewModel")
    public static void injectViewModel(TariffLandingFragment tariffLandingFragment, TariffLandingViewModel tariffLandingViewModel) {
        tariffLandingFragment.viewModel = tariffLandingViewModel;
    }

    public void injectMembers(TariffLandingFragment tariffLandingFragment) {
        injectRecyclerAdapter(tariffLandingFragment, this.a.get());
        injectAdapterPresenter(tariffLandingFragment, this.b.get());
        injectItemPresenterSet(tariffLandingFragment, this.c.get());
        injectViewModel(tariffLandingFragment, this.d.get());
    }
}
