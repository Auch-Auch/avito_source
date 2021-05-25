package com.avito.android.advert.actions;

import dagger.internal.Factory;
public final class HiddenAdvertsStorageImpl_Factory implements Factory<HiddenAdvertsStorageImpl> {

    public static final class a {
        public static final HiddenAdvertsStorageImpl_Factory a = new HiddenAdvertsStorageImpl_Factory();
    }

    public static HiddenAdvertsStorageImpl_Factory create() {
        return a.a;
    }

    public static HiddenAdvertsStorageImpl newInstance() {
        return new HiddenAdvertsStorageImpl();
    }

    @Override // javax.inject.Provider
    public HiddenAdvertsStorageImpl get() {
        return newInstance();
    }
}
