package com.avito.android.search.filter.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectItemBlueprint_Factory implements Factory<SelectItemBlueprint> {
    public final Provider<SelectItemPresenter> a;

    public SelectItemBlueprint_Factory(Provider<SelectItemPresenter> provider) {
        this.a = provider;
    }

    public static SelectItemBlueprint_Factory create(Provider<SelectItemPresenter> provider) {
        return new SelectItemBlueprint_Factory(provider);
    }

    public static SelectItemBlueprint newInstance(SelectItemPresenter selectItemPresenter) {
        return new SelectItemBlueprint(selectItemPresenter);
    }

    @Override // javax.inject.Provider
    public SelectItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
