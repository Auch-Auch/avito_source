package com.avito.android.analytics.screens;

import dagger.internal.Factory;
public final class TimerFactory_Factory implements Factory<TimerFactory> {

    public static final class a {
        public static final TimerFactory_Factory a = new TimerFactory_Factory();
    }

    public static TimerFactory_Factory create() {
        return a.a;
    }

    public static TimerFactory newInstance() {
        return new TimerFactory();
    }

    @Override // javax.inject.Provider
    public TimerFactory get() {
        return newInstance();
    }
}
