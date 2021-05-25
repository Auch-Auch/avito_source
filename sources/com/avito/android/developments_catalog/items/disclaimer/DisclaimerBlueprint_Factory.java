package com.avito.android.developments_catalog.items.disclaimer;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DisclaimerBlueprint_Factory implements Factory<DisclaimerBlueprint> {
    public final Provider<DisclaimerPresenter> a;

    public DisclaimerBlueprint_Factory(Provider<DisclaimerPresenter> provider) {
        this.a = provider;
    }

    public static DisclaimerBlueprint_Factory create(Provider<DisclaimerPresenter> provider) {
        return new DisclaimerBlueprint_Factory(provider);
    }

    public static DisclaimerBlueprint newInstance(DisclaimerPresenter disclaimerPresenter) {
        return new DisclaimerBlueprint(disclaimerPresenter);
    }

    @Override // javax.inject.Provider
    public DisclaimerBlueprint get() {
        return newInstance(this.a.get());
    }
}
