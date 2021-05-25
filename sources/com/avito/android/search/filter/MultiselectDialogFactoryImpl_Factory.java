package com.avito.android.search.filter;

import com.avito.android.search.filter.adapter.SelectableItemCheckBoxBlueprint;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MultiselectDialogFactoryImpl_Factory implements Factory<MultiselectDialogFactoryImpl> {
    public final Provider<SelectableItemCheckBoxBlueprint> a;
    public final Provider<MultiselectDialogPresenter> b;

    public MultiselectDialogFactoryImpl_Factory(Provider<SelectableItemCheckBoxBlueprint> provider, Provider<MultiselectDialogPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MultiselectDialogFactoryImpl_Factory create(Provider<SelectableItemCheckBoxBlueprint> provider, Provider<MultiselectDialogPresenter> provider2) {
        return new MultiselectDialogFactoryImpl_Factory(provider, provider2);
    }

    public static MultiselectDialogFactoryImpl newInstance(SelectableItemCheckBoxBlueprint selectableItemCheckBoxBlueprint, MultiselectDialogPresenter multiselectDialogPresenter) {
        return new MultiselectDialogFactoryImpl(selectableItemCheckBoxBlueprint, multiselectDialogPresenter);
    }

    @Override // javax.inject.Provider
    public MultiselectDialogFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
