package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.avito.android.remote.model.registration.RegisteredProfile;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/SocialAuthResult;", "", "<init>", "()V", "AccountSuggest", "Ok", "WrongSocialUser", "Lcom/avito/android/remote/model/SocialAuthResult$Ok;", "Lcom/avito/android/remote/model/SocialAuthResult$WrongSocialUser;", "Lcom/avito/android/remote/model/SocialAuthResult$AccountSuggest;", "profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class SocialAuthResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/model/SocialAuthResult$AccountSuggest;", "Lcom/avito/android/remote/model/SocialAuthResult;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/registration/RegisteredProfile;", "accountList", "Ljava/util/List;", "getAccountList", "()Ljava/util/List;", "suggestKey", "getSuggestKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class AccountSuggest extends SocialAuthResult {
        @SerializedName("accountList")
        @NotNull
        private final List<RegisteredProfile> accountList;
        @SerializedName("suggestKey")
        @NotNull
        private final String suggestKey;
        @SerializedName("title")
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AccountSuggest(@NotNull String str, @NotNull String str2, @NotNull List<RegisteredProfile> list) {
            super(null);
            a.c1(str, "title", str2, "suggestKey", list, "accountList");
            this.title = str;
            this.suggestKey = str2;
            this.accountList = list;
        }

        @NotNull
        public final List<RegisteredProfile> getAccountList() {
            return this.accountList;
        }

        @NotNull
        public final String getSuggestKey() {
            return this.suggestKey;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/SocialAuthResult$Ok;", "Lcom/avito/android/remote/model/SocialAuthResult;", "Lcom/avito/android/remote/model/AuthResult;", "authResult", "Lcom/avito/android/remote/model/AuthResult;", "getAuthResult", "()Lcom/avito/android/remote/model/AuthResult;", "<init>", "(Lcom/avito/android/remote/model/AuthResult;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends SocialAuthResult {
        @NotNull
        private final AuthResult authResult;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull AuthResult authResult2) {
            super(null);
            Intrinsics.checkNotNullParameter(authResult2, "authResult");
            this.authResult = authResult2;
        }

        @NotNull
        public final AuthResult getAuthResult() {
            return this.authResult;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/SocialAuthResult$WrongSocialUser;", "Lcom/avito/android/remote/model/SocialAuthResult;", "Lcom/avito/android/remote/model/UserDialog;", "userDialog", "Lcom/avito/android/remote/model/UserDialog;", "getUserDialog", "()Lcom/avito/android/remote/model/UserDialog;", "<init>", "(Lcom/avito/android/remote/model/UserDialog;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class WrongSocialUser extends SocialAuthResult {
        @SerializedName("userDialog")
        @NotNull
        private final UserDialog userDialog;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WrongSocialUser(@NotNull UserDialog userDialog2) {
            super(null);
            Intrinsics.checkNotNullParameter(userDialog2, "userDialog");
            this.userDialog = userDialog2;
        }

        @NotNull
        public final UserDialog getUserDialog() {
            return this.userDialog;
        }
    }

    private SocialAuthResult() {
    }

    public /* synthetic */ SocialAuthResult(j jVar) {
        this();
    }
}
