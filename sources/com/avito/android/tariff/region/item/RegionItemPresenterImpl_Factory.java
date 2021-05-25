package com.avito.android.tariff.region.item;

import dagger.internal.Factory;
public final class RegionItemPresenterImpl_Factory implements Factory<RegionItemPresenterImpl> {

    public static final class a {
        public static final RegionItemPresenterImpl_Factory a = new RegionItemPresenterImpl_Factory();
    }

    public static RegionItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static RegionItemPresenterImpl newInstance() {
        return new RegionItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public RegionItemPresenterImpl get() {
        return newInstance();
    }
}
