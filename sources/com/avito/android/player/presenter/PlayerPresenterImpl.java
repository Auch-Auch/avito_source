package com.avito.android.player.presenter;

import a2.a.a.a2.a.a;
import a2.a.a.a2.a.b;
import a2.a.a.a2.a.c;
import a2.g.r.g;
import a2.j.b.b.k0;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.player.di.PlayerMediaUrl;
import com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor;
import com.avito.android.player.presenter.tracker.PlayerTracker;
import com.avito.android.player.router.PlayerRouter;
import com.avito.android.player.view.PlayerState;
import com.avito.android.player.view.PlayerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import dagger.Lazy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002BI\b\u0007\u0012\b\b\u0001\u0010P\u001a\u00020M\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010T\u001a\u00020Q\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u00104\u001a\u000201\u0012\f\u0010H\u001a\b\u0012\u0004\u0012\u00020*0E\u0012\u0006\u0010L\u001a\u00020I¢\u0006\u0004\bU\u0010VJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\tJ\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\tJ\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\tJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\tJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\tJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\tJ\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0004\b%\u0010\tR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020*0E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010S¨\u0006W"}, d2 = {"Lcom/avito/android/player/presenter/PlayerPresenterImpl;", "Lcom/avito/android/player/presenter/PlayerPresenter;", "Lcom/google/android/exoplayer2/Player$EventListener;", "Lcom/avito/android/player/view/PlayerView;", "view", "", "onViewCreated", "(Lcom/avito/android/player/view/PlayerView;)V", "onViewDestroyed", "()V", "Lcom/avito/android/player/router/PlayerRouter;", "router", "onViewStarted", "(Lcom/avito/android/player/router/PlayerRouter;)V", "onViewStopped", "onViewResumed", "onViewPaused", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "savedInstanceState", "onRestoreState", "(Landroid/os/Bundle;)V", "onClosePressed", "onRetryClicked", "", "playbackState", "onPlaybackStateChanged", "(I)V", "onPlayerPausePressed", "onPlayerPlayPressed", "onPlayerFastForwardPressed", "onPlayerRewindPressed", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "error", "onPlayerError", "(Lcom/google/android/exoplayer2/ExoPlaybackException;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/player/presenter/tracker/PlayerTracker;", "h", "Lcom/avito/android/player/presenter/tracker/PlayerTracker;", "tracker", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", ScreenPublicConstsKt.CONTENT_TYPE_PLAYER, "Lio/reactivex/rxjava3/disposables/Disposable;", "f", "Lio/reactivex/rxjava3/disposables/Disposable;", "playbackProgressDisposable", "Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor;", "k", "Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor;", "playerAnalyticsInteractor", "Lcom/avito/android/player/view/PlayerState;", "e", "Lcom/avito/android/player/view/PlayerState;", "playerState", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "j", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", AuthSource.BOOKING_ORDER, "Lcom/avito/android/player/router/PlayerRouter;", "c", "Lcom/avito/android/player/view/PlayerView;", "Lcom/avito/android/util/LoadingState;", "d", "Lcom/avito/android/util/LoadingState;", "mediaState", "Ldagger/Lazy;", "l", "Ldagger/Lazy;", "lazyPlayer", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", g.a, "Ljava/lang/String;", "mediaUrl", "Lcom/avito/android/player/presenter/PlayerResourcesProvider;", "i", "Lcom/avito/android/player/presenter/PlayerResourcesProvider;", "resources", "<init>", "(Ljava/lang/String;Lcom/avito/android/player/presenter/tracker/PlayerTracker;Lcom/avito/android/player/presenter/PlayerResourcesProvider;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor;Ldagger/Lazy;Lcom/avito/android/util/SchedulersFactory3;)V", "player_release"}, k = 1, mv = {1, 4, 2})
public final class PlayerPresenterImpl implements PlayerPresenter, Player.EventListener {
    public SimpleExoPlayer a;
    public PlayerRouter b;
    public PlayerView c;
    public LoadingState<? super Unit> d;
    public PlayerState e;
    public Disposable f;
    public final String g;
    public final PlayerTracker h;
    public final PlayerResourcesProvider i;
    public final ConnectivityProvider j;
    public final PlayerAnalyticsInteractor k;
    public final Lazy<SimpleExoPlayer> l;
    public final SchedulersFactory3 m;

