package com.avito.android.blueprints.chips;

import dagger.internal.Factory;
public final class ChipsSelectItemPresenterImpl_Factory implements Factory<ChipsSelectItemPresenterImpl> {

    public static final class a {
        public static final ChipsSelectItemPresenterImpl_Factory a = new ChipsSelectItemPresenterImpl_Factory();
    }

    public static ChipsSelectItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ChipsSelectItemPresenterImpl newInstance() {
        return new ChipsSelectItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ChipsSelectItemPresenterImpl get() {
        return newInstance();
    }
}
