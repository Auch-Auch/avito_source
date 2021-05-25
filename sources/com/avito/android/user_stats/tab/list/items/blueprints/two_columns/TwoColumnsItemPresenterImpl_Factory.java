package com.avito.android.user_stats.tab.list.items.blueprints.two_columns;

import dagger.internal.Factory;
public final class TwoColumnsItemPresenterImpl_Factory implements Factory<TwoColumnsItemPresenterImpl> {

    public static final class a {
        public static final TwoColumnsItemPresenterImpl_Factory a = new TwoColumnsItemPresenterImpl_Factory();
    }

    public static TwoColumnsItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static TwoColumnsItemPresenterImpl newInstance() {
        return new TwoColumnsItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public TwoColumnsItemPresenterImpl get() {
        return newInstance();
    }
}
