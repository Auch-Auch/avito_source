package com.avito.android.messenger.conversation.adapter;

import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OutgoingMessagePresenter_Impl_Factory implements Factory<OutgoingMessagePresenter.Impl> {
    public final Provider<MessageClickListener> a;

    public OutgoingMessagePresenter_Impl_Factory(Provider<MessageClickListener> provider) {
        this.a = provider;
    }

    public static OutgoingMessagePresenter_Impl_Factory create(Provider<MessageClickListener> provider) {
        return new OutgoingMessagePresenter_Impl_Factory(provider);
    }

    public static OutgoingMessagePresenter.Impl newInstance(Lazy<MessageClickListener> lazy) {
        return new OutgoingMessagePresenter.Impl(lazy);
    }

    @Override // javax.inject.Provider
    public OutgoingMessagePresenter.Impl get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
