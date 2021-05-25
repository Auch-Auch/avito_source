package com.avito.android.tariff.change.item.benefit;

import dagger.internal.Factory;
public final class BenefitItemPresenterImpl_Factory implements Factory<BenefitItemPresenterImpl> {

    public static final class a {
        public static final BenefitItemPresenterImpl_Factory a = new BenefitItemPresenterImpl_Factory();
    }

    public static BenefitItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static BenefitItemPresenterImpl newInstance() {
        return new BenefitItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public BenefitItemPresenterImpl get() {
        return newInstance();
    }
}
