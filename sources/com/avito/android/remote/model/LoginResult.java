package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/LoginResult;", "", "<init>", "()V", "AntihackCheck", "AntihackCheckPhone", "FailedWithDialog", "FailedWithMessage", "FailedWithMessages", "NeedPhoneVerification", "Ok", "TfaCheck", "Lcom/avito/android/remote/model/LoginResult$Ok;", "Lcom/avito/android/remote/model/LoginResult$AntihackCheck;", "Lcom/avito/android/remote/model/LoginResult$AntihackCheckPhone;", "Lcom/avito/android/remote/model/LoginResult$FailedWithMessage;", "Lcom/avito/android/remote/model/LoginResult$FailedWithMessages;", "Lcom/avito/android/remote/model/LoginResult$FailedWithDialog;", "Lcom/avito/android/remote/model/LoginResult$NeedPhoneVerification;", "Lcom/avito/android/remote/model/LoginResult$TfaCheck;", "profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class LoginResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/LoginResult$AntihackCheck;", "Lcom/avito/android/remote/model/LoginResult;", "", "phoneMask", "Ljava/lang/String;", "getPhoneMask", "()Ljava/lang/String;", "challengeId", "getChallengeId", "", "phoneList", "Ljava/util/List;", "getPhoneList", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class AntihackCheck extends LoginResult {
        @SerializedName("challengeId")
        @NotNull
        private final String challengeId;
        @SerializedName("phoneList")
        @Nullable
        private final List<String> phoneList;
        @SerializedName("phoneMask")
        @Nullable
        private final String phoneMask;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AntihackCheck(@Nullable String str, @NotNull String str2, @Nullable List<String> list) {
            super(null);
            Intrinsics.checkNotNullParameter(str2, "challengeId");
            this.phoneMask = str;
            this.challengeId = str2;
            this.phoneList = list;
        }

        @NotNull
        public final String getChallengeId() {
            return this.challengeId;
        }

        @Nullable
        public final List<String> getPhoneList() {
            return this.phoneList;
        }

        @Nullable
        public final String getPhoneMask() {
            return this.phoneMask;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/LoginResult$AntihackCheckPhone;", "Lcom/avito/android/remote/model/LoginResult;", "", "challengeId", "Ljava/lang/String;", "getChallengeId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class AntihackCheckPhone extends LoginResult {
        @NotNull
        private final String challengeId;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AntihackCheckPhone(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "challengeId");
            this.challengeId = str;
        }

        @NotNull
        public final String getChallengeId() {
            return this.challengeId;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/LoginResult$FailedWithDialog;", "Lcom/avito/android/remote/model/LoginResult;", "Lcom/avito/android/remote/model/UserDialog;", "userDialog", "Lcom/avito/android/remote/model/UserDialog;", "getUserDialog", "()Lcom/avito/android/remote/model/UserDialog;", "<init>", "(Lcom/avito/android/remote/model/UserDialog;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class FailedWithDialog extends LoginResult {
        @SerializedName("userDialog")
        @NotNull
        private final UserDialog userDialog;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FailedWithDialog(@NotNull UserDialog userDialog2) {
            super(null);
            Intrinsics.checkNotNullParameter(userDialog2, "userDialog");
            this.userDialog = userDialog2;
        }

        @NotNull
        public final UserDialog getUserDialog() {
            return this.userDialog;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/LoginResult$FailedWithMessage;", "Lcom/avito/android/remote/model/LoginResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class FailedWithMessage extends LoginResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FailedWithMessage(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/LoginResult$FailedWithMessages;", "Lcom/avito/android/remote/model/LoginResult;", "", "", "messages", "Ljava/util/Map;", "getMessages", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class FailedWithMessages extends LoginResult {
        @SerializedName("messages")
        @NotNull
        private final Map<String, String> messages;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FailedWithMessages(@NotNull Map<String, String> map) {
            super(null);
            Intrinsics.checkNotNullParameter(map, "messages");
            this.messages = map;
        }

        @NotNull
        public final Map<String, String> getMessages() {
            return this.messages;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/LoginResult$NeedPhoneVerification;", "Lcom/avito/android/remote/model/LoginResult;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class NeedPhoneVerification extends LoginResult {
        public NeedPhoneVerification() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/LoginResult$Ok;", "Lcom/avito/android/remote/model/LoginResult;", "Lcom/avito/android/remote/model/AuthResult;", "authResult", "Lcom/avito/android/remote/model/AuthResult;", "getAuthResult", "()Lcom/avito/android/remote/model/AuthResult;", "<init>", "(Lcom/avito/android/remote/model/AuthResult;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends LoginResult {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/LoginResult$TfaCheck;", "Lcom/avito/android/remote/model/LoginResult;", "", "", "phoneList", "Ljava/util/List;", "getPhoneList", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class TfaCheck extends LoginResult {
        @SerializedName("phoneList")
        @NotNull
        private final List<String> phoneList;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TfaCheck(@NotNull List<String> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "phoneList");
            this.phoneList = list;
        }

        @NotNull
        public final List<String> getPhoneList() {
            return this.phoneList;
        }
    }

    private LoginResult() {
    }

    public /* synthetic */ LoginResult(j jVar) {
        this();
    }
}
