package com.avito.android;

import com.avito.android.app.task.ApplicationForegroundStartupTask;
import com.avito.android.app.task.UnreadChatsCounterSyncTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class MessengerTasksModule_ProvideMessengerForegroundTasksFactory implements Factory<List<ApplicationForegroundStartupTask>> {
    public final Provider<UnreadChatsCounterSyncTask> a;

    public MessengerTasksModule_ProvideMessengerForegroundTasksFactory(Provider<UnreadChatsCounterSyncTask> provider) {
        this.a = provider;
    }

    public static MessengerTasksModule_ProvideMessengerForegroundTasksFactory create(Provider<UnreadChatsCounterSyncTask> provider) {
        return new MessengerTasksModule_ProvideMessengerForegroundTasksFactory(provider);
    }

    public static List<ApplicationForegroundStartupTask> provideMessengerForegroundTasks(UnreadChatsCounterSyncTask unreadChatsCounterSyncTask) {
        return (List) Preconditions.checkNotNullFromProvides(MessengerTasksModule.INSTANCE.provideMessengerForegroundTasks(unreadChatsCounterSyncTask));
    }

    @Override // javax.inject.Provider
    public List<ApplicationForegroundStartupTask> get() {
        return provideMessengerForegroundTasks(this.a.get());
    }
}
