package com.avito.android.player.presenter;

import android.os.Bundle;
import com.avito.android.player.router.PlayerRouter;
import com.avito.android.player.view.PlayerView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\bJ\u000f\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/player/presenter/PlayerPresenter;", "", "Lcom/avito/android/player/view/PlayerView;", "view", "", "onViewCreated", "(Lcom/avito/android/player/view/PlayerView;)V", "onViewDestroyed", "()V", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "savedInstanceState", "onRestoreState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/player/router/PlayerRouter;", "router", "onViewStarted", "(Lcom/avito/android/player/router/PlayerRouter;)V", "onViewStopped", "onViewResumed", "onViewPaused", "onClosePressed", "onRetryClicked", "onPlayerPausePressed", "onPlayerPlayPressed", "onPlayerFastForwardPressed", "onPlayerRewindPressed", "player_release"}, k = 1, mv = {1, 4, 2})
public interface PlayerPresenter {
    void onClosePressed();

    void onPlayerFastForwardPressed();

    void onPlayerPausePressed();

    void onPlayerPlayPressed();

    void onPlayerRewindPressed();

    void onRestoreState(@Nullable Bundle bundle);

    void onRetryClicked();

    @NotNull
    Bundle onSaveState();

    void onViewCreated(@NotNull PlayerView playerView);

    void onViewDestroyed();

    void onViewPaused();

    void onViewResumed();

    void onViewStarted(@NotNull PlayerRouter playerRouter);

    void onViewStopped();
}
