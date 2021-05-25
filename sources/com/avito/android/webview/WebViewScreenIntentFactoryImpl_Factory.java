package com.avito.android.webview;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class WebViewScreenIntentFactoryImpl_Factory implements Factory<WebViewScreenIntentFactoryImpl> {
    public final Provider<Context> a;

    public WebViewScreenIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static WebViewScreenIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new WebViewScreenIntentFactoryImpl_Factory(provider);
    }

    public static WebViewScreenIntentFactoryImpl newInstance(Context context) {
        return new WebViewScreenIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public WebViewScreenIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
