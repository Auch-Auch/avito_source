package com.avito.android.messenger.conversation.mvi.context;

import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isConnecting", "", "accept", "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl$subscribeToConnectingStateChanges$2<T> implements Consumer<Boolean> {
    public final /* synthetic */ ChannelContextInteractorImpl a;

    public ChannelContextInteractorImpl$subscribeToConnectingStateChanges$2(ChannelContextInteractorImpl channelContextInteractorImpl) {
        this.a = channelContextInteractorImpl;
    }

    public final void accept(Boolean bool) {
        ReducerQueue reducerQueue = this.a.getReducerQueue();
        ChannelContextInteractorImpl channelContextInteractorImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(bool, "isConnecting");
        reducerQueue.plusAssign(new ChannelContextInteractorImpl.ConnectingStateChangedMutator(channelContextInteractorImpl, bool.booleanValue()));
    }
}
