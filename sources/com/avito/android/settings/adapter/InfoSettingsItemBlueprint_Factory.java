package com.avito.android.settings.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class InfoSettingsItemBlueprint_Factory implements Factory<InfoSettingsItemBlueprint> {
    public final Provider<InfoSettingsItemPresenter> a;

    public InfoSettingsItemBlueprint_Factory(Provider<InfoSettingsItemPresenter> provider) {
        this.a = provider;
    }

    public static InfoSettingsItemBlueprint_Factory create(Provider<InfoSettingsItemPresenter> provider) {
        return new InfoSettingsItemBlueprint_Factory(provider);
    }

    public static InfoSettingsItemBlueprint newInstance(InfoSettingsItemPresenter infoSettingsItemPresenter) {
        return new InfoSettingsItemBlueprint(infoSettingsItemPresenter);
    }

    @Override // javax.inject.Provider
    public InfoSettingsItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
