package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChartItemPresenterImpl_Factory implements Factory<ChartItemPresenterImpl> {
    public final Provider<SimpleRecyclerAdapter> a;
    public final Provider<BarItemPresenter> b;

    public ChartItemPresenterImpl_Factory(Provider<SimpleRecyclerAdapter> provider, Provider<BarItemPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChartItemPresenterImpl_Factory create(Provider<SimpleRecyclerAdapter> provider, Provider<BarItemPresenter> provider2) {
        return new ChartItemPresenterImpl_Factory(provider, provider2);
    }

    public static ChartItemPresenterImpl newInstance(SimpleRecyclerAdapter simpleRecyclerAdapter, BarItemPresenter barItemPresenter) {
        return new ChartItemPresenterImpl(simpleRecyclerAdapter, barItemPresenter);
    }

    @Override // javax.inject.Provider
    public ChartItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
