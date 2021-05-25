package com.avito.android.messenger.conversation.mvi.platform_actions.sample;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SamplePlatformActionsStateProducerImpl_Factory implements Factory<SamplePlatformActionsStateProducerImpl> {
    public final Provider<SchedulersFactory> a;

    public SamplePlatformActionsStateProducerImpl_Factory(Provider<SchedulersFactory> provider) {
        this.a = provider;
    }

    public static SamplePlatformActionsStateProducerImpl_Factory create(Provider<SchedulersFactory> provider) {
        return new SamplePlatformActionsStateProducerImpl_Factory(provider);
    }

    public static SamplePlatformActionsStateProducerImpl newInstance(SchedulersFactory schedulersFactory) {
        return new SamplePlatformActionsStateProducerImpl(schedulersFactory);
    }

    @Override // javax.inject.Provider
    public SamplePlatformActionsStateProducerImpl get() {
        return newInstance(this.a.get());
    }
}
