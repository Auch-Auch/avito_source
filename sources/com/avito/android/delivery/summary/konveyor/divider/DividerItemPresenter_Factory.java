package com.avito.android.delivery.summary.konveyor.divider;

import dagger.internal.Factory;
public final class DividerItemPresenter_Factory implements Factory<DividerItemPresenter> {

    public static final class a {
        public static final DividerItemPresenter_Factory a = new DividerItemPresenter_Factory();
    }

    public static DividerItemPresenter_Factory create() {
        return a.a;
    }

    public static DividerItemPresenter newInstance() {
        return new DividerItemPresenter();
    }

    @Override // javax.inject.Provider
    public DividerItemPresenter get() {
        return newInstance();
    }
}
