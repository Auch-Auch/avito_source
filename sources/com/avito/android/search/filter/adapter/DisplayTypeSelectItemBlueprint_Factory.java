package com.avito.android.search.filter.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DisplayTypeSelectItemBlueprint_Factory implements Factory<DisplayTypeSelectItemBlueprint> {
    public final Provider<DisplayTypeSelectPresenter> a;

    public DisplayTypeSelectItemBlueprint_Factory(Provider<DisplayTypeSelectPresenter> provider) {
        this.a = provider;
    }

    public static DisplayTypeSelectItemBlueprint_Factory create(Provider<DisplayTypeSelectPresenter> provider) {
        return new DisplayTypeSelectItemBlueprint_Factory(provider);
    }

    public static DisplayTypeSelectItemBlueprint newInstance(DisplayTypeSelectPresenter displayTypeSelectPresenter) {
        return new DisplayTypeSelectItemBlueprint(displayTypeSelectPresenter);
    }

    @Override // javax.inject.Provider
    public DisplayTypeSelectItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
