package com.avito.android.select.new_metro.adapter.selected_stations;

import dagger.internal.Factory;
public final class MetroSelectedStationsItemPresenterImpl_Factory implements Factory<MetroSelectedStationsItemPresenterImpl> {

    public static final class a {
        public static final MetroSelectedStationsItemPresenterImpl_Factory a = new MetroSelectedStationsItemPresenterImpl_Factory();
    }

    public static MetroSelectedStationsItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static MetroSelectedStationsItemPresenterImpl newInstance() {
        return new MetroSelectedStationsItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public MetroSelectedStationsItemPresenterImpl get() {
        return newInstance();
    }
}
