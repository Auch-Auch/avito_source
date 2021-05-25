package com.avito.android.vas_performance.ui.items.vas;

import dagger.internal.Factory;
public final class PerformanceVasItemPresenterImpl_Factory implements Factory<PerformanceVasItemPresenterImpl> {

    public static final class a {
        public static final PerformanceVasItemPresenterImpl_Factory a = new PerformanceVasItemPresenterImpl_Factory();
    }

    public static PerformanceVasItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static PerformanceVasItemPresenterImpl newInstance() {
        return new PerformanceVasItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public PerformanceVasItemPresenterImpl get() {
        return newInstance();
    }
}
