package com.avito.android.serp;

import dagger.internal.Factory;
public final class InlineFiltersParametersKeyWrapper_Factory implements Factory<InlineFiltersParametersKeyWrapper> {

    public static final class a {
        public static final InlineFiltersParametersKeyWrapper_Factory a = new InlineFiltersParametersKeyWrapper_Factory();
    }

    public static InlineFiltersParametersKeyWrapper_Factory create() {
        return a.a;
    }

    public static InlineFiltersParametersKeyWrapper newInstance() {
        return new InlineFiltersParametersKeyWrapper();
    }

    @Override // javax.inject.Provider
    public InlineFiltersParametersKeyWrapper get() {
        return newInstance();
    }
}
