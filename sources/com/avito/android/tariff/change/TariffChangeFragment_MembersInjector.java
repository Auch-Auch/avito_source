package com.avito.android.tariff.change;

import com.avito.android.tariff.change.viewmodel.TariffChangeViewModel;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class TariffChangeFragment_MembersInjector implements MembersInjector<TariffChangeFragment> {
    public final Provider<SimpleRecyclerAdapter> a;
    public final Provider<TariffChangeViewModel> b;
    public final Provider<ItemBinder> c;

    public TariffChangeFragment_MembersInjector(Provider<SimpleRecyclerAdapter> provider, Provider<TariffChangeViewModel> provider2, Provider<ItemBinder> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<TariffChangeFragment> create(Provider<SimpleRecyclerAdapter> provider, Provider<TariffChangeViewModel> provider2, Provider<ItemBinder> provider3) {
        return new TariffChangeFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.tariff.change.TariffChangeFragment.itemBinder")
    public static void injectItemBinder(TariffChangeFragment tariffChangeFragment, ItemBinder itemBinder) {
        tariffChangeFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.tariff.change.TariffChangeFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(TariffChangeFragment tariffChangeFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        tariffChangeFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.change.TariffChangeFragment.viewModel")
    public static void injectViewModel(TariffChangeFragment tariffChangeFragment, TariffChangeViewModel tariffChangeViewModel) {
        tariffChangeFragment.viewModel = tariffChangeViewModel;
    }

    public void injectMembers(TariffChangeFragment tariffChangeFragment) {
        injectRecyclerAdapter(tariffChangeFragment, this.a.get());
        injectViewModel(tariffChangeFragment, this.b.get());
        injectItemBinder(tariffChangeFragment, this.c.get());
    }
}
