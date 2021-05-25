package com.avito.android.advert_stats.item.hint;

import dagger.internal.Factory;
public final class HintItemPresenterImpl_Factory implements Factory<HintItemPresenterImpl> {

    public static final class a {
        public static final HintItemPresenterImpl_Factory a = new HintItemPresenterImpl_Factory();
    }

    public static HintItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static HintItemPresenterImpl newInstance() {
        return new HintItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public HintItemPresenterImpl get() {
        return newInstance();
    }
}
