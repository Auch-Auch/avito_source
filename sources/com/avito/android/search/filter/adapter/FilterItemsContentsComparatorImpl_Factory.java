package com.avito.android.search.filter.adapter;

import dagger.internal.Factory;
public final class FilterItemsContentsComparatorImpl_Factory implements Factory<FilterItemsContentsComparatorImpl> {

    public static final class a {
        public static final FilterItemsContentsComparatorImpl_Factory a = new FilterItemsContentsComparatorImpl_Factory();
    }

    public static FilterItemsContentsComparatorImpl_Factory create() {
        return a.a;
    }

    public static FilterItemsContentsComparatorImpl newInstance() {
        return new FilterItemsContentsComparatorImpl();
    }

    @Override // javax.inject.Provider
    public FilterItemsContentsComparatorImpl get() {
        return newInstance();
    }
}
