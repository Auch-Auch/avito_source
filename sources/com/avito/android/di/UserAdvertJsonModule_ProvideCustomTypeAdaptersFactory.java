package com.avito.android.di;

import com.avito.android.util.CustomTypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class UserAdvertJsonModule_ProvideCustomTypeAdaptersFactory implements Factory<Set<CustomTypeAdapterEntry>> {

    public static final class a {
        public static final UserAdvertJsonModule_ProvideCustomTypeAdaptersFactory a = new UserAdvertJsonModule_ProvideCustomTypeAdaptersFactory();
    }

    public static UserAdvertJsonModule_ProvideCustomTypeAdaptersFactory create() {
        return a.a;
    }

    public static Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return (Set) Preconditions.checkNotNullFromProvides(UserAdvertJsonModule.provideCustomTypeAdapters());
    }

    @Override // javax.inject.Provider
    public Set<CustomTypeAdapterEntry> get() {
        return provideCustomTypeAdapters();
    }
}
