package com.avito.android.di.module;

import com.avito.android.util.CustomTypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class FavoriteSellersJsonModule_ProvideCustomTypeAdaptersFactory implements Factory<Set<CustomTypeAdapterEntry>> {

    public static final class a {
        public static final FavoriteSellersJsonModule_ProvideCustomTypeAdaptersFactory a = new FavoriteSellersJsonModule_ProvideCustomTypeAdaptersFactory();
    }

    public static FavoriteSellersJsonModule_ProvideCustomTypeAdaptersFactory create() {
        return a.a;
    }

    public static Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return (Set) Preconditions.checkNotNullFromProvides(FavoriteSellersJsonModule.provideCustomTypeAdapters());
    }

    @Override // javax.inject.Provider
    public Set<CustomTypeAdapterEntry> get() {
        return provideCustomTypeAdapters();
    }
}
