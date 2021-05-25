package com.avito.android.in_app_calls.task;

import dagger.internal.Factory;
public final class SetupCallNotificationChannelTask_Factory implements Factory<SetupCallNotificationChannelTask> {

    public static final class a {
        public static final SetupCallNotificationChannelTask_Factory a = new SetupCallNotificationChannelTask_Factory();
    }

    public static SetupCallNotificationChannelTask_Factory create() {
        return a.a;
    }

    public static SetupCallNotificationChannelTask newInstance() {
        return new SetupCallNotificationChannelTask();
    }

    @Override // javax.inject.Provider
    public SetupCallNotificationChannelTask get() {
        return newInstance();
    }
}
