package com.avito.android.tariff.edit_info.item.add_category;

import dagger.internal.Factory;
public final class AddCategoryItemPresenterImpl_Factory implements Factory<AddCategoryItemPresenterImpl> {

    public static final class a {
        public static final AddCategoryItemPresenterImpl_Factory a = new AddCategoryItemPresenterImpl_Factory();
    }

    public static AddCategoryItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static AddCategoryItemPresenterImpl newInstance() {
        return new AddCategoryItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AddCategoryItemPresenterImpl get() {
        return newInstance();
    }
}
