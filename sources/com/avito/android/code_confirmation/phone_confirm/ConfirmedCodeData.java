package com.avito.android.code_confirmation.phone_confirm;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/code_confirmation/phone_confirm/ConfirmedCodeData;", "", "<init>", "()V", "Error", "Ok", "Lcom/avito/android/code_confirmation/phone_confirm/ConfirmedCodeData$Ok;", "Lcom/avito/android/code_confirmation/phone_confirm/ConfirmedCodeData$Error;", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public abstract class ConfirmedCodeData {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/code_confirmation/phone_confirm/ConfirmedCodeData$Error;", "Lcom/avito/android/code_confirmation/phone_confirm/ConfirmedCodeData;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lcom/avito/android/code_confirmation/phone_confirm/ConfirmedCodeData$Error;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends ConfirmedCodeData {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.a;
            }
            return error.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Error copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new Error(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Error) && Intrinsics.areEqual(this.a, ((Error) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getMessage() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.t(a.L("Error(message="), this.a, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u000b\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/code_confirmation/phone_confirm/ConfirmedCodeData$Ok;", "Lcom/avito/android/code_confirmation/phone_confirm/ConfirmedCodeData;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "login", "hash", "isPhoneUsed", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lcom/avito/android/code_confirmation/phone_confirm/ConfirmedCodeData$Ok;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getLogin", AuthSource.BOOKING_ORDER, "getHash", "c", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends ConfirmedCodeData {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        public final boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull String str, @NotNull String str2, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "login");
            Intrinsics.checkNotNullParameter(str2, "hash");
            this.a = str;
            this.b = str2;
            this.c = z;
        }

        public static /* synthetic */ Ok copy$default(Ok ok, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ok.a;
            }
            if ((i & 2) != 0) {
                str2 = ok.b;
            }
            if ((i & 4) != 0) {
                z = ok.c;
            }
            return ok.copy(str, str2, z);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        @NotNull
        public final Ok copy(@NotNull String str, @NotNull String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "login");
            Intrinsics.checkNotNullParameter(str2, "hash");
            return new Ok(str, str2, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ok)) {
                return false;
            }
            Ok ok = (Ok) obj;
            return Intrinsics.areEqual(this.a, ok.a) && Intrinsics.areEqual(this.b, ok.b) && this.c == ok.c;
        }

        @NotNull
        public final String getHash() {
            return this.b;
        }

        @NotNull
        public final String getLogin() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            int i2 = (hashCode + i) * 31;
            boolean z = this.c;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return i2 + i3;
        }

        public final boolean isPhoneUsed() {
            return this.c;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Ok(login=");
            L.append(this.a);
            L.append(", hash=");
            L.append(this.b);
            L.append(", isPhoneUsed=");
            return a.B(L, this.c, ")");
        }
    }

    public ConfirmedCodeData() {
    }

    public ConfirmedCodeData(j jVar) {
    }
}
