package com.avito.android.recycler.data_aware;

import dagger.internal.Factory;
public final class SimpleEqualityComparator_Factory implements Factory<SimpleEqualityComparator> {

    public static final class a {
        public static final SimpleEqualityComparator_Factory a = new SimpleEqualityComparator_Factory();
    }

    public static SimpleEqualityComparator_Factory create() {
        return a.a;
    }

    public static SimpleEqualityComparator newInstance() {
        return new SimpleEqualityComparator();
    }

    @Override // javax.inject.Provider
    public SimpleEqualityComparator get() {
        return newInstance();
    }
}
