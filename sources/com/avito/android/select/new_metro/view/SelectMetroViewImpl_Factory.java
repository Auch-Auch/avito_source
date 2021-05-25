package com.avito.android.select.new_metro.view;

import android.view.View;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItemPresenter;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemPresenter;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItemPresenter;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemPresenter;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypePresenter;
import com.avito.android.select.new_metro.view_model.SelectMetroViewModel;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectMetroViewImpl_Factory implements Factory<SelectMetroViewImpl> {
    public final Provider<DataAwareAdapterPresenter> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<SelectMetroViewModel> c;
    public final Provider<Boolean> d;
    public final Provider<MetroStationItemPresenter> e;
    public final Provider<MetroSelectedStationsItemPresenter> f;
    public final Provider<MetroFilterItemPresenter> g;
    public final Provider<MetroListOutputTypePresenter> h;
    public final Provider<Integer> i;
    public final Provider<MetroLineItemPresenter> j;
    public final Provider<View> k;

    public SelectMetroViewImpl_Factory(Provider<DataAwareAdapterPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<SelectMetroViewModel> provider3, Provider<Boolean> provider4, Provider<MetroStationItemPresenter> provider5, Provider<MetroSelectedStationsItemPresenter> provider6, Provider<MetroFilterItemPresenter> provider7, Provider<MetroListOutputTypePresenter> provider8, Provider<Integer> provider9, Provider<MetroLineItemPresenter> provider10, Provider<View> provider11) {
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
        this.k = provider11;
    }

    public static SelectMetroViewImpl_Factory create(Provider<DataAwareAdapterPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<SelectMetroViewModel> provider3, Provider<Boolean> provider4, Provider<MetroStationItemPresenter> provider5, Provider<MetroSelectedStationsItemPresenter> provider6, Provider<MetroFilterItemPresenter> provider7, Provider<MetroListOutputTypePresenter> provider8, Provider<Integer> provider9, Provider<MetroLineItemPresenter> provider10, Provider<View> provider11) {
        return new SelectMetroViewImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static SelectMetroViewImpl newInstance(DataAwareAdapterPresenter dataAwareAdapterPresenter, SimpleRecyclerAdapter simpleRecyclerAdapter, SelectMetroViewModel selectMetroViewModel, boolean z, MetroStationItemPresenter metroStationItemPresenter, MetroSelectedStationsItemPresenter metroSelectedStationsItemPresenter, MetroFilterItemPresenter metroFilterItemPresenter, MetroListOutputTypePresenter metroListOutputTypePresenter, int i2, MetroLineItemPresenter metroLineItemPresenter, View view) {
        return new SelectMetroViewImpl(dataAwareAdapterPresenter, simpleRecyclerAdapter, selectMetroViewModel, z, metroStationItemPresenter, metroSelectedStationsItemPresenter, metroFilterItemPresenter, metroListOutputTypePresenter, i2, metroLineItemPresenter, view);
    }

    @Override // javax.inject.Provider
    public SelectMetroViewImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get().booleanValue(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get().intValue(), this.j.get(), this.k.get());
    }
}
