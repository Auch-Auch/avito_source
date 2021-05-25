package com.avito.android.publish.details.analytics;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublishDetailsFlowTrackerImpl_Factory implements Factory<PublishDetailsFlowTrackerImpl> {
    public final Provider<FlowTrackerFactory> a;

    public PublishDetailsFlowTrackerImpl_Factory(Provider<FlowTrackerFactory> provider) {
        this.a = provider;
    }

    public static PublishDetailsFlowTrackerImpl_Factory create(Provider<FlowTrackerFactory> provider) {
        return new PublishDetailsFlowTrackerImpl_Factory(provider);
    }

    public static PublishDetailsFlowTrackerImpl newInstance(FlowTrackerFactory flowTrackerFactory) {
        return new PublishDetailsFlowTrackerImpl(flowTrackerFactory);
    }

    @Override // javax.inject.Provider
    public PublishDetailsFlowTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
