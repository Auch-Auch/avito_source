package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.util.OptimalTypeAdapterEntry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class CoreOptimalJsonModule_ProvideCommonTypeAdaptersFactory implements Factory<Set<OptimalTypeAdapterEntry>> {
    public final Provider<DeepLinkFactory> a;
    public final Provider<Features> b;

    public CoreOptimalJsonModule_ProvideCommonTypeAdaptersFactory(Provider<DeepLinkFactory> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CoreOptimalJsonModule_ProvideCommonTypeAdaptersFactory create(Provider<DeepLinkFactory> provider, Provider<Features> provider2) {
        return new CoreOptimalJsonModule_ProvideCommonTypeAdaptersFactory(provider, provider2);
    }

    public static Set<OptimalTypeAdapterEntry> provideCommonTypeAdapters(DeepLinkFactory deepLinkFactory, Features features) {
        return (Set) Preconditions.checkNotNullFromProvides(CoreOptimalJsonModule.provideCommonTypeAdapters(deepLinkFactory, features));
    }

    @Override // javax.inject.Provider
    public Set<OptimalTypeAdapterEntry> get() {
        return provideCommonTypeAdapters(this.a.get(), this.b.get());
    }
}
