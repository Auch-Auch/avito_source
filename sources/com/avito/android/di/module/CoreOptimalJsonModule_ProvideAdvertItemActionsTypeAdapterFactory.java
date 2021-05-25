package com.avito.android.di.module;

import com.avito.android.util.OptimalTypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class CoreOptimalJsonModule_ProvideAdvertItemActionsTypeAdapterFactory implements Factory<Set<OptimalTypeAdapterEntry>> {

    public static final class a {
        public static final CoreOptimalJsonModule_ProvideAdvertItemActionsTypeAdapterFactory a = new CoreOptimalJsonModule_ProvideAdvertItemActionsTypeAdapterFactory();
    }

    public static CoreOptimalJsonModule_ProvideAdvertItemActionsTypeAdapterFactory create() {
        return a.a;
    }

    public static Set<OptimalTypeAdapterEntry> provideAdvertItemActionsTypeAdapter() {
        return (Set) Preconditions.checkNotNullFromProvides(CoreOptimalJsonModule.INSTANCE.provideAdvertItemActionsTypeAdapter());
    }

    @Override // javax.inject.Provider
    public Set<OptimalTypeAdapterEntry> get() {
        return provideAdvertItemActionsTypeAdapter();
    }
}
