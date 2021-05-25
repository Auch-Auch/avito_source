package com.avito.android.di.module;

import com.avito.android.util.CustomTypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class FavoritesJsonModule_ProvideCustomTypeAdapterFactory implements Factory<Set<CustomTypeAdapterEntry>> {

    public static final class a {
        public static final FavoritesJsonModule_ProvideCustomTypeAdapterFactory a = new FavoritesJsonModule_ProvideCustomTypeAdapterFactory();
    }

    public static FavoritesJsonModule_ProvideCustomTypeAdapterFactory create() {
        return a.a;
    }

    public static Set<CustomTypeAdapterEntry> provideCustomTypeAdapter() {
        return (Set) Preconditions.checkNotNullFromProvides(FavoritesJsonModule.provideCustomTypeAdapter());
    }

    @Override // javax.inject.Provider
    public Set<CustomTypeAdapterEntry> get() {
        return provideCustomTypeAdapter();
    }
}
