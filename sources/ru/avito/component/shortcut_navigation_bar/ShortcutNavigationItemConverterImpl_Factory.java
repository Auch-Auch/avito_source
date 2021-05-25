package ru.avito.component.shortcut_navigation_bar;

import dagger.internal.Factory;
public final class ShortcutNavigationItemConverterImpl_Factory implements Factory<ShortcutNavigationItemConverterImpl> {

    public static final class a {
        public static final ShortcutNavigationItemConverterImpl_Factory a = new ShortcutNavigationItemConverterImpl_Factory();
    }

    public static ShortcutNavigationItemConverterImpl_Factory create() {
        return a.a;
    }

    public static ShortcutNavigationItemConverterImpl newInstance() {
        return new ShortcutNavigationItemConverterImpl();
    }

    @Override // javax.inject.Provider
    public ShortcutNavigationItemConverterImpl get() {
        return newInstance();
    }
}
