package com.avito.android.user_subscribers.adapter.subscriber;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SubscriberItemBlueprint_Factory implements Factory<SubscriberItemBlueprint> {
    public final Provider<SubscriberItemPresenter> a;

    public SubscriberItemBlueprint_Factory(Provider<SubscriberItemPresenter> provider) {
        this.a = provider;
    }

    public static SubscriberItemBlueprint_Factory create(Provider<SubscriberItemPresenter> provider) {
        return new SubscriberItemBlueprint_Factory(provider);
    }

    public static SubscriberItemBlueprint newInstance(SubscriberItemPresenter subscriberItemPresenter) {
        return new SubscriberItemBlueprint(subscriberItemPresenter);
    }

    @Override // javax.inject.Provider
    public SubscriberItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
