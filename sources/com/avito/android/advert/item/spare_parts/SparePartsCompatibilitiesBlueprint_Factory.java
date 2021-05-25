package com.avito.android.advert.item.spare_parts;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SparePartsCompatibilitiesBlueprint_Factory implements Factory<SparePartsCompatibilitiesBlueprint> {
    public final Provider<SparePartsPresenter> a;

    public SparePartsCompatibilitiesBlueprint_Factory(Provider<SparePartsPresenter> provider) {
        this.a = provider;
    }

    public static SparePartsCompatibilitiesBlueprint_Factory create(Provider<SparePartsPresenter> provider) {
        return new SparePartsCompatibilitiesBlueprint_Factory(provider);
    }

    public static SparePartsCompatibilitiesBlueprint newInstance(SparePartsPresenter sparePartsPresenter) {
        return new SparePartsCompatibilitiesBlueprint(sparePartsPresenter);
    }

    @Override // javax.inject.Provider
    public SparePartsCompatibilitiesBlueprint get() {
        return newInstance(this.a.get());
    }
}
