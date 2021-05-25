package com.avito.android.developments_catalog.items.avitoOffers;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AvitoOffersBlueprint_Factory implements Factory<AvitoOffersBlueprint> {
    public final Provider<AvitoOffersPresenter> a;

    public AvitoOffersBlueprint_Factory(Provider<AvitoOffersPresenter> provider) {
        this.a = provider;
    }

    public static AvitoOffersBlueprint_Factory create(Provider<AvitoOffersPresenter> provider) {
        return new AvitoOffersBlueprint_Factory(provider);
    }

    public static AvitoOffersBlueprint newInstance(AvitoOffersPresenter avitoOffersPresenter) {
        return new AvitoOffersBlueprint(avitoOffersPresenter);
    }

    @Override // javax.inject.Provider
    public AvitoOffersBlueprint get() {
        return newInstance(this.a.get());
    }
}
