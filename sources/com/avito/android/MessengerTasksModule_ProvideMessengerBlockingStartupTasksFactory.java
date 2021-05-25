package com.avito.android;

import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.MessengerDbMaintenanceTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class MessengerTasksModule_ProvideMessengerBlockingStartupTasksFactory implements Factory<List<ApplicationBlockingStartupTask>> {
    public final Provider<MessengerDbMaintenanceTask> a;

    public MessengerTasksModule_ProvideMessengerBlockingStartupTasksFactory(Provider<MessengerDbMaintenanceTask> provider) {
        this.a = provider;
    }

    public static MessengerTasksModule_ProvideMessengerBlockingStartupTasksFactory create(Provider<MessengerDbMaintenanceTask> provider) {
        return new MessengerTasksModule_ProvideMessengerBlockingStartupTasksFactory(provider);
    }

    public static List<ApplicationBlockingStartupTask> provideMessengerBlockingStartupTasks(MessengerDbMaintenanceTask messengerDbMaintenanceTask) {
        return (List) Preconditions.checkNotNullFromProvides(MessengerTasksModule.INSTANCE.provideMessengerBlockingStartupTasks(messengerDbMaintenanceTask));
    }

    @Override // javax.inject.Provider
    public List<ApplicationBlockingStartupTask> get() {
        return provideMessengerBlockingStartupTasks(this.a.get());
    }
}
