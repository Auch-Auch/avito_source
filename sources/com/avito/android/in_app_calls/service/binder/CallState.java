package com.avito.android.in_app_calls.service.binder;

import a2.b.a.a.a;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.AppCallResult;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/in_app_calls/service/binder/CallState;", "", "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "()Lcom/avito/android/calls_shared/AppCallInfo;", "call", "<init>", "()V", "Connected", "Dialing", "Idle", "Ringing", "Lcom/avito/android/in_app_calls/service/binder/CallState$Idle;", "Lcom/avito/android/in_app_calls/service/binder/CallState$Ringing;", "Lcom/avito/android/in_app_calls/service/binder/CallState$Dialing;", "Lcom/avito/android/in_app_calls/service/binder/CallState$Connected;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public abstract class CallState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\r\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lcom/avito/android/in_app_calls/service/binder/CallState$Connected;", "Lcom/avito/android/in_app_calls/service/binder/CallState;", "Lcom/avito/android/calls_shared/AppCallInfo;", "component1", "()Lcom/avito/android/calls_shared/AppCallInfo;", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "call", "reconnectUrl", "isReconnecting", "copy", "(Lcom/avito/android/calls_shared/AppCallInfo;Ljava/lang/String;Z)Lcom/avito/android/in_app_calls/service/binder/CallState$Connected;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "c", "Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getReconnectUrl", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;Ljava/lang/String;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Connected extends CallState {
        @NotNull
        public final AppCallInfo a;
        @Nullable
        public final String b;
        public final boolean c;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Connected(AppCallInfo appCallInfo, String str, boolean z, int i, j jVar) {
            this(appCallInfo, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z);
        }

        public static /* synthetic */ Connected copy$default(Connected connected, AppCallInfo appCallInfo, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                appCallInfo = connected.getCall();
            }
            if ((i & 2) != 0) {
                str = connected.b;
            }
            if ((i & 4) != 0) {
                z = connected.c;
            }
            return connected.copy(appCallInfo, str, z);
        }

        @NotNull
        public final AppCallInfo component1() {
            return getCall();
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        @NotNull
        public final Connected copy(@NotNull AppCallInfo appCallInfo, @Nullable String str, boolean z) {
            Intrinsics.checkNotNullParameter(appCallInfo, "call");
            return new Connected(appCallInfo, str, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Connected)) {
                return false;
            }
            Connected connected = (Connected) obj;
            return Intrinsics.areEqual(getCall(), connected.getCall()) && Intrinsics.areEqual(this.b, connected.b) && this.c == connected.c;
        }

        @Override // com.avito.android.in_app_calls.service.binder.CallState
        @NotNull
        public AppCallInfo getCall() {
            return this.a;
        }

        @Nullable
        public final String getReconnectUrl() {
            return this.b;
        }

        public int hashCode() {
            AppCallInfo call = getCall();
            int i = 0;
            int hashCode = (call != null ? call.hashCode() : 0) * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
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

        public final boolean isReconnecting() {
            return this.c;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Connected(call=");
            L.append(getCall());
            L.append(", reconnectUrl=");
            L.append(this.b);
            L.append(", isReconnecting=");
            return a.B(L, this.c, ")");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Connected(@NotNull AppCallInfo appCallInfo, @Nullable String str, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(appCallInfo, "call");
            this.a = appCallInfo;
            this.b = str;
            this.c = z;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/in_app_calls/service/binder/CallState$Dialing;", "Lcom/avito/android/in_app_calls/service/binder/CallState;", "Lcom/avito/android/calls_shared/AppCallInfo;", "component1", "()Lcom/avito/android/calls_shared/AppCallInfo;", "call", "copy", "(Lcom/avito/android/calls_shared/AppCallInfo;)Lcom/avito/android/in_app_calls/service/binder/CallState$Dialing;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Dialing extends CallState {
        @NotNull
        public final AppCallInfo a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Dialing(@NotNull AppCallInfo appCallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(appCallInfo, "call");
            this.a = appCallInfo;
        }

        public static /* synthetic */ Dialing copy$default(Dialing dialing, AppCallInfo appCallInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                appCallInfo = dialing.getCall();
            }
            return dialing.copy(appCallInfo);
        }

        @NotNull
        public final AppCallInfo component1() {
            return getCall();
        }

        @NotNull
        public final Dialing copy(@NotNull AppCallInfo appCallInfo) {
            Intrinsics.checkNotNullParameter(appCallInfo, "call");
            return new Dialing(appCallInfo);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Dialing) && Intrinsics.areEqual(getCall(), ((Dialing) obj).getCall());
            }
            return true;
        }

        @Override // com.avito.android.in_app_calls.service.binder.CallState
        @NotNull
        public AppCallInfo getCall() {
            return this.a;
        }

        public int hashCode() {
            AppCallInfo call = getCall();
            if (call != null) {
                return call.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Dialing(call=");
            L.append(getCall());
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/service/binder/CallState$Idle;", "Lcom/avito/android/in_app_calls/service/binder/CallState;", "<init>", "()V", "Finished", "None", "Lcom/avito/android/in_app_calls/service/binder/CallState$Idle$None;", "Lcom/avito/android/in_app_calls/service/binder/CallState$Idle$Finished;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Idle extends CallState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/in_app_calls/service/binder/CallState$Idle$Finished;", "Lcom/avito/android/in_app_calls/service/binder/CallState$Idle;", "Lcom/avito/android/calls_shared/AppCallInfo;", "component1", "()Lcom/avito/android/calls_shared/AppCallInfo;", "Lcom/avito/android/calls_shared/AppCallResult;", "component2", "()Lcom/avito/android/calls_shared/AppCallResult;", "", "component3", "()Ljava/lang/String;", "call", "result", "reconnectUrl", "copy", "(Lcom/avito/android/calls_shared/AppCallInfo;Lcom/avito/android/calls_shared/AppCallResult;Ljava/lang/String;)Lcom/avito/android/in_app_calls/service/binder/CallState$Idle$Finished;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls_shared/AppCallResult;", "getResult", "c", "Ljava/lang/String;", "getReconnectUrl", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;Lcom/avito/android/calls_shared/AppCallResult;Ljava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Finished extends Idle {
            @NotNull
            public final AppCallInfo a;
            @NotNull
            public final AppCallResult b;
            @Nullable
            public final String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Finished(@NotNull AppCallInfo appCallInfo, @NotNull AppCallResult appCallResult, @Nullable String str) {
                super(null);
                Intrinsics.checkNotNullParameter(appCallInfo, "call");
                Intrinsics.checkNotNullParameter(appCallResult, "result");
                this.a = appCallInfo;
                this.b = appCallResult;
                this.c = str;
            }

            public static /* synthetic */ Finished copy$default(Finished finished, AppCallInfo appCallInfo, AppCallResult appCallResult, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    appCallInfo = finished.getCall();
                }
                if ((i & 2) != 0) {
                    appCallResult = finished.b;
                }
                if ((i & 4) != 0) {
                    str = finished.c;
                }
                return finished.copy(appCallInfo, appCallResult, str);
            }

            @NotNull
            public final AppCallInfo component1() {
                return getCall();
            }

            @NotNull
            public final AppCallResult component2() {
                return this.b;
            }

            @Nullable
            public final String component3() {
                return this.c;
            }

            @NotNull
            public final Finished copy(@NotNull AppCallInfo appCallInfo, @NotNull AppCallResult appCallResult, @Nullable String str) {
                Intrinsics.checkNotNullParameter(appCallInfo, "call");
                Intrinsics.checkNotNullParameter(appCallResult, "result");
                return new Finished(appCallInfo, appCallResult, str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Finished)) {
                    return false;
                }
                Finished finished = (Finished) obj;
                return Intrinsics.areEqual(getCall(), finished.getCall()) && Intrinsics.areEqual(this.b, finished.b) && Intrinsics.areEqual(this.c, finished.c);
            }

            @Override // com.avito.android.in_app_calls.service.binder.CallState
            @NotNull
            public AppCallInfo getCall() {
                return this.a;
            }

            @Nullable
            public final String getReconnectUrl() {
                return this.c;
            }

            @NotNull
            public final AppCallResult getResult() {
                return this.b;
            }

            public int hashCode() {
                AppCallInfo call = getCall();
                int i = 0;
                int hashCode = (call != null ? call.hashCode() : 0) * 31;
                AppCallResult appCallResult = this.b;
                int hashCode2 = (hashCode + (appCallResult != null ? appCallResult.hashCode() : 0)) * 31;
                String str = this.c;
                if (str != null) {
                    i = str.hashCode();
                }
                return hashCode2 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Finished(call=");
                L.append(getCall());
                L.append(", result=");
                L.append(this.b);
                L.append(", reconnectUrl=");
                return a.t(L, this.c, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/in_app_calls/service/binder/CallState$Idle$None;", "Lcom/avito/android/in_app_calls/service/binder/CallState$Idle;", "Lcom/avito/android/calls_shared/AppCallInfo;", "call", "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "()Lcom/avito/android/calls_shared/AppCallInfo;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class None extends Idle {
            @NotNull
            public static final None INSTANCE = new None();

            public None() {
                super(null);
            }

            @Override // com.avito.android.in_app_calls.service.binder.CallState
            @Nullable
            public AppCallInfo getCall() {
                return null;
            }
        }

        public Idle() {
            super(null);
        }

        public Idle(j jVar) {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/in_app_calls/service/binder/CallState$Ringing;", "Lcom/avito/android/in_app_calls/service/binder/CallState;", "Lcom/avito/android/calls_shared/AppCallInfo;", "component1", "()Lcom/avito/android/calls_shared/AppCallInfo;", "call", "copy", "(Lcom/avito/android/calls_shared/AppCallInfo;)Lcom/avito/android/in_app_calls/service/binder/CallState$Ringing;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls_shared/AppCallInfo;", "getCall", "<init>", "(Lcom/avito/android/calls_shared/AppCallInfo;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ringing extends CallState {
        @NotNull
        public final AppCallInfo a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ringing(@NotNull AppCallInfo appCallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(appCallInfo, "call");
            this.a = appCallInfo;
        }

        public static /* synthetic */ Ringing copy$default(Ringing ringing, AppCallInfo appCallInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                appCallInfo = ringing.getCall();
            }
            return ringing.copy(appCallInfo);
        }

        @NotNull
        public final AppCallInfo component1() {
            return getCall();
        }

        @NotNull
        public final Ringing copy(@NotNull AppCallInfo appCallInfo) {
            Intrinsics.checkNotNullParameter(appCallInfo, "call");
            return new Ringing(appCallInfo);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Ringing) && Intrinsics.areEqual(getCall(), ((Ringing) obj).getCall());
            }
            return true;
        }

        @Override // com.avito.android.in_app_calls.service.binder.CallState
        @NotNull
        public AppCallInfo getCall() {
            return this.a;
        }

        public int hashCode() {
            AppCallInfo call = getCall();
            if (call != null) {
                return call.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Ringing(call=");
            L.append(getCall());
            L.append(")");
            return L.toString();
        }
    }

    public CallState() {
    }

    @Nullable
    public abstract AppCallInfo getCall();

    public CallState(j jVar) {
    }
}
