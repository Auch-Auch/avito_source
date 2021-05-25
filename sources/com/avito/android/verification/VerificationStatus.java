package com.avito.android.verification;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/verification/VerificationStatus;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "IN_PROGRESS", "ERROR", "INFO", "verification_release"}, k = 1, mv = {1, 4, 2})
public enum VerificationStatus {
    IN_PROGRESS("inProgress"),
    ERROR("error"),
    INFO("info");
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/verification/VerificationStatus$Companion;", "", "", "type", "Lcom/avito/android/verification/VerificationStatus;", "valueOfType", "(Ljava/lang/String;)Lcom/avito/android/verification/VerificationStatus;", "<init>", "()V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final VerificationStatus valueOfType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "type");
            VerificationStatus verificationStatus = VerificationStatus.IN_PROGRESS;
            if (Intrinsics.areEqual(str, verificationStatus.getType())) {
                return verificationStatus;
            }
            VerificationStatus verificationStatus2 = VerificationStatus.ERROR;
            return Intrinsics.areEqual(str, verificationStatus2.getType()) ? verificationStatus2 : VerificationStatus.INFO;
        }

        public Companion(j jVar) {
        }
    }

    /* access modifiers changed from: public */
    VerificationStatus(String str) {
        this.a = str;
    }

    @NotNull
    public final String getType() {
        return this.a;
    }
}
