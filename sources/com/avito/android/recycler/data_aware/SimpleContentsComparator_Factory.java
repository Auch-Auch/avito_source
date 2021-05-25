package com.avito.android.recycler.data_aware;

import dagger.internal.Factory;
public final class SimpleContentsComparator_Factory implements Factory<SimpleContentsComparator> {

    public static final class a {
        public static final SimpleContentsComparator_Factory a = new SimpleContentsComparator_Factory();
    }

    public static SimpleContentsComparator_Factory create() {
        return a.a;
    }

    public static SimpleContentsComparator newInstance() {
        return new SimpleContentsComparator();
    }

    @Override // javax.inject.Provider
    public SimpleContentsComparator get() {
        return newInstance();
    }
}
