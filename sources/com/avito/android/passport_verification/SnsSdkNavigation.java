package com.avito.android.passport_verification;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/passport_verification/SnsSdkNavigation;", "", "<init>", "()V", "DismissSnsSdk", "OpenSnsSdk", "Lcom/avito/android/passport_verification/SnsSdkNavigation$OpenSnsSdk;", "Lcom/avito/android/passport_verification/SnsSdkNavigation$DismissSnsSdk;", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
public abstract class SnsSdkNavigation {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/passport_verification/SnsSdkNavigation$DismissSnsSdk;", "Lcom/avito/android/passport_verification/SnsSdkNavigation;", "<init>", "()V", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class DismissSnsSdk extends SnsSdkNavigation {
        @NotNull
        public static final DismissSnsSdk INSTANCE = new DismissSnsSdk();

        public DismissSnsSdk() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/passport_verification/SnsSdkNavigation$OpenSnsSdk;", "Lcom/avito/android/passport_verification/SnsSdkNavigation;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAccessToken", "()Ljava/lang/String;", SDKConstants.PARAM_ACCESS_TOKEN, AuthSource.BOOKING_ORDER, "getFlowName", "flowName", "c", "getUrl", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class OpenSnsSdk extends SnsSdkNavigation {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @NotNull
        public final String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OpenSnsSdk(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            super(null);
            a.Z0(str, SDKConstants.PARAM_ACCESS_TOKEN, str2, "flowName", str3, "url");
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @NotNull
        public final String getAccessToken() {
            return this.a;
        }

        @NotNull
        public final String getFlowName() {
            return this.b;
        }

        @NotNull
        public final String getUrl() {
            return this.c;
        }
    }

    public SnsSdkNavigation() {
    }

    public SnsSdkNavigation(j jVar) {
    }
}
