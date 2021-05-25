package com.avito.android.tariff.change.item.benefit;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class BenefitItemBlueprint_Factory implements Factory<BenefitItemBlueprint> {
    public final Provider<BenefitItemPresenter> a;

    public BenefitItemBlueprint_Factory(Provider<BenefitItemPresenter> provider) {
        this.a = provider;
    }

    public static BenefitItemBlueprint_Factory create(Provider<BenefitItemPresenter> provider) {
        return new BenefitItemBlueprint_Factory(provider);
    }

    public static BenefitItemBlueprint newInstance(BenefitItemPresenter benefitItemPresenter) {
        return new BenefitItemBlueprint(benefitItemPresenter);
    }

    @Override // javax.inject.Provider
    public BenefitItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
