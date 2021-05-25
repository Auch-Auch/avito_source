package com.avito.android.extended_profile.adapter.category.category_button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoryButtonItemBlueprint_Factory implements Factory<CategoryButtonItemBlueprint> {
    public final Provider<CategoryButtonItemPresenter> a;
    public final Provider<Boolean> b;

    public CategoryButtonItemBlueprint_Factory(Provider<CategoryButtonItemPresenter> provider, Provider<Boolean> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CategoryButtonItemBlueprint_Factory create(Provider<CategoryButtonItemPresenter> provider, Provider<Boolean> provider2) {
        return new CategoryButtonItemBlueprint_Factory(provider, provider2);
    }

    public static CategoryButtonItemBlueprint newInstance(CategoryButtonItemPresenter categoryButtonItemPresenter, boolean z) {
        return new CategoryButtonItemBlueprint(categoryButtonItemPresenter, z);
    }

    @Override // javax.inject.Provider
    public CategoryButtonItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get().booleanValue());
    }
}
