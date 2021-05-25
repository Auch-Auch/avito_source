package com.avito.android.extended_profile.adapter.progress;

import dagger.internal.Factory;
public final class ProgressItemPresenterImpl_Factory implements Factory<ProgressItemPresenterImpl> {

    public static final class a {
        public static final ProgressItemPresenterImpl_Factory a = new ProgressItemPresenterImpl_Factory();
    }

    public static ProgressItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ProgressItemPresenterImpl newInstance() {
        return new ProgressItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ProgressItemPresenterImpl get() {
        return newInstance();
    }
}
