package com.avito.android.di.module;

import com.avito.android.remote.parse.adapter.TypedResultDeserializer;
import com.avito.android.util.CustomTypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class CoreJsonModule_ProvideTypedResultDeserializerFactory implements Factory<TypedResultDeserializer> {
    public final Provider<Set<CustomTypeAdapterEntry>> a;

    public CoreJsonModule_ProvideTypedResultDeserializerFactory(Provider<Set<CustomTypeAdapterEntry>> provider) {
        this.a = provider;
    }

    public static CoreJsonModule_ProvideTypedResultDeserializerFactory create(Provider<Set<CustomTypeAdapterEntry>> provider) {
        return new CoreJsonModule_ProvideTypedResultDeserializerFactory(provider);
    }

    public static TypedResultDeserializer provideTypedResultDeserializer(Set<CustomTypeAdapterEntry> set) {
        return (TypedResultDeserializer) Preconditions.checkNotNullFromProvides(CoreJsonModule.provideTypedResultDeserializer(set));
    }

    @Override // javax.inject.Provider
    public TypedResultDeserializer get() {
        return provideTypedResultDeserializer(this.a.get());
    }
}
