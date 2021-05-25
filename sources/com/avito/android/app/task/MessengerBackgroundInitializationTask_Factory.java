package com.avito.android.app.task;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessengerBackgroundInitializationTask_Factory implements Factory<MessengerBackgroundInitializationTask> {
    public final Provider<MessengerEmptyChatsCleanupTask> a;
    public final Provider<MessengerPhotosCleanupTask> b;
    public final Provider<SendPendingMessagesTask> c;
    public final Provider<ChannelSyncTask> d;
    public final Provider<MessageSyncTask> e;

    public MessengerBackgroundInitializationTask_Factory(Provider<MessengerEmptyChatsCleanupTask> provider, Provider<MessengerPhotosCleanupTask> provider2, Provider<SendPendingMessagesTask> provider3, Provider<ChannelSyncTask> provider4, Provider<MessageSyncTask> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MessengerBackgroundInitializationTask_Factory create(Provider<MessengerEmptyChatsCleanupTask> provider, Provider<MessengerPhotosCleanupTask> provider2, Provider<SendPendingMessagesTask> provider3, Provider<ChannelSyncTask> provider4, Provider<MessageSyncTask> provider5) {
        return new MessengerBackgroundInitializationTask_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static MessengerBackgroundInitializationTask newInstance(MessengerEmptyChatsCleanupTask messengerEmptyChatsCleanupTask, MessengerPhotosCleanupTask messengerPhotosCleanupTask, SendPendingMessagesTask sendPendingMessagesTask, ChannelSyncTask channelSyncTask, MessageSyncTask messageSyncTask) {
        return new MessengerBackgroundInitializationTask(messengerEmptyChatsCleanupTask, messengerPhotosCleanupTask, sendPendingMessagesTask, channelSyncTask, messageSyncTask);
    }

    @Override // javax.inject.Provider
    public MessengerBackgroundInitializationTask get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
