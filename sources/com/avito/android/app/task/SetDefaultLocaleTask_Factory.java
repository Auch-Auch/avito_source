package com.avito.android.app.task;

import dagger.internal.Factory;
public final class SetDefaultLocaleTask_Factory implements Factory<SetDefaultLocaleTask> {

    public static final class a {
        public static final SetDefaultLocaleTask_Factory a = new SetDefaultLocaleTask_Factory();
    }

    public static SetDefaultLocaleTask_Factory create() {
        return a.a;
    }

    public static SetDefaultLocaleTask newInstance() {
        return new SetDefaultLocaleTask();
    }

    @Override // javax.inject.Provider
    public SetDefaultLocaleTask get() {
        return newInstance();
    }
}
