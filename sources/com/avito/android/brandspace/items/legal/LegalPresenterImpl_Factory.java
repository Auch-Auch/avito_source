package com.avito.android.brandspace.items.legal;

import dagger.internal.Factory;
public final class LegalPresenterImpl_Factory implements Factory<LegalPresenterImpl> {

    public static final class a {
        public static final LegalPresenterImpl_Factory a = new LegalPresenterImpl_Factory();
    }

    public static LegalPresenterImpl_Factory create() {
        return a.a;
    }

    public static LegalPresenterImpl newInstance() {
        return new LegalPresenterImpl();
    }

    @Override // javax.inject.Provider
    public LegalPresenterImpl get() {
        return newInstance();
    }
}
