package com.avito.android.search.filter;

import dagger.internal.Factory;
public final class ParametersTreeSearchParamsConverterImpl_Factory implements Factory<ParametersTreeSearchParamsConverterImpl> {

    public static final class a {
        public static final ParametersTreeSearchParamsConverterImpl_Factory a = new ParametersTreeSearchParamsConverterImpl_Factory();
    }

    public static ParametersTreeSearchParamsConverterImpl_Factory create() {
        return a.a;
    }

    public static ParametersTreeSearchParamsConverterImpl newInstance() {
        return new ParametersTreeSearchParamsConverterImpl();
    }

    @Override // javax.inject.Provider
    public ParametersTreeSearchParamsConverterImpl get() {
        return newInstance();
    }
}
