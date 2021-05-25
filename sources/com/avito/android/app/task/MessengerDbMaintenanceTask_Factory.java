package com.avito.android.app.task;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessengerDbMaintenanceTask_Factory implements Factory<MessengerDbMaintenanceTask> {
    public final Provider<Analytics> a;

    public MessengerDbMaintenanceTask_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static MessengerDbMaintenanceTask_Factory create(Provider<Analytics> provider) {
        return new MessengerDbMaintenanceTask_Factory(provider);
    }

    public static MessengerDbMaintenanceTask newInstance(Analytics analytics) {
        return new MessengerDbMaintenanceTask(analytics);
    }

    @Override // javax.inject.Provider
    public MessengerDbMaintenanceTask get() {
        return newInstance(this.a.get());
    }
}
