package a2.j.b.b.d1;

import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;
/* compiled from: LoadErrorHandlingPolicy */
public final /* synthetic */ class g {
    @Deprecated
    public static long $default$getBlacklistDurationMsFor(LoadErrorHandlingPolicy _this, int i, long j, IOException iOException, int i2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static long $default$getRetryDelayMsFor(LoadErrorHandlingPolicy _this, int i, long j, IOException iOException, int i2) {
        throw new UnsupportedOperationException();
    }

    public static void $default$onLoadTaskConcluded(LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j) {
    }

    public static long $default$getBlacklistDurationMsFor(LoadErrorHandlingPolicy _this, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        return _this.getBlacklistDurationMsFor(loadErrorInfo.mediaLoadData.dataType, loadErrorInfo.loadEventInfo.loadDurationMs, loadErrorInfo.exception, loadErrorInfo.errorCount);
    }

    public static long $default$getRetryDelayMsFor(LoadErrorHandlingPolicy _this, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        return _this.getRetryDelayMsFor(loadErrorInfo.mediaLoadData.dataType, loadErrorInfo.loadEventInfo.loadDurationMs, loadErrorInfo.exception, loadErrorInfo.errorCount);
    }
}
