package com.avito.android.html_formatter.jsoup;

import dagger.internal.Factory;
public final class JsoupHtmlCleaner_Factory implements Factory<JsoupHtmlCleaner> {

    public static final class a {
        public static final JsoupHtmlCleaner_Factory a = new JsoupHtmlCleaner_Factory();
    }

    public static JsoupHtmlCleaner_Factory create() {
        return a.a;
    }

    public static JsoupHtmlCleaner newInstance() {
        return new JsoupHtmlCleaner();
    }

    @Override // javax.inject.Provider
    public JsoupHtmlCleaner get() {
        return newInstance();
    }
}
