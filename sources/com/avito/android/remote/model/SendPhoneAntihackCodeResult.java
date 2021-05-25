package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult;", "", "<init>", "()V", "FailedWithDialog", "Failure", "IncorrectData", "Ok", "Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult$Ok;", "Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult$Failure;", "Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult$IncorrectData;", "Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult$FailedWithDialog;", "profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class SendPhoneAntihackCodeResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult$FailedWithDialog;", "Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult;", "Lcom/avito/android/remote/model/UserDialog;", "userDialog", "Lcom/avito/android/remote/model/UserDialog;", "getUserDialog", "()Lcom/avito/android/remote/model/UserDialog;", "<init>", "(Lcom/avito/android/remote/model/UserDialog;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class FailedWithDialog extends SendPhoneAntihackCodeResult {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult$Failure;", "Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Failure extends SendPhoneAntihackCodeResult {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult$IncorrectData;", "Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult;", "", "", "messages", "Ljava/util/Map;", "getMessages", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class IncorrectData extends SendPhoneAntihackCodeResult {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult$Ok;", "Lcom/avito/android/remote/model/SendPhoneAntihackCodeResult;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends SendPhoneAntihackCodeResult {
        public Ok() {
            super(null);
        }
    }

    private SendPhoneAntihackCodeResult() {
    }

    public /* synthetic */ SendPhoneAntihackCodeResult(j jVar) {
        this();
    }
}
