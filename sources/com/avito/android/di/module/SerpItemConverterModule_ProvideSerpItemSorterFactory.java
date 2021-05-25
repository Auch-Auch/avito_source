package com.avito.android.di.module;

import com.avito.android.serp.adapter.item_sorter.SerpItemSorter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpItemConverterModule_ProvideSerpItemSorterFactory implements Factory<SerpItemSorter> {

    public static final class a {
        public static final SerpItemConverterModule_ProvideSerpItemSorterFactory a = new SerpItemConverterModule_ProvideSerpItemSorterFactory();
    }

    public static SerpItemConverterModule_ProvideSerpItemSorterFactory create() {
        return a.a;
    }

    public static SerpItemSorter provideSerpItemSorter() {
        return (SerpItemSorter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideSerpItemSorter());
    }

    @Override // javax.inject.Provider
    public SerpItemSorter get() {
        return provideSerpItemSorter();
    }
}
