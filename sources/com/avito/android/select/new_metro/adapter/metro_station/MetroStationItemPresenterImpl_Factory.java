package com.avito.android.select.new_metro.adapter.metro_station;

import dagger.internal.Factory;
public final class MetroStationItemPresenterImpl_Factory implements Factory<MetroStationItemPresenterImpl> {

    public static final class a {
        public static final MetroStationItemPresenterImpl_Factory a = new MetroStationItemPresenterImpl_Factory();
    }

    public static MetroStationItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static MetroStationItemPresenterImpl newInstance() {
        return new MetroStationItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public MetroStationItemPresenterImpl get() {
        return newInstance();
    }
}
