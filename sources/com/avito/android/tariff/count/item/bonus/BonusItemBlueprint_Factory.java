package com.avito.android.tariff.count.item.bonus;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class BonusItemBlueprint_Factory implements Factory<BonusItemBlueprint> {
    public final Provider<BonusItemPresenter> a;

    public BonusItemBlueprint_Factory(Provider<BonusItemPresenter> provider) {
        this.a = provider;
    }

    public static BonusItemBlueprint_Factory create(Provider<BonusItemPresenter> provider) {
        return new BonusItemBlueprint_Factory(provider);
    }

    public static BonusItemBlueprint newInstance(BonusItemPresenter bonusItemPresenter) {
        return new BonusItemBlueprint(bonusItemPresenter);
    }

    @Override // javax.inject.Provider
    public BonusItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
