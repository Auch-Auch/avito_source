package com.avito.android;

import com.avito.android.app.task.MessageSyncTask;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessengerTasksModule_ProvideMessageSyncTaskFactory implements Factory<MessageSyncTask> {
    public final Provider<MessageSyncAgent> a;

    public MessengerTasksModule_ProvideMessageSyncTaskFactory(Provider<MessageSyncAgent> provider) {
        this.a = provider;
    }

    public static MessengerTasksModule_ProvideMessageSyncTaskFactory create(Provider<MessageSyncAgent> provider) {
        return new MessengerTasksModule_ProvideMessageSyncTaskFactory(provider);
    }

    public static MessageSyncTask provideMessageSyncTask(Lazy<MessageSyncAgent> lazy) {
        return (MessageSyncTask) Preconditions.checkNotNullFromProvides(MessengerTasksModule.INSTANCE.provideMessageSyncTask(lazy));
    }

    @Override // javax.inject.Provider
    public MessageSyncTask get() {
        return provideMessageSyncTask(DoubleCheck.lazy(this.a));
    }
}
