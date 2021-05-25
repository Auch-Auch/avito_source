package com.avito.android.messenger.blacklist.mvi;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.messenger.blacklist.mvi.BlacklistPresenter;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.RendererWithDiff;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistView;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/RendererWithDiff;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", "", "destroy", "()V", "Lio/reactivex/Observable;", "getRetryClickedStream", "()Lio/reactivex/Observable;", "retryClickedStream", "getPulledToRefreshStream", "pulledToRefreshStream", "getStartPaginationStream", "startPaginationStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface BlacklistView extends RendererWithDiff<BlacklistPresenter.State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull BlacklistView blacklistView, @NotNull BlacklistPresenter.State state, @Nullable DiffUtil.DiffResult diffResult) {
            Intrinsics.checkNotNullParameter(state, "state");
            RendererWithDiff.DefaultImpls.render(blacklistView, state, diffResult);
        }
    }

    void destroy();

    @NotNull
    Observable<Unit> getPulledToRefreshStream();

    @NotNull
    Observable<Unit> getRetryClickedStream();

    @NotNull
    Observable<Unit> getStartPaginationStream();
}
