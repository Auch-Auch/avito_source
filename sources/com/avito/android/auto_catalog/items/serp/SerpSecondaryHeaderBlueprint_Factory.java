package com.avito.android.auto_catalog.items.serp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpSecondaryHeaderBlueprint_Factory implements Factory<SerpSecondaryHeaderBlueprint> {
    public final Provider<SerpSecondaryHeaderPresenter> a;

    public SerpSecondaryHeaderBlueprint_Factory(Provider<SerpSecondaryHeaderPresenter> provider) {
        this.a = provider;
    }

    public static SerpSecondaryHeaderBlueprint_Factory create(Provider<SerpSecondaryHeaderPresenter> provider) {
        return new SerpSecondaryHeaderBlueprint_Factory(provider);
    }

    public static SerpSecondaryHeaderBlueprint newInstance(SerpSecondaryHeaderPresenter serpSecondaryHeaderPresenter) {
        return new SerpSecondaryHeaderBlueprint(serpSecondaryHeaderPresenter);
    }

    @Override // javax.inject.Provider
    public SerpSecondaryHeaderBlueprint get() {
        return newInstance(this.a.get());
    }
}
