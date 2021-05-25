package com.avito.android.code_confirmation.phone_confirm;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo;", "", "<init>", "()V", "Error", "LandlinePhone", "Ok", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo$Ok;", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo$LandlinePhone;", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo$Error;", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public abstract class PhoneCodeInfo {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo$Error;", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo$Error;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends PhoneCodeInfo {
        @Nullable
        public final String a;

        public Error(@Nullable String str) {
            super(null);
            this.a = str;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.a;
            }
            return error.copy(str);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Error copy(@Nullable String str) {
            return new Error(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Error) && Intrinsics.areEqual(this.a, ((Error) obj).a);
            }
            return true;
        }

        @Nullable
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo$LandlinePhone;", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo$LandlinePhone;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
    public static final class LandlinePhone extends PhoneCodeInfo {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LandlinePhone(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deeplink");
            this.a = deepLink;
        }

        public static /* synthetic */ LandlinePhone copy$default(LandlinePhone landlinePhone, DeepLink deepLink, int i, Object obj) {
            if ((i & 1) != 0) {
                deepLink = landlinePhone.a;
            }
            return landlinePhone.copy(deepLink);
        }

        @NotNull
        public final DeepLink component1() {
            return this.a;
        }

        @NotNull
        public final LandlinePhone copy(@NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(deepLink, "deeplink");
            return new LandlinePhone(deepLink);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof LandlinePhone) && Intrinsics.areEqual(this.a, ((LandlinePhone) obj).a);
            }
            return true;
        }

        @NotNull
        public final DeepLink getDeeplink() {
            return this.a;
        }

        public int hashCode() {
            DeepLink deepLink = this.a;
            if (deepLink != null) {
                return deepLink.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.m(a.L("LandlinePhone(deeplink="), this.a, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo$Ok;", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo;", "", "component1", "()J", "", "component2", "()I", "timeout", "length", "copy", "(JI)Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo$Ok;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getLength", AuthSource.SEND_ABUSE, "J", "getTimeout", "<init>", "(JI)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends PhoneCodeInfo {
        public final long a;
        public final int b;

        public Ok(long j, int i) {
            super(null);
            this.a = j;
            this.b = i;
        }

        public static /* synthetic */ Ok copy$default(Ok ok, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = ok.a;
            }
            if ((i2 & 2) != 0) {
                i = ok.b;
            }
            return ok.copy(j, i);
        }

        public final long component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final Ok copy(long j, int i) {
            return new Ok(j, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ok)) {
                return false;
            }
            Ok ok = (Ok) obj;
            return this.a == ok.a && this.b == ok.b;
        }

        public final int getLength() {
            return this.b;
        }

        public final long getTimeout() {
            return this.a;
        }

        public int hashCode() {
            return (c.a(this.a) * 31) + this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Ok(timeout=");
            L.append(this.a);
            L.append(", length=");
            return a.j(L, this.b, ")");
        }
    }

    public PhoneCodeInfo() {
    }

    public PhoneCodeInfo(j jVar) {
    }
}
