package com.avito.android.section.title;

import dagger.internal.Factory;
public final class SectionTitleItemPresenterImpl_Factory implements Factory<SectionTitleItemPresenterImpl> {

    public static final class a {
        public static final SectionTitleItemPresenterImpl_Factory a = new SectionTitleItemPresenterImpl_Factory();
    }

    public static SectionTitleItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static SectionTitleItemPresenterImpl newInstance() {
        return new SectionTitleItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public SectionTitleItemPresenterImpl get() {
        return newInstance();
    }
}
