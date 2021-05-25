package com.avito.android.advert.item.delivery;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDeliveryPresenterImpl_Factory implements Factory<AdvertDeliveryPresenterImpl> {
    public final Provider<String> a;
    public final Provider<DeepLinkFactory> b;
    public final Provider<AdvertDeliveryStorage> c;
    public final Provider<AccountStateProvider> d;
    public final Provider<AdvertDetailsAnalyticsInteractor> e;
    public final Provider<Analytics> f;
    public final Provider<Features> g;

    public AdvertDeliveryPresenterImpl_Factory(Provider<String> provider, Provider<DeepLinkFactory> provider2, Provider<AdvertDeliveryStorage> provider3, Provider<AccountStateProvider> provider4, Provider<AdvertDetailsAnalyticsInteractor> provider5, Provider<Analytics> provider6, Provider<Features> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static AdvertDeliveryPresenterImpl_Factory create(Provider<String> provider, Provider<DeepLinkFactory> provider2, Provider<AdvertDeliveryStorage> provider3, Provider<AccountStateProvider> provider4, Provider<AdvertDetailsAnalyticsInteractor> provider5, Provider<Analytics> provider6, Provider<Features> provider7) {
        return new AdvertDeliveryPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static AdvertDeliveryPresenterImpl newInstance(String str, DeepLinkFactory deepLinkFactory, AdvertDeliveryStorage advertDeliveryStorage, AccountStateProvider accountStateProvider, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, Analytics analytics, Features features) {
        return new AdvertDeliveryPresenterImpl(str, deepLinkFactory, advertDeliveryStorage, accountStateProvider, advertDetailsAnalyticsInteractor, analytics, features);
    }

    @Override // javax.inject.Provider
    public AdvertDeliveryPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
