package com.avito.android.di.module;

import com.avito.android.util.CustomTypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class DeliveryJsonModule_ProvideCustomTypeAdaptersFactory implements Factory<Set<CustomTypeAdapterEntry>> {

    public static final class a {
        public static final DeliveryJsonModule_ProvideCustomTypeAdaptersFactory a = new DeliveryJsonModule_ProvideCustomTypeAdaptersFactory();
    }

    public static DeliveryJsonModule_ProvideCustomTypeAdaptersFactory create() {
        return a.a;
    }

    public static Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return (Set) Preconditions.checkNotNullFromProvides(DeliveryJsonModule.provideCustomTypeAdapters());
    }

    @Override // javax.inject.Provider
    public Set<CustomTypeAdapterEntry> get() {
        return provideCustomTypeAdapters();
    }
}
