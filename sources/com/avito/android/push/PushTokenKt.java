package com.avito.android.push;

import com.avito.android.push.PushToken;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0016\u0010\u0001\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0017\u0010\u0006\u001a\u00020\u0000*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"", "GcmTokenTypeRemote", "Ljava/lang/String;", "Lcom/avito/android/push/PushToken;", "getTokenTypeRemote", "(Lcom/avito/android/push/PushToken;)Ljava/lang/String;", "tokenTypeRemote", "core_release"}, k = 2, mv = {1, 4, 2})
public final class PushTokenKt {
    @NotNull
    public static final String GcmTokenTypeRemote = "fcm";

    @NotNull
    public static final String getTokenTypeRemote(@NotNull PushToken pushToken) {
        Intrinsics.checkNotNullParameter(pushToken, "$this$tokenTypeRemote");
        if (pushToken instanceof PushToken.GcmToken) {
            return "fcm";
        }
        throw new NoWhenBranchMatchedException();
    }
}
