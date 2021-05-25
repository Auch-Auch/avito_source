package com.avito.android.remote.model.recover_by_phone;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/recover_by_phone/ConfirmPasswordRecoveryByPhoneResult;", "", "<init>", "()V", "Failure", "IncorrectData", "Ok", "Lcom/avito/android/remote/model/recover_by_phone/ConfirmPasswordRecoveryByPhoneResult$Ok;", "Lcom/avito/android/remote/model/recover_by_phone/ConfirmPasswordRecoveryByPhoneResult$Failure;", "Lcom/avito/android/remote/model/recover_by_phone/ConfirmPasswordRecoveryByPhoneResult$IncorrectData;", "profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class ConfirmPasswordRecoveryByPhoneResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/recover_by_phone/ConfirmPasswordRecoveryByPhoneResult$Failure;", "Lcom/avito/android/remote/model/recover_by_phone/ConfirmPasswordRecoveryByPhoneResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Failure extends ConfirmPasswordRecoveryByPhoneResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failure(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/recover_by_phone/ConfirmPasswordRecoveryByPhoneResult$IncorrectData;", "Lcom/avito/android/remote/model/recover_by_phone/ConfirmPasswordRecoveryByPhoneResult;", "", "", "messages", "Ljava/util/Map;", "getMessages", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class IncorrectData extends ConfirmPasswordRecoveryByPhoneResult {
        @SerializedName("messages")
        @NotNull
        private final Map<String, String> messages;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IncorrectData(@NotNull Map<String, String> map) {
            super(null);
            Intrinsics.checkNotNullParameter(map, "messages");
            this.messages = map;
        }

        @NotNull
        public final Map<String, String> getMessages() {
            return this.messages;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/recover_by_phone/ConfirmPasswordRecoveryByPhoneResult$Ok;", "Lcom/avito/android/remote/model/recover_by_phone/ConfirmPasswordRecoveryByPhoneResult;", "", "hash", "Ljava/lang/String;", "getHash", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends ConfirmPasswordRecoveryByPhoneResult {
        @SerializedName("hash")
        @NotNull
        private final String hash;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "hash");
            this.hash = str;
        }

        @NotNull
        public final String getHash() {
            return this.hash;
        }
    }

    private ConfirmPasswordRecoveryByPhoneResult() {
    }

    public /* synthetic */ ConfirmPasswordRecoveryByPhoneResult(j jVar) {
        this();
    }
}
