package com.avito.android.util;

import dagger.internal.Factory;
public final class ClipDataFactoryImpl_Factory implements Factory<ClipDataFactoryImpl> {

    public static final class a {
        public static final ClipDataFactoryImpl_Factory a = new ClipDataFactoryImpl_Factory();
    }

    public static ClipDataFactoryImpl_Factory create() {
        return a.a;
    }

    public static ClipDataFactoryImpl newInstance() {
        return new ClipDataFactoryImpl();
    }

    @Override // javax.inject.Provider
    public ClipDataFactoryImpl get() {
        return newInstance();
    }
}
