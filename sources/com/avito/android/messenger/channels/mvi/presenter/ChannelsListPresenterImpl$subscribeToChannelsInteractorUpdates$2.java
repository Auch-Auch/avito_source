package com.avito.android.messenger.channels.mvi.presenter;

import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "kotlin.jvm.PlatformType", "newState", "", "accept", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListPresenterImpl$subscribeToChannelsInteractorUpdates$2<T> implements Consumer<ChannelsListInteractor.State> {
    public final /* synthetic */ ChannelsListPresenterImpl a;

    public ChannelsListPresenterImpl$subscribeToChannelsInteractorUpdates$2(ChannelsListPresenterImpl channelsListPresenterImpl) {
        this.a = channelsListPresenterImpl;
    }

    public final void accept(ChannelsListInteractor.State state) {
        ReducerQueue reducerQueue = this.a.getReducerQueue();
        ChannelsListPresenterImpl channelsListPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(state, "newState");
        reducerQueue.plusAssign(new ChannelsListPresenterImpl.NewChannelsInteractorStateMutator(channelsListPresenterImpl, state));
    }
}
