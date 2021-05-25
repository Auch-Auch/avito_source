package com.avito.android.tariff.edit_info.item.add_category;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AddCategoryItemBlueprint_Factory implements Factory<AddCategoryItemBlueprint> {
    public final Provider<AddCategoryItemPresenter> a;

    public AddCategoryItemBlueprint_Factory(Provider<AddCategoryItemPresenter> provider) {
        this.a = provider;
    }

    public static AddCategoryItemBlueprint_Factory create(Provider<AddCategoryItemPresenter> provider) {
        return new AddCategoryItemBlueprint_Factory(provider);
    }

    public static AddCategoryItemBlueprint newInstance(AddCategoryItemPresenter addCategoryItemPresenter) {
        return new AddCategoryItemBlueprint(addCategoryItemPresenter);
    }

    @Override // javax.inject.Provider
    public AddCategoryItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
