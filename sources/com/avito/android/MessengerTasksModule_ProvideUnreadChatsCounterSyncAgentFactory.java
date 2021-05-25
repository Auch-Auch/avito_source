package com.avito.android;

import com.avito.android.app.task.UnreadChatsCounterSyncTask;
import com.avito.android.messenger.service.UnreadChatsCounterSyncAgent;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessengerTasksModule_ProvideUnreadChatsCounterSyncAgentFactory implements Factory<UnreadChatsCounterSyncTask> {
    public final Provider<UnreadChatsCounterSyncAgent> a;

    public MessengerTasksModule_ProvideUnreadChatsCounterSyncAgentFactory(Provider<UnreadChatsCounterSyncAgent> provider) {
        this.a = provider;
    }

    public static MessengerTasksModule_ProvideUnreadChatsCounterSyncAgentFactory create(Provider<UnreadChatsCounterSyncAgent> provider) {
        return new MessengerTasksModule_ProvideUnreadChatsCounterSyncAgentFactory(provider);
    }

    public static UnreadChatsCounterSyncTask provideUnreadChatsCounterSyncAgent(Lazy<UnreadChatsCounterSyncAgent> lazy) {
        return (UnreadChatsCounterSyncTask) Preconditions.checkNotNullFromProvides(MessengerTasksModule.INSTANCE.provideUnreadChatsCounterSyncAgent(lazy));
    }

    @Override // javax.inject.Provider
    public UnreadChatsCounterSyncTask get() {
        return provideUnreadChatsCounterSyncAgent(DoubleCheck.lazy(this.a));
    }
}
