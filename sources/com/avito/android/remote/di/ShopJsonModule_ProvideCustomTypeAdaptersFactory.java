package com.avito.android.remote.di;

import com.avito.android.util.CustomTypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class ShopJsonModule_ProvideCustomTypeAdaptersFactory implements Factory<Set<CustomTypeAdapterEntry>> {

    public static final class a {
        public static final ShopJsonModule_ProvideCustomTypeAdaptersFactory a = new ShopJsonModule_ProvideCustomTypeAdaptersFactory();
    }

    public static ShopJsonModule_ProvideCustomTypeAdaptersFactory create() {
        return a.a;
    }

    public static Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return (Set) Preconditions.checkNotNullFromProvides(ShopJsonModule.provideCustomTypeAdapters());
    }

    @Override // javax.inject.Provider
    public Set<CustomTypeAdapterEntry> get() {
        return provideCustomTypeAdapters();
    }
}
