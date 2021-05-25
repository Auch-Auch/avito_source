package com.avito.android.update;

import dagger.internal.Factory;
public final class UpdateApplicationPresenterImpl_Factory implements Factory<UpdateApplicationPresenterImpl> {

    public static final class a {
        public static final UpdateApplicationPresenterImpl_Factory a = new UpdateApplicationPresenterImpl_Factory();
    }

    public static UpdateApplicationPresenterImpl_Factory create() {
        return a.a;
    }

    public static UpdateApplicationPresenterImpl newInstance() {
        return new UpdateApplicationPresenterImpl();
    }

    @Override // javax.inject.Provider
    public UpdateApplicationPresenterImpl get() {
        return newInstance();
    }
}
