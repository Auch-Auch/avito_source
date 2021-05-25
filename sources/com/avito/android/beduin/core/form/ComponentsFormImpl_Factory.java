package com.avito.android.beduin.core.form;

import dagger.internal.Factory;
public final class ComponentsFormImpl_Factory implements Factory<ComponentsFormImpl> {

    public static final class a {
        public static final ComponentsFormImpl_Factory a = new ComponentsFormImpl_Factory();
    }

    public static ComponentsFormImpl_Factory create() {
        return a.a;
    }

    public static ComponentsFormImpl newInstance() {
        return new ComponentsFormImpl();
    }

    @Override // javax.inject.Provider
    public ComponentsFormImpl get() {
        return newInstance();
    }
}
