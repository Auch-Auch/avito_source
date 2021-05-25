package com.avito.android.tariff.count;

import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.tariff.count.viewmodel.TariffCountViewModel;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class TariffCountFragment_MembersInjector implements MembersInjector<TariffCountFragment> {
    public final Provider<DataAwareAdapterPresenter> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<Set<ItemPresenter<?, ?>>> c;
    public final Provider<TariffCountViewModel> d;

    public TariffCountFragment_MembersInjector(Provider<DataAwareAdapterPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<TariffCountViewModel> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<TariffCountFragment> create(Provider<DataAwareAdapterPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<TariffCountViewModel> provider4) {
        return new TariffCountFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.tariff.count.TariffCountFragment.adapterPresenter")
    public static void injectAdapterPresenter(TariffCountFragment tariffCountFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        tariffCountFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.count.TariffCountFragment.itemPresenterSet")
    public static void injectItemPresenterSet(TariffCountFragment tariffCountFragment, Set<ItemPresenter<?, ?>> set) {
        tariffCountFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.tariff.count.TariffCountFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(TariffCountFragment tariffCountFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        tariffCountFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.count.TariffCountFragment.viewModel")
    public static void injectViewModel(TariffCountFragment tariffCountFragment, TariffCountViewModel tariffCountViewModel) {
        tariffCountFragment.viewModel = tariffCountViewModel;
    }

    public void injectMembers(TariffCountFragment tariffCountFragment) {
        injectAdapterPresenter(tariffCountFragment, this.a.get());
        injectRecyclerAdapter(tariffCountFragment, this.b.get());
        injectItemPresenterSet(tariffCountFragment, this.c.get());
        injectViewModel(tariffCountFragment, this.d.get());
    }
}
