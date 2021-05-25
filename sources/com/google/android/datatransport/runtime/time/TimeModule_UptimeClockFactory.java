package com.google.android.datatransport.runtime.time;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class TimeModule_UptimeClockFactory implements Factory<Clock> {
    public static final TimeModule_UptimeClockFactory a = new TimeModule_UptimeClockFactory();

    public static TimeModule_UptimeClockFactory create() {
        return a;
    }

    public static Clock uptimeClock() {
        return (Clock) Preconditions.checkNotNull(new UptimeClock(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Clock get() {
        return uptimeClock();
    }
}
