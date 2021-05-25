package com.avito.android.tariff.edit_info.item.button;

import dagger.internal.Factory;
public final class ButtonItemPresenterImpl_Factory implements Factory<ButtonItemPresenterImpl> {

    public static final class a {
        public static final ButtonItemPresenterImpl_Factory a = new ButtonItemPresenterImpl_Factory();
    }

    public static ButtonItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ButtonItemPresenterImpl newInstance() {
        return new ButtonItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ButtonItemPresenterImpl get() {
        return newInstance();
    }
}
