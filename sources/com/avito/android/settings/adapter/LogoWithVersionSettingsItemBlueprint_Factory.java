package com.avito.android.settings.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class LogoWithVersionSettingsItemBlueprint_Factory implements Factory<LogoWithVersionSettingsItemBlueprint> {
    public final Provider<LogoWithVersionSettingsItemPresenter> a;

    public LogoWithVersionSettingsItemBlueprint_Factory(Provider<LogoWithVersionSettingsItemPresenter> provider) {
        this.a = provider;
    }

    public static LogoWithVersionSettingsItemBlueprint_Factory create(Provider<LogoWithVersionSettingsItemPresenter> provider) {
        return new LogoWithVersionSettingsItemBlueprint_Factory(provider);
    }

    public static LogoWithVersionSettingsItemBlueprint newInstance(LogoWithVersionSettingsItemPresenter logoWithVersionSettingsItemPresenter) {
        return new LogoWithVersionSettingsItemBlueprint(logoWithVersionSettingsItemPresenter);
    }

    @Override // javax.inject.Provider
    public LogoWithVersionSettingsItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
