package com.avito.android.tariff.info;

import com.avito.android.tariff.info.ui.TariffInfoViewTypeProvider;
import com.avito.android.tariff.info.viewmodel.TariffInfoViewModel;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class TariffInfoFragment_MembersInjector implements MembersInjector<TariffInfoFragment> {
    public final Provider<SimpleRecyclerAdapter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<TariffInfoViewModel> c;
    public final Provider<TariffInfoViewTypeProvider> d;

    public TariffInfoFragment_MembersInjector(Provider<SimpleRecyclerAdapter> provider, Provider<AdapterPresenter> provider2, Provider<TariffInfoViewModel> provider3, Provider<TariffInfoViewTypeProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<TariffInfoFragment> create(Provider<SimpleRecyclerAdapter> provider, Provider<AdapterPresenter> provider2, Provider<TariffInfoViewModel> provider3, Provider<TariffInfoViewTypeProvider> provider4) {
        return new TariffInfoFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.tariff.info.TariffInfoFragment.adapterPresenter")
    public static void injectAdapterPresenter(TariffInfoFragment tariffInfoFragment, AdapterPresenter adapterPresenter) {
        tariffInfoFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.info.TariffInfoFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(TariffInfoFragment tariffInfoFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        tariffInfoFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.info.TariffInfoFragment.viewModel")
    public static void injectViewModel(TariffInfoFragment tariffInfoFragment, TariffInfoViewModel tariffInfoViewModel) {
        tariffInfoFragment.viewModel = tariffInfoViewModel;
    }

    @InjectedFieldSignature("com.avito.android.tariff.info.TariffInfoFragment.viewTypeProvider")
    public static void injectViewTypeProvider(TariffInfoFragment tariffInfoFragment, TariffInfoViewTypeProvider tariffInfoViewTypeProvider) {
        tariffInfoFragment.viewTypeProvider = tariffInfoViewTypeProvider;
    }

    public void injectMembers(TariffInfoFragment tariffInfoFragment) {
        injectRecyclerAdapter(tariffInfoFragment, this.a.get());
        injectAdapterPresenter(tariffInfoFragment, this.b.get());
        injectViewModel(tariffInfoFragment, this.c.get());
        injectViewTypeProvider(tariffInfoFragment, this.d.get());
    }
}
