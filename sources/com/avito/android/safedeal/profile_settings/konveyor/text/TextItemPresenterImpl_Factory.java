package com.avito.android.safedeal.profile_settings.konveyor.text;

import dagger.internal.Factory;
public final class TextItemPresenterImpl_Factory implements Factory<TextItemPresenterImpl> {

    public static final class a {
        public static final TextItemPresenterImpl_Factory a = new TextItemPresenterImpl_Factory();
    }

    public static TextItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static TextItemPresenterImpl newInstance() {
        return new TextItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public TextItemPresenterImpl get() {
        return newInstance();
    }
}
