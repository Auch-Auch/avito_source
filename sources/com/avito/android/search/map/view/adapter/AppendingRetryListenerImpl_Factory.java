package com.avito.android.search.map.view.adapter;

import dagger.internal.Factory;
public final class AppendingRetryListenerImpl_Factory implements Factory<AppendingRetryListenerImpl> {

    public static final class a {
        public static final AppendingRetryListenerImpl_Factory a = new AppendingRetryListenerImpl_Factory();
    }

    public static AppendingRetryListenerImpl_Factory create() {
        return a.a;
    }

    public static AppendingRetryListenerImpl newInstance() {
        return new AppendingRetryListenerImpl();
    }

    @Override // javax.inject.Provider
    public AppendingRetryListenerImpl get() {
        return newInstance();
    }
}
