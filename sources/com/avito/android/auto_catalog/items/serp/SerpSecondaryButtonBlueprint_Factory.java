package com.avito.android.auto_catalog.items.serp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpSecondaryButtonBlueprint_Factory implements Factory<SerpSecondaryButtonBlueprint> {
    public final Provider<SerpSecondaryButtonPresenter> a;

    public SerpSecondaryButtonBlueprint_Factory(Provider<SerpSecondaryButtonPresenter> provider) {
        this.a = provider;
    }

    public static SerpSecondaryButtonBlueprint_Factory create(Provider<SerpSecondaryButtonPresenter> provider) {
        return new SerpSecondaryButtonBlueprint_Factory(provider);
    }

    public static SerpSecondaryButtonBlueprint newInstance(SerpSecondaryButtonPresenter serpSecondaryButtonPresenter) {
        return new SerpSecondaryButtonBlueprint(serpSecondaryButtonPresenter);
    }

    @Override // javax.inject.Provider
    public SerpSecondaryButtonBlueprint get() {
        return newInstance(this.a.get());
    }
}
