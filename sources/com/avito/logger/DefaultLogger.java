package com.avito.logger;

import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_advert.reject.RejectReasonItemKt;
import com.avito.android.util.preferences.Names;
import com.avito.logger.handler.LoggingHandler;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J!\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/avito/logger/DefaultLogger;", "Lcom/avito/logger/Logger;", "Ljava/io/Serializable;", "", NotificationCompat.CATEGORY_MESSAGE, "", Names.DEBUG, "(Ljava/lang/String;)V", "info", "", "error", "warn", "(Ljava/lang/String;Ljava/lang/Throwable;)V", RejectReasonItemKt.SEVERITY_CRITICAL, "Lcom/avito/logger/handler/LoggingHandler;", AuthSource.BOOKING_ORDER, "Lcom/avito/logger/handler/LoggingHandler;", "infoHandler", "c", "warningHandler", "d", "criticalHandler", AuthSource.SEND_ABUSE, "debugHandler", "<init>", "(Lcom/avito/logger/handler/LoggingHandler;Lcom/avito/logger/handler/LoggingHandler;Lcom/avito/logger/handler/LoggingHandler;Lcom/avito/logger/handler/LoggingHandler;)V", "logger"}, k = 1, mv = {1, 4, 2})
public final class DefaultLogger implements Logger, Serializable {
    public final LoggingHandler a;
    public final LoggingHandler b;
    public final LoggingHandler c;
    public final LoggingHandler d;

    public DefaultLogger(@NotNull LoggingHandler loggingHandler, @NotNull LoggingHandler loggingHandler2, @NotNull LoggingHandler loggingHandler3, @NotNull LoggingHandler loggingHandler4) {
        Intrinsics.checkNotNullParameter(loggingHandler, "debugHandler");
        Intrinsics.checkNotNullParameter(loggingHandler2, "infoHandler");
        Intrinsics.checkNotNullParameter(loggingHandler3, "warningHandler");
        Intrinsics.checkNotNullParameter(loggingHandler4, "criticalHandler");
        this.a = loggingHandler;
        this.b = loggingHandler2;
        this.c = loggingHandler3;
        this.d = loggingHandler4;
    }

    @Override // com.avito.logger.Logger
    public void critical(@NotNull String str, @NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "error");
        this.d.write(LogLevel.CRITICAL, str, th);
    }

    @Override // com.avito.logger.Logger
    public void debug(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        LoggingHandler.DefaultImpls.write$default(this.a, LogLevel.DEBUG, str, null, 4, null);
    }

    @Override // com.avito.logger.Logger
    public void info(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        LoggingHandler.DefaultImpls.write$default(this.b, LogLevel.INFO, str, null, 4, null);
    }

    @Override // com.avito.logger.Logger
    public void warn(@NotNull String str, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        this.c.write(LogLevel.WARNING, str, th);
    }
}
