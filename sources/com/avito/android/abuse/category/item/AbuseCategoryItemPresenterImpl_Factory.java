package com.avito.android.abuse.category.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AbuseCategoryItemPresenterImpl_Factory implements Factory<AbuseCategoryItemPresenterImpl> {
    public final Provider<AbuseCategoryItemClickListener> a;

    public AbuseCategoryItemPresenterImpl_Factory(Provider<AbuseCategoryItemClickListener> provider) {
        this.a = provider;
    }

    public static AbuseCategoryItemPresenterImpl_Factory create(Provider<AbuseCategoryItemClickListener> provider) {
        return new AbuseCategoryItemPresenterImpl_Factory(provider);
    }

    public static AbuseCategoryItemPresenterImpl newInstance(AbuseCategoryItemClickListener abuseCategoryItemClickListener) {
        return new AbuseCategoryItemPresenterImpl(abuseCategoryItemClickListener);
    }

    @Override // javax.inject.Provider
    public AbuseCategoryItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
