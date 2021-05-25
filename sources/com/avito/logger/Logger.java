package com.avito.logger;

import androidx.core.app.NotificationCompat;
import com.avito.android.user_advert.reject.RejectReasonItemKt;
import com.avito.android.util.preferences.Names;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J#\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/logger/Logger;", "", "", NotificationCompat.CATEGORY_MESSAGE, "", Names.DEBUG, "(Ljava/lang/String;)V", "info", "", "error", "warn", "(Ljava/lang/String;Ljava/lang/Throwable;)V", RejectReasonItemKt.SEVERITY_CRITICAL, "logger"}, k = 1, mv = {1, 4, 2})
public interface Logger {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void warn$default(Logger logger, String str, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    th = null;
                }
                logger.warn(str, th);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
        }
    }

    void critical(@NotNull String str, @NotNull Throwable th);

    void debug(@NotNull String str);

    void info(@NotNull String str);

    void warn(@NotNull String str, @Nullable Throwable th);
}
