package com.avito.android.bundles.ui.recycler.item.benefit;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BenefitItemPresenterImpl_Factory implements Factory<BenefitItemPresenterImpl> {
    public final Provider<Features> a;

    public BenefitItemPresenterImpl_Factory(Provider<Features> provider) {
        this.a = provider;
    }

    public static BenefitItemPresenterImpl_Factory create(Provider<Features> provider) {
        return new BenefitItemPresenterImpl_Factory(provider);
    }

    public static BenefitItemPresenterImpl newInstance(Features features) {
        return new BenefitItemPresenterImpl(features);
    }

    @Override // javax.inject.Provider
    public BenefitItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
