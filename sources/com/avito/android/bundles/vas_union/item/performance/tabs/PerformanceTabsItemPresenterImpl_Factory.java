package com.avito.android.bundles.vas_union.item.performance.tabs;

import dagger.internal.Factory;
public final class PerformanceTabsItemPresenterImpl_Factory implements Factory<PerformanceTabsItemPresenterImpl> {

    public static final class a {
        public static final PerformanceTabsItemPresenterImpl_Factory a = new PerformanceTabsItemPresenterImpl_Factory();
    }

    public static PerformanceTabsItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static PerformanceTabsItemPresenterImpl newInstance() {
        return new PerformanceTabsItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public PerformanceTabsItemPresenterImpl get() {
        return newInstance();
    }
}
