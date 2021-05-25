package com.avito.android.abuse.details.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SecondaryButtonItemBlueprint_Factory implements Factory<SecondaryButtonItemBlueprint> {
    public final Provider<SecondaryButtonItemPresenter> a;

    public SecondaryButtonItemBlueprint_Factory(Provider<SecondaryButtonItemPresenter> provider) {
        this.a = provider;
    }

    public static SecondaryButtonItemBlueprint_Factory create(Provider<SecondaryButtonItemPresenter> provider) {
        return new SecondaryButtonItemBlueprint_Factory(provider);
    }

    public static SecondaryButtonItemBlueprint newInstance(SecondaryButtonItemPresenter secondaryButtonItemPresenter) {
        return new SecondaryButtonItemBlueprint(secondaryButtonItemPresenter);
    }

    @Override // javax.inject.Provider
    public SecondaryButtonItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
