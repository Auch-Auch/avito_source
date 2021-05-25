package com.avito.android.advert_stats.item.period;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PeriodItemBlueprint_Factory implements Factory<PeriodItemBlueprint> {
    public final Provider<PeriodItemPresenter> a;

    public PeriodItemBlueprint_Factory(Provider<PeriodItemPresenter> provider) {
        this.a = provider;
    }

    public static PeriodItemBlueprint_Factory create(Provider<PeriodItemPresenter> provider) {
        return new PeriodItemBlueprint_Factory(provider);
    }

    public static PeriodItemBlueprint newInstance(PeriodItemPresenter periodItemPresenter) {
        return new PeriodItemBlueprint(periodItemPresenter);
    }

    @Override // javax.inject.Provider
    public PeriodItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
