package com.avito.android.blueprints.chips_multiselect;

import dagger.internal.Factory;
public final class ChipsMultiselectItemPresenterImpl_Factory implements Factory<ChipsMultiselectItemPresenterImpl> {

    public static final class a {
        public static final ChipsMultiselectItemPresenterImpl_Factory a = new ChipsMultiselectItemPresenterImpl_Factory();
    }

    public static ChipsMultiselectItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ChipsMultiselectItemPresenterImpl newInstance() {
        return new ChipsMultiselectItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ChipsMultiselectItemPresenterImpl get() {
        return newInstance();
    }
}
