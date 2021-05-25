package com.avito.android.extended_profile.adapter.category.category_header;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoryHeaderItemBlueprint_Factory implements Factory<CategoryHeaderItemBlueprint> {
    public final Provider<CategoryHeaderItemPresenter> a;

    public CategoryHeaderItemBlueprint_Factory(Provider<CategoryHeaderItemPresenter> provider) {
        this.a = provider;
    }

    public static CategoryHeaderItemBlueprint_Factory create(Provider<CategoryHeaderItemPresenter> provider) {
        return new CategoryHeaderItemBlueprint_Factory(provider);
    }

    public static CategoryHeaderItemBlueprint newInstance(CategoryHeaderItemPresenter categoryHeaderItemPresenter) {
        return new CategoryHeaderItemBlueprint(categoryHeaderItemPresenter);
    }

    @Override // javax.inject.Provider
    public CategoryHeaderItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
