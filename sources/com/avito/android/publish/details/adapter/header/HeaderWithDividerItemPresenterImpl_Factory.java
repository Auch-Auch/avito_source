package com.avito.android.publish.details.adapter.header;

import dagger.internal.Factory;
public final class HeaderWithDividerItemPresenterImpl_Factory implements Factory<HeaderWithDividerItemPresenterImpl> {

    public static final class a {
        public static final HeaderWithDividerItemPresenterImpl_Factory a = new HeaderWithDividerItemPresenterImpl_Factory();
    }

    public static HeaderWithDividerItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static HeaderWithDividerItemPresenterImpl newInstance() {
        return new HeaderWithDividerItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public HeaderWithDividerItemPresenterImpl get() {
        return newInstance();
    }
}
