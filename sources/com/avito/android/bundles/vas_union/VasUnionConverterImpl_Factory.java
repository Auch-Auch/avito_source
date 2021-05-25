package com.avito.android.bundles.vas_union;

import dagger.internal.Factory;
public final class VasUnionConverterImpl_Factory implements Factory<VasUnionConverterImpl> {

    public static final class a {
        public static final VasUnionConverterImpl_Factory a = new VasUnionConverterImpl_Factory();
    }

    public static VasUnionConverterImpl_Factory create() {
        return a.a;
    }

    public static VasUnionConverterImpl newInstance() {
        return new VasUnionConverterImpl();
    }

    @Override // javax.inject.Provider
    public VasUnionConverterImpl get() {
        return newInstance();
    }
}
