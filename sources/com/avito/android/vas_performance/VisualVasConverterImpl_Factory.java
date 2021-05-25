package com.avito.android.vas_performance;

import dagger.internal.Factory;
public final class VisualVasConverterImpl_Factory implements Factory<VisualVasConverterImpl> {

    public static final class a {
        public static final VisualVasConverterImpl_Factory a = new VisualVasConverterImpl_Factory();
    }

    public static VisualVasConverterImpl_Factory create() {
        return a.a;
    }

    public static VisualVasConverterImpl newInstance() {
        return new VisualVasConverterImpl();
    }

    @Override // javax.inject.Provider
    public VisualVasConverterImpl get() {
        return newInstance();
    }
}
