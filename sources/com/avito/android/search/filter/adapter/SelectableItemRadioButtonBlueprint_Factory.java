package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.SelectableItemIconFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectableItemRadioButtonBlueprint_Factory implements Factory<SelectableItemRadioButtonBlueprint> {
    public final Provider<SelectableItemPresenter> a;
    public final Provider<SelectableItemIconFactory> b;

    public SelectableItemRadioButtonBlueprint_Factory(Provider<SelectableItemPresenter> provider, Provider<SelectableItemIconFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SelectableItemRadioButtonBlueprint_Factory create(Provider<SelectableItemPresenter> provider, Provider<SelectableItemIconFactory> provider2) {
        return new SelectableItemRadioButtonBlueprint_Factory(provider, provider2);
    }

    public static SelectableItemRadioButtonBlueprint newInstance(SelectableItemPresenter selectableItemPresenter, SelectableItemIconFactory selectableItemIconFactory) {
        return new SelectableItemRadioButtonBlueprint(selectableItemPresenter, selectableItemIconFactory);
    }

    @Override // javax.inject.Provider
    public SelectableItemRadioButtonBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
