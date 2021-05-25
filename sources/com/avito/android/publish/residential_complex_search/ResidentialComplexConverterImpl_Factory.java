package com.avito.android.publish.residential_complex_search;

import dagger.internal.Factory;
public final class ResidentialComplexConverterImpl_Factory implements Factory<ResidentialComplexConverterImpl> {

    public static final class a {
        public static final ResidentialComplexConverterImpl_Factory a = new ResidentialComplexConverterImpl_Factory();
    }

    public static ResidentialComplexConverterImpl_Factory create() {
        return a.a;
    }

    public static ResidentialComplexConverterImpl newInstance() {
        return new ResidentialComplexConverterImpl();
    }

    @Override // javax.inject.Provider
    public ResidentialComplexConverterImpl get() {
        return newInstance();
    }
}
