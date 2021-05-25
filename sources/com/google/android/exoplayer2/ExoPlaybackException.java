package com.google.android.exoplayer2;

import a2.b.a.a.a;
import a2.j.b.b.n0;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeoutException;
public final class ExoPlaybackException extends Exception {
    public static final int TIMEOUT_OPERATION_RELEASE = 1;
    public static final int TIMEOUT_OPERATION_SET_FOREGROUND_MODE = 2;
    public static final int TIMEOUT_OPERATION_UNDEFINED = 0;
    public static final int TYPE_OUT_OF_MEMORY = 4;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_TIMEOUT = 5;
    public static final int TYPE_UNEXPECTED = 2;
    @Nullable
    public final Throwable a;
    @Nullable
    public final MediaSource.MediaPeriodId mediaPeriodId;
    @Nullable
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    @Nullable
    public final String rendererName;
    public final int timeoutOperation;
    public final long timestampMs;
    public final int type;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimeoutOperation {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public ExoPlaybackException(int i, Throwable th) {
        this(i, th, null, null, -1, null, 4, 0);
    }

    @Nullable
    public static String b(int i, @Nullable String str, @Nullable String str2, int i2, @Nullable Format format, int i3) {
        String str3;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = i != 3 ? i != 4 ? i != 5 ? "Unexpected runtime error" : "Timeout error" : "Out of memory error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i2 + ", format=" + format + ", format_supported=" + n0.a(i3);
        }
        return !TextUtils.isEmpty(str) ? a.e3(str3, ": ", str) : str3;
    }

    public static ExoPlaybackException createForOutOfMemory(OutOfMemoryError outOfMemoryError) {
        return new ExoPlaybackException(4, outOfMemoryError);
    }

    public static ExoPlaybackException createForRemote(String str) {
        return new ExoPlaybackException(3, null, str, null, -1, null, 4, 0);
    }

    public static ExoPlaybackException createForRenderer(Exception exc, String str, int i, @Nullable Format format, int i2) {
        return new ExoPlaybackException(1, exc, null, str, i, format, format == null ? 4 : i2, 0);
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        return new ExoPlaybackException(0, iOException);
    }

    public static ExoPlaybackException createForTimeout(TimeoutException timeoutException, int i) {
        return new ExoPlaybackException(5, timeoutException, null, null, -1, null, 4, i);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, runtimeException);
    }

    @CheckResult
    public ExoPlaybackException a(@Nullable MediaSource.MediaPeriodId mediaPeriodId2) {
        return new ExoPlaybackException(getMessage(), this.a, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, mediaPeriodId2, this.timeoutOperation, this.timestampMs);
    }

    public OutOfMemoryError getOutOfMemoryError() {
        Assertions.checkState(this.type == 4);
        return (OutOfMemoryError) Assertions.checkNotNull(this.a);
    }

    public Exception getRendererException() {
        boolean z = true;
        if (this.type != 1) {
            z = false;
        }
        Assertions.checkState(z);
        return (Exception) Assertions.checkNotNull(this.a);
    }

    public IOException getSourceException() {
        Assertions.checkState(this.type == 0);
        return (IOException) Assertions.checkNotNull(this.a);
    }

    public TimeoutException getTimeoutException() {
        Assertions.checkState(this.type == 5);
        return (TimeoutException) Assertions.checkNotNull(this.a);
    }

    public RuntimeException getUnexpectedException() {
        Assertions.checkState(this.type == 2);
        return (RuntimeException) Assertions.checkNotNull(this.a);
    }

    public ExoPlaybackException(int i, @Nullable Throwable th, @Nullable String str, @Nullable String str2, int i2, @Nullable Format format, int i3, int i4) {
        this(b(i, str, str2, i2, format, i3), th, i, str2, i2, format, i3, null, i4, SystemClock.elapsedRealtime());
    }

    public ExoPlaybackException(@Nullable String str, @Nullable Throwable th, int i, @Nullable String str2, int i2, @Nullable Format format, int i3, @Nullable MediaSource.MediaPeriodId mediaPeriodId2, int i4, long j) {
        super(str, th);
        this.type = i;
        this.a = th;
        this.rendererName = str2;
        this.rendererIndex = i2;
        this.rendererFormat = format;
        this.rendererFormatSupport = i3;
        this.mediaPeriodId = mediaPeriodId2;
        this.timeoutOperation = i4;
        this.timestampMs = j;
    }
}
