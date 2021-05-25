package com.avito.android.push;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.AppleSignInManagerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0001\t¨\u0006\n"}, d2 = {"Lcom/avito/android/push/PushToken;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "GcmToken", "Lcom/avito/android/push/PushToken$GcmToken;", "core_release"}, k = 1, mv = {1, 4, 2})
public abstract class PushToken {
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/push/PushToken$GcmToken;", "Lcom/avito/android/push/PushToken;", "", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "<init>", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class GcmToken extends PushToken {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GcmToken(@NotNull String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        }
    }

    public PushToken(String str, j jVar) {
        this.a = str;
    }

    @NotNull
    public final String getToken() {
        return this.a;
    }
}
