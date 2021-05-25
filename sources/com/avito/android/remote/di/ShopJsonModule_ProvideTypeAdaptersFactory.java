package com.avito.android.remote.di;

import com.avito.android.util.TypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class ShopJsonModule_ProvideTypeAdaptersFactory implements Factory<Set<TypeAdapterEntry>> {

    public static final class a {
        public static final ShopJsonModule_ProvideTypeAdaptersFactory a = new ShopJsonModule_ProvideTypeAdaptersFactory();
    }

    public static ShopJsonModule_ProvideTypeAdaptersFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterEntry> provideTypeAdapters() {
        return (Set) Preconditions.checkNotNullFromProvides(ShopJsonModule.provideTypeAdapters());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterEntry> get() {
        return provideTypeAdapters();
    }
}
