package com.avito.android.conveyor_shared_item.single_text;

import dagger.internal.Factory;
public final class SingleTextPresenterImpl_Factory implements Factory<SingleTextPresenterImpl> {

    public static final class a {
        public static final SingleTextPresenterImpl_Factory a = new SingleTextPresenterImpl_Factory();
    }

    public static SingleTextPresenterImpl_Factory create() {
        return a.a;
    }

    public static SingleTextPresenterImpl newInstance() {
        return new SingleTextPresenterImpl();
    }

    @Override // javax.inject.Provider
    public SingleTextPresenterImpl get() {
        return newInstance();
    }
}
