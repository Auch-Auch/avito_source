package com.avito.android.user_stats.tab.list.items.blueprints.header;

import dagger.internal.Factory;
public final class HeaderItemPresenterImpl_Factory implements Factory<HeaderItemPresenterImpl> {

    public static final class a {
        public static final HeaderItemPresenterImpl_Factory a = new HeaderItemPresenterImpl_Factory();
    }

    public static HeaderItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static HeaderItemPresenterImpl newInstance() {
        return new HeaderItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public HeaderItemPresenterImpl get() {
        return newInstance();
    }
}
