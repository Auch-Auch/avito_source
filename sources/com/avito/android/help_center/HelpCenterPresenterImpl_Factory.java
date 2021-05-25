package com.avito.android.help_center;

import android.webkit.CookieManager;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HelpCenterPresenterImpl_Factory implements Factory<HelpCenterPresenterImpl> {
    public final Provider<SchedulersFactory> a;
    public final Provider<CookieManager> b;
    public final Provider<CookieProvider> c;
    public final Provider<HelpCenterJSInterface> d;
    public final Provider<HelpCenterUrlInterceptor> e;
    public final Provider<HelpCenterUrlProvider> f;
    public final Provider<String> g;
    public final Provider<HelpCenterPresenterState> h;

    public HelpCenterPresenterImpl_Factory(Provider<SchedulersFactory> provider, Provider<CookieManager> provider2, Provider<CookieProvider> provider3, Provider<HelpCenterJSInterface> provider4, Provider<HelpCenterUrlInterceptor> provider5, Provider<HelpCenterUrlProvider> provider6, Provider<String> provider7, Provider<HelpCenterPresenterState> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static HelpCenterPresenterImpl_Factory create(Provider<SchedulersFactory> provider, Provider<CookieManager> provider2, Provider<CookieProvider> provider3, Provider<HelpCenterJSInterface> provider4, Provider<HelpCenterUrlInterceptor> provider5, Provider<HelpCenterUrlProvider> provider6, Provider<String> provider7, Provider<HelpCenterPresenterState> provider8) {
        return new HelpCenterPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static HelpCenterPresenterImpl newInstance(SchedulersFactory schedulersFactory, CookieManager cookieManager, CookieProvider cookieProvider, HelpCenterJSInterface helpCenterJSInterface, HelpCenterUrlInterceptor helpCenterUrlInterceptor, HelpCenterUrlProvider helpCenterUrlProvider, String str, HelpCenterPresenterState helpCenterPresenterState) {
        return new HelpCenterPresenterImpl(schedulersFactory, cookieManager, cookieProvider, helpCenterJSInterface, helpCenterUrlInterceptor, helpCenterUrlProvider, str, helpCenterPresenterState);
    }

    @Override // javax.inject.Provider
    public HelpCenterPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
