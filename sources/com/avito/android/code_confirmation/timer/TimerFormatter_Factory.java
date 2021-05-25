package com.avito.android.code_confirmation.timer;

import dagger.internal.Factory;
public final class TimerFormatter_Factory implements Factory<TimerFormatter> {

    public static final class a {
        public static final TimerFormatter_Factory a = new TimerFormatter_Factory();
    }

    public static TimerFormatter_Factory create() {
        return a.a;
    }

    public static TimerFormatter newInstance() {
        return new TimerFormatter();
    }

    @Override // javax.inject.Provider
    public TimerFormatter get() {
        return newInstance();
    }
}
