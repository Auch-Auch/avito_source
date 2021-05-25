package com.avito.android.player.view;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.google.android.exoplayer2.SimpleExoPlayer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/player/view/PlayerView;", "", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", ScreenPublicConstsKt.CONTENT_TYPE_PLAYER, "", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "releasePlayer", "()V", "showLoading", "", "message", "showError", "(Ljava/lang/String;)V", "showContent", "hideSystemUI", "player_release"}, k = 1, mv = {1, 4, 2})
public interface PlayerView {
    void hideSystemUI();

    void releasePlayer();

    void setPlayer(@NotNull SimpleExoPlayer simpleExoPlayer);

    void showContent();

    void showError(@NotNull String str);

    void showLoading();
}
