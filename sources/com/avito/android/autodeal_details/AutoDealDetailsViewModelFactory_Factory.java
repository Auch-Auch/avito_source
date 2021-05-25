package com.avito.android.autodeal_details;

import android.webkit.CookieManager;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoDealDetailsViewModelFactory_Factory implements Factory<AutoDealDetailsViewModelFactory> {
    public final Provider<String> a;
    public final Provider<AutoDealDetailsJSInterface> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<CookieProvider> d;
    public final Provider<CookieManager> e;

    public AutoDealDetailsViewModelFactory_Factory(Provider<String> provider, Provider<AutoDealDetailsJSInterface> provider2, Provider<SchedulersFactory> provider3, Provider<CookieProvider> provider4, Provider<CookieManager> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AutoDealDetailsViewModelFactory_Factory create(Provider<String> provider, Provider<AutoDealDetailsJSInterface> provider2, Provider<SchedulersFactory> provider3, Provider<CookieProvider> provider4, Provider<CookieManager> provider5) {
        return new AutoDealDetailsViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AutoDealDetailsViewModelFactory newInstance(String str, AutoDealDetailsJSInterface autoDealDetailsJSInterface, SchedulersFactory schedulersFactory, CookieProvider cookieProvider, CookieManager cookieManager) {
        return new AutoDealDetailsViewModelFactory(str, autoDealDetailsJSInterface, schedulersFactory, cookieProvider, cookieManager);
    }

    @Override // javax.inject.Provider
    public AutoDealDetailsViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
