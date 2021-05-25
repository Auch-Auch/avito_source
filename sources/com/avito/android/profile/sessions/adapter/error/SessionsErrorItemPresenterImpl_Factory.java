package com.avito.android.profile.sessions.adapter.error;

import com.avito.android.profile.sessions.adapter.action.SessionsItemAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class SessionsErrorItemPresenterImpl_Factory implements Factory<SessionsErrorItemPresenterImpl> {
    public final Provider<Consumer<SessionsItemAction>> a;

    public SessionsErrorItemPresenterImpl_Factory(Provider<Consumer<SessionsItemAction>> provider) {
        this.a = provider;
    }

    public static SessionsErrorItemPresenterImpl_Factory create(Provider<Consumer<SessionsItemAction>> provider) {
        return new SessionsErrorItemPresenterImpl_Factory(provider);
    }

    public static SessionsErrorItemPresenterImpl newInstance(Consumer<SessionsItemAction> consumer) {
        return new SessionsErrorItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public SessionsErrorItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
