package com.avito.logger.handler;

import com.avito.android.remote.auth.AuthSource;
import com.avito.logger.LogLevel;
import com.avito.logger.LoggingDestination;
import com.avito.logger.LoggingFormatter;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/logger/handler/DefaultLoggingHandler;", "Lcom/avito/logger/handler/LoggingHandler;", "Lcom/avito/logger/LogLevel;", FirebaseAnalytics.Param.LEVEL, "", "message", "", "error", "", "write", "(Lcom/avito/logger/LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V", "Lcom/avito/logger/LoggingDestination;", AuthSource.BOOKING_ORDER, "Lcom/avito/logger/LoggingDestination;", "destination", "Lcom/avito/logger/LoggingFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/logger/LoggingFormatter;", "formatter", "<init>", "(Lcom/avito/logger/LoggingFormatter;Lcom/avito/logger/LoggingDestination;)V", "logger"}, k = 1, mv = {1, 4, 2})
public final class DefaultLoggingHandler implements LoggingHandler {
    public final LoggingFormatter a;
    public final LoggingDestination b;

    public DefaultLoggingHandler(@Nullable LoggingFormatter loggingFormatter, @NotNull LoggingDestination loggingDestination) {
        Intrinsics.checkNotNullParameter(loggingDestination, "destination");
        this.a = loggingFormatter;
        this.b = loggingDestination;
    }

    @Override // com.avito.logger.handler.LoggingHandler
    public void write(@NotNull LogLevel logLevel, @NotNull String str, @Nullable Throwable th) {
        String format;
        Intrinsics.checkNotNullParameter(logLevel, FirebaseAnalytics.Param.LEVEL);
        Intrinsics.checkNotNullParameter(str, "message");
        LoggingDestination loggingDestination = this.b;
        LoggingFormatter loggingFormatter = this.a;
        if (!(loggingFormatter == null || (format = loggingFormatter.format(str)) == null)) {
            str = format;
        }
        loggingDestination.write(logLevel, str, th);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultLoggingHandler(LoggingFormatter loggingFormatter, LoggingDestination loggingDestination, int i, j jVar) {
        this((i & 1) != 0 ? null : loggingFormatter, loggingDestination);
    }
}
