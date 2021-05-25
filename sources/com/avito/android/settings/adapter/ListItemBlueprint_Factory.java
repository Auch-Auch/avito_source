package com.avito.android.settings.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ListItemBlueprint_Factory implements Factory<ListItemBlueprint> {
    public final Provider<ListItemPresenter> a;

    public ListItemBlueprint_Factory(Provider<ListItemPresenter> provider) {
        this.a = provider;
    }

    public static ListItemBlueprint_Factory create(Provider<ListItemPresenter> provider) {
        return new ListItemBlueprint_Factory(provider);
    }

    public static ListItemBlueprint newInstance(ListItemPresenter listItemPresenter) {
        return new ListItemBlueprint(listItemPresenter);
    }

    @Override // javax.inject.Provider
    public ListItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
