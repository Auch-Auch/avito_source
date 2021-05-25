package com.avito.android.settings.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategorySettingsItemBlueprint_Factory implements Factory<CategorySettingsItemBlueprint> {
    public final Provider<CategorySettingsItemPresenter> a;

    public CategorySettingsItemBlueprint_Factory(Provider<CategorySettingsItemPresenter> provider) {
        this.a = provider;
    }

    public static CategorySettingsItemBlueprint_Factory create(Provider<CategorySettingsItemPresenter> provider) {
        return new CategorySettingsItemBlueprint_Factory(provider);
    }

    public static CategorySettingsItemBlueprint newInstance(CategorySettingsItemPresenter categorySettingsItemPresenter) {
        return new CategorySettingsItemBlueprint(categorySettingsItemPresenter);
    }

    @Override // javax.inject.Provider
    public CategorySettingsItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
