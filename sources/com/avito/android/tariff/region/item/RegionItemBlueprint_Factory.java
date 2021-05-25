package com.avito.android.tariff.region.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RegionItemBlueprint_Factory implements Factory<RegionItemBlueprint> {
    public final Provider<RegionItemPresenter> a;

    public RegionItemBlueprint_Factory(Provider<RegionItemPresenter> provider) {
        this.a = provider;
    }

    public static RegionItemBlueprint_Factory create(Provider<RegionItemPresenter> provider) {
        return new RegionItemBlueprint_Factory(provider);
    }

    public static RegionItemBlueprint newInstance(RegionItemPresenter regionItemPresenter) {
        return new RegionItemBlueprint(regionItemPresenter);
    }

    @Override // javax.inject.Provider
    public RegionItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
