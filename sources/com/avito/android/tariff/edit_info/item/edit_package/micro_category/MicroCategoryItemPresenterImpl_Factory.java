package com.avito.android.tariff.edit_info.item.edit_package.micro_category;

import dagger.internal.Factory;
public final class MicroCategoryItemPresenterImpl_Factory implements Factory<MicroCategoryItemPresenterImpl> {

    public static final class a {
        public static final MicroCategoryItemPresenterImpl_Factory a = new MicroCategoryItemPresenterImpl_Factory();
    }

    public static MicroCategoryItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static MicroCategoryItemPresenterImpl newInstance() {
        return new MicroCategoryItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public MicroCategoryItemPresenterImpl get() {
        return newInstance();
    }
}
