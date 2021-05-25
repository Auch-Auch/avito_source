package com.avito.android.developments_catalog.items.description;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DescriptionBlueprint_Factory implements Factory<DescriptionBlueprint> {
    public final Provider<DescriptionPresenter> a;

    public DescriptionBlueprint_Factory(Provider<DescriptionPresenter> provider) {
        this.a = provider;
    }

    public static DescriptionBlueprint_Factory create(Provider<DescriptionPresenter> provider) {
        return new DescriptionBlueprint_Factory(provider);
    }

    public static DescriptionBlueprint newInstance(DescriptionPresenter descriptionPresenter) {
        return new DescriptionBlueprint(descriptionPresenter);
    }

    @Override // javax.inject.Provider
    public DescriptionBlueprint get() {
        return newInstance(this.a.get());
    }
}
