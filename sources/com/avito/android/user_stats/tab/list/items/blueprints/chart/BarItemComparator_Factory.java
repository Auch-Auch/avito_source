package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import dagger.internal.Factory;
public final class BarItemComparator_Factory implements Factory<BarItemComparator> {

    public static final class a {
        public static final BarItemComparator_Factory a = new BarItemComparator_Factory();
    }

    public static BarItemComparator_Factory create() {
        return a.a;
    }

    public static BarItemComparator newInstance() {
        return new BarItemComparator();
    }

    @Override // javax.inject.Provider
    public BarItemComparator get() {
        return newInstance();
    }
}
