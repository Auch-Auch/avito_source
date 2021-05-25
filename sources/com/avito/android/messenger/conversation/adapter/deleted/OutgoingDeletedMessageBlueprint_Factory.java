package com.avito.android.messenger.conversation.adapter.deleted;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class OutgoingDeletedMessageBlueprint_Factory implements Factory<OutgoingDeletedMessageBlueprint> {
    public final Provider<DeletedMessagePresenter> a;

    public OutgoingDeletedMessageBlueprint_Factory(Provider<DeletedMessagePresenter> provider) {
        this.a = provider;
    }

    public static OutgoingDeletedMessageBlueprint_Factory create(Provider<DeletedMessagePresenter> provider) {
        return new OutgoingDeletedMessageBlueprint_Factory(provider);
    }

    public static OutgoingDeletedMessageBlueprint newInstance(DeletedMessagePresenter deletedMessagePresenter) {
        return new OutgoingDeletedMessageBlueprint(deletedMessagePresenter);
    }

    @Override // javax.inject.Provider
    public OutgoingDeletedMessageBlueprint get() {
        return newInstance(this.a.get());
    }
}
