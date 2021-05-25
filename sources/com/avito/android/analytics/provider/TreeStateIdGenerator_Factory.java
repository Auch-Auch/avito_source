package com.avito.android.analytics.provider;

import dagger.internal.Factory;
public final class TreeStateIdGenerator_Factory implements Factory<TreeStateIdGenerator> {

    public static final class a {
        public static final TreeStateIdGenerator_Factory a = new TreeStateIdGenerator_Factory();
    }

    public static TreeStateIdGenerator_Factory create() {
        return a.a;
    }

    public static TreeStateIdGenerator newInstance() {
        return new TreeStateIdGenerator();
    }

    @Override // javax.inject.Provider
    public TreeStateIdGenerator get() {
        return newInstance();
    }
}
