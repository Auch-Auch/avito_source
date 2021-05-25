package com.avito.android.delivery.summary.konveyor.text;

import dagger.internal.Factory;
public final class TextItemPresenter_Factory implements Factory<TextItemPresenter> {

    public static final class a {
        public static final TextItemPresenter_Factory a = new TextItemPresenter_Factory();
    }

    public static TextItemPresenter_Factory create() {
        return a.a;
    }

    public static TextItemPresenter newInstance() {
        return new TextItemPresenter();
    }

    @Override // javax.inject.Provider
    public TextItemPresenter get() {
        return newInstance();
    }
}
