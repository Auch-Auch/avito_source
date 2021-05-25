package com.avito.android.app.task;

import dagger.internal.Factory;
public final class InitRxTask_Factory implements Factory<InitRxTask> {

    public static final class a {
        public static final InitRxTask_Factory a = new InitRxTask_Factory();
    }

    public static InitRxTask_Factory create() {
        return a.a;
    }

    public static InitRxTask newInstance() {
        return new InitRxTask();
    }

    @Override // javax.inject.Provider
    public InitRxTask get() {
        return newInstance();
    }
}
