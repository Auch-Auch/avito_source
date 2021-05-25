package com.avito.android.select.new_metro.adapter.gap;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MetroListGapItemBlueprint_Factory implements Factory<MetroListGapItemBlueprint> {
    public final Provider<MetroListGapItemPresenter> a;

    public MetroListGapItemBlueprint_Factory(Provider<MetroListGapItemPresenter> provider) {
        this.a = provider;
    }

    public static MetroListGapItemBlueprint_Factory create(Provider<MetroListGapItemPresenter> provider) {
        return new MetroListGapItemBlueprint_Factory(provider);
    }

    public static MetroListGapItemBlueprint newInstance(MetroListGapItemPresenter metroListGapItemPresenter) {
        return new MetroListGapItemBlueprint(metroListGapItemPresenter);
    }

    @Override // javax.inject.Provider
    public MetroListGapItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
