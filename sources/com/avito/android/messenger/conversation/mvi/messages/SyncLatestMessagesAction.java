package com.avito.android.messenger.conversation.mvi.messages;

import androidx.annotation.VisibleForTesting;
import com.avito.android.messenger.channels.mvi.common.v2.ActionSingle;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import com.avito.android.util.Singles;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/SyncLatestMessagesAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;)Lio/reactivex/Single;", "", "c", "Ljava/lang/String;", ChannelContext.Item.USER_ID, "d", "channelId", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "e", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "deps", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@VisibleForTesting(otherwise = 3)
public final class SyncLatestMessagesAction extends ActionSingle<MessageListInteractor.State> {
    public final String c;
    public final String d;
    public final MessageListInteractorImpl.Dependencies e;

    public static final class a<T, R> implements Function<Throwable, Unit> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            Logs.warning$default("MessageListInteractor", "SyncLatestMessagesAction failed: " + th2, null, 4, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SyncLatestMessagesAction(@NotNull String str, @NotNull String str2, @NotNull MessageListInteractorImpl.Dependencies dependencies) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(dependencies, "deps");
        this.c = str;
        this.d = str2;
        this.e = dependencies;
    }

    @NotNull
    public Single<?> invoke(@NotNull MessageListInteractor.State state) {
        Intrinsics.checkNotNullParameter(state, "curState");
        if (!(state instanceof MessageListInteractor.State.FirstPageLoaded)) {
            return Singles.toSingle(Unit.INSTANCE);
        }
        Single<?> onErrorReturn = this.e.getSyncLatestMessages().invoke(this.c, this.d).toSingleDefault(Unit.INSTANCE).onErrorReturn(a.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "deps.syncLatestMessages(…   Unit\n                }");
        return onErrorReturn;
    }
}
