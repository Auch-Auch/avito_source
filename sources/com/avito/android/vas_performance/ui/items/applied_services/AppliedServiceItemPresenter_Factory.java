package com.avito.android.vas_performance.ui.items.applied_services;

import dagger.internal.Factory;
public final class AppliedServiceItemPresenter_Factory implements Factory<AppliedServiceItemPresenter> {

    public static final class a {
        public static final AppliedServiceItemPresenter_Factory a = new AppliedServiceItemPresenter_Factory();
    }

    public static AppliedServiceItemPresenter_Factory create() {
        return a.a;
    }

    public static AppliedServiceItemPresenter newInstance() {
        return new AppliedServiceItemPresenter();
    }

    @Override // javax.inject.Provider
    public AppliedServiceItemPresenter get() {
        return newInstance();
    }
}
