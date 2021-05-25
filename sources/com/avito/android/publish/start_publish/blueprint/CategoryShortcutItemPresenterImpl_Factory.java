package com.avito.android.publish.start_publish.blueprint;

import dagger.internal.Factory;
public final class CategoryShortcutItemPresenterImpl_Factory implements Factory<CategoryShortcutItemPresenterImpl> {

    public static final class a {
        public static final CategoryShortcutItemPresenterImpl_Factory a = new CategoryShortcutItemPresenterImpl_Factory();
    }

    public static CategoryShortcutItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static CategoryShortcutItemPresenterImpl newInstance() {
        return new CategoryShortcutItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public CategoryShortcutItemPresenterImpl get() {
        return newInstance();
    }
}
