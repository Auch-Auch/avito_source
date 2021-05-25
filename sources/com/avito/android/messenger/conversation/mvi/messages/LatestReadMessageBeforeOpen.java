package com.avito.android.messenger.conversation.mvi.messages;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen;", "", "<init>", "()V", "IsLastMessage", "IsNotLastMessage", "NotFound", "Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen$NotFound;", "Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen$IsLastMessage;", "Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen$IsNotLastMessage;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class LatestReadMessageBeforeOpen {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen$IsLastMessage;", "Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class IsLastMessage extends LatestReadMessageBeforeOpen {
        @NotNull
        public static final IsLastMessage INSTANCE = new IsLastMessage();

        public IsLastMessage() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen$IsNotLastMessage;", "Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class IsNotLastMessage extends LatestReadMessageBeforeOpen {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IsNotLastMessage(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            this.a = str;
        }

        @NotNull
        public final String getId() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen$NotFound;", "Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class NotFound extends LatestReadMessageBeforeOpen {
        @NotNull
        public static final NotFound INSTANCE = new NotFound();

        public NotFound() {
            super(null);
        }
    }

    public LatestReadMessageBeforeOpen() {
    }

    public LatestReadMessageBeforeOpen(j jVar) {
    }
}
