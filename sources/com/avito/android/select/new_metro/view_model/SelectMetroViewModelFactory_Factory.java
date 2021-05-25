package com.avito.android.select.new_metro.view_model;

import com.avito.android.select.new_metro.ItemsHolder;
import com.avito.android.select.new_metro.SelectMetroParams;
import com.avito.android.select.new_metro.analytics.SelectMetroAnalytics;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectMetroViewModelFactory_Factory implements Factory<SelectMetroViewModelFactory> {
    public final Provider<ItemsHolder> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<SelectMetroAnalytics> c;
    public final Provider<SelectMetroParams> d;

    public SelectMetroViewModelFactory_Factory(Provider<ItemsHolder> provider, Provider<SchedulersFactory3> provider2, Provider<SelectMetroAnalytics> provider3, Provider<SelectMetroParams> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SelectMetroViewModelFactory_Factory create(Provider<ItemsHolder> provider, Provider<SchedulersFactory3> provider2, Provider<SelectMetroAnalytics> provider3, Provider<SelectMetroParams> provider4) {
        return new SelectMetroViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static SelectMetroViewModelFactory newInstance(ItemsHolder itemsHolder, SchedulersFactory3 schedulersFactory3, SelectMetroAnalytics selectMetroAnalytics, SelectMetroParams selectMetroParams) {
        return new SelectMetroViewModelFactory(itemsHolder, schedulersFactory3, selectMetroAnalytics, selectMetroParams);
    }

    @Override // javax.inject.Provider
    public SelectMetroViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
