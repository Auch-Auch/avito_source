package com.avito.android.design.widget.dfp_debug;

import dagger.internal.Factory;
public final class DfpDebugPresenterImpl_Factory implements Factory<DfpDebugPresenterImpl> {

    public static final class a {
        public static final DfpDebugPresenterImpl_Factory a = new DfpDebugPresenterImpl_Factory();
    }

    public static DfpDebugPresenterImpl_Factory create() {
        return a.a;
    }

    public static DfpDebugPresenterImpl newInstance() {
        return new DfpDebugPresenterImpl();
    }

    @Override // javax.inject.Provider
    public DfpDebugPresenterImpl get() {
        return newInstance();
    }
}
