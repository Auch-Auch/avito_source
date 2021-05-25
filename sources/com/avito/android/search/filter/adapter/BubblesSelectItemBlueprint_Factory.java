package com.avito.android.search.filter.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class BubblesSelectItemBlueprint_Factory implements Factory<BubblesSelectItemBlueprint> {
    public final Provider<BubblesSelectItemPresenter> a;

    public BubblesSelectItemBlueprint_Factory(Provider<BubblesSelectItemPresenter> provider) {
        this.a = provider;
    }

    public static BubblesSelectItemBlueprint_Factory create(Provider<BubblesSelectItemPresenter> provider) {
        return new BubblesSelectItemBlueprint_Factory(provider);
    }

    public static BubblesSelectItemBlueprint newInstance(BubblesSelectItemPresenter bubblesSelectItemPresenter) {
        return new BubblesSelectItemBlueprint(bubblesSelectItemPresenter);
    }

    @Override // javax.inject.Provider
    public BubblesSelectItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
