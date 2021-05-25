package com.avito.android.search.filter;

import com.avito.android.search.filter.adapter.SelectableItemRadioButtonBlueprint;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectDialogFactoryImpl_Factory implements Factory<SelectDialogFactoryImpl> {
    public final Provider<SelectableItemRadioButtonBlueprint> a;
    public final Provider<SelectDialogPresenter> b;

    public SelectDialogFactoryImpl_Factory(Provider<SelectableItemRadioButtonBlueprint> provider, Provider<SelectDialogPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SelectDialogFactoryImpl_Factory create(Provider<SelectableItemRadioButtonBlueprint> provider, Provider<SelectDialogPresenter> provider2) {
        return new SelectDialogFactoryImpl_Factory(provider, provider2);
    }

    public static SelectDialogFactoryImpl newInstance(SelectableItemRadioButtonBlueprint selectableItemRadioButtonBlueprint, SelectDialogPresenter selectDialogPresenter) {
        return new SelectDialogFactoryImpl(selectableItemRadioButtonBlueprint, selectDialogPresenter);
    }

    @Override // javax.inject.Provider
    public SelectDialogFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
