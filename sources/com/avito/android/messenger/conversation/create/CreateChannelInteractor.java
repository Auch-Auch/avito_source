package com.avito.android.messenger.conversation.create;

import a2.b.a.a.a;
import com.avito.android.messenger.conversation.ChannelActivityArguments;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor;", "", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "createParams", "Lio/reactivex/Single;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result;", "getOrCreateChannel", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;)Lio/reactivex/Single;", "Result", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface CreateChannelInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result;", "", "<init>", "()V", "Error", "Success", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Success;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Result {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result;", "<init>", "()V", "Auth", "Forbidden", "Network", "PhoneVerification", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error$Auth;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error$PhoneVerification;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error$Forbidden;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error$Network;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error$Unknown;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Error extends Result {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error$Auth;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Auth extends Error {
                @NotNull
                public static final Auth INSTANCE = new Auth();

                public Auth() {
                    super(null);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error$Forbidden;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Forbidden extends Error {
                @NotNull
                public static final Forbidden INSTANCE = new Forbidden();

                public Forbidden() {
                    super(null);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error$Network;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Network extends Error {
                @NotNull
                public static final Network INSTANCE = new Network();

                public Network() {
                    super(null);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error$PhoneVerification;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class PhoneVerification extends Error {
                @NotNull
                public static final PhoneVerification INSTANCE = new PhoneVerification();

                public PhoneVerification() {
                    super(null);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error$Unknown;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "error", "<init>", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Unknown extends Error {
                @NotNull
                public final Throwable a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Unknown(@NotNull Throwable th) {
                    super(null);
                    Intrinsics.checkNotNullParameter(th, "error");
                    this.a = th;
                }

                @NotNull
                public final Throwable getError() {
                    return this.a;
                }
            }

            public Error() {
                super(null);
            }

            public Error(j jVar) {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Success;", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result;", "", "component1", "()Ljava/lang/String;", "channelId", "copy", "(Ljava/lang/String;)Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Success;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getChannelId", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends Result {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "channelId");
                this.a = str;
            }

            public static /* synthetic */ Success copy$default(Success success, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = success.a;
                }
                return success.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final Success copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                return new Success(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Success) && Intrinsics.areEqual(this.a, ((Success) obj).a);
                }
                return true;
            }

            @NotNull
            public final String getChannelId() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a.t(a.L("Success(channelId="), this.a, ")");
            }
        }

        public Result() {
        }

        public Result(j jVar) {
        }
    }

    @NotNull
    Single<Result> getOrCreateChannel(@NotNull ChannelActivityArguments.Create create);
}
