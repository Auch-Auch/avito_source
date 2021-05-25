package com.avito.android.profile.sessions.adapter.session;

import com.avito.android.profile.sessions.adapter.action.SessionsItemAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class SessionItemPresenterImpl_Factory implements Factory<SessionItemPresenterImpl> {
    public final Provider<Consumer<SessionsItemAction>> a;

    public SessionItemPresenterImpl_Factory(Provider<Consumer<SessionsItemAction>> provider) {
        this.a = provider;
    }

    public static SessionItemPresenterImpl_Factory create(Provider<Consumer<SessionsItemAction>> provider) {
        return new SessionItemPresenterImpl_Factory(provider);
    }

    public static SessionItemPresenterImpl newInstance(Consumer<SessionsItemAction> consumer) {
        return new SessionItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public SessionItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
