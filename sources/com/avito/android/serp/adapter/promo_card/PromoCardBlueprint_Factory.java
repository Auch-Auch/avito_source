package com.avito.android.serp.adapter.promo_card;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PromoCardBlueprint_Factory implements Factory<PromoCardBlueprint> {
    public final Provider<PromoCardItemPresenter> a;

    public PromoCardBlueprint_Factory(Provider<PromoCardItemPresenter> provider) {
        this.a = provider;
    }

    public static PromoCardBlueprint_Factory create(Provider<PromoCardItemPresenter> provider) {
        return new PromoCardBlueprint_Factory(provider);
    }

    public static PromoCardBlueprint newInstance(PromoCardItemPresenter promoCardItemPresenter) {
        return new PromoCardBlueprint(promoCardItemPresenter);
    }

    @Override // javax.inject.Provider
    public PromoCardBlueprint get() {
        return newInstance(this.a.get());
    }
}
