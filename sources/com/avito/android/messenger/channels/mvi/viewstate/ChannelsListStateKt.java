package com.avito.android.messenger.channels.mvi.viewstate;

import com.avito.android.messenger.channels.mvi.view.ChannelsListProgressItem;
import com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004\"\u0018\u0010\t\u001a\u00020\u0006*\u00020\u00058Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\r\u001a\u0004\u0018\u00010\n*\u00020\u00058Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState;", "other", "", "compareTo", "(Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState;Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState;)I", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "", "getInitialLoadingInProgress", "(Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;)Z", "initialLoadingInProgress", "Lcom/avito/android/messenger/channels/mvi/view/ChannelsListProgressItem;", "getListProgressItem", "(Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;)Lcom/avito/android/messenger/channels/mvi/view/ChannelsListProgressItem;", "listProgressItem", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ChannelsListStateKt {
    public static final int compareTo(@NotNull ChannelsListState.SnackbarState snackbarState, @NotNull ChannelsListState.SnackbarState snackbarState2) {
        Intrinsics.checkNotNullParameter(snackbarState, "$this$compareTo");
        Intrinsics.checkNotNullParameter(snackbarState2, "other");
        return Intrinsics.compare(snackbarState.getPriority(), snackbarState2.getPriority());
    }

    public static final boolean getInitialLoadingInProgress(@NotNull ChannelsListState channelsListState) {
        Intrinsics.checkNotNullParameter(channelsListState, "$this$initialLoadingInProgress");
        return channelsListState.progressOverlayState instanceof ChannelsListState.ProgressOverlayState.Loading;
    }

    @Nullable
    public static final ChannelsListProgressItem getListProgressItem(@NotNull ChannelsListState channelsListState) {
        Intrinsics.checkNotNullParameter(channelsListState, "$this$listProgressItem");
        Object lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) channelsListState.listItems);
        if (!(lastOrNull instanceof ChannelsListProgressItem)) {
            lastOrNull = null;
        }
        return (ChannelsListProgressItem) lastOrNull;
    }
}
