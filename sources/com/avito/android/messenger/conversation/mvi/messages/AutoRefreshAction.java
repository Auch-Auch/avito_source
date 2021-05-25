package com.avito.android.messenger.conversation.mvi.messages;

import com.avito.android.messenger.channels.mvi.common.v2.Action;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/AutoRefreshAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;)V", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "f", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "deps", "", "e", "Z", "recovered", "", "d", "Ljava/lang/String;", "channelId", "c", ChannelContext.Item.USER_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class AutoRefreshAction extends Action<MessageListInteractor.State> {
    public final String c;
    public final String d;
    public final boolean e;
    public final MessageListInteractorImpl.Dependencies f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoRefreshAction(@NotNull String str, @NotNull String str2, boolean z, @NotNull MessageListInteractorImpl.Dependencies dependencies) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(dependencies, "deps");
        this.c = str;
        this.d = str2;
        this.e = z;
        this.f = dependencies;
    }

    public void invoke(@NotNull MessageListInteractor.State state) {
        Intrinsics.checkNotNullParameter(state, "curState");
        if (state instanceof MessageListInteractor.State.FirstPageLoaded) {
            if (!this.e) {
                this.f.getDispatchSyncLatestMessagesAction().invoke(this.c, this.d);
            }
            if (((MessageListInteractor.State.FirstPageLoaded) state).getPaginationState() instanceof MessageListInteractor.PaginationState.Error) {
                this.f.getDispatchStartLoadingPrevPageMutator().invoke(this.c, this.d);
                return;
            }
            return;
        }
        this.f.getDispatchStartLoadingFirstPageMutator().invoke(this.c, this.d);
    }
}
