package com.avito.android.tariff.count.item.bonus;

import dagger.internal.Factory;
public final class BonusItemPresenter_Factory implements Factory<BonusItemPresenter> {

    public static final class a {
        public static final BonusItemPresenter_Factory a = new BonusItemPresenter_Factory();
    }

    public static BonusItemPresenter_Factory create() {
        return a.a;
    }

    public static BonusItemPresenter newInstance() {
        return new BonusItemPresenter();
    }

    @Override // javax.inject.Provider
    public BonusItemPresenter get() {
        return newInstance();
    }
}
