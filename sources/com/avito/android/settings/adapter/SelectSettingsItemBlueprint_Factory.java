package com.avito.android.settings.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectSettingsItemBlueprint_Factory implements Factory<SelectSettingsItemBlueprint> {
    public final Provider<SelectSettingsItemPresenter> a;

    public SelectSettingsItemBlueprint_Factory(Provider<SelectSettingsItemPresenter> provider) {
        this.a = provider;
    }

    public static SelectSettingsItemBlueprint_Factory create(Provider<SelectSettingsItemPresenter> provider) {
        return new SelectSettingsItemBlueprint_Factory(provider);
    }

    public static SelectSettingsItemBlueprint newInstance(SelectSettingsItemPresenter selectSettingsItemPresenter) {
        return new SelectSettingsItemBlueprint(selectSettingsItemPresenter);
    }

    @Override // javax.inject.Provider
    public SelectSettingsItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
