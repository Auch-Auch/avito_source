package com.avito.android.tariff.edit_info.item.manager_call;

import dagger.internal.Factory;
public final class ManagerCallPresenterImpl_Factory implements Factory<ManagerCallPresenterImpl> {

    public static final class a {
        public static final ManagerCallPresenterImpl_Factory a = new ManagerCallPresenterImpl_Factory();
    }

    public static ManagerCallPresenterImpl_Factory create() {
        return a.a;
    }

    public static ManagerCallPresenterImpl newInstance() {
        return new ManagerCallPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ManagerCallPresenterImpl get() {
        return newInstance();
    }
}
