package com.avito.android.help_center.help_center_request;

import android.webkit.CookieManager;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.help_center.HelpCenterJSInterface;
import com.avito.android.help_center.HelpCenterUrlInterceptor;
import com.avito.android.help_center.HelpCenterUrlProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HelpCenterRequestPresenterImpl_Factory implements Factory<HelpCenterRequestPresenterImpl> {
    public final Provider<SchedulersFactory> a;
    public final Provider<CookieManager> b;
    public final Provider<CookieProvider> c;
    public final Provider<HelpCenterJSInterface> d;
    public final Provider<HelpCenterUrlProvider> e;
    public final Provider<HelpCenterUrlInterceptor> f;
    public final Provider<String> g;
    public final Provider<String> h;
    public final Provider<String> i;

    public HelpCenterRequestPresenterImpl_Factory(Provider<SchedulersFactory> provider, Provider<CookieManager> provider2, Provider<CookieProvider> provider3, Provider<HelpCenterJSInterface> provider4, Provider<HelpCenterUrlProvider> provider5, Provider<HelpCenterUrlInterceptor> provider6, Provider<String> provider7, Provider<String> provider8, Provider<String> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static HelpCenterRequestPresenterImpl_Factory create(Provider<SchedulersFactory> provider, Provider<CookieManager> provider2, Provider<CookieProvider> provider3, Provider<HelpCenterJSInterface> provider4, Provider<HelpCenterUrlProvider> provider5, Provider<HelpCenterUrlInterceptor> provider6, Provider<String> provider7, Provider<String> provider8, Provider<String> provider9) {
        return new HelpCenterRequestPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static HelpCenterRequestPresenterImpl newInstance(SchedulersFactory schedulersFactory, CookieManager cookieManager, CookieProvider cookieProvider, HelpCenterJSInterface helpCenterJSInterface, HelpCenterUrlProvider helpCenterUrlProvider, HelpCenterUrlInterceptor helpCenterUrlInterceptor, String str, String str2, String str3) {
        return new HelpCenterRequestPresenterImpl(schedulersFactory, cookieManager, cookieProvider, helpCenterJSInterface, helpCenterUrlProvider, helpCenterUrlInterceptor, str, str2, str3);
    }

    @Override // javax.inject.Provider
    public HelpCenterRequestPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
