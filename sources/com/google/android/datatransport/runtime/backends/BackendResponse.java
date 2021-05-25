package com.google.android.datatransport.runtime.backends;

import a2.j.b.a.c.l.b;
import com.google.auto.value.AutoValue;
@AutoValue
public abstract class BackendResponse {

    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public static BackendResponse fatalError() {
        return new b(Status.FATAL_ERROR, -1);
    }

    public static BackendResponse ok(long j) {
        return new b(Status.OK, j);
    }

    public static BackendResponse transientError() {
        return new b(Status.TRANSIENT_ERROR, -1);
    }

    public abstract long getNextRequestWaitMillis();

    public abstract Status getStatus();
}
