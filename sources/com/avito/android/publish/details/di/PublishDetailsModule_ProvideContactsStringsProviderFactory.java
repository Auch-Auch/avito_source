package com.avito.android.publish.details.di;

import android.content.res.Resources;
import com.avito.android.publish.slots.profile_info.PublishContactsStringProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideContactsStringsProviderFactory implements Factory<PublishContactsStringProvider> {
    public final PublishDetailsModule a;
    public final Provider<Resources> b;

    public PublishDetailsModule_ProvideContactsStringsProviderFactory(PublishDetailsModule publishDetailsModule, Provider<Resources> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideContactsStringsProviderFactory create(PublishDetailsModule publishDetailsModule, Provider<Resources> provider) {
        return new PublishDetailsModule_ProvideContactsStringsProviderFactory(publishDetailsModule, provider);
    }

    public static PublishContactsStringProvider provideContactsStringsProvider(PublishDetailsModule publishDetailsModule, Resources resources) {
        return (PublishContactsStringProvider) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideContactsStringsProvider(resources));
    }

    @Override // javax.inject.Provider
    public PublishContactsStringProvider get() {
        return provideContactsStringsProvider(this.a, this.b.get());
    }
}
