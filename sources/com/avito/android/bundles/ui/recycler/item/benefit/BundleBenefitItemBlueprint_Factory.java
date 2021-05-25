package com.avito.android.bundles.ui.recycler.item.benefit;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class BundleBenefitItemBlueprint_Factory implements Factory<BundleBenefitItemBlueprint> {
    public final Provider<BenefitItemPresenter> a;

    public BundleBenefitItemBlueprint_Factory(Provider<BenefitItemPresenter> provider) {
        this.a = provider;
    }

    public static BundleBenefitItemBlueprint_Factory create(Provider<BenefitItemPresenter> provider) {
        return new BundleBenefitItemBlueprint_Factory(provider);
    }

    public static BundleBenefitItemBlueprint newInstance(BenefitItemPresenter benefitItemPresenter) {
        return new BundleBenefitItemBlueprint(benefitItemPresenter);
    }

    @Override // javax.inject.Provider
    public BundleBenefitItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
