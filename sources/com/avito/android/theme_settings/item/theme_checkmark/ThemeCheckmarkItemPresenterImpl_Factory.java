package com.avito.android.theme_settings.item.theme_checkmark;

import dagger.internal.Factory;
public final class ThemeCheckmarkItemPresenterImpl_Factory implements Factory<ThemeCheckmarkItemPresenterImpl> {

    public static final class a {
        public static final ThemeCheckmarkItemPresenterImpl_Factory a = new ThemeCheckmarkItemPresenterImpl_Factory();
    }

    public static ThemeCheckmarkItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ThemeCheckmarkItemPresenterImpl newInstance() {
        return new ThemeCheckmarkItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ThemeCheckmarkItemPresenterImpl get() {
        return newInstance();
    }
}
