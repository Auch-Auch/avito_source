package ru.avito.messenger.internal.log;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ+\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\n\u0010\tJ+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0006\u0010\tJ+\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lru/avito/messenger/internal/log/Logger;", "", "", "tag", "message", "", "e", "", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "d", VKApiConst.VERSION, "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface Logger {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void d$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    th = null;
                }
                logger.d(str, str2, th);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
        }

        public static /* synthetic */ void e$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    th = null;
                }
                logger.e(str, str2, th);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
        }

        public static /* synthetic */ void i$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    th = null;
                }
                logger.i(str, str2, th);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
        }

        public static /* synthetic */ void v$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    th = null;
                }
                logger.v(str, str2, th);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v");
        }
    }

    void d(@NotNull String str, @NotNull String str2, @Nullable Throwable th);

    void e(@NotNull String str, @NotNull String str2, @Nullable Throwable th);

    void i(@NotNull String str, @NotNull String str2, @Nullable Throwable th);

    void v(@NotNull String str, @NotNull String str2, @Nullable Throwable th);
}
