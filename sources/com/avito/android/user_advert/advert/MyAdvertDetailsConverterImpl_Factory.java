package com.avito.android.user_advert.advert;

import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.HtmlRenderer;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyAdvertDetailsConverterImpl_Factory implements Factory<MyAdvertDetailsConverterImpl> {
    public final Provider<HtmlRenderer> a;
    public final Provider<HtmlCleaner> b;
    public final Provider<HtmlRenderOptions> c;

    public MyAdvertDetailsConverterImpl_Factory(Provider<HtmlRenderer> provider, Provider<HtmlCleaner> provider2, Provider<HtmlRenderOptions> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MyAdvertDetailsConverterImpl_Factory create(Provider<HtmlRenderer> provider, Provider<HtmlCleaner> provider2, Provider<HtmlRenderOptions> provider3) {
        return new MyAdvertDetailsConverterImpl_Factory(provider, provider2, provider3);
    }

    public static MyAdvertDetailsConverterImpl newInstance(HtmlRenderer htmlRenderer, HtmlCleaner htmlCleaner, HtmlRenderOptions htmlRenderOptions) {
        return new MyAdvertDetailsConverterImpl(htmlRenderer, htmlCleaner, htmlRenderOptions);
    }

    @Override // javax.inject.Provider
    public MyAdvertDetailsConverterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
