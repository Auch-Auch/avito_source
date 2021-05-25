package com.avito.android.app.task;

import dagger.internal.Factory;
public final class SetupNotificationChannelsTask_Factory implements Factory<SetupNotificationChannelsTask> {

    public static final class a {
        public static final SetupNotificationChannelsTask_Factory a = new SetupNotificationChannelsTask_Factory();
    }

    public static SetupNotificationChannelsTask_Factory create() {
        return a.a;
    }

    public static SetupNotificationChannelsTask newInstance() {
        return new SetupNotificationChannelsTask();
    }

    @Override // javax.inject.Provider
    public SetupNotificationChannelsTask get() {
        return newInstance();
    }
}
