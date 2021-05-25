package com.avito.android.orders.feature.list.adapter.loading;

import dagger.internal.Factory;
public final class LoadingItemPresenter_Factory implements Factory<LoadingItemPresenter> {

    public static final class a {
        public static final LoadingItemPresenter_Factory a = new LoadingItemPresenter_Factory();
    }

    public static LoadingItemPresenter_Factory create() {
        return a.a;
    }

    public static LoadingItemPresenter newInstance() {
        return new LoadingItemPresenter();
    }

    @Override // javax.inject.Provider
    public LoadingItemPresenter get() {
        return newInstance();
    }
}
