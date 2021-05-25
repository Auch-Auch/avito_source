package com.avito.android.abuse.details.adapter;

import dagger.internal.Factory;
public final class ErrorLabelItemPresenterImpl_Factory implements Factory<ErrorLabelItemPresenterImpl> {

    public static final class a {
        public static final ErrorLabelItemPresenterImpl_Factory a = new ErrorLabelItemPresenterImpl_Factory();
    }

    public static ErrorLabelItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ErrorLabelItemPresenterImpl newInstance() {
        return new ErrorLabelItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ErrorLabelItemPresenterImpl get() {
        return newInstance();
    }
}
