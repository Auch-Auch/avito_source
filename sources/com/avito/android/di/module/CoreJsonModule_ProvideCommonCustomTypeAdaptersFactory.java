package com.avito.android.di.module;

import com.avito.android.util.CustomTypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class CoreJsonModule_ProvideCommonCustomTypeAdaptersFactory implements Factory<Set<CustomTypeAdapterEntry>> {

    public static final class a {
        public static final CoreJsonModule_ProvideCommonCustomTypeAdaptersFactory a = new CoreJsonModule_ProvideCommonCustomTypeAdaptersFactory();
    }

    public static CoreJsonModule_ProvideCommonCustomTypeAdaptersFactory create() {
        return a.a;
    }

    public static Set<CustomTypeAdapterEntry> provideCommonCustomTypeAdapters() {
        return (Set) Preconditions.checkNotNullFromProvides(CoreJsonModule.provideCommonCustomTypeAdapters());
    }

    @Override // javax.inject.Provider
    public Set<CustomTypeAdapterEntry> get() {
        return provideCommonCustomTypeAdapters();
    }
}
