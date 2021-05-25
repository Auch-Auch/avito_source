package com.avito.android.abuse.details.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PrimaryButtonItemBlueprint_Factory implements Factory<PrimaryButtonItemBlueprint> {
    public final Provider<PrimaryButtonItemPresenter> a;

    public PrimaryButtonItemBlueprint_Factory(Provider<PrimaryButtonItemPresenter> provider) {
        this.a = provider;
    }

    public static PrimaryButtonItemBlueprint_Factory create(Provider<PrimaryButtonItemPresenter> provider) {
        return new PrimaryButtonItemBlueprint_Factory(provider);
    }

    public static PrimaryButtonItemBlueprint newInstance(PrimaryButtonItemPresenter primaryButtonItemPresenter) {
        return new PrimaryButtonItemBlueprint(primaryButtonItemPresenter);
    }

    @Override // javax.inject.Provider
    public PrimaryButtonItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
