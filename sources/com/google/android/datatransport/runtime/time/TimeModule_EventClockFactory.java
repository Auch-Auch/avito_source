package com.google.android.datatransport.runtime.time;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class TimeModule_EventClockFactory implements Factory<Clock> {
    public static final TimeModule_EventClockFactory a = new TimeModule_EventClockFactory();

    public static TimeModule_EventClockFactory create() {
        return a;
    }

    public static Clock eventClock() {
        return (Clock) Preconditions.checkNotNull(new WallTimeClock(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Clock get() {
        return eventClock();
    }
}
