package com.avito.android.advert.item.shorttermrent;

import com.avito.android.Features;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsShortTermRentPresenterImpl_Factory implements Factory<AdvertDetailsShortTermRentPresenterImpl> {
    public final Provider<String> a;
    public final Provider<Analytics> b;
    public final Provider<AdvertDetailsAnalyticsInteractor> c;
    public final Provider<DeepLinkFactory> d;
    public final Provider<Features> e;

    public AdvertDetailsShortTermRentPresenterImpl_Factory(Provider<String> provider, Provider<Analytics> provider2, Provider<AdvertDetailsAnalyticsInteractor> provider3, Provider<DeepLinkFactory> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AdvertDetailsShortTermRentPresenterImpl_Factory create(Provider<String> provider, Provider<Analytics> provider2, Provider<AdvertDetailsAnalyticsInteractor> provider3, Provider<DeepLinkFactory> provider4, Provider<Features> provider5) {
        return new AdvertDetailsShortTermRentPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AdvertDetailsShortTermRentPresenterImpl newInstance(String str, Analytics analytics, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, DeepLinkFactory deepLinkFactory, Features features) {
        return new AdvertDetailsShortTermRentPresenterImpl(str, analytics, advertDetailsAnalyticsInteractor, deepLinkFactory, features);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsShortTermRentPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
