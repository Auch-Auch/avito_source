package com.avito.android.advert.item.autoteka;

import com.avito.android.Features;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAutotekaPresenterImpl_Factory implements Factory<AdvertDetailsAutotekaPresenterImpl> {
    public final Provider<String> a;
    public final Provider<AutotekaDetailsInteractor> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<Analytics> d;
    public final Provider<AdvertDetailsAnalyticsInteractor> e;
    public final Provider<Features> f;

    public AdvertDetailsAutotekaPresenterImpl_Factory(Provider<String> provider, Provider<AutotekaDetailsInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<Analytics> provider4, Provider<AdvertDetailsAnalyticsInteractor> provider5, Provider<Features> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static AdvertDetailsAutotekaPresenterImpl_Factory create(Provider<String> provider, Provider<AutotekaDetailsInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<Analytics> provider4, Provider<AdvertDetailsAnalyticsInteractor> provider5, Provider<Features> provider6) {
        return new AdvertDetailsAutotekaPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AdvertDetailsAutotekaPresenterImpl newInstance(String str, AutotekaDetailsInteractor autotekaDetailsInteractor, SchedulersFactory3 schedulersFactory3, Analytics analytics, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, Features features) {
        return new AdvertDetailsAutotekaPresenterImpl(str, autotekaDetailsInteractor, schedulersFactory3, analytics, advertDetailsAnalyticsInteractor, features);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAutotekaPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
