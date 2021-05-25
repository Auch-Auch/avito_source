package com.avito.android.in_app_calls.auth;

import com.avito.android.analytics.Analytics;
import com.avito.android.calls.Credentials;
import com.avito.android.calls.CredentialsStorage;
import com.avito.android.calls.auth.PushTokenRegistration;
import com.avito.android.calls_shared.di.CallsModule;
import com.avito.android.code_confirmation.Source;
import com.avito.android.in_app_calls.analytics.CallClientAuthorizationEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.avito.android.util.preferences.Preferences;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'B#\b\u0007\u0012\b\b\u0001\u00103\u001a\u000201\u0012\u0006\u00106\u001a\u000204\u0012\u0006\u0010<\u001a\u000209¢\u0006\u0004\b=\u0010>J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010 J\u0019\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b%\u0010&J\u0011\u0010'\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b'\u0010(J\u0011\u0010)\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b)\u0010(J#\u0010,\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010#2\b\u0010+\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b,\u0010-R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u00102R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u00105R\u0018\u00108\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/avito/android/in_app_calls/auth/CallClientCredentialsManager;", "Lcom/avito/android/calls/CredentialsStorage;", "", ChannelContext.Item.USER_ID, "", "setUserId", "(Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "name", "setUsername", "Lcom/avito/android/calls/Credentials;", "getCredentials", "()Lcom/avito/android/calls/Credentials;", SDKConstants.PARAM_ACCESS_TOKEN, "", "accessTokenExpiresIn", "refreshToken", "refreshTokenExpiresIn", "saveTokens", "(Ljava/lang/String;JLjava/lang/String;J)V", "Lcom/avito/android/calls/auth/PushTokenRegistration;", "getPushTokenRegistration", "()Lcom/avito/android/calls/auth/PushTokenRegistration;", Source.REGISTRATION, "savePushTokenRegistration", "(Lcom/avito/android/calls/auth/PushTokenRegistration;)V", "", "isNotified", "saveBackendNotified", "(Z)V", "clearAccessToken", "()V", "clearTokens", "clearAll", "Lcom/avito/android/in_app_calls/auth/CallClientCredentialsManager$a;", "data", "d", "(Lcom/avito/android/in_app_calls/auth/CallClientCredentialsManager$a;)V", AuthSource.SEND_ABUSE, "()Lcom/avito/android/in_app_calls/auth/CallClientCredentialsManager$a;", AuthSource.BOOKING_ORDER, "prev", "cur", "c", "(Lcom/avito/android/in_app_calls/auth/CallClientCredentialsManager$a;Lcom/avito/android/in_app_calls/auth/CallClientCredentialsManager$a;)V", "", "Ljava/lang/Object;", "lock", "Lcom/avito/android/util/preferences/Preferences;", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/in_app_calls/auth/CallClientCredentialsManager$a;", "credentialsCache", "Lcom/avito/android/server_time/TimeSource;", "e", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "<init>", "(Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/server_time/TimeSource;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallClientCredentialsManager implements CredentialsStorage {
    public final Object a = new Object();
    @GuardedBy("lock")
    public a b;
    public final Preferences c;
    public final Analytics d;
    public final TimeSource e;

    public static final class a {
        @NotNull
        public final String a;
        @Nullable
        public final String b;
        public final long c;
        @Nullable
        public final String d;
        public final long e;

        public a(@NotNull String str, @Nullable String str2, long j, @Nullable String str3, long j2) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.a = str;
            this.b = str2;
            this.c = j;
            this.d = str3;
            this.e = j2;
        }

        public static a a(a aVar, String str, String str2, long j, String str3, long j2, int i) {
            String str4 = (i & 1) != 0 ? aVar.a : null;
            String str5 = (i & 2) != 0 ? aVar.b : str2;
            long j3 = (i & 4) != 0 ? aVar.c : j;
            String str6 = (i & 8) != 0 ? aVar.d : str3;
            long j4 = (i & 16) != 0 ? aVar.e : j2;
            Objects.requireNonNull(aVar);
            Intrinsics.checkNotNullParameter(str4, "name");
            return new a(str4, str5, j3, str6, j4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && this.c == aVar.c && Intrinsics.areEqual(this.d, aVar.d) && this.e == aVar.e;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + c.a(this.c)) * 31;
            String str3 = this.d;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return ((hashCode2 + i) * 31) + c.a(this.e);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("CredentialsData(name=");
            L.append(this.a);
            L.append(", accessToken=");
            L.append(this.b);
            L.append(", accessExpiresAt=");
            L.append(this.c);
            L.append(", refreshToken=");
            L.append(this.d);
            L.append(", refreshExpiresAt=");
            return a2.b.a.a.a.l(L, this.e, ")");
        }
    }

    @Inject
    public CallClientCredentialsManager(@CallsModule.InAppCallsPreferences @NotNull Preferences preferences, @NotNull Analytics analytics, @NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.c = preferences;
        this.d = analytics;
        this.e = timeSource;
    }

    public final a a() {
        String string = this.c.getString("calls.username");
        if (string != null) {
            return new a(string, this.c.getString("calls.access_token", null), this.c.getLong("calls.access_expires", 0), this.c.getString("calls.refresh_token", null), this.c.getLong("calls.refresh_expires", 0));
        }
        return null;
    }

    public final a b() {
        a a3 = a();
        this.b = a3;
        return a3;
    }

    public final void c(a aVar, a aVar2) {
        boolean z = true;
        boolean z2 = (aVar == null || aVar.d == null) ? false : true;
        if (aVar2 == null || aVar2.d == null) {
            z = false;
        }
        if (z != z2) {
            this.d.track(new CallClientAuthorizationEvent(z));
        }
    }

    @Override // com.avito.android.calls.CredentialsStorage
    public void clearAccessToken() {
        synchronized (this.a) {
            a aVar = this.b;
            if (aVar == null) {
                aVar = b();
            }
            if (aVar != null) {
                a a3 = a.a(aVar, null, null, 0, null, 0, 29);
                d(a3);
                c(aVar, a3);
            }
        }
    }

    @Override // com.avito.android.calls.CredentialsStorage
    public void clearAll() {
        synchronized (this.a) {
            a aVar = this.b;
            if (aVar == null) {
                aVar = a();
            }
            d(null);
            c(aVar, null);
        }
    }

    @Override // com.avito.android.calls.CredentialsStorage
    public void clearTokens() {
        synchronized (this.a) {
            a aVar = this.b;
            if (aVar == null) {
                aVar = b();
            }
            if (aVar != null) {
                a a3 = a.a(aVar, null, null, 0, null, 0, 21);
                d(a3);
                c(aVar, a3);
            }
        }
    }

    public final void d(a aVar) {
        if (aVar != null) {
            this.c.putString("calls.username", aVar.a);
            this.c.putString("calls.access_token", aVar.b);
            this.c.putLong("calls.access_expires", aVar.c);
            this.c.putString("calls.refresh_token", aVar.d);
            this.c.putLong("calls.refresh_expires", aVar.e);
            Logs.debug$default("CallClientCredentialsManager", "Credentials persisted", null, 4, null);
        } else {
            this.c.remove("calls.username");
            this.c.remove("calls.access_token");
            this.c.remove("calls.access_expires");
            this.c.remove("calls.refresh_token");
            this.c.remove("calls.refresh_expires");
            this.c.remove("calls.registration_status");
            this.c.remove("calls.push_token");
            this.c.remove("calls.backend_notified");
            Logs.debug$default("CallClientCredentialsManager", "Credentials cleared", null, 4, null);
        }
        this.b = aVar;
    }

    @Override // com.avito.android.calls.CredentialsStorage
    @NotNull
    public Credentials getCredentials() {
        a aVar;
        a aVar2 = this.b;
        if (aVar2 == null) {
            synchronized (this.a) {
                aVar = this.b;
                if (aVar == null) {
                    aVar = b();
                }
            }
            aVar2 = aVar;
        }
        if (aVar2 == null) {
            return Credentials.None.INSTANCE;
        }
        if (aVar2.b == null || aVar2.d == null) {
            return new Credentials.OneTimeKey(aVar2.a);
        }
        long now = this.e.now();
        if (aVar2.e <= now + 5000) {
            return new Credentials.OneTimeKey(aVar2.a);
        }
        String str = aVar2.a;
        String str2 = aVar2.b;
        if (!(aVar2.c >= now - 5000)) {
            str2 = null;
        }
        return new Credentials.AccessToken(str, str2, aVar2.d);
    }

    @Override // com.avito.android.calls.CredentialsStorage
    @NotNull
    public PushTokenRegistration getPushTokenRegistration() {
        PushTokenRegistration pushTokenRegistration;
        synchronized (this.a) {
            String string = this.c.getString("calls.push_token", null);
            String string2 = this.c.getString("calls.registration_status", null);
            if (string2 == null) {
                string2 = "none";
            }
            if (string != null) {
                int hashCode = string2.hashCode();
                if (hashCode != -1869930878) {
                    if (hashCode != 764647091) {
                        if (hashCode == 1113640428) {
                            if (string2.equals("pending_reg")) {
                                pushTokenRegistration = new PushTokenRegistration.PendingRegister(string);
                            }
                        }
                    } else if (string2.equals("pending_unreg")) {
                        pushTokenRegistration = new PushTokenRegistration.PendingUnregister(string);
                    }
                } else if (string2.equals("registered")) {
                    pushTokenRegistration = new PushTokenRegistration.Registered(string, this.c.getBoolean("calls.backend_notified", false));
                }
                pushTokenRegistration = new PushTokenRegistration.None(string);
            } else {
                pushTokenRegistration = new PushTokenRegistration.None(null);
            }
        }
        return pushTokenRegistration;
    }

    @Override // com.avito.android.calls.CredentialsStorage
    @Nullable
    public String getUsername() {
        a aVar;
        a aVar2 = this.b;
        if (aVar2 == null) {
            synchronized (this.a) {
                aVar = this.b;
                if (aVar == null) {
                    aVar = b();
                }
            }
            aVar2 = aVar;
        }
        if (aVar2 != null) {
            return aVar2.a;
        }
        return null;
    }

    @Override // com.avito.android.calls.CredentialsStorage
    public void saveBackendNotified(boolean z) {
        synchronized (this.a) {
            String string = this.c.getString("calls.registration_status", null);
            if (string == null) {
                string = "none";
            }
            if (Intrinsics.areEqual(string, "registered")) {
                this.c.putBoolean("calls.backend_notified", z);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.calls.CredentialsStorage
    public void savePushTokenRegistration(@NotNull PushTokenRegistration pushTokenRegistration) {
        String str;
        Intrinsics.checkNotNullParameter(pushTokenRegistration, Source.REGISTRATION);
        Logs.debug$default("CallClientCredentialsManager", "Save push token registration: " + pushTokenRegistration, null, 4, null);
        synchronized (this.a) {
            if (pushTokenRegistration instanceof PushTokenRegistration.None) {
                str = "none";
            } else if (pushTokenRegistration instanceof PushTokenRegistration.PendingRegister) {
                str = "pending_reg";
            } else if (pushTokenRegistration instanceof PushTokenRegistration.PendingUnregister) {
                str = "pending_unreg";
            } else if (pushTokenRegistration instanceof PushTokenRegistration.Registered) {
                str = "registered";
            } else {
                throw new NoWhenBranchMatchedException();
            }
            boolean z = (pushTokenRegistration instanceof PushTokenRegistration.Registered) && ((PushTokenRegistration.Registered) pushTokenRegistration).getBackendNotified();
            this.c.putString("calls.registration_status", str);
            this.c.putString("calls.push_token", pushTokenRegistration.getToken());
            this.c.putBoolean("calls.backend_notified", z);
        }
    }

    @Override // com.avito.android.calls.CredentialsStorage
    public void saveTokens(@NotNull String str, long j, @NotNull String str2, long j2) {
        a aVar;
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_ACCESS_TOKEN);
        Intrinsics.checkNotNullParameter(str2, "refreshToken");
        synchronized (this.a) {
            a aVar2 = this.b;
            if (aVar2 == null) {
                aVar2 = b();
            }
            if (aVar2 != null) {
                long now = this.e.now();
                a aVar3 = this.b;
                if (aVar3 == null) {
                    aVar3 = b();
                }
                if (aVar3 != null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    aVar = a.a(aVar3, null, str, timeUnit.toMillis(j) + now, str2, timeUnit.toMillis(j2) + now, 1);
                } else {
                    aVar = null;
                }
                d(aVar);
                c(aVar2, aVar);
            }
        }
    }

    @Override // com.avito.android.calls.CredentialsStorage
    public void setUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        synchronized (this.a) {
            if (!Intrinsics.areEqual(this.c.getString("calls.user_id", null), str)) {
                d(null);
                this.c.putString("calls.user_id", str);
                this.c.putString("calls.registration_status", "pending_reg");
                this.c.remove("calls.backend_notified");
                c(this.b, null);
            }
        }
    }

    @Override // com.avito.android.calls.CredentialsStorage
    public void setUsername(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        synchronized (this.a) {
            a aVar = this.b;
            if (aVar == null) {
                aVar = b();
            }
            if (!Intrinsics.areEqual(aVar != null ? aVar.a : null, str)) {
                a aVar2 = new a(str, null, 0, null, 0);
                d(aVar2);
                c(aVar, aVar2);
                this.b = aVar2;
            }
        }
    }
}
