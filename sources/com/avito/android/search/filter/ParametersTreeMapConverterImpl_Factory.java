package com.avito.android.search.filter;

import dagger.internal.Factory;
public final class ParametersTreeMapConverterImpl_Factory implements Factory<ParametersTreeMapConverterImpl> {

    public static final class a {
        public static final ParametersTreeMapConverterImpl_Factory a = new ParametersTreeMapConverterImpl_Factory();
    }

    public static ParametersTreeMapConverterImpl_Factory create() {
        return a.a;
    }

    public static ParametersTreeMapConverterImpl newInstance() {
        return new ParametersTreeMapConverterImpl();
    }

    @Override // javax.inject.Provider
    public ParametersTreeMapConverterImpl get() {
        return newInstance();
    }
}
