package com.avito.android.user_subscribers.adapter.subscriber;

import com.avito.android.user_subscribers.action.SubscriberAction;
import dagger.internal.Factory;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class SubscriberItemPresenterImpl_Factory implements Factory<SubscriberItemPresenterImpl> {
    public final Provider<Consumer<SubscriberAction>> a;

    public SubscriberItemPresenterImpl_Factory(Provider<Consumer<SubscriberAction>> provider) {
        this.a = provider;
    }

    public static SubscriberItemPresenterImpl_Factory create(Provider<Consumer<SubscriberAction>> provider) {
        return new SubscriberItemPresenterImpl_Factory(provider);
    }

    public static SubscriberItemPresenterImpl newInstance(Consumer<SubscriberAction> consumer) {
        return new SubscriberItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public SubscriberItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
