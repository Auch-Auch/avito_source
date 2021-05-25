package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.remote.parse.adapter.TypedResultDeserializer;
import com.avito.android.util.TypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class CoreJsonModule_ProvideCommonTypeAdaptersFactory implements Factory<Set<TypeAdapterEntry>> {
    public final Provider<DeepLinkFactory> a;
    public final Provider<Features> b;
    public final Provider<TypedResultDeserializer> c;

    public CoreJsonModule_ProvideCommonTypeAdaptersFactory(Provider<DeepLinkFactory> provider, Provider<Features> provider2, Provider<TypedResultDeserializer> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CoreJsonModule_ProvideCommonTypeAdaptersFactory create(Provider<DeepLinkFactory> provider, Provider<Features> provider2, Provider<TypedResultDeserializer> provider3) {
        return new CoreJsonModule_ProvideCommonTypeAdaptersFactory(provider, provider2, provider3);
    }

    public static Set<TypeAdapterEntry> provideCommonTypeAdapters(DeepLinkFactory deepLinkFactory, Features features, TypedResultDeserializer typedResultDeserializer) {
        return (Set) Preconditions.checkNotNullFromProvides(CoreJsonModule.provideCommonTypeAdapters(deepLinkFactory, features, typedResultDeserializer));
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterEntry> get() {
        return provideCommonTypeAdapters(this.a.get(), this.b.get(), this.c.get());
    }
}
