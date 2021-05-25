package com.avito.android.theme_settings.item.theme_checkmark;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ThemeCheckmarkItemBlueprint_Factory implements Factory<ThemeCheckmarkItemBlueprint> {
    public final Provider<ThemeCheckmarkItemPresenter> a;

    public ThemeCheckmarkItemBlueprint_Factory(Provider<ThemeCheckmarkItemPresenter> provider) {
        this.a = provider;
    }

    public static ThemeCheckmarkItemBlueprint_Factory create(Provider<ThemeCheckmarkItemPresenter> provider) {
        return new ThemeCheckmarkItemBlueprint_Factory(provider);
    }

    public static ThemeCheckmarkItemBlueprint newInstance(ThemeCheckmarkItemPresenter themeCheckmarkItemPresenter) {
        return new ThemeCheckmarkItemBlueprint(themeCheckmarkItemPresenter);
    }

    @Override // javax.inject.Provider
    public ThemeCheckmarkItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
