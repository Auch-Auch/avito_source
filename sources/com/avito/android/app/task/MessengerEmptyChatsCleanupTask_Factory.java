package com.avito.android.app.task;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessengerEmptyChatsCleanupTask_Factory implements Factory<MessengerEmptyChatsCleanupTask> {
    public final Provider<EmptyChatsCleaner> a;

    public MessengerEmptyChatsCleanupTask_Factory(Provider<EmptyChatsCleaner> provider) {
        this.a = provider;
    }

    public static MessengerEmptyChatsCleanupTask_Factory create(Provider<EmptyChatsCleaner> provider) {
        return new MessengerEmptyChatsCleanupTask_Factory(provider);
    }

    public static MessengerEmptyChatsCleanupTask newInstance(Lazy<EmptyChatsCleaner> lazy) {
        return new MessengerEmptyChatsCleanupTask(lazy);
    }

    @Override // javax.inject.Provider
    public MessengerEmptyChatsCleanupTask get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
