package com.avito.android.util;

import dagger.internal.Factory;
public final class DefaultRandomizationGenerator_Factory implements Factory<DefaultRandomizationGenerator> {

    public static final class a {
        public static final DefaultRandomizationGenerator_Factory a = new DefaultRandomizationGenerator_Factory();
    }

    public static DefaultRandomizationGenerator_Factory create() {
        return a.a;
    }

    public static DefaultRandomizationGenerator newInstance() {
        return new DefaultRandomizationGenerator();
    }

    @Override // javax.inject.Provider
    public DefaultRandomizationGenerator get() {
        return newInstance();
    }
}
