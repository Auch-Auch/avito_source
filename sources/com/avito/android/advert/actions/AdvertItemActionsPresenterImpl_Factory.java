package com.avito.android.advert.actions;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertItemActionsPresenterImpl_Factory implements Factory<AdvertItemActionsPresenterImpl> {
    public final Provider<HiddenAdvertsInteractor> a;
    public final Provider<Analytics> b;
    public final Provider<SchedulersFactory3> c;

    public AdvertItemActionsPresenterImpl_Factory(Provider<HiddenAdvertsInteractor> provider, Provider<Analytics> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertItemActionsPresenterImpl_Factory create(Provider<HiddenAdvertsInteractor> provider, Provider<Analytics> provider2, Provider<SchedulersFactory3> provider3) {
        return new AdvertItemActionsPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static AdvertItemActionsPresenterImpl newInstance(HiddenAdvertsInteractor hiddenAdvertsInteractor, Analytics analytics, SchedulersFactory3 schedulersFactory3) {
        return new AdvertItemActionsPresenterImpl(hiddenAdvertsInteractor, analytics, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public AdvertItemActionsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
