package com.avito.android.social.esia;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/social/esia/EsiaAuthResult;", "", "<init>", "()V", "Failure", "Success", "Lcom/avito/android/social/esia/EsiaAuthResult$Success;", "Lcom/avito/android/social/esia/EsiaAuthResult$Failure;", "social_release"}, k = 1, mv = {1, 4, 2})
public abstract class EsiaAuthResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/social/esia/EsiaAuthResult$Failure;", "Lcom/avito/android/social/esia/EsiaAuthResult;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "reason", "<init>", "(Ljava/lang/String;)V", "social_release"}, k = 1, mv = {1, 4, 2})
    public static final class Failure extends EsiaAuthResult {
        @Nullable
        public final String a;

        public Failure(@Nullable String str) {
            super(null);
            this.a = str;
        }

        @Nullable
        public final String getReason() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/social/esia/EsiaAuthResult$Success;", "Lcom/avito/android/social/esia/EsiaAuthResult;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "code", AuthSource.BOOKING_ORDER, "getState", "state", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "social_release"}, k = 1, mv = {1, 4, 2})
    public static final class Success extends EsiaAuthResult {
        @NotNull
        public final String a;
        @Nullable
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(@NotNull String str, @Nullable String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "code");
            this.a = str;
            this.b = str2;
        }

        @NotNull
        public final String getCode() {
            return this.a;
        }

        @Nullable
        public final String getState() {
            return this.b;
        }
    }

    public EsiaAuthResult() {
    }

    public EsiaAuthResult(j jVar) {
    }
}
