package com.avito.android.auto_catalog.items.image;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SchemeBlueprint_Factory implements Factory<SchemeBlueprint> {
    public final Provider<SchemePresenter> a;

    public SchemeBlueprint_Factory(Provider<SchemePresenter> provider) {
        this.a = provider;
    }

    public static SchemeBlueprint_Factory create(Provider<SchemePresenter> provider) {
        return new SchemeBlueprint_Factory(provider);
    }

    public static SchemeBlueprint newInstance(SchemePresenter schemePresenter) {
        return new SchemeBlueprint(schemePresenter);
    }

    @Override // javax.inject.Provider
    public SchemeBlueprint get() {
        return newInstance(this.a.get());
    }
}
