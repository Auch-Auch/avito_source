package com.avito.android.publish.details.analytics;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class FlowTrackerFactoryImpl_Factory implements Factory<FlowTrackerFactoryImpl> {
    public final Provider<PublishDetailsTracker> a;

    public FlowTrackerFactoryImpl_Factory(Provider<PublishDetailsTracker> provider) {
        this.a = provider;
    }

    public static FlowTrackerFactoryImpl_Factory create(Provider<PublishDetailsTracker> provider) {
        return new FlowTrackerFactoryImpl_Factory(provider);
    }

    public static FlowTrackerFactoryImpl newInstance(PublishDetailsTracker publishDetailsTracker) {
        return new FlowTrackerFactoryImpl(publishDetailsTracker);
    }

    @Override // javax.inject.Provider
    public FlowTrackerFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
