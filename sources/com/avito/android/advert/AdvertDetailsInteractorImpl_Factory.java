package com.avito.android.advert;

import com.avito.android.Features;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.rec.ScreenSource;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsInteractorImpl_Factory implements Factory<AdvertDetailsInteractorImpl> {
    public final Provider<String> a;
    public final Provider<AdvertDetailsApi> b;
    public final Provider<CommercialBannersInteractor> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<Boolean> e;
    public final Provider<ScreenSource> f;
    public final Provider<Features> g;
    public final Provider<HtmlRenderer> h;
    public final Provider<HtmlCleaner> i;
    public final Provider<HtmlRenderOptions> j;

    public AdvertDetailsInteractorImpl_Factory(Provider<String> provider, Provider<AdvertDetailsApi> provider2, Provider<CommercialBannersInteractor> provider3, Provider<SchedulersFactory3> provider4, Provider<Boolean> provider5, Provider<ScreenSource> provider6, Provider<Features> provider7, Provider<HtmlRenderer> provider8, Provider<HtmlCleaner> provider9, Provider<HtmlRenderOptions> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static AdvertDetailsInteractorImpl_Factory create(Provider<String> provider, Provider<AdvertDetailsApi> provider2, Provider<CommercialBannersInteractor> provider3, Provider<SchedulersFactory3> provider4, Provider<Boolean> provider5, Provider<ScreenSource> provider6, Provider<Features> provider7, Provider<HtmlRenderer> provider8, Provider<HtmlCleaner> provider9, Provider<HtmlRenderOptions> provider10) {
        return new AdvertDetailsInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static AdvertDetailsInteractorImpl newInstance(String str, AdvertDetailsApi advertDetailsApi, CommercialBannersInteractor commercialBannersInteractor, SchedulersFactory3 schedulersFactory3, boolean z, ScreenSource screenSource, Features features, HtmlRenderer htmlRenderer, HtmlCleaner htmlCleaner, HtmlRenderOptions htmlRenderOptions) {
        return new AdvertDetailsInteractorImpl(str, advertDetailsApi, commercialBannersInteractor, schedulersFactory3, z, screenSource, features, htmlRenderer, htmlCleaner, htmlRenderOptions);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get().booleanValue(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
