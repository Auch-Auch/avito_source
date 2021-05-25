package com.avito.android.settings.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class InfoSettingsWithProgressItemBlueprint_Factory implements Factory<InfoSettingsWithProgressItemBlueprint> {
    public final Provider<InfoSettingsWithProgressItemPresenter> a;

    public InfoSettingsWithProgressItemBlueprint_Factory(Provider<InfoSettingsWithProgressItemPresenter> provider) {
        this.a = provider;
    }

    public static InfoSettingsWithProgressItemBlueprint_Factory create(Provider<InfoSettingsWithProgressItemPresenter> provider) {
        return new InfoSettingsWithProgressItemBlueprint_Factory(provider);
    }

    public static InfoSettingsWithProgressItemBlueprint newInstance(InfoSettingsWithProgressItemPresenter infoSettingsWithProgressItemPresenter) {
        return new InfoSettingsWithProgressItemBlueprint(infoSettingsWithProgressItemPresenter);
    }

    @Override // javax.inject.Provider
    public InfoSettingsWithProgressItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
