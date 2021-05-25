package com.avito.android.remote.model.messenger;
public class MessengerTimestamp {
    public static long fromMillis(long j) {
        return j * 10000;
    }

    public static long toMillis(long j) {
        return j / 10000;
    }
}
