package com.avito.android.messenger.channels.mvi.common.v4;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0006\u001a\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/avito/android/messenger/channels/mvi/common/v4/ShouldCancelChecker$Companion$dummy$1", "Lcom/avito/android/messenger/channels/mvi/common/v4/ShouldCancelChecker;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "", "aShouldCancelB", "(Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;)Z", "mvi_release"}, k = 1, mv = {1, 4, 2})
public final class ShouldCancelChecker$Companion$dummy$1 implements ShouldCancelChecker<T> {
    @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
    public boolean aShouldCancelB(@NotNull Reducible<T> reducible, @NotNull Reducible<T> reducible2) {
        Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
        return false;
    }
}
