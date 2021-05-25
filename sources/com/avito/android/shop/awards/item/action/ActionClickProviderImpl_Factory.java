package com.avito.android.shop.awards.item.action;

import dagger.internal.Factory;
public final class ActionClickProviderImpl_Factory implements Factory<ActionClickProviderImpl> {

    public static final class a {
        public static final ActionClickProviderImpl_Factory a = new ActionClickProviderImpl_Factory();
    }

    public static ActionClickProviderImpl_Factory create() {
        return a.a;
    }

    public static ActionClickProviderImpl newInstance() {
        return new ActionClickProviderImpl();
    }

    @Override // javax.inject.Provider
    public ActionClickProviderImpl get() {
        return newInstance();
    }
}
