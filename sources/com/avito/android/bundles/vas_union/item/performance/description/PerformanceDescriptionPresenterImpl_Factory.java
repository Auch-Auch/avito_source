package com.avito.android.bundles.vas_union.item.performance.description;

import dagger.internal.Factory;
public final class PerformanceDescriptionPresenterImpl_Factory implements Factory<PerformanceDescriptionPresenterImpl> {

    public static final class a {
        public static final PerformanceDescriptionPresenterImpl_Factory a = new PerformanceDescriptionPresenterImpl_Factory();
    }

    public static PerformanceDescriptionPresenterImpl_Factory create() {
        return a.a;
    }

    public static PerformanceDescriptionPresenterImpl newInstance() {
        return new PerformanceDescriptionPresenterImpl();
    }

    @Override // javax.inject.Provider
    public PerformanceDescriptionPresenterImpl get() {
        return newInstance();
    }
}
