package ru.avito.messenger;

import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lru/avito/messenger/MessengerSessionRefresher;", "", "", "originalSession", "source", "Lio/reactivex/Single;", "", "refreshSession", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "Dummy", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerSessionRefresher {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lru/avito/messenger/MessengerSessionRefresher$Dummy;", "Lru/avito/messenger/MessengerSessionRefresher;", "", "originalSession", "source", "Lio/reactivex/Single;", "", "refreshSession", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Dummy implements MessengerSessionRefresher {
        @Override // ru.avito.messenger.MessengerSessionRefresher
        @NotNull
        public Single<Boolean> refreshSession(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "originalSession");
            Single<Boolean> just = Single.just(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(false)");
            return just;
        }
    }

    @NotNull
    Single<Boolean> refreshSession(@NotNull String str, @Nullable String str2);
}
