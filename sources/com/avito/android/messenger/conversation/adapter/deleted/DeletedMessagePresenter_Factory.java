package com.avito.android.messenger.conversation.adapter.deleted;

import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeletedMessagePresenter_Factory implements Factory<DeletedMessagePresenter> {
    public final Provider<IncomingMessagePresenter> a;
    public final Provider<OutgoingMessagePresenter> b;

    public DeletedMessagePresenter_Factory(Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DeletedMessagePresenter_Factory create(Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2) {
        return new DeletedMessagePresenter_Factory(provider, provider2);
    }

    public static DeletedMessagePresenter newInstance(IncomingMessagePresenter incomingMessagePresenter, OutgoingMessagePresenter outgoingMessagePresenter) {
        return new DeletedMessagePresenter(incomingMessagePresenter, outgoingMessagePresenter);
    }

    @Override // javax.inject.Provider
    public DeletedMessagePresenter get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
