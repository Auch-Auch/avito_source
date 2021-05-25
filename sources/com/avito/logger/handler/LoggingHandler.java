package com.avito.logger.handler;

import com.avito.logger.LogLevel;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/logger/handler/LoggingHandler;", "Ljava/io/Serializable;", "Lcom/avito/logger/LogLevel;", FirebaseAnalytics.Param.LEVEL, "", "message", "", "error", "", "write", "(Lcom/avito/logger/LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V", "logger"}, k = 1, mv = {1, 4, 2})
public interface LoggingHandler extends Serializable {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void write$default(LoggingHandler loggingHandler, LogLevel logLevel, String str, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    th = null;
                }
                loggingHandler.write(logLevel, str, th);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
    }

    void write(@NotNull LogLevel logLevel, @NotNull String str, @Nullable Throwable th);
}
