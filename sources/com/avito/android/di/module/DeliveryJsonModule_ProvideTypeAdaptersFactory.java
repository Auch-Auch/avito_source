package com.avito.android.di.module;

import com.avito.android.util.TypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class DeliveryJsonModule_ProvideTypeAdaptersFactory implements Factory<Set<TypeAdapterEntry>> {

    public static final class a {
        public static final DeliveryJsonModule_ProvideTypeAdaptersFactory a = new DeliveryJsonModule_ProvideTypeAdaptersFactory();
    }

    public static DeliveryJsonModule_ProvideTypeAdaptersFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterEntry> provideTypeAdapters() {
        return (Set) Preconditions.checkNotNullFromProvides(DeliveryJsonModule.provideTypeAdapters());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterEntry> get() {
        return provideTypeAdapters();
    }
}
