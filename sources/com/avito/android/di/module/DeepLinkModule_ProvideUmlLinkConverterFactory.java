package com.avito.android.di.module;

import com.avito.android.deep_linking.links.UTMLinkConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class DeepLinkModule_ProvideUmlLinkConverterFactory implements Factory<UTMLinkConverter> {
    public final DeepLinkModule a;

    public DeepLinkModule_ProvideUmlLinkConverterFactory(DeepLinkModule deepLinkModule) {
        this.a = deepLinkModule;
    }

    public static DeepLinkModule_ProvideUmlLinkConverterFactory create(DeepLinkModule deepLinkModule) {
        return new DeepLinkModule_ProvideUmlLinkConverterFactory(deepLinkModule);
    }

    public static UTMLinkConverter provideUmlLinkConverter(DeepLinkModule deepLinkModule) {
        return (UTMLinkConverter) Preconditions.checkNotNullFromProvides(deepLinkModule.provideUmlLinkConverter());
    }

    @Override // javax.inject.Provider
    public UTMLinkConverter get() {
        return provideUmlLinkConverter(this.a);
    }
}
