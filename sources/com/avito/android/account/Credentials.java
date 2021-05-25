package com.avito.android.account;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.preferences.Preference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/account/Credentials;", "", "<init>", "()V", "PasswordCredentials", "SignInServiceCredentials", "Lcom/avito/android/account/Credentials$PasswordCredentials;", "Lcom/avito/android/account/Credentials$SignInServiceCredentials;", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public abstract class Credentials {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/account/Credentials$PasswordCredentials;", "Lcom/avito/android/account/Credentials;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUserName", "()Ljava/lang/String;", "userName", AuthSource.BOOKING_ORDER, "getPassword", Preference.PASSWORD, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
    public static final class PasswordCredentials extends Credentials {
        @NotNull
        public final String a;
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PasswordCredentials(@NotNull String str, @NotNull String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "userName");
            Intrinsics.checkNotNullParameter(str2, Preference.PASSWORD);
            this.a = str;
            this.b = str2;
        }

        @NotNull
        public final String getPassword() {
            return this.b;
        }

        @NotNull
        public final String getUserName() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/account/Credentials$SignInServiceCredentials;", "Lcom/avito/android/account/Credentials;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSocialNetworkType", "()Ljava/lang/String;", "socialNetworkType", "AppleCredentials", "SocialCredentials", "Lcom/avito/android/account/Credentials$SignInServiceCredentials$SocialCredentials;", "Lcom/avito/android/account/Credentials$SignInServiceCredentials$AppleCredentials;", "account-storage_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class SignInServiceCredentials extends Credentials {
        @NotNull
        public final String a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/account/Credentials$SignInServiceCredentials$AppleCredentials;", "Lcom/avito/android/account/Credentials$SignInServiceCredentials;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "c", "getUser", "user", "socialNetworkType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
        public static final class AppleCredentials extends SignInServiceCredentials {
            @NotNull
            public final String b;
            @Nullable
            public final String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AppleCredentials(@NotNull String str, @Nullable String str2, @NotNull String str3) {
                super(str3, null);
                Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
                Intrinsics.checkNotNullParameter(str3, "socialNetworkType");
                this.b = str;
                this.c = str2;
            }

            @NotNull
            public final String getToken() {
                return this.b;
            }

            @Nullable
            public final String getUser() {
                return this.c;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/account/Credentials$SignInServiceCredentials$SocialCredentials;", "Lcom/avito/android/account/Credentials$SignInServiceCredentials;", "", "c", "Ljava/lang/String;", "getEmail", "()Ljava/lang/String;", "email", AuthSource.BOOKING_ORDER, "getToken", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "socialNetworkType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
        public static final class SocialCredentials extends SignInServiceCredentials {
            @NotNull
            public final String b;
            @Nullable
            public final String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SocialCredentials(@NotNull String str, @Nullable String str2, @NotNull String str3) {
                super(str3, null);
                Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
                Intrinsics.checkNotNullParameter(str3, "socialNetworkType");
                this.b = str;
                this.c = str2;
            }

            @Nullable
            public final String getEmail() {
                return this.c;
            }

            @NotNull
            public final String getToken() {
                return this.b;
            }
        }

        public SignInServiceCredentials(String str, j jVar) {
            super(null);
            this.a = str;
        }

        @NotNull
        public final String getSocialNetworkType() {
            return this.a;
        }
    }

    public Credentials() {
    }

    public Credentials(j jVar) {
    }
}
