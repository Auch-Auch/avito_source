package com.avito.android.tariff.info.item.disclaimer;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DisclaimerItemBlueprint_Factory implements Factory<DisclaimerItemBlueprint> {
    public final Provider<DisclaimerItemPresenter> a;

    public DisclaimerItemBlueprint_Factory(Provider<DisclaimerItemPresenter> provider) {
        this.a = provider;
    }

    public static DisclaimerItemBlueprint_Factory create(Provider<DisclaimerItemPresenter> provider) {
        return new DisclaimerItemBlueprint_Factory(provider);
    }

    public static DisclaimerItemBlueprint newInstance(DisclaimerItemPresenter disclaimerItemPresenter) {
        return new DisclaimerItemBlueprint(disclaimerItemPresenter);
    }

    @Override // javax.inject.Provider
    public DisclaimerItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
