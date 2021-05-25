package com.avito.android.brandspace.items.categories;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoriesBlueprint_Factory implements Factory<CategoriesBlueprint> {
    public final Provider<CategoriesPresenter> a;

    public CategoriesBlueprint_Factory(Provider<CategoriesPresenter> provider) {
        this.a = provider;
    }

    public static CategoriesBlueprint_Factory create(Provider<CategoriesPresenter> provider) {
        return new CategoriesBlueprint_Factory(provider);
    }

    public static CategoriesBlueprint newInstance(CategoriesPresenter categoriesPresenter) {
        return new CategoriesBlueprint(categoriesPresenter);
    }

    @Override // javax.inject.Provider
    public CategoriesBlueprint get() {
        return newInstance(this.a.get());
    }
}
