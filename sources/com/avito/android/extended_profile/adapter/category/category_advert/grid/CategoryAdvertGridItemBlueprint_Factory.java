package com.avito.android.extended_profile.adapter.category.category_advert.grid;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoryAdvertGridItemBlueprint_Factory implements Factory<CategoryAdvertGridItemBlueprint> {
    public final Provider<CategoryAdvertGridItemPresenter> a;
    public final Provider<Boolean> b;

    public CategoryAdvertGridItemBlueprint_Factory(Provider<CategoryAdvertGridItemPresenter> provider, Provider<Boolean> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CategoryAdvertGridItemBlueprint_Factory create(Provider<CategoryAdvertGridItemPresenter> provider, Provider<Boolean> provider2) {
        return new CategoryAdvertGridItemBlueprint_Factory(provider, provider2);
    }

    public static CategoryAdvertGridItemBlueprint newInstance(CategoryAdvertGridItemPresenter categoryAdvertGridItemPresenter, boolean z) {
        return new CategoryAdvertGridItemBlueprint(categoryAdvertGridItemPresenter, z);
    }

    @Override // javax.inject.Provider
    public CategoryAdvertGridItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get().booleanValue());
    }
}
