package com.avito.android;

import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.MessengerBackgroundInitializationTask;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class MessengerTasksModule_ProvideMessengerBackgroundTasksFactory implements Factory<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> {
    public final Provider<MessengerBackgroundInitializationTask> a;

    public MessengerTasksModule_ProvideMessengerBackgroundTasksFactory(Provider<MessengerBackgroundInitializationTask> provider) {
        this.a = provider;
    }

    public static MessengerTasksModule_ProvideMessengerBackgroundTasksFactory create(Provider<MessengerBackgroundInitializationTask> provider) {
        return new MessengerTasksModule_ProvideMessengerBackgroundTasksFactory(provider);
    }

    public static List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideMessengerBackgroundTasks(Lazy<MessengerBackgroundInitializationTask> lazy) {
        return (List) Preconditions.checkNotNullFromProvides(MessengerTasksModule.INSTANCE.provideMessengerBackgroundTasks(lazy));
    }

    @Override // javax.inject.Provider
    public List<TypedLazy<? extends ApplicationBackgroundStartupTask>> get() {
        return provideMessengerBackgroundTasks(DoubleCheck.lazy(this.a));
    }
}
