package ru.avito.messenger.internal.log;

import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.LogLevel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\tJ)\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\tR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lru/avito/messenger/internal/log/LeveledLogger;", "Lru/avito/messenger/internal/log/Logger;", "", "tag", "message", "", "e", "", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "d", VKApiConst.VERSION, "", AuthSource.SEND_ABUSE, "I", FirebaseAnalytics.Param.LEVEL, AuthSource.BOOKING_ORDER, "Lru/avito/messenger/internal/log/Logger;", "logger", "<init>", "(ILru/avito/messenger/internal/log/Logger;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LeveledLogger implements Logger {
    public final int a;
    public final Logger b;

    public LeveledLogger(@LogLevel int i, @NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.a = i;
        this.b = logger;
    }

    @Override // ru.avito.messenger.internal.log.Logger
    public void d(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        if (this.a != 0 && 2 >= this.a) {
            this.b.d(str, str2, th);
        }
    }

    @Override // ru.avito.messenger.internal.log.Logger
    public void e(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        if (this.a != 0 && 4 >= this.a) {
            this.b.e(str, str2, th);
        }
    }

    @Override // ru.avito.messenger.internal.log.Logger
    public void i(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        if (this.a != 0 && 3 >= this.a) {
            this.b.i(str, str2, th);
        }
    }

    @Override // ru.avito.messenger.internal.log.Logger
    public void v(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        if (this.a != 0 && 1 >= this.a) {
            this.b.v(str, str2, th);
        }
    }
}
