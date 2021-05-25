package com.avito.android.messenger.conversation.adapter.deleted;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class IncomingDeletedMessageBlueprint_Factory implements Factory<IncomingDeletedMessageBlueprint> {
    public final Provider<DeletedMessagePresenter> a;

    public IncomingDeletedMessageBlueprint_Factory(Provider<DeletedMessagePresenter> provider) {
        this.a = provider;
    }

    public static IncomingDeletedMessageBlueprint_Factory create(Provider<DeletedMessagePresenter> provider) {
        return new IncomingDeletedMessageBlueprint_Factory(provider);
    }

    public static IncomingDeletedMessageBlueprint newInstance(DeletedMessagePresenter deletedMessagePresenter) {
        return new IncomingDeletedMessageBlueprint(deletedMessagePresenter);
    }

    @Override // javax.inject.Provider
    public IncomingDeletedMessageBlueprint get() {
        return newInstance(this.a.get());
    }
}
