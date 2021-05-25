package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "notificationQueueWasRestored", "", "accept", "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListInteractorImpl$subscribeToReconnects$1<T> implements Consumer<Boolean> {
    public final /* synthetic */ ChannelsListInteractorImpl a;

    public ChannelsListInteractorImpl$subscribeToReconnects$1(ChannelsListInteractorImpl channelsListInteractorImpl) {
        this.a = channelsListInteractorImpl;
    }

    public final void accept(Boolean bool) {
        ReducerQueue reducerQueue = this.a.getReducerQueue();
        ChannelsListInteractorImpl channelsListInteractorImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(bool, "notificationQueueWasRestored");
        reducerQueue.plusAssign(new ChannelsListInteractorImpl.OnReconnectAction(bool.booleanValue()));
    }
}
