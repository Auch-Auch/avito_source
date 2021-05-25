package com.avito.android.di;

import com.avito.android.util.CustomTypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class VasJsonModule_ProvideCustomTypeAdaptersFactory implements Factory<Set<CustomTypeAdapterEntry>> {

    public static final class a {
        public static final VasJsonModule_ProvideCustomTypeAdaptersFactory a = new VasJsonModule_ProvideCustomTypeAdaptersFactory();
    }

    public static VasJsonModule_ProvideCustomTypeAdaptersFactory create() {
        return a.a;
    }

    public static Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return (Set) Preconditions.checkNotNullFromProvides(VasJsonModule.provideCustomTypeAdapters());
    }

    @Override // javax.inject.Provider
    public Set<CustomTypeAdapterEntry> get() {
        return provideCustomTypeAdapters();
    }
}
