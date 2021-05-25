package com.avito.android.select.bottom_sheet.blueprints;

import dagger.internal.Factory;
public final class CheckableItemPresenterImpl_Factory implements Factory<CheckableItemPresenterImpl> {

    public static final class a {
        public static final CheckableItemPresenterImpl_Factory a = new CheckableItemPresenterImpl_Factory();
    }

    public static CheckableItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static CheckableItemPresenterImpl newInstance() {
        return new CheckableItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public CheckableItemPresenterImpl get() {
        return newInstance();
    }
}
