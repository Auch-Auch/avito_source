package com.avito.android.extended_profile.adapter.divider;

import dagger.internal.Factory;
public final class DividerItemPresenterImpl_Factory implements Factory<DividerItemPresenterImpl> {

    public static final class a {
        public static final DividerItemPresenterImpl_Factory a = new DividerItemPresenterImpl_Factory();
    }

    public static DividerItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static DividerItemPresenterImpl newInstance() {
        return new DividerItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public DividerItemPresenterImpl get() {
        return newInstance();
    }
}
