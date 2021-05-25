package com.avito.android.advert.item.groups;

import dagger.internal.Factory;
public final class AdvertDetailsGroupsPresenterImpl_Factory implements Factory<AdvertDetailsGroupsPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsGroupsPresenterImpl_Factory a = new AdvertDetailsGroupsPresenterImpl_Factory();
    }

    public static AdvertDetailsGroupsPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsGroupsPresenterImpl newInstance() {
        return new AdvertDetailsGroupsPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsGroupsPresenterImpl get() {
        return newInstance();
    }
}
