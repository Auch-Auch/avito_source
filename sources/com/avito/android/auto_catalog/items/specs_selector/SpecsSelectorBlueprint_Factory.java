package com.avito.android.auto_catalog.items.specs_selector;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SpecsSelectorBlueprint_Factory implements Factory<SpecsSelectorBlueprint> {
    public final Provider<SpecsSelectorPresenter> a;

    public SpecsSelectorBlueprint_Factory(Provider<SpecsSelectorPresenter> provider) {
        this.a = provider;
    }

    public static SpecsSelectorBlueprint_Factory create(Provider<SpecsSelectorPresenter> provider) {
        return new SpecsSelectorBlueprint_Factory(provider);
    }

    public static SpecsSelectorBlueprint newInstance(SpecsSelectorPresenter specsSelectorPresenter) {
        return new SpecsSelectorBlueprint(specsSelectorPresenter);
    }

    @Override // javax.inject.Provider
    public SpecsSelectorBlueprint get() {
        return newInstance(this.a.get());
    }
}
