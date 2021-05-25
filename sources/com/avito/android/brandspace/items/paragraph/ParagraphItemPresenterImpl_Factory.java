package com.avito.android.brandspace.items.paragraph;

import dagger.internal.Factory;
public final class ParagraphItemPresenterImpl_Factory implements Factory<ParagraphItemPresenterImpl> {

    public static final class a {
        public static final ParagraphItemPresenterImpl_Factory a = new ParagraphItemPresenterImpl_Factory();
    }

    public static ParagraphItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ParagraphItemPresenterImpl newInstance() {
        return new ParagraphItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ParagraphItemPresenterImpl get() {
        return newInstance();
    }
}
