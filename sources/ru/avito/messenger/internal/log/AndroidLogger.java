package ru.avito.messenger.internal.log;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\tJ)\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lru/avito/messenger/internal/log/AndroidLogger;", "Lru/avito/messenger/internal/log/Logger;", "", "tag", "message", "", "e", "", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "d", VKApiConst.VERSION, "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class AndroidLogger implements Logger {
    @Override // ru.avito.messenger.internal.log.Logger
    public void d(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    @Override // ru.avito.messenger.internal.log.Logger
    public void e(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    @Override // ru.avito.messenger.internal.log.Logger
    public void i(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    @Override // ru.avito.messenger.internal.log.Logger
    public void v(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
    }
}
