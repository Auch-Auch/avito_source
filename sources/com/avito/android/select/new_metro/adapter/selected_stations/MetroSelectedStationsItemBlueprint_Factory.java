package com.avito.android.select.new_metro.adapter.selected_stations;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MetroSelectedStationsItemBlueprint_Factory implements Factory<MetroSelectedStationsItemBlueprint> {
    public final Provider<MetroSelectedStationsItemPresenter> a;

    public MetroSelectedStationsItemBlueprint_Factory(Provider<MetroSelectedStationsItemPresenter> provider) {
        this.a = provider;
    }

    public static MetroSelectedStationsItemBlueprint_Factory create(Provider<MetroSelectedStationsItemPresenter> provider) {
        return new MetroSelectedStationsItemBlueprint_Factory(provider);
    }

    public static MetroSelectedStationsItemBlueprint newInstance(MetroSelectedStationsItemPresenter metroSelectedStationsItemPresenter) {
        return new MetroSelectedStationsItemBlueprint(metroSelectedStationsItemPresenter);
    }

    @Override // javax.inject.Provider
    public MetroSelectedStationsItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
