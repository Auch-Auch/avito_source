package com.avito.android.remote.model.registration;

import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/registration/RequestCodeResult;", "", "<init>", "()V", "Confirmed", "Failure", "IncorrectData", "Ok", "VerifyByCall", "Lcom/avito/android/remote/model/registration/RequestCodeResult$Ok;", "Lcom/avito/android/remote/model/registration/RequestCodeResult$Failure;", "Lcom/avito/android/remote/model/registration/RequestCodeResult$IncorrectData;", "Lcom/avito/android/remote/model/registration/RequestCodeResult$VerifyByCall;", "Lcom/avito/android/remote/model/registration/RequestCodeResult$Confirmed;", "profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class RequestCodeResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/registration/RequestCodeResult$Confirmed;", "Lcom/avito/android/remote/model/registration/RequestCodeResult;", "", "hash", "Ljava/lang/String;", "getHash", "()Ljava/lang/String;", "", "isPhoneUsed", "Z", "()Z", "<init>", "(Ljava/lang/String;Z)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Confirmed extends RequestCodeResult {
        @SerializedName("hash")
        @NotNull
        private final String hash;
        @SerializedName("is_phone_used")
        private final boolean isPhoneUsed;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Confirmed(@NotNull String str, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "hash");
            this.hash = str;
            this.isPhoneUsed = z;
        }

        @NotNull
        public final String getHash() {
            return this.hash;
        }

        public final boolean isPhoneUsed() {
            return this.isPhoneUsed;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/registration/RequestCodeResult$Failure;", "Lcom/avito/android/remote/model/registration/RequestCodeResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Failure extends RequestCodeResult {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/registration/RequestCodeResult$IncorrectData;", "Lcom/avito/android/remote/model/registration/RequestCodeResult;", "", "", "messages", "Ljava/util/Map;", "getMessages", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class IncorrectData extends RequestCodeResult {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/registration/RequestCodeResult$Ok;", "Lcom/avito/android/remote/model/registration/RequestCodeResult;", "", "nextTryTime", "J", "getNextTryTime", "()J", "lastTryTime", "getLastTryTime", "<init>", "(JJ)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends RequestCodeResult {
        @SerializedName("lastTryTime")
        private final long lastTryTime;
        @SerializedName("nextTryTime")
        private final long nextTryTime;

        public Ok(long j, long j2) {
            super(null);
            this.lastTryTime = j;
            this.nextTryTime = j2;
        }

        public final long getLastTryTime() {
            return this.lastTryTime;
        }

        public final long getNextTryTime() {
            return this.nextTryTime;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/registration/RequestCodeResult$VerifyByCall;", "Lcom/avito/android/remote/model/registration/RequestCodeResult;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class VerifyByCall extends RequestCodeResult {
        @SerializedName("deeplink")
        @NotNull
        private final DeepLink deeplink;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VerifyByCall(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deeplink");
            this.deeplink = deepLink;
        }

        @NotNull
        public final DeepLink getDeeplink() {
            return this.deeplink;
        }
    }

    private RequestCodeResult() {
    }

    public /* synthetic */ RequestCodeResult(j jVar) {
        this();
    }
}
