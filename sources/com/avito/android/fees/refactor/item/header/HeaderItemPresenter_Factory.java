package com.avito.android.fees.refactor.item.header;

import dagger.internal.Factory;
public final class HeaderItemPresenter_Factory implements Factory<HeaderItemPresenter> {

    public static final class a {
        public static final HeaderItemPresenter_Factory a = new HeaderItemPresenter_Factory();
    }

    public static HeaderItemPresenter_Factory create() {
        return a.a;
    }

    public static HeaderItemPresenter newInstance() {
        return new HeaderItemPresenter();
    }

    @Override // javax.inject.Provider
    public HeaderItemPresenter get() {
        return newInstance();
    }
}
