package com.avito.android.di.module;

import com.avito.android.util.OptimalTypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class CoreOptimalJsonModule_ProvideUserAdvertStatusTypeAdapterFactory implements Factory<Set<OptimalTypeAdapterEntry>> {

    public static final class a {
        public static final CoreOptimalJsonModule_ProvideUserAdvertStatusTypeAdapterFactory a = new CoreOptimalJsonModule_ProvideUserAdvertStatusTypeAdapterFactory();
    }

    public static CoreOptimalJsonModule_ProvideUserAdvertStatusTypeAdapterFactory create() {
        return a.a;
    }

    public static Set<OptimalTypeAdapterEntry> provideUserAdvertStatusTypeAdapter() {
        return (Set) Preconditions.checkNotNullFromProvides(CoreOptimalJsonModule.INSTANCE.provideUserAdvertStatusTypeAdapter());
    }

    @Override // javax.inject.Provider
    public Set<OptimalTypeAdapterEntry> get() {
        return provideUserAdvertStatusTypeAdapter();
    }
}
