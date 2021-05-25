package com.avito.android.app.task;

import dagger.internal.Factory;
public final class InitializeYandexMapsTask_Factory implements Factory<InitializeYandexMapsTask> {

    public static final class a {
        public static final InitializeYandexMapsTask_Factory a = new InitializeYandexMapsTask_Factory();
    }

    public static InitializeYandexMapsTask_Factory create() {
        return a.a;
    }

    public static InitializeYandexMapsTask newInstance() {
        return new InitializeYandexMapsTask();
    }

    @Override // javax.inject.Provider
    public InitializeYandexMapsTask get() {
        return newInstance();
    }
}
