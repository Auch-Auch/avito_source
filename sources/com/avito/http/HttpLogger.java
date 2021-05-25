package com.avito.http;

import com.avito.android.remote.auth.AuthSource;
import com.avito.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/http/HttpLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "message", "", "log", "(Ljava/lang/String;)V", "Lcom/avito/logger/Logger;", AuthSource.SEND_ABUSE, "Lcom/avito/logger/Logger;", "logger", "<init>", "(Lcom/avito/logger/Logger;)V", "okhttp"}, k = 1, mv = {1, 4, 2})
public final class HttpLogger implements HttpLoggingInterceptor.Logger {
    public final Logger a;

    public HttpLogger(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.a = logger;
    }

    @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
    public void log(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.a.debug(str);
    }
}
