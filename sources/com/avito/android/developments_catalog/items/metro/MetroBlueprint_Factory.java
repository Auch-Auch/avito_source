package com.avito.android.developments_catalog.items.metro;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MetroBlueprint_Factory implements Factory<MetroBlueprint> {
    public final Provider<MetroPresenter> a;

    public MetroBlueprint_Factory(Provider<MetroPresenter> provider) {
        this.a = provider;
    }

    public static MetroBlueprint_Factory create(Provider<MetroPresenter> provider) {
        return new MetroBlueprint_Factory(provider);
    }

    public static MetroBlueprint newInstance(MetroPresenter metroPresenter) {
        return new MetroBlueprint(metroPresenter);
    }

    @Override // javax.inject.Provider
    public MetroBlueprint get() {
        return newInstance(this.a.get());
    }
}
