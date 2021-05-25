package com.avito.android.serp;

import dagger.internal.Factory;
public final class InlineFiltersChangesParamsConverterImpl_Factory implements Factory<InlineFiltersChangesParamsConverterImpl> {

    public static final class a {
        public static final InlineFiltersChangesParamsConverterImpl_Factory a = new InlineFiltersChangesParamsConverterImpl_Factory();
    }

    public static InlineFiltersChangesParamsConverterImpl_Factory create() {
        return a.a;
    }

    public static InlineFiltersChangesParamsConverterImpl newInstance() {
        return new InlineFiltersChangesParamsConverterImpl();
    }

    @Override // javax.inject.Provider
    public InlineFiltersChangesParamsConverterImpl get() {
        return newInstance();
    }
}
