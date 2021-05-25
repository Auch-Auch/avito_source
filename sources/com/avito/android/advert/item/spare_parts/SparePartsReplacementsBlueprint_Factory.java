package com.avito.android.advert.item.spare_parts;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SparePartsReplacementsBlueprint_Factory implements Factory<SparePartsReplacementsBlueprint> {
    public final Provider<SparePartsPresenter> a;

    public SparePartsReplacementsBlueprint_Factory(Provider<SparePartsPresenter> provider) {
        this.a = provider;
    }

    public static SparePartsReplacementsBlueprint_Factory create(Provider<SparePartsPresenter> provider) {
        return new SparePartsReplacementsBlueprint_Factory(provider);
    }

    public static SparePartsReplacementsBlueprint newInstance(SparePartsPresenter sparePartsPresenter) {
        return new SparePartsReplacementsBlueprint(sparePartsPresenter);
    }

    @Override // javax.inject.Provider
    public SparePartsReplacementsBlueprint get() {
        return newInstance(this.a.get());
    }
}
