package com.avito.logger;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/logger/LoggingDestination;", "Ljava/io/Serializable;", "Lcom/avito/logger/LogLevel;", FirebaseAnalytics.Param.LEVEL, "", "message", "", "throwable", "", "write", "(Lcom/avito/logger/LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V", "logger"}, k = 1, mv = {1, 4, 2})
public interface LoggingDestination extends Serializable {
    void write(@NotNull LogLevel logLevel, @NotNull String str, @Nullable Throwable th);
}
