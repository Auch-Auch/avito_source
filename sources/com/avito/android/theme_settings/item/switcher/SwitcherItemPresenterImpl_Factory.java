package com.avito.android.theme_settings.item.switcher;

import dagger.internal.Factory;
public final class SwitcherItemPresenterImpl_Factory implements Factory<SwitcherItemPresenterImpl> {

    public static final class a {
        public static final SwitcherItemPresenterImpl_Factory a = new SwitcherItemPresenterImpl_Factory();
    }

    public static SwitcherItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static SwitcherItemPresenterImpl newInstance() {
        return new SwitcherItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public SwitcherItemPresenterImpl get() {
        return newInstance();
    }
}
