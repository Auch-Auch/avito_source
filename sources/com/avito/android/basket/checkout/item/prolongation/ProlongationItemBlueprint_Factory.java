package com.avito.android.basket.checkout.item.prolongation;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProlongationItemBlueprint_Factory implements Factory<ProlongationItemBlueprint> {
    public final Provider<ProlongationItemPresenter> a;

    public ProlongationItemBlueprint_Factory(Provider<ProlongationItemPresenter> provider) {
        this.a = provider;
    }

    public static ProlongationItemBlueprint_Factory create(Provider<ProlongationItemPresenter> provider) {
        return new ProlongationItemBlueprint_Factory(provider);
    }

    public static ProlongationItemBlueprint newInstance(ProlongationItemPresenter prolongationItemPresenter) {
        return new ProlongationItemBlueprint(prolongationItemPresenter);
    }

    @Override // javax.inject.Provider
    public ProlongationItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
