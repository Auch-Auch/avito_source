package com.avito.android.tariff.edit_info.item.edit_package.micro_category;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MicroCategoryItemBlueprint_Factory implements Factory<MicroCategoryItemBlueprint> {
    public final Provider<MicroCategoryItemPresenter> a;

    public MicroCategoryItemBlueprint_Factory(Provider<MicroCategoryItemPresenter> provider) {
        this.a = provider;
    }

    public static MicroCategoryItemBlueprint_Factory create(Provider<MicroCategoryItemPresenter> provider) {
        return new MicroCategoryItemBlueprint_Factory(provider);
    }

    public static MicroCategoryItemBlueprint newInstance(MicroCategoryItemPresenter microCategoryItemPresenter) {
        return new MicroCategoryItemBlueprint(microCategoryItemPresenter);
    }

    @Override // javax.inject.Provider
    public MicroCategoryItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
