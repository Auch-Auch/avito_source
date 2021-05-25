package com.avito.android.calls.auth;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.AppleSignInManagerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/calls/auth/PushTokenRegistration;", "", "", "getToken", "()Ljava/lang/String;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "<init>", "()V", "None", "PendingRegister", "PendingUnregister", "Registered", "Lcom/avito/android/calls/auth/PushTokenRegistration$None;", "Lcom/avito/android/calls/auth/PushTokenRegistration$PendingRegister;", "Lcom/avito/android/calls/auth/PushTokenRegistration$PendingUnregister;", "Lcom/avito/android/calls/auth/PushTokenRegistration$Registered;", "calls_release"}, k = 1, mv = {1, 4, 2})
public abstract class PushTokenRegistration {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/calls/auth/PushTokenRegistration$None;", "Lcom/avito/android/calls/auth/PushTokenRegistration;", "", "component1", "()Ljava/lang/String;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "copy", "(Ljava/lang/String;)Lcom/avito/android/calls/auth/PushTokenRegistration$None;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getToken", "<init>", "(Ljava/lang/String;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class None extends PushTokenRegistration {
        @Nullable
        public final String a;

        public None(@Nullable String str) {
            super(null);
            this.a = str;
        }

        public static /* synthetic */ None copy$default(None none, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = none.getToken();
            }
            return none.copy(str);
        }

        @Nullable
        public final String component1() {
            return getToken();
        }

        @NotNull
        public final None copy(@Nullable String str) {
            return new None(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof None) && Intrinsics.areEqual(getToken(), ((None) obj).getToken());
            }
            return true;
        }

        @Override // com.avito.android.calls.auth.PushTokenRegistration
        @Nullable
        public String getToken() {
            return this.a;
        }

        public int hashCode() {
            String token = getToken();
            if (token != null) {
                return token.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("None(token=");
            L.append(getToken());
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/calls/auth/PushTokenRegistration$PendingRegister;", "Lcom/avito/android/calls/auth/PushTokenRegistration;", "", "component1", "()Ljava/lang/String;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "copy", "(Ljava/lang/String;)Lcom/avito/android/calls/auth/PushTokenRegistration$PendingRegister;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getToken", "<init>", "(Ljava/lang/String;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class PendingRegister extends PushTokenRegistration {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PendingRegister(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            this.a = str;
        }

        public static /* synthetic */ PendingRegister copy$default(PendingRegister pendingRegister, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pendingRegister.getToken();
            }
            return pendingRegister.copy(str);
        }

        @NotNull
        public final String component1() {
            return getToken();
        }

        @NotNull
        public final PendingRegister copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            return new PendingRegister(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof PendingRegister) && Intrinsics.areEqual(getToken(), ((PendingRegister) obj).getToken());
            }
            return true;
        }

        @Override // com.avito.android.calls.auth.PushTokenRegistration
        @NotNull
        public String getToken() {
            return this.a;
        }

        public int hashCode() {
            String token = getToken();
            if (token != null) {
                return token.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("PendingRegister(token=");
            L.append(getToken());
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/calls/auth/PushTokenRegistration$PendingUnregister;", "Lcom/avito/android/calls/auth/PushTokenRegistration;", "", "component1", "()Ljava/lang/String;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "copy", "(Ljava/lang/String;)Lcom/avito/android/calls/auth/PushTokenRegistration$PendingUnregister;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getToken", "<init>", "(Ljava/lang/String;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class PendingUnregister extends PushTokenRegistration {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PendingUnregister(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            this.a = str;
        }

        public static /* synthetic */ PendingUnregister copy$default(PendingUnregister pendingUnregister, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pendingUnregister.getToken();
            }
            return pendingUnregister.copy(str);
        }

        @NotNull
        public final String component1() {
            return getToken();
        }

        @NotNull
        public final PendingUnregister copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            return new PendingUnregister(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof PendingUnregister) && Intrinsics.areEqual(getToken(), ((PendingUnregister) obj).getToken());
            }
            return true;
        }

        @Override // com.avito.android.calls.auth.PushTokenRegistration
        @NotNull
        public String getToken() {
            return this.a;
        }

        public int hashCode() {
            String token = getToken();
            if (token != null) {
                return token.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("PendingUnregister(token=");
            L.append(getToken());
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/calls/auth/PushTokenRegistration$Registered;", "Lcom/avito/android/calls/auth/PushTokenRegistration;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "backendNotified", "copy", "(Ljava/lang/String;Z)Lcom/avito/android/calls/auth/PushTokenRegistration$Registered;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Z", "getBackendNotified", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getToken", "<init>", "(Ljava/lang/String;Z)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Registered extends PushTokenRegistration {
        @NotNull
        public final String a;
        public final boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Registered(@NotNull String str, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            this.a = str;
            this.b = z;
        }

        public static /* synthetic */ Registered copy$default(Registered registered, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = registered.getToken();
            }
            if ((i & 2) != 0) {
                z = registered.b;
            }
            return registered.copy(str, z);
        }

        @NotNull
        public final String component1() {
            return getToken();
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final Registered copy(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            return new Registered(str, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Registered)) {
                return false;
            }
            Registered registered = (Registered) obj;
            return Intrinsics.areEqual(getToken(), registered.getToken()) && this.b == registered.b;
        }

        public final boolean getBackendNotified() {
            return this.b;
        }

        @Override // com.avito.android.calls.auth.PushTokenRegistration
        @NotNull
        public String getToken() {
            return this.a;
        }

        public int hashCode() {
            String token = getToken();
            int hashCode = (token != null ? token.hashCode() : 0) * 31;
            boolean z = this.b;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Registered(token=");
            L.append(getToken());
            L.append(", backendNotified=");
            return a.B(L, this.b, ")");
        }
    }

    public PushTokenRegistration() {
    }

    @Nullable
    public abstract String getToken();

    public PushTokenRegistration(j jVar) {
    }
}
