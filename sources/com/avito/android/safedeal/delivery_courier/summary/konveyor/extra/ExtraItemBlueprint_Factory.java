package com.avito.android.safedeal.delivery_courier.summary.konveyor.extra;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExtraItemBlueprint_Factory implements Factory<ExtraItemBlueprint> {
    public final Provider<ExtraItemPresenter> a;

    public ExtraItemBlueprint_Factory(Provider<ExtraItemPresenter> provider) {
        this.a = provider;
    }

    public static ExtraItemBlueprint_Factory create(Provider<ExtraItemPresenter> provider) {
        return new ExtraItemBlueprint_Factory(provider);
    }

    public static ExtraItemBlueprint newInstance(ExtraItemPresenter extraItemPresenter) {
        return new ExtraItemBlueprint(extraItemPresenter);
    }

    @Override // javax.inject.Provider
    public ExtraItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
