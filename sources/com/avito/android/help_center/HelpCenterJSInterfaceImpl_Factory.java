package com.avito.android.help_center;

import dagger.internal.Factory;
public final class HelpCenterJSInterfaceImpl_Factory implements Factory<HelpCenterJSInterfaceImpl> {

    public static final class a {
        public static final HelpCenterJSInterfaceImpl_Factory a = new HelpCenterJSInterfaceImpl_Factory();
    }

    public static HelpCenterJSInterfaceImpl_Factory create() {
        return a.a;
    }

    public static HelpCenterJSInterfaceImpl newInstance() {
        return new HelpCenterJSInterfaceImpl();
    }

    @Override // javax.inject.Provider
    public HelpCenterJSInterfaceImpl get() {
        return newInstance();
    }
}
