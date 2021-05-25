package com.avito.android.serp.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SpanLookup_Factory implements Factory<SpanLookup> {
    public final Provider<SpanProvider> a;

    public SpanLookup_Factory(Provider<SpanProvider> provider) {
        this.a = provider;
    }

    public static SpanLookup_Factory create(Provider<SpanProvider> provider) {
        return new SpanLookup_Factory(provider);
    }

    public static SpanLookup newInstance(SpanProvider spanProvider) {
        return new SpanLookup(spanProvider);
    }

    @Override // javax.inject.Provider
    public SpanLookup get() {
        return newInstance(this.a.get());
    }
}
