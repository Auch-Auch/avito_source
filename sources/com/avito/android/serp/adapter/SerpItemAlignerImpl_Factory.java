package com.avito.android.serp.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpItemAlignerImpl_Factory implements Factory<SerpItemAlignerImpl> {
    public final Provider<SpannedGridPositionProvider> a;

    public SerpItemAlignerImpl_Factory(Provider<SpannedGridPositionProvider> provider) {
        this.a = provider;
    }

    public static SerpItemAlignerImpl_Factory create(Provider<SpannedGridPositionProvider> provider) {
        return new SerpItemAlignerImpl_Factory(provider);
    }

    public static SerpItemAlignerImpl newInstance(SpannedGridPositionProvider spannedGridPositionProvider) {
        return new SerpItemAlignerImpl(spannedGridPositionProvider);
    }

    @Override // javax.inject.Provider
    public SerpItemAlignerImpl get() {
        return newInstance(this.a.get());
    }
}
