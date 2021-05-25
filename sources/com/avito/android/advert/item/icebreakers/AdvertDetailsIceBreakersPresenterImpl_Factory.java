package com.avito.android.advert.item.icebreakers;

import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsIceBreakersPresenterImpl_Factory implements Factory<AdvertDetailsIceBreakersPresenterImpl> {
    public final Provider<AdvertDetailsAnalyticsInteractor> a;

    public AdvertDetailsIceBreakersPresenterImpl_Factory(Provider<AdvertDetailsAnalyticsInteractor> provider) {
        this.a = provider;
    }

    public static AdvertDetailsIceBreakersPresenterImpl_Factory create(Provider<AdvertDetailsAnalyticsInteractor> provider) {
        return new AdvertDetailsIceBreakersPresenterImpl_Factory(provider);
    }

    public static AdvertDetailsIceBreakersPresenterImpl newInstance(AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        return new AdvertDetailsIceBreakersPresenterImpl(advertDetailsAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsIceBreakersPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
