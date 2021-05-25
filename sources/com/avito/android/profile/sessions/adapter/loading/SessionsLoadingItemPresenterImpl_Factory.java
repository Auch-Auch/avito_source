package com.avito.android.profile.sessions.adapter.loading;

import com.avito.android.profile.sessions.adapter.action.SessionsItemAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class SessionsLoadingItemPresenterImpl_Factory implements Factory<SessionsLoadingItemPresenterImpl> {
    public final Provider<Consumer<SessionsItemAction>> a;

    public SessionsLoadingItemPresenterImpl_Factory(Provider<Consumer<SessionsItemAction>> provider) {
        this.a = provider;
    }

    public static SessionsLoadingItemPresenterImpl_Factory create(Provider<Consumer<SessionsItemAction>> provider) {
        return new SessionsLoadingItemPresenterImpl_Factory(provider);
    }

    public static SessionsLoadingItemPresenterImpl newInstance(Consumer<SessionsItemAction> consumer) {
        return new SessionsLoadingItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public SessionsLoadingItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