    @Inject
    public PlayerPresenterImpl(@PlayerMediaUrl @NotNull String str, @NotNull PlayerTracker playerTracker, @NotNull PlayerResourcesProvider playerResourcesProvider, @NotNull ConnectivityProvider connectivityProvider, @NotNull PlayerAnalyticsInteractor playerAnalyticsInteractor, @NotNull Lazy<SimpleExoPlayer> lazy, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(str, "mediaUrl");
        Intrinsics.checkNotNullParameter(playerTracker, "tracker");
        Intrinsics.checkNotNullParameter(playerResourcesProvider, "resources");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        Intrinsics.checkNotNullParameter(playerAnalyticsInteractor, "playerAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(lazy, "lazyPlayer");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.g = str;
        this.h = playerTracker;
        this.i = playerResourcesProvider;
        this.j = connectivityProvider;
        this.k = playerAnalyticsInteractor;
        this.l = lazy;
        this.m = schedulersFactory3;
    }

    public static final void access$onMediaProgressChanged(PlayerPresenterImpl playerPresenterImpl, float f2) {
        Objects.requireNonNull(playerPresenterImpl);
        if (f2 >= 0.25f) {
            playerPresenterImpl.k.trackMediaFirstQuartileIfNeeded();
        }
        if (f2 >= 0.5f) {
            playerPresenterImpl.k.trackMediaMidpointIfNeeded();
        }
        if (f2 >= 0.75f) {
            playerPresenterImpl.k.trackMediaThirdQuartileIfNeeded();
        }
    }

    public final void a() {
        MediaItem build = new MediaItem.Builder().setUri(Uri.parse(this.g)).build();
        Intrinsics.checkNotNullExpressionValue(build, "MediaItem.Builder()\n    …uri)\n            .build()");
        SimpleExoPlayer simpleExoPlayer = this.l.get();
        this.a = simpleExoPlayer;
        simpleExoPlayer.setMediaItem(build);
        PlayerState playerState = this.e;
        boolean playWhenReady = playerState != null ? playerState.getPlayWhenReady() : true;
        PlayerState playerState2 = this.e;
        int currentWindow = playerState2 != null ? playerState2.getCurrentWindow() : 0;
        PlayerState playerState3 = this.e;
        long playbackPosition = playerState3 != null ? playerState3.getPlaybackPosition() : 0;
        Intrinsics.checkNotNullExpressionValue(simpleExoPlayer, ScreenPublicConstsKt.CONTENT_TYPE_PLAYER);
        simpleExoPlayer.setPlayWhenReady(playWhenReady);
        simpleExoPlayer.seekTo(currentWindow, playbackPosition);
        simpleExoPlayer.addListener(this);
        PlayerView playerView = this.c;
        if (playerView != null) {
            playerView.setPlayer(simpleExoPlayer);
        }
        SimpleExoPlayer simpleExoPlayer2 = this.a;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.prepare();
        }
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    public void onClosePressed() {
        this.k.trackClose();
        PlayerRouter playerRouter = this.b;
        if (playerRouter != null) {
            playerRouter.closeScreen();
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
        k0.$default$onExperimentalOffloadSchedulingEnabledChanged(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onIsLoadingChanged(boolean z) {
        k0.$default$onIsLoadingChanged(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onIsPlayingChanged(boolean z) {
        k0.$default$onIsPlayingChanged(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onLoadingChanged(boolean z) {
        k0.$default$onLoadingChanged(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i2) {
        k0.$default$onMediaItemTransition(this, mediaItem, i2);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i2) {
        k0.$default$onPlayWhenReadyChanged(this, z, i2);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        k0.$default$onPlaybackParametersChanged(this, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackStateChanged(int i2) {
        if (i2 != 2) {
            LoadingState<? super Unit> loadingState = this.d;
            if (!(loadingState instanceof LoadingState.Error)) {
                if (loadingState instanceof LoadingState.Loading) {
                    this.d = new LoadingState.Loaded(Unit.INSTANCE);
                    this.h.trackMediaLoaded();
                }
                PlayerView playerView = this.c;
                if (playerView != null) {
                    playerView.showContent();
                }
            }
        } else if (!(this.d instanceof LoadingState.Loading)) {
            this.h.startLoadingMedia();
            this.d = LoadingState.Loading.INSTANCE;
            PlayerView playerView2 = this.c;
            if (playerView2 != null) {
                playerView2.showLoading();
            }
        }
        if (i2 == 3) {
            this.k.trackMediaStartIfNeeded();
        } else if (i2 == 4) {
            this.k.trackMediaCompleteIfNeeded();
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i2) {
        k0.$default$onPlaybackSuppressionReasonChanged(this, i2);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(@NotNull ExoPlaybackException exoPlaybackException) {
        String str;
        Intrinsics.checkNotNullParameter(exoPlaybackException, "error");
        k0.$default$onPlayerError(this, exoPlaybackException);
        this.h.trackPlayerErrorPrepare();
        if (this.j.isConnectionAvailable()) {
            str = this.i.unknownError();
        } else {
            str = this.i.connectionError();
        }
        PlayerView playerView = this.c;
        if (playerView != null) {
            playerView.showError(str);
        }
        this.d = new LoadingState.Error(new ErrorWithMessage.SimpleMessageError(str));
        this.h.trackPlayerErrorDraw();
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    public void onPlayerFastForwardPressed() {
        this.k.trackFastForward();
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    public void onPlayerPausePressed() {
        this.k.trackPause();
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    public void onPlayerPlayPressed() {
        this.k.trackResume();
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    public void onPlayerRewindPressed() {
        this.k.trackRewind();
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlayerStateChanged(boolean z, int i2) {
        k0.$default$onPlayerStateChanged(this, z, i2);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPositionDiscontinuity(int i2) {
        k0.$default$onPositionDiscontinuity(this, i2);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onRepeatModeChanged(int i2) {
        k0.$default$onRepeatModeChanged(this, i2);
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    public void onRestoreState(@Nullable Bundle bundle) {
        if (bundle != null) {
            PlayerState playerState = (PlayerState) bundle.getParcelable("player_state");
            if (playerState != null) {
                this.e = playerState;
            }
            PlayerAnalyticsInteractor.State state = (PlayerAnalyticsInteractor.State) bundle.getParcelable("player_analytics_state");
            if (state != null) {
                PlayerAnalyticsInteractor playerAnalyticsInteractor = this.k;
                Intrinsics.checkNotNullExpressionValue(state, "state");
                playerAnalyticsInteractor.restoreState(state);
            }
        }
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    public void onRetryClicked() {
        SimpleExoPlayer simpleExoPlayer = this.a;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.prepare();
        }
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    @NotNull
    public Bundle onSaveState() {
        SimpleExoPlayer simpleExoPlayer = this.a;
        PlayerState playerState = simpleExoPlayer != null ? new PlayerState(simpleExoPlayer.getPlayWhenReady(), simpleExoPlayer.getCurrentWindowIndex(), simpleExoPlayer.getCurrentPosition()) : null;
        Bundle bundle = new Bundle();
        bundle.putParcelable("player_state", playerState);
        bundle.putParcelable("player_analytics_state", this.k.saveState());
        return bundle;
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onSeekProcessed() {
        k0.$default$onSeekProcessed(this);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
        k0.$default$onShuffleModeEnabledChanged(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i2) {
        k0.$default$onTimelineChanged(this, timeline, i2);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i2) {
        k0.$default$onTimelineChanged(this, timeline, obj, i2);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        k0.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    public void onViewCreated(@NotNull PlayerView playerView) {
        Intrinsics.checkNotNullParameter(playerView, "view");
        this.c = playerView;
        this.f = Observable.interval(200, TimeUnit.MILLISECONDS, this.m.mainThread()).map(new a(this)).filter(b.a).subscribe(new c(this));
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    public void onViewDestroyed() {
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f = null;
        this.c = null;
        this.a = null;
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    public void onViewPaused() {
        if (Build.VERSION.SDK_INT < 24) {
            SimpleExoPlayer simpleExoPlayer = this.a;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.removeListener(this);
            }
            SimpleExoPlayer simpleExoPlayer2 = this.a;
            if (simpleExoPlayer2 != null) {
                simpleExoPlayer2.release();
            }
            this.a = null;
        }
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    public void onViewResumed() {
        PlayerView playerView = this.c;
        if (playerView != null) {
            playerView.hideSystemUI();
        }
        if (Build.VERSION.SDK_INT < 24 || this.a == null) {
            a();
        }
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    public void onViewStarted(@NotNull PlayerRouter playerRouter) {
        Intrinsics.checkNotNullParameter(playerRouter, "router");
        this.b = playerRouter;
        this.h.restart();
        if (Build.VERSION.SDK_INT >= 24) {
            a();
        }
    }

    @Override // com.avito.android.player.presenter.PlayerPresenter
    public void onViewStopped() {
        this.b = null;
        this.h.stop();
        if (Build.VERSION.SDK_INT >= 24) {
            SimpleExoPlayer simpleExoPlayer = this.a;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.removeListener(this);
            }
            SimpleExoPlayer simpleExoPlayer2 = this.a;
            if (simpleExoPlayer2 != null) {
                simpleExoPlayer2.release();
            }
            this.a = null;
        }
    }
}
