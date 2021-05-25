package com.avito.android.user_subscribers.adapter.loading;

import com.avito.android.user_subscribers.action.SubscriberAction;
import dagger.internal.Factory;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class LoadingItemPresenterImpl_Factory implements Factory<LoadingItemPresenterImpl> {
    public final Provider<Consumer<SubscriberAction>> a;

    public LoadingItemPresenterImpl_Factory(Provider<Consumer<SubscriberAction>> provider) {
        this.a = provider;
    }

    public static LoadingItemPresenterImpl_Factory create(Provider<Consumer<SubscriberAction>> provider) {
        return new LoadingItemPresenterImpl_Factory(provider);
    }

    public static LoadingItemPresenterImpl newInstance(Consumer<SubscriberAction> consumer) {
        return new LoadingItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public LoadingItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
