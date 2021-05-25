package com.google.android.exoplayer2.upstream;

import java.io.IOException;
public final class DataSourceException extends IOException {
    public static final int POSITION_OUT_OF_RANGE = 0;
    public final int reason;

    public DataSourceException(int i) {
        this.reason = i;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Throwable] */
    public static boolean isCausedByPositionOutOfRange(IOException iOException) {
        while (iOException != 0) {
            if ((iOException instanceof DataSourceException) && ((DataSourceException) iOException).reason == 0) {
                return true;
            }
            iOException = iOException.getCause();
        }
        return false;
    }
}
