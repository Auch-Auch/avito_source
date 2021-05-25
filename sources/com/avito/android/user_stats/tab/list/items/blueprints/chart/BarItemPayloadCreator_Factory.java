package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import dagger.internal.Factory;
public final class BarItemPayloadCreator_Factory implements Factory<BarItemPayloadCreator> {

    public static final class a {
        public static final BarItemPayloadCreator_Factory a = new BarItemPayloadCreator_Factory();
    }

    public static BarItemPayloadCreator_Factory create() {
        return a.a;
    }

    public static BarItemPayloadCreator newInstance() {
        return new BarItemPayloadCreator();
    }

    @Override // javax.inject.Provider
    public BarItemPayloadCreator get() {
        return newInstance();
    }
}
