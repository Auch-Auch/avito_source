package com.avito.android.html_formatter.jsoup;

import dagger.internal.Factory;
public final class JsoupHtmlNodeFactory_Factory implements Factory<JsoupHtmlNodeFactory> {

    public static final class a {
        public static final JsoupHtmlNodeFactory_Factory a = new JsoupHtmlNodeFactory_Factory();
    }

    public static JsoupHtmlNodeFactory_Factory create() {
        return a.a;
    }

    public static JsoupHtmlNodeFactory newInstance() {
        return new JsoupHtmlNodeFactory();
    }

    @Override // javax.inject.Provider
    public JsoupHtmlNodeFactory get() {
        return newInstance();
    }
}
