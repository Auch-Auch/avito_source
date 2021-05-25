package com.avito.android.messenger.channels.mvi.view;

import androidx.lifecycle.LifecycleObserver;
import com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelsListView;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroyView", "()V", "Lio/reactivex/Observable;", "getScrollEvents", "()Lio/reactivex/Observable;", "scrollEvents", "getSwipeRefreshes", "swipeRefreshes", "getOverlayRefreshClicks", "overlayRefreshClicks", "getSnackbarRefreshClicks", "snackbarRefreshClicks", "getPaginationStream", "paginationStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsListView extends Renderer<ChannelsListState>, ScrollToUpHandler, LifecycleObserver {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull ChannelsListView channelsListView, @NotNull ChannelsListState channelsListState) {
            Intrinsics.checkNotNullParameter(channelsListState, "state");
            Renderer.DefaultImpls.render(channelsListView, channelsListState);
        }
    }

    @NotNull
    Observable<Unit> getOverlayRefreshClicks();

    @NotNull
    Observable<Unit> getPaginationStream();

    @NotNull
    Observable<Unit> getScrollEvents();

    @NotNull
    Observable<Unit> getSnackbarRefreshClicks();

    @NotNull
    Observable<Unit> getSwipeRefreshes();

    void onDestroyView();
}
