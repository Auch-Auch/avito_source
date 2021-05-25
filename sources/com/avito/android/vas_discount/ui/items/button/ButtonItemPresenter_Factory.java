package com.avito.android.vas_discount.ui.items.button;

import dagger.internal.Factory;
public final class ButtonItemPresenter_Factory implements Factory<ButtonItemPresenter> {

    public static final class a {
        public static final ButtonItemPresenter_Factory a = new ButtonItemPresenter_Factory();
    }

    public static ButtonItemPresenter_Factory create() {
        return a.a;
    }

    public static ButtonItemPresenter newInstance() {
        return new ButtonItemPresenter();
    }

    @Override // javax.inject.Provider
    public ButtonItemPresenter get() {
        return newInstance();
    }
}
