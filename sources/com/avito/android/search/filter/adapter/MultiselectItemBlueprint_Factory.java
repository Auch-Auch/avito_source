package com.avito.android.search.filter.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MultiselectItemBlueprint_Factory implements Factory<MultiselectItemBlueprint> {
    public final Provider<MultiselectItemPresenter> a;

    public MultiselectItemBlueprint_Factory(Provider<MultiselectItemPresenter> provider) {
        this.a = provider;
    }

    public static MultiselectItemBlueprint_Factory create(Provider<MultiselectItemPresenter> provider) {
        return new MultiselectItemBlueprint_Factory(provider);
    }

    public static MultiselectItemBlueprint newInstance(MultiselectItemPresenter multiselectItemPresenter) {
        return new MultiselectItemBlueprint(multiselectItemPresenter);
    }

    @Override // javax.inject.Provider
    public MultiselectItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
