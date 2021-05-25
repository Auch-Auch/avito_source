package com.avito.android.brandspace.items.legal;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class LegalBlueprint_Factory implements Factory<LegalBlueprint> {
    public final Provider<LegalPresenter> a;

    public LegalBlueprint_Factory(Provider<LegalPresenter> provider) {
        this.a = provider;
    }

    public static LegalBlueprint_Factory create(Provider<LegalPresenter> provider) {
        return new LegalBlueprint_Factory(provider);
    }

    public static LegalBlueprint newInstance(LegalPresenter legalPresenter) {
        return new LegalBlueprint(legalPresenter);
    }

    @Override // javax.inject.Provider
    public LegalBlueprint get() {
        return newInstance(this.a.get());
    }
}
