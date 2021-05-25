package com.avito.android.brandspace.items.text;

import dagger.internal.Factory;
public final class TextPresenterImpl_Factory implements Factory<TextPresenterImpl> {

    public static final class a {
        public static final TextPresenterImpl_Factory a = new TextPresenterImpl_Factory();
    }

    public static TextPresenterImpl_Factory create() {
        return a.a;
    }

    public static TextPresenterImpl newInstance() {
        return new TextPresenterImpl();
    }

    @Override // javax.inject.Provider
    public TextPresenterImpl get() {
        return newInstance();
    }
}
