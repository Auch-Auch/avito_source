package com.avito.android.messenger.conversation.mvi.platform_actions.sample;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SamplePlatformActionsStateProducerFactory_Factory implements Factory<SamplePlatformActionsStateProducerFactory> {
    public final Provider<SamplePlatformActionsStateProducer> a;

    public SamplePlatformActionsStateProducerFactory_Factory(Provider<SamplePlatformActionsStateProducer> provider) {
        this.a = provider;
    }

    public static SamplePlatformActionsStateProducerFactory_Factory create(Provider<SamplePlatformActionsStateProducer> provider) {
        return new SamplePlatformActionsStateProducerFactory_Factory(provider);
    }

    public static SamplePlatformActionsStateProducerFactory newInstance(Provider<SamplePlatformActionsStateProducer> provider) {
        return new SamplePlatformActionsStateProducerFactory(provider);
    }

    @Override // javax.inject.Provider
    public SamplePlatformActionsStateProducerFactory get() {
        return newInstance(this.a);
    }
}
