package com.avito.android.publish_limits_info.history.tab.advert;

import dagger.internal.Factory;
public final class HistoryAdvertItemPresenterImpl_Factory implements Factory<HistoryAdvertItemPresenterImpl> {

    public static final class a {
        public static final HistoryAdvertItemPresenterImpl_Factory a = new HistoryAdvertItemPresenterImpl_Factory();
    }

    public static HistoryAdvertItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static HistoryAdvertItemPresenterImpl newInstance() {
        return new HistoryAdvertItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public HistoryAdvertItemPresenterImpl get() {
        return newInstance();
    }
}
