package com.avito.android.messenger.conversation.adapter;

import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class IncomingMessagePresenter_Impl_Factory implements Factory<IncomingMessagePresenter.Impl> {
    public final Provider<MessageClickListener> a;
    public final Provider<MessageAvatarClickListener> b;

    public IncomingMessagePresenter_Impl_Factory(Provider<MessageClickListener> provider, Provider<MessageAvatarClickListener> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static IncomingMessagePresenter_Impl_Factory create(Provider<MessageClickListener> provider, Provider<MessageAvatarClickListener> provider2) {
        return new IncomingMessagePresenter_Impl_Factory(provider, provider2);
    }

    public static IncomingMessagePresenter.Impl newInstance(Lazy<MessageClickListener> lazy, Lazy<MessageAvatarClickListener> lazy2) {
        return new IncomingMessagePresenter.Impl(lazy, lazy2);
    }

    @Override // javax.inject.Provider
    public IncomingMessagePresenter.Impl get() {
        return newInstance(DoubleCheck.lazy(this.a), DoubleCheck.lazy(this.b));
    }
}
