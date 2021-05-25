package com.avito.android.publish.start_publish;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StartPublishResourceProviderImpl_Factory implements Factory<StartPublishResourceProviderImpl> {
    public final Provider<Resources> a;

    public StartPublishResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static StartPublishResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new StartPublishResourceProviderImpl_Factory(provider);
    }

    public static StartPublishResourceProviderImpl newInstance(Resources resources) {
        return new StartPublishResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public StartPublishResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
