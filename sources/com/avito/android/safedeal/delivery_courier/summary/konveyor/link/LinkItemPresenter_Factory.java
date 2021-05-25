package com.avito.android.safedeal.delivery_courier.summary.konveyor.link;

import dagger.internal.Factory;
public final class LinkItemPresenter_Factory implements Factory<LinkItemPresenter> {

    public static final class a {
        public static final LinkItemPresenter_Factory a = new LinkItemPresenter_Factory();
    }

    public static LinkItemPresenter_Factory create() {
        return a.a;
    }

    public static LinkItemPresenter newInstance() {
        return new LinkItemPresenter();
    }

    @Override // javax.inject.Provider
    public LinkItemPresenter get() {
        return newInstance();
    }
}
