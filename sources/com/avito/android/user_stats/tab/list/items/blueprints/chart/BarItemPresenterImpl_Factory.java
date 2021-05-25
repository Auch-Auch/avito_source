package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import dagger.internal.Factory;
public final class BarItemPresenterImpl_Factory implements Factory<BarItemPresenterImpl> {

    public static final class a {
        public static final BarItemPresenterImpl_Factory a = new BarItemPresenterImpl_Factory();
    }

    public static BarItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static BarItemPresenterImpl newInstance() {
        return new BarItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public BarItemPresenterImpl get() {
        return newInstance();
    }
}
