package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.SelectableItemIconFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectableItemCheckBoxBlueprint_Factory implements Factory<SelectableItemCheckBoxBlueprint> {
    public final Provider<SelectableItemPresenter> a;
    public final Provider<SelectableItemIconFactory> b;

    public SelectableItemCheckBoxBlueprint_Factory(Provider<SelectableItemPresenter> provider, Provider<SelectableItemIconFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SelectableItemCheckBoxBlueprint_Factory create(Provider<SelectableItemPresenter> provider, Provider<SelectableItemIconFactory> provider2) {
        return new SelectableItemCheckBoxBlueprint_Factory(provider, provider2);
    }

    public static SelectableItemCheckBoxBlueprint newInstance(SelectableItemPresenter selectableItemPresenter, SelectableItemIconFactory selectableItemIconFactory) {
        return new SelectableItemCheckBoxBlueprint(selectableItemPresenter, selectableItemIconFactory);
    }

    @Override // javax.inject.Provider
    public SelectableItemCheckBoxBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
