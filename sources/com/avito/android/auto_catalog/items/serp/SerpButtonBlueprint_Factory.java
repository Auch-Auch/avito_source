package com.avito.android.auto_catalog.items.serp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpButtonBlueprint_Factory implements Factory<SerpButtonBlueprint> {
    public final Provider<SerpButtonPresenter> a;

    public SerpButtonBlueprint_Factory(Provider<SerpButtonPresenter> provider) {
        this.a = provider;
    }

    public static SerpButtonBlueprint_Factory create(Provider<SerpButtonPresenter> provider) {
        return new SerpButtonBlueprint_Factory(provider);
    }

    public static SerpButtonBlueprint newInstance(SerpButtonPresenter serpButtonPresenter) {
        return new SerpButtonBlueprint(serpButtonPresenter);
    }

    @Override // javax.inject.Provider
    public SerpButtonBlueprint get() {
        return newInstance(this.a.get());
    }
}
