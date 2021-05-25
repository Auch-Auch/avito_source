package com.avito.android.calls.voximplant;

import com.avito.android.calls.ConnectionListener;
import com.avito.android.calls.CredentialsStorage;
import com.avito.android.calls.voximplant.VoxCallClient;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import com.voximplant.sdk.client.AuthParams;
import com.voximplant.sdk.client.IClientLoginListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\n¨\u0006\u0013"}, d2 = {"com/avito/android/calls/voximplant/VoxCallClient$loginListener$1", "Lcom/voximplant/sdk/client/IClientLoginListener;", "Lcom/voximplant/sdk/client/AuthParams;", "authParams", "", "onRefreshTokenSuccess", "(Lcom/voximplant/sdk/client/AuthParams;)V", "Lcom/voximplant/sdk/client/LoginError;", "loginError", "onLoginFailed", "(Lcom/voximplant/sdk/client/LoginError;)V", "", "key", "onOneTimeKeyGenerated", "(Ljava/lang/String;)V", "displayName", "onLoginSuccessful", "(Ljava/lang/String;Lcom/voximplant/sdk/client/AuthParams;)V", "onRefreshTokenFailed", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class VoxCallClient$loginListener$1 implements IClientLoginListener {
    public final /* synthetic */ VoxCallClient a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VoxCallClient$loginListener$1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(VoxCallClient$loginListener$1 voxCallClient$loginListener$1) {
            super(0);
            this.a = voxCallClient$loginListener$1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (this.a.a.c > 0) {
                VoxCallClient voxCallClient = this.a.a;
                voxCallClient.c = voxCallClient.c - 1;
                VoxCallClient.access$performLogin(this.a.a);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VoxCallClient$loginListener$1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(VoxCallClient$loginListener$1 voxCallClient$loginListener$1) {
            super(0);
            this.a = voxCallClient$loginListener$1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (this.a.a.c > 0) {
                VoxCallClient voxCallClient = this.a.a;
                voxCallClient.c = voxCallClient.c - 1;
                this.a.a.d(null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public VoxCallClient$loginListener$1(VoxCallClient voxCallClient) {
        this.a = voxCallClient;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009a, code lost:
        if (r3 != 8) goto L_0x009c;
     */
    @Override // com.voximplant.sdk.client.IClientLoginListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLoginFailed(@org.jetbrains.annotations.Nullable com.voximplant.sdk.client.LoginError r9) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 91
            java.lang.StringBuilder r1 = a2.b.a.a.a.I(r1)
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            java.lang.String r3 = "Thread.currentThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            r2 = 93
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.String r1 = " Login failed: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "VoxCallClient"
            r2 = 0
            com.avito.android.util.Logs.debug(r1, r0, r2)
            com.avito.android.calls.voximplant.VoxCallClient r0 = r8.a
            com.avito.android.calls.ConnectionListener r0 = com.avito.android.calls.voximplant.VoxCallClient.access$getConnectionListener$p(r0)
            if (r0 == 0) goto L_0x0046
            com.avito.android.calls.ConnectionListener$DisconnectReason r3 = com.avito.android.calls.ConnectionListener.DisconnectReason.LOGIN_FAILED
            r0.onClientDisconnected(r3)
        L_0x0046:
            com.avito.android.calls.voximplant.VoxCallClient r0 = r8.a
            com.avito.android.calls.analytics.CallAnalyticsTracker r0 = com.avito.android.calls.voximplant.VoxCallClient.access$getAnalyticsTracker$p(r0)
            if (r9 == 0) goto L_0x0076
            int r3 = r9.ordinal()
            switch(r3) {
                case 0: goto L_0x0073;
                case 1: goto L_0x0070;
                case 2: goto L_0x006d;
                case 3: goto L_0x006a;
                case 4: goto L_0x0067;
                case 5: goto L_0x0064;
                case 6: goto L_0x0061;
                case 7: goto L_0x005e;
                case 8: goto L_0x005b;
                default: goto L_0x0055;
            }
        L_0x0055:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        L_0x005b:
            java.lang.String r3 = "timeout"
            goto L_0x0078
        L_0x005e:
            java.lang.String r3 = "token"
            goto L_0x0078
        L_0x0061:
            java.lang.String r3 = "network"
            goto L_0x0078
        L_0x0064:
            java.lang.String r3 = "limit"
            goto L_0x0078
        L_0x0067:
            java.lang.String r3 = "state"
            goto L_0x0078
        L_0x006a:
            java.lang.String r3 = "internal"
            goto L_0x0078
        L_0x006d:
            java.lang.String r3 = "frozen"
            goto L_0x0078
        L_0x0070:
            java.lang.String r3 = "username"
            goto L_0x0078
        L_0x0073:
            java.lang.String r3 = "password"
            goto L_0x0078
        L_0x0076:
            java.lang.String r3 = "null"
        L_0x0078:
            r0.trackLoginError(r3)
            com.avito.android.calls.voximplant.VoxCallClient r0 = r8.a
            long r3 = com.avito.android.calls.voximplant.VoxCallClient.access$getRetryCount$p(r0)
            r5 = 0
            r0 = 1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d3
            if (r9 != 0) goto L_0x008b
            goto L_0x009c
        L_0x008b:
            int r3 = r9.ordinal()
            r4 = 3
            if (r3 == r4) goto L_0x00c6
            r4 = 6
            if (r3 == r4) goto L_0x00c6
            r4 = 7
            if (r3 == r4) goto L_0x00b7
            r4 = 8
            if (r3 == r4) goto L_0x00c6
        L_0x009c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Disconnecting due to unrecoverable error "
            r3.append(r4)
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            r3 = 4
            com.avito.android.util.Logs.error$default(r1, r9, r2, r3, r2)
            com.avito.android.calls.voximplant.VoxCallClient r9 = r8.a
            r9.disconnect(r0)
            goto L_0x00d8
        L_0x00b7:
            com.avito.android.calls.voximplant.VoxCallClient r9 = r8.a
            com.avito.android.calls.CredentialsStorage r9 = com.avito.android.calls.voximplant.VoxCallClient.access$getCredentialsStorage$p(r9)
            r9.clearAccessToken()
            com.avito.android.calls.voximplant.VoxCallClient r9 = r8.a
            r9.d(r2)
            goto L_0x00d8
        L_0x00c6:
            com.avito.android.calls.voximplant.VoxCallClient r9 = r8.a
            r0 = 3
            com.avito.android.calls.voximplant.VoxCallClient$loginListener$1$a r2 = new com.avito.android.calls.voximplant.VoxCallClient$loginListener$1$a
            r2.<init>(r8)
            com.avito.android.calls.voximplant.VoxCallClient.access$scheduleWithDelay(r9, r0, r2)
            goto L_0x00d8
        L_0x00d3:
            com.avito.android.calls.voximplant.VoxCallClient r9 = r8.a
            r9.disconnect(r0)
        L_0x00d8:
            return
            switch-data {0->0x0073, 1->0x0070, 2->0x006d, 3->0x006a, 4->0x0067, 5->0x0064, 6->0x0061, 7->0x005e, 8->0x005b, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.calls.voximplant.VoxCallClient$loginListener$1.onLoginFailed(com.voximplant.sdk.client.LoginError):void");
    }

    @Override // com.voximplant.sdk.client.IClientLoginListener
    public void onLoginSuccessful(@Nullable String str, @Nullable AuthParams authParams) {
        Logs.debug(LogTagsKt.TAG_VOX_CLIENT, a2.b.a.a.a.g("Thread.currentThread()", a2.b.a.a.a.I('['), ']', new StringBuilder(), " Login successful"), null);
        if (this.a.d.getClearOnSuccess()) {
            this.a.c = 0;
        }
        if (authParams != null) {
            try {
                CredentialsStorage credentialsStorage = this.a.j;
                String accessToken = authParams.getAccessToken();
                Intrinsics.checkNotNullExpressionValue(accessToken, "authParams.accessToken");
                String refreshToken = authParams.getRefreshToken();
                Intrinsics.checkNotNullExpressionValue(refreshToken, "authParams.refreshToken");
                credentialsStorage.saveTokens(accessToken, (long) authParams.getAccessTokenTimeExpired(), refreshToken, (long) authParams.getRefreshTokenTimeExpired());
            } catch (Exception e) {
                Logs.error(LogTagsKt.TAG_VOX_CLIENT, "Failed to save auth tokens", e);
            }
        }
        ConnectionListener connectionListener = this.a.g;
        if (connectionListener != null) {
            connectionListener.onClientConnected();
        }
        this.a.p.trackLoginSuccess();
        this.a.c();
    }

    @Override // com.voximplant.sdk.client.IClientLoginListener
    public void onOneTimeKeyGenerated(@Nullable String str) {
        Logs.debug(LogTagsKt.TAG_VOX_CLIENT, a2.b.a.a.a.g("Thread.currentThread()", a2.b.a.a.a.I('['), ']', new StringBuilder(), " One-time key generated"), null);
        if (str == null) {
            Logs.error$default(LogTagsKt.TAG_VOX_CLIENT, "Disconnecting due to unexpected one-time key: null", null, 4, null);
            this.a.disconnect(true);
        } else if (this.a.d != VoxCallClient.Command.DISCONNECT) {
            try {
                VoxCallClient.access$requestOneTimeLoginKey(this.a, str);
            } catch (Exception e) {
                Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "One-key request failed", e);
                this.a.disconnect(true);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008e, code lost:
        if (r3 != 8) goto L_0x0090;
     */
    @Override // com.voximplant.sdk.client.IClientLoginListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRefreshTokenFailed(@org.jetbrains.annotations.Nullable com.voximplant.sdk.client.LoginError r11) {
        /*
        // Method dump skipped, instructions count: 344
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.calls.voximplant.VoxCallClient$loginListener$1.onRefreshTokenFailed(com.voximplant.sdk.client.LoginError):void");
    }

    @Override // com.voximplant.sdk.client.IClientLoginListener
    public void onRefreshTokenSuccess(@Nullable AuthParams authParams) {
        String str = null;
        Logs.debug(LogTagsKt.TAG_VOX_CLIENT, a2.b.a.a.a.g("Thread.currentThread()", a2.b.a.a.a.I('['), ']', new StringBuilder(), " Access tokens refreshed"), null);
        String accessToken = authParams != null ? authParams.getAccessToken() : null;
        if (authParams != null) {
            str = authParams.getRefreshToken();
        }
        if (accessToken == null || str == null) {
            this.a.p.trackRefreshTokenError("bad_auth_params");
            this.a.disconnect(true);
            return;
        }
        try {
            this.a.j.saveTokens(accessToken, (long) authParams.getAccessTokenTimeExpired(), str, (long) authParams.getRefreshTokenTimeExpired());
            this.a.p.trackRefreshTokenSuccess();
            if (this.a.d != VoxCallClient.Command.DISCONNECT) {
                VoxCallClient.access$performLogin(this.a);
            }
        } catch (Exception e) {
            this.a.p.trackRefreshTokenError("storage");
            Logs.error(LogTagsKt.TAG_VOX_CLIENT, "Disconnecting due to failure during tokens storage after refresh", e);
            this.a.disconnect(true);
        }
    }
}
