package com.avito.android.messenger.conversation.mvi.send;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessengerPhotoStorageImpl_Factory implements Factory<MessengerPhotoStorageImpl> {
    public final Provider<Context> a;

    public MessengerPhotoStorageImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static MessengerPhotoStorageImpl_Factory create(Provider<Context> provider) {
        return new MessengerPhotoStorageImpl_Factory(provider);
    }

    public static MessengerPhotoStorageImpl newInstance(Context context) {
        return new MessengerPhotoStorageImpl(context);
    }

    @Override // javax.inject.Provider
    public MessengerPhotoStorageImpl get() {
        return newInstance(this.a.get());
    }
}
