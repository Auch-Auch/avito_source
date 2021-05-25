package com.avito.android.serp.adapter.promo_card;

import com.avito.android.analytics.Analytics;
import com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PromoCardItemPresenter_Factory implements Factory<PromoCardItemPresenter> {
    public final Provider<PromoCardItemPresenter.Router> a;
    public final Provider<Analytics> b;

    public PromoCardItemPresenter_Factory(Provider<PromoCardItemPresenter.Router> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PromoCardItemPresenter_Factory create(Provider<PromoCardItemPresenter.Router> provider, Provider<Analytics> provider2) {
        return new PromoCardItemPresenter_Factory(provider, provider2);
    }

    public static PromoCardItemPresenter newInstance(Lazy<PromoCardItemPresenter.Router> lazy, Analytics analytics) {
        return new PromoCardItemPresenter(lazy, analytics);
    }

    @Override // javax.inject.Provider
    public PromoCardItemPresenter get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get());
    }
}
