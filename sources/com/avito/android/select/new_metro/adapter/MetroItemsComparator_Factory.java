package com.avito.android.select.new_metro.adapter;

import dagger.internal.Factory;
public final class MetroItemsComparator_Factory implements Factory<MetroItemsComparator> {

    public static final class a {
        public static final MetroItemsComparator_Factory a = new MetroItemsComparator_Factory();
    }

    public static MetroItemsComparator_Factory create() {
        return a.a;
    }

    public static MetroItemsComparator newInstance() {
        return new MetroItemsComparator();
    }

    @Override // javax.inject.Provider
    public MetroItemsComparator get() {
        return newInstance();
    }
}
