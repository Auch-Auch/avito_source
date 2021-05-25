package com.avito.android.select.new_metro;

import com.avito.android.Features;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItemPresenter;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemPresenter;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItemPresenter;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemPresenter;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypePresenter;
import com.avito.android.select.new_metro.view_model.SelectMetroViewModel;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SelectMetroFragment_MembersInjector implements MembersInjector<SelectMetroFragment> {
    public final Provider<DataAwareAdapterPresenter> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<SelectMetroViewModel> c;
    public final Provider<ItemBinder> d;
    public final Provider<MetroLineItemPresenter> e;
    public final Provider<MetroStationItemPresenter> f;
    public final Provider<MetroListOutputTypePresenter> g;
    public final Provider<MetroFilterItemPresenter> h;
    public final Provider<MetroSelectedStationsItemPresenter> i;
    public final Provider<Features> j;

    public SelectMetroFragment_MembersInjector(Provider<DataAwareAdapterPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<SelectMetroViewModel> provider3, Provider<ItemBinder> provider4, Provider<MetroLineItemPresenter> provider5, Provider<MetroStationItemPresenter> provider6, Provider<MetroListOutputTypePresenter> provider7, Provider<MetroFilterItemPresenter> provider8, Provider<MetroSelectedStationsItemPresenter> provider9, Provider<Features> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static MembersInjector<SelectMetroFragment> create(Provider<DataAwareAdapterPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<SelectMetroViewModel> provider3, Provider<ItemBinder> provider4, Provider<MetroLineItemPresenter> provider5, Provider<MetroStationItemPresenter> provider6, Provider<MetroListOutputTypePresenter> provider7, Provider<MetroFilterItemPresenter> provider8, Provider<MetroSelectedStationsItemPresenter> provider9, Provider<Features> provider10) {
        return new SelectMetroFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @InjectedFieldSignature("com.avito.android.select.new_metro.SelectMetroFragment.features")
    public static void injectFeatures(SelectMetroFragment selectMetroFragment, Features features) {
        selectMetroFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.select.new_metro.SelectMetroFragment.itemBinder")
    public static void injectItemBinder(SelectMetroFragment selectMetroFragment, ItemBinder itemBinder) {
        selectMetroFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.select.new_metro.SelectMetroFragment.metroFiltersPresenter")
    public static void injectMetroFiltersPresenter(SelectMetroFragment selectMetroFragment, MetroFilterItemPresenter metroFilterItemPresenter) {
        selectMetroFragment.metroFiltersPresenter = metroFilterItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.select.new_metro.SelectMetroFragment.metroLineItemPresenter")
    public static void injectMetroLineItemPresenter(SelectMetroFragment selectMetroFragment, MetroLineItemPresenter metroLineItemPresenter) {
        selectMetroFragment.metroLineItemPresenter = metroLineItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.select.new_metro.SelectMetroFragment.metroStationsPresenter")
    public static void injectMetroStationsPresenter(SelectMetroFragment selectMetroFragment, MetroStationItemPresenter metroStationItemPresenter) {
        selectMetroFragment.metroStationsPresenter = metroStationItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.select.new_metro.SelectMetroFragment.metroTypePresenter")
    public static void injectMetroTypePresenter(SelectMetroFragment selectMetroFragment, MetroListOutputTypePresenter metroListOutputTypePresenter) {
        selectMetroFragment.metroTypePresenter = metroListOutputTypePresenter;
    }

    @InjectedFieldSignature("com.avito.android.select.new_metro.SelectMetroFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(SelectMetroFragment selectMetroFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        selectMetroFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.select.new_metro.SelectMetroFragment.recyclerPresenter")
    public static void injectRecyclerPresenter(SelectMetroFragment selectMetroFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        selectMetroFragment.recyclerPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.select.new_metro.SelectMetroFragment.selectMetroViewModel")
    public static void injectSelectMetroViewModel(SelectMetroFragment selectMetroFragment, SelectMetroViewModel selectMetroViewModel) {
        selectMetroFragment.selectMetroViewModel = selectMetroViewModel;
    }

    @InjectedFieldSignature("com.avito.android.select.new_metro.SelectMetroFragment.selectedStationsItemPresenter")
    public static void injectSelectedStationsItemPresenter(SelectMetroFragment selectMetroFragment, MetroSelectedStationsItemPresenter metroSelectedStationsItemPresenter) {
        selectMetroFragment.selectedStationsItemPresenter = metroSelectedStationsItemPresenter;
    }

    public void injectMembers(SelectMetroFragment selectMetroFragment) {
        injectRecyclerPresenter(selectMetroFragment, this.a.get());
        injectRecyclerAdapter(selectMetroFragment, this.b.get());
        injectSelectMetroViewModel(selectMetroFragment, this.c.get());
        injectItemBinder(selectMetroFragment, this.d.get());
        injectMetroLineItemPresenter(selectMetroFragment, this.e.get());
        injectMetroStationsPresenter(selectMetroFragment, this.f.get());
        injectMetroTypePresenter(selectMetroFragment, this.g.get());
        injectMetroFiltersPresenter(selectMetroFragment, this.h.get());
        injectSelectedStationsItemPresenter(selectMetroFragment, this.i.get());
        injectFeatures(selectMetroFragment, this.j.get());
    }
}
