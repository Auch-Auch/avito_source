package com.avito.android.tariff.edit_info.item.tabs;

import dagger.internal.Factory;
public final class TabsItemPresenterImpl_Factory implements Factory<TabsItemPresenterImpl> {

    public static final class a {
        public static final TabsItemPresenterImpl_Factory a = new TabsItemPresenterImpl_Factory();
    }

    public static TabsItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static TabsItemPresenterImpl newInstance() {
        return new TabsItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public TabsItemPresenterImpl get() {
        return newInstance();
    }
}
