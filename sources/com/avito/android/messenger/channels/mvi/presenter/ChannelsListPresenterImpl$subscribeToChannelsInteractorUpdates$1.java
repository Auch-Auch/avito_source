package com.avito.android.messenger.channels.mvi.presenter;

import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.messenger.ChatListLoadingException;
import com.avito.android.messenger.ChatListPaginationException;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "prevState", "curState", "apply", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListPresenterImpl$subscribeToChannelsInteractorUpdates$1<T1, T2, R> implements BiFunction<ChannelsListInteractor.State, ChannelsListInteractor.State, ChannelsListInteractor.State> {
    public final /* synthetic */ ChannelsListPresenterImpl a;

    public ChannelsListPresenterImpl$subscribeToChannelsInteractorUpdates$1(ChannelsListPresenterImpl channelsListPresenterImpl) {
        this.a = channelsListPresenterImpl;
    }

    @NotNull
    public final ChannelsListInteractor.State apply(@NotNull ChannelsListInteractor.State state, @NotNull ChannelsListInteractor.State state2) {
        Intrinsics.checkNotNullParameter(state, "prevState");
        Intrinsics.checkNotNullParameter(state2, "curState");
        ChannelsListPresenterImpl channelsListPresenterImpl = this.a;
        if (!(state.getInitialLoadingState() instanceof ChannelsListInteractor.State.Loading.Error) && (state2.getInitialLoadingState() instanceof ChannelsListInteractor.State.Loading.Error)) {
            ErrorTracker.DefaultImpls.track$default(ChannelsListPresenterImpl.access$getErrorTracker$p(channelsListPresenterImpl), new ChatListLoadingException("Failed to load channels list", ((ChannelsListInteractor.State.Loading.Error) state2.getInitialLoadingState()).getThrowable()), null, q.mapOf(TuplesKt.to("isRefresh", Boolean.FALSE)), 2, null);
        }
        if (!(state.getNextPageLoadingState() instanceof ChannelsListInteractor.State.Loading.Error) && (state2.getNextPageLoadingState() instanceof ChannelsListInteractor.State.Loading.Error)) {
            ErrorTracker.DefaultImpls.track$default(ChannelsListPresenterImpl.access$getErrorTracker$p(channelsListPresenterImpl), new ChatListPaginationException("Failed to load next page of channels list", ((ChannelsListInteractor.State.Loading.Error) state2.getNextPageLoadingState()).getThrowable()), null, null, 6, null);
        }
        if (!(state.getRefreshState() instanceof ChannelsListInteractor.State.Loading.Error) && (state2.getRefreshState() instanceof ChannelsListInteractor.State.Loading.Error)) {
            ErrorTracker.DefaultImpls.track$default(ChannelsListPresenterImpl.access$getErrorTracker$p(channelsListPresenterImpl), new ChatListLoadingException("Failed to refresh channels list", ((ChannelsListInteractor.State.Loading.Error) state2.getRefreshState()).getThrowable()), null, q.mapOf(TuplesKt.to("isRefresh", Boolean.TRUE)), 2, null);
        }
        return state2;
    }
}
