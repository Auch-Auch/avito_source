package com.avito.android.advert.item.safe_show;

import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SafeShowItemPresenterImpl_Factory implements Factory<SafeShowItemPresenterImpl> {
    public final Provider<AdvertDetailsAnalyticsInteractor> a;

    public SafeShowItemPresenterImpl_Factory(Provider<AdvertDetailsAnalyticsInteractor> provider) {
        this.a = provider;
    }

    public static SafeShowItemPresenterImpl_Factory create(Provider<AdvertDetailsAnalyticsInteractor> provider) {
        return new SafeShowItemPresenterImpl_Factory(provider);
    }

    public static SafeShowItemPresenterImpl newInstance(AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        return new SafeShowItemPresenterImpl(advertDetailsAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public SafeShowItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
