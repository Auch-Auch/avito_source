package com.avito.android.serp.adapter.vertical_main.vertical_filter;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerticalSearchFilterResourceProviderImpl_Factory implements Factory<VerticalSearchFilterResourceProviderImpl> {
    public final Provider<Resources> a;

    public VerticalSearchFilterResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static VerticalSearchFilterResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new VerticalSearchFilterResourceProviderImpl_Factory(provider);
    }

    public static VerticalSearchFilterResourceProviderImpl newInstance(Resources resources) {
        return new VerticalSearchFilterResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public VerticalSearchFilterResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
