package com.avito.android.di.module;

import com.avito.android.util.CustomTypedResultEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class CoreOptimalJsonModule_CustomTypedResultEntrySetFactory implements Factory<Set<CustomTypedResultEntry>> {

    public static final class a {
        public static final CoreOptimalJsonModule_CustomTypedResultEntrySetFactory a = new CoreOptimalJsonModule_CustomTypedResultEntrySetFactory();
    }

    public static CoreOptimalJsonModule_CustomTypedResultEntrySetFactory create() {
        return a.a;
    }

    public static Set<CustomTypedResultEntry> customTypedResultEntrySet() {
        return (Set) Preconditions.checkNotNullFromProvides(CoreOptimalJsonModule.customTypedResultEntrySet());
    }

    @Override // javax.inject.Provider
    public Set<CustomTypedResultEntry> get() {
        return customTypedResultEntrySet();
    }
}
