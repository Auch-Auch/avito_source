package com.avito.android.messenger.service.user_last_activity;

import com.avito.android.remote.model.User;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00068\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\u00018\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0016\u0010\u000b\u001a\u00020\u00018\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u000b\u0010\n\"\u0016\u0010\f\u001a\u00020\u00018\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/User;", "", "nowInSeconds", "", "isOnline", "(Lcom/avito/android/remote/model/User;J)Z", "", "MAX_USERS_REQUEST_SIZE", "I", "ONLINE_THRESHOLD_S", "J", "REQUEST_THROTTLE_MS", "POLLING_INTERVAL_S", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class UsersKt {
    public static final int MAX_USERS_REQUEST_SIZE = 100;
    public static final long ONLINE_THRESHOLD_S = 150;
    public static final long POLLING_INTERVAL_S = 15;
    public static final long REQUEST_THROTTLE_MS = 5000;

    public static final boolean isOnline(@NotNull User user, long j) {
        Intrinsics.checkNotNullParameter(user, "$this$isOnline");
        Long lastActionTime = user.getLastActionTime();
        return lastActionTime != null && j - lastActionTime.longValue() < 150;
    }
}
