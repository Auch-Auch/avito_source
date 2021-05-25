package com.avito.logger.handler;

import com.avito.android.remote.auth.AuthSource;
import com.avito.logger.LogLevel;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/logger/handler/CombinedHandler;", "Lcom/avito/logger/handler/LoggingHandler;", "Lcom/avito/logger/LogLevel;", FirebaseAnalytics.Param.LEVEL, "", "message", "", "error", "", "write", "(Lcom/avito/logger/LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V", "", AuthSource.SEND_ABUSE, "Ljava/util/Collection;", "handlers", "<init>", "(Ljava/util/Collection;)V", "logger"}, k = 1, mv = {1, 4, 2})
public final class CombinedHandler implements LoggingHandler {
    public final Collection<LoggingHandler> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends com.avito.logger.handler.LoggingHandler> */
    /* JADX WARN: Multi-variable type inference failed */
    public CombinedHandler(@NotNull Collection<? extends LoggingHandler> collection) {
        Intrinsics.checkNotNullParameter(collection, "handlers");
        this.a = collection;
    }

    @Override // com.avito.logger.handler.LoggingHandler
    public void write(@NotNull LogLevel logLevel, @NotNull String str, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(logLevel, FirebaseAnalytics.Param.LEVEL);
        Intrinsics.checkNotNullParameter(str, "message");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().write(logLevel, str, th);
        }
    }
}
