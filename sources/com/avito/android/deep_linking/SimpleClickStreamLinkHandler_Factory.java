package com.avito.android.deep_linking;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SimpleClickStreamLinkHandler_Factory implements Factory<SimpleClickStreamLinkHandler> {
    public final Provider<Analytics> a;

    public SimpleClickStreamLinkHandler_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static SimpleClickStreamLinkHandler_Factory create(Provider<Analytics> provider) {
        return new SimpleClickStreamLinkHandler_Factory(provider);
    }

    public static SimpleClickStreamLinkHandler newInstance(Analytics analytics) {
        return new SimpleClickStreamLinkHandler(analytics);
    }

    @Override // javax.inject.Provider
    public SimpleClickStreamLinkHandler get() {
        return newInstance(this.a.get());
    }
}
