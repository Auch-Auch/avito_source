package com.avito.android.app.task;

import dagger.internal.Factory;
public final class GlobalAnimationsStateTask_Factory implements Factory<GlobalAnimationsStateTask> {

    public static final class a {
        public static final GlobalAnimationsStateTask_Factory a = new GlobalAnimationsStateTask_Factory();
    }

    public static GlobalAnimationsStateTask_Factory create() {
        return a.a;
    }

    public static GlobalAnimationsStateTask newInstance() {
        return new GlobalAnimationsStateTask();
    }

    @Override // javax.inject.Provider
    public GlobalAnimationsStateTask get() {
        return newInstance();
    }
}
