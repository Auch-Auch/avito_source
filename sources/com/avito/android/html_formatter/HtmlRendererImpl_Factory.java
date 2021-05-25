package com.avito.android.html_formatter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class HtmlRendererImpl_Factory implements Factory<HtmlRendererImpl> {
    public final Provider<HtmlNodeFactory> a;

    public HtmlRendererImpl_Factory(Provider<HtmlNodeFactory> provider) {
        this.a = provider;
    }

    public static HtmlRendererImpl_Factory create(Provider<HtmlNodeFactory> provider) {
        return new HtmlRendererImpl_Factory(provider);
    }

    public static HtmlRendererImpl newInstance(HtmlNodeFactory htmlNodeFactory) {
        return new HtmlRendererImpl(htmlNodeFactory);
    }

    @Override // javax.inject.Provider
    public HtmlRendererImpl get() {
        return newInstance(this.a.get());
    }
}
