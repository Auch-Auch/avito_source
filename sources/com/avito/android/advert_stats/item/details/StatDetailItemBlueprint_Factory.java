package com.avito.android.advert_stats.item.details;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class StatDetailItemBlueprint_Factory implements Factory<StatDetailItemBlueprint> {
    public final Provider<StatDetailItemPresenter> a;

    public StatDetailItemBlueprint_Factory(Provider<StatDetailItemPresenter> provider) {
        this.a = provider;
    }

    public static StatDetailItemBlueprint_Factory create(Provider<StatDetailItemPresenter> provider) {
        return new StatDetailItemBlueprint_Factory(provider);
    }

    public static StatDetailItemBlueprint newInstance(StatDetailItemPresenter statDetailItemPresenter) {
        return new StatDetailItemBlueprint(statDetailItemPresenter);
    }

    @Override // javax.inject.Provider
    public StatDetailItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
