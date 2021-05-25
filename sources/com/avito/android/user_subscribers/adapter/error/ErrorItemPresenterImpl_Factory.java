package com.avito.android.user_subscribers.adapter.error;

import com.avito.android.user_subscribers.action.SubscriberAction;
import dagger.internal.Factory;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class ErrorItemPresenterImpl_Factory implements Factory<ErrorItemPresenterImpl> {
    public final Provider<Consumer<SubscriberAction>> a;

    public ErrorItemPresenterImpl_Factory(Provider<Consumer<SubscriberAction>> provider) {
        this.a = provider;
    }

    public static ErrorItemPresenterImpl_Factory create(Provider<Consumer<SubscriberAction>> provider) {
        return new ErrorItemPresenterImpl_Factory(provider);
    }

    public static ErrorItemPresenterImpl newInstance(Consumer<SubscriberAction> consumer) {
        return new ErrorItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public ErrorItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
