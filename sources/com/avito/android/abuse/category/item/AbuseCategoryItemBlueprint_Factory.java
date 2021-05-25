package com.avito.android.abuse.category.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AbuseCategoryItemBlueprint_Factory implements Factory<AbuseCategoryItemBlueprint> {
    public final Provider<AbuseCategoryItemPresenter> a;

    public AbuseCategoryItemBlueprint_Factory(Provider<AbuseCategoryItemPresenter> provider) {
        this.a = provider;
    }

    public static AbuseCategoryItemBlueprint_Factory create(Provider<AbuseCategoryItemPresenter> provider) {
        return new AbuseCategoryItemBlueprint_Factory(provider);
    }

    public static AbuseCategoryItemBlueprint newInstance(AbuseCategoryItemPresenter abuseCategoryItemPresenter) {
        return new AbuseCategoryItemBlueprint(abuseCategoryItemPresenter);
    }

    @Override // javax.inject.Provider
    public AbuseCategoryItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
