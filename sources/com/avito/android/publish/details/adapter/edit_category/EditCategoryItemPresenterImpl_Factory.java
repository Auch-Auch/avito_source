package com.avito.android.publish.details.adapter.edit_category;

import dagger.internal.Factory;
public final class EditCategoryItemPresenterImpl_Factory implements Factory<EditCategoryItemPresenterImpl> {

    public static final class a {
        public static final EditCategoryItemPresenterImpl_Factory a = new EditCategoryItemPresenterImpl_Factory();
    }

    public static EditCategoryItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static EditCategoryItemPresenterImpl newInstance() {
        return new EditCategoryItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public EditCategoryItemPresenterImpl get() {
        return newInstance();
    }
}
