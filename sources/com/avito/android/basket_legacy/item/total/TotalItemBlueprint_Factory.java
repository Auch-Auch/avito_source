package com.avito.android.basket_legacy.item.total;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TotalItemBlueprint_Factory implements Factory<TotalItemBlueprint> {
    public final Provider<TotalItemPresenter> a;

    public TotalItemBlueprint_Factory(Provider<TotalItemPresenter> provider) {
        this.a = provider;
    }

    public static TotalItemBlueprint_Factory create(Provider<TotalItemPresenter> provider) {
        return new TotalItemBlueprint_Factory(provider);
    }

    public static TotalItemBlueprint newInstance(TotalItemPresenter totalItemPresenter) {
        return new TotalItemBlueprint(totalItemPresenter);
    }

    @Override // javax.inject.Provider
    public TotalItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
