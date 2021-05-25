package com.avito.android.di.module;

import com.avito.android.remote.parse.adapter.stream_gson.TypedResultTypeAdapterFactory;
import com.avito.android.util.CustomTypedResultEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class CoreOptimalJsonModule_ProvideTypedResultTypeAdapterFactoryFactory implements Factory<TypedResultTypeAdapterFactory> {
    public final Provider<Set<CustomTypedResultEntry>> a;

    public CoreOptimalJsonModule_ProvideTypedResultTypeAdapterFactoryFactory(Provider<Set<CustomTypedResultEntry>> provider) {
        this.a = provider;
    }

    public static CoreOptimalJsonModule_ProvideTypedResultTypeAdapterFactoryFactory create(Provider<Set<CustomTypedResultEntry>> provider) {
        return new CoreOptimalJsonModule_ProvideTypedResultTypeAdapterFactoryFactory(provider);
    }

    public static TypedResultTypeAdapterFactory provideTypedResultTypeAdapterFactory(Set<CustomTypedResultEntry> set) {
        return (TypedResultTypeAdapterFactory) Preconditions.checkNotNullFromProvides(CoreOptimalJsonModule.provideTypedResultTypeAdapterFactory(set));
    }

    @Override // javax.inject.Provider
    public TypedResultTypeAdapterFactory get() {
        return provideTypedResultTypeAdapterFactory(this.a.get());
    }
}
