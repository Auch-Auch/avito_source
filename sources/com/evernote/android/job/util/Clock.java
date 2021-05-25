package com.evernote.android.job.util;

import android.os.SystemClock;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface Clock {
    public static final Clock DEFAULT = new a();

    public static class a implements Clock {
        @Override // com.evernote.android.job.util.Clock
        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }

        @Override // com.evernote.android.job.util.Clock
        public long elapsedRealtime() {
            return SystemClock.elapsedRealtime();
        }
    }

    long currentTimeMillis();

    long elapsedRealtime();
}
