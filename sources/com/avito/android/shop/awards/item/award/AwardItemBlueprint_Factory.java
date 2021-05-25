package com.avito.android.shop.awards.item.award;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AwardItemBlueprint_Factory implements Factory<AwardItemBlueprint> {
    public final Provider<AwardItemPresenter> a;

    public AwardItemBlueprint_Factory(Provider<AwardItemPresenter> provider) {
        this.a = provider;
    }

    public static AwardItemBlueprint_Factory create(Provider<AwardItemPresenter> provider) {
        return new AwardItemBlueprint_Factory(provider);
    }

    public static AwardItemBlueprint newInstance(AwardItemPresenter awardItemPresenter) {
        return new AwardItemBlueprint(awardItemPresenter);
    }

    @Override // javax.inject.Provider
    public AwardItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
