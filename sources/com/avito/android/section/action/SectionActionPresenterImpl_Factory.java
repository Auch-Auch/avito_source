package com.avito.android.section.action;

import dagger.internal.Factory;
public final class SectionActionPresenterImpl_Factory implements Factory<SectionActionPresenterImpl> {

    public static final class a {
        public static final SectionActionPresenterImpl_Factory a = new SectionActionPresenterImpl_Factory();
    }

    public static SectionActionPresenterImpl_Factory create() {
        return a.a;
    }

    public static SectionActionPresenterImpl newInstance() {
        return new SectionActionPresenterImpl();
    }

    @Override // javax.inject.Provider
    public SectionActionPresenterImpl get() {
        return newInstance();
    }
}
