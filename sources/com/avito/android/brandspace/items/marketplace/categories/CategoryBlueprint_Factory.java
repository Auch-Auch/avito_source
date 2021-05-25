package com.avito.android.brandspace.items.marketplace.categories;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoryBlueprint_Factory implements Factory<CategoryBlueprint> {
    public final Provider<CategoryPresenter> a;

    public CategoryBlueprint_Factory(Provider<CategoryPresenter> provider) {
        this.a = provider;
    }

    public static CategoryBlueprint_Factory create(Provider<CategoryPresenter> provider) {
        return new CategoryBlueprint_Factory(provider);
    }

    public static CategoryBlueprint newInstance(CategoryPresenter categoryPresenter) {
        return new CategoryBlueprint(categoryPresenter);
    }

    @Override // javax.inject.Provider
    public CategoryBlueprint get() {
        return newInstance(this.a.get());
    }
}
