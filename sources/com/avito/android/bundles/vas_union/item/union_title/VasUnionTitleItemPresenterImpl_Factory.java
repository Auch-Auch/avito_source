package com.avito.android.bundles.vas_union.item.union_title;

import dagger.internal.Factory;
public final class VasUnionTitleItemPresenterImpl_Factory implements Factory<VasUnionTitleItemPresenterImpl> {

    public static final class a {
        public static final VasUnionTitleItemPresenterImpl_Factory a = new VasUnionTitleItemPresenterImpl_Factory();
    }

    public static VasUnionTitleItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static VasUnionTitleItemPresenterImpl newInstance() {
        return new VasUnionTitleItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public VasUnionTitleItemPresenterImpl get() {
        return newInstance();
    }
}
