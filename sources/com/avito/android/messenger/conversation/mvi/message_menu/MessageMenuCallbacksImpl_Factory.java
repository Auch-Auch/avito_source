package com.avito.android.messenger.conversation.mvi.message_menu;

import android.app.Application;
import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessageMenuCallbacksImpl_Factory implements Factory<MessageMenuCallbacksImpl> {
    public final Provider<Resources> a;
    public final Provider<Application> b;

    public MessageMenuCallbacksImpl_Factory(Provider<Resources> provider, Provider<Application> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MessageMenuCallbacksImpl_Factory create(Provider<Resources> provider, Provider<Application> provider2) {
        return new MessageMenuCallbacksImpl_Factory(provider, provider2);
    }

    public static MessageMenuCallbacksImpl newInstance(Resources resources, Application application) {
        return new MessageMenuCallbacksImpl(resources, application);
    }

    @Override // javax.inject.Provider
    public MessageMenuCallbacksImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
