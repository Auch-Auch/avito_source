package com.avito.android.serp.adapter.adstub;

import dagger.internal.Factory;
public final class NotLoadAdStubPresenter_Factory implements Factory<NotLoadAdStubPresenter> {

    public static final class a {
        public static final NotLoadAdStubPresenter_Factory a = new NotLoadAdStubPresenter_Factory();
    }

    public static NotLoadAdStubPresenter_Factory create() {
        return a.a;
    }

    public static NotLoadAdStubPresenter newInstance() {
        return new NotLoadAdStubPresenter();
    }

    @Override // javax.inject.Provider
    public NotLoadAdStubPresenter get() {
        return newInstance();
    }
}
