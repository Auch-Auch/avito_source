package com.google.android.exoplayer2.upstream;

import a2.j.b.b.d1.g;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class DefaultLoadErrorHandlingPolicy implements LoadErrorHandlingPolicy {
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_PROGRESSIVE_LIVE = 6;
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000;
    public final int a;

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public /* synthetic */ long getBlacklistDurationMsFor(int i, long j, IOException iOException, int i2) {
        return g.$default$getBlacklistDurationMsFor(this, i, j, iOException, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getBlacklistDurationMsFor(LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        IOException iOException = loadErrorInfo.exception;
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return C.TIME_UNSET;
        }
        int i = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode;
        if (i == 403 || i == 404 || i == 410 || i == 416 || i == 500 || i == 503) {
            return DEFAULT_TRACK_BLACKLIST_MS;
        }
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public int getMinimumLoadableRetryCount(int i) {
        int i2 = this.a;
        if (i2 == -1) {
            return i == 7 ? 6 : 3;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public /* synthetic */ long getRetryDelayMsFor(int i, long j, IOException iOException, int i2) {
        return g.$default$getRetryDelayMsFor(this, i, j, iOException, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getRetryDelayMsFor(LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        IOException iOException = loadErrorInfo.exception;
        return ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource.CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException)) ? C.TIME_UNSET : (long) Math.min((loadErrorInfo.errorCount - 1) * 1000, 5000);
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public /* synthetic */ void onLoadTaskConcluded(long j) {
        g.$default$onLoadTaskConcluded(this, j);
    }

    public DefaultLoadErrorHandlingPolicy(int i) {
        this.a = i;
    }
}
