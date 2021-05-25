package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a6\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005 \u0006*\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "state", "Lkotlin/Pair;", "", "", "Lcom/avito/android/messenger/channels/mvi/sync/Timestamp;", "kotlin.jvm.PlatformType", "apply", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListInteractorImpl$subscribeToChannelsUpdatesFromDb$4<T, R> implements Function<ChannelsListInteractor.State, Pair<? extends String, ? extends Long>> {
    public static final ChannelsListInteractorImpl$subscribeToChannelsUpdatesFromDb$4 INSTANCE = new ChannelsListInteractorImpl$subscribeToChannelsUpdatesFromDb$4();

    public final Pair<String, Long> apply(@NotNull ChannelsListInteractor.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return TuplesKt.to(state.getUserId(), state.getPinnedListBottomTimestamp());
    }
}
