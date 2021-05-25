package com.avito.android.messenger.channels.mvi.common.v4;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.memory.BitmapPoolType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \t*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\tJ+\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v4/ShouldCancelChecker;", "", "StateT", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "", "aShouldCancelB", "(Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;)Z", "Companion", "mvi_release"}, k = 1, mv = {1, 4, 2})
public interface ShouldCancelChecker<StateT> {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0001H\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v4/ShouldCancelChecker$Companion;", "", "T", "Lcom/avito/android/messenger/channels/mvi/common/v4/ShouldCancelChecker;", BitmapPoolType.DUMMY, "()Lcom/avito/android/messenger/channels/mvi/common/v4/ShouldCancelChecker;", "<init>", "()V", "mvi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final <T> ShouldCancelChecker<T> dummy() {
            return new ShouldCancelChecker$Companion$dummy$1();
        }
    }

    boolean aShouldCancelB(@NotNull Reducible<StateT> reducible, @NotNull Reducible<StateT> reducible2);
}
