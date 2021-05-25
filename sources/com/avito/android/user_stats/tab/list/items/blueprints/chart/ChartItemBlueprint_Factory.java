package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChartItemBlueprint_Factory implements Factory<ChartItemBlueprint> {
    public final Provider<ChartItemPresenter> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<AdapterPresenter> c;

    public ChartItemBlueprint_Factory(Provider<ChartItemPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<AdapterPresenter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ChartItemBlueprint_Factory create(Provider<ChartItemPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<AdapterPresenter> provider3) {
        return new ChartItemBlueprint_Factory(provider, provider2, provider3);
    }

    public static ChartItemBlueprint newInstance(ChartItemPresenter chartItemPresenter, SimpleRecyclerAdapter simpleRecyclerAdapter, AdapterPresenter adapterPresenter) {
        return new ChartItemBlueprint(chartItemPresenter, simpleRecyclerAdapter, adapterPresenter);
    }

    @Override // javax.inject.Provider
    public ChartItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
