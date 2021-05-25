package com.avito.android.brandspace.items.categories.categoryitem;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoryItemBlueprint_Factory implements Factory<CategoryItemBlueprint> {
    public final Provider<CategoryItemPresenter> a;

    public CategoryItemBlueprint_Factory(Provider<CategoryItemPresenter> provider) {
        this.a = provider;
    }

    public static CategoryItemBlueprint_Factory create(Provider<CategoryItemPresenter> provider) {
        return new CategoryItemBlueprint_Factory(provider);
    }

    public static CategoryItemBlueprint newInstance(CategoryItemPresenter categoryItemPresenter) {
        return new CategoryItemBlueprint(categoryItemPresenter);
    }

    @Override // javax.inject.Provider
    public CategoryItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
