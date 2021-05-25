package com.avito.android.vas_performance.ui.items.info_action;

import dagger.internal.Factory;
public final class InfoActionItemPresenterImpl_Factory implements Factory<InfoActionItemPresenterImpl> {

    public static final class a {
        public static final InfoActionItemPresenterImpl_Factory a = new InfoActionItemPresenterImpl_Factory();
    }

    public static InfoActionItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static InfoActionItemPresenterImpl newInstance() {
        return new InfoActionItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public InfoActionItemPresenterImpl get() {
        return newInstance();
    }
}
