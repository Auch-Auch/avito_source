package com.avito.android.settings.adapter;

import dagger.internal.Factory;
public final class CategorySettingsItemPresenterImpl_Factory implements Factory<CategorySettingsItemPresenterImpl> {

    public static final class a {
        public static final CategorySettingsItemPresenterImpl_Factory a = new CategorySettingsItemPresenterImpl_Factory();
    }

    public static CategorySettingsItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static CategorySettingsItemPresenterImpl newInstance() {
        return new CategorySettingsItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public CategorySettingsItemPresenterImpl get() {
        return newInstance();
    }
}
