package com.avito.android.auto_catalog.items.serp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpHeaderBlueprint_Factory implements Factory<SerpHeaderBlueprint> {
    public final Provider<SerpHeaderPresenter> a;

    public SerpHeaderBlueprint_Factory(Provider<SerpHeaderPresenter> provider) {
        this.a = provider;
    }

    public static SerpHeaderBlueprint_Factory create(Provider<SerpHeaderPresenter> provider) {
        return new SerpHeaderBlueprint_Factory(provider);
    }

    public static SerpHeaderBlueprint newInstance(SerpHeaderPresenter serpHeaderPresenter) {
        return new SerpHeaderBlueprint(serpHeaderPresenter);
    }

    @Override // javax.inject.Provider
    public SerpHeaderBlueprint get() {
        return newInstance(this.a.get());
    }
}
