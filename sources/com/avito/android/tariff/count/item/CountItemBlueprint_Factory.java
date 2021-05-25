package com.avito.android.tariff.count.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CountItemBlueprint_Factory implements Factory<CountItemBlueprint> {
    public final Provider<CountItemPresenter> a;

    public CountItemBlueprint_Factory(Provider<CountItemPresenter> provider) {
        this.a = provider;
    }

    public static CountItemBlueprint_Factory create(Provider<CountItemPresenter> provider) {
        return new CountItemBlueprint_Factory(provider);
    }

    public static CountItemBlueprint newInstance(CountItemPresenter countItemPresenter) {
        return new CountItemBlueprint(countItemPresenter);
    }

    @Override // javax.inject.Provider
    public CountItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
