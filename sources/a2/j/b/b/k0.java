package a2.j.b.b;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
/* compiled from: Player */
public final /* synthetic */ class k0 {
    public static void $default$onExperimentalOffloadSchedulingEnabledChanged(Player.EventListener eventListener, boolean z) {
    }

    public static void $default$onIsLoadingChanged(Player.EventListener _this, boolean z) {
        _this.onLoadingChanged(z);
    }

    public static void $default$onIsPlayingChanged(Player.EventListener eventListener, boolean z) {
    }

    @Deprecated
    public static void $default$onLoadingChanged(Player.EventListener eventListener, boolean z) {
    }

    public static void $default$onMediaItemTransition(@Nullable Player.EventListener eventListener, MediaItem mediaItem, int i) {
    }

    public static void $default$onPlayWhenReadyChanged(Player.EventListener eventListener, boolean z, int i) {
    }

    public static void $default$onPlaybackParametersChanged(Player.EventListener eventListener, PlaybackParameters playbackParameters) {
    }

    public static void $default$onPlaybackStateChanged(Player.EventListener eventListener, int i) {
    }

    public static void $default$onPlaybackSuppressionReasonChanged(Player.EventListener eventListener, int i) {
    }

    public static void $default$onPlayerError(Player.EventListener eventListener, ExoPlaybackException exoPlaybackException) {
    }

    @Deprecated
    public static void $default$onPlayerStateChanged(Player.EventListener eventListener, boolean z, int i) {
    }

    public static void $default$onPositionDiscontinuity(Player.EventListener eventListener, int i) {
    }

    public static void $default$onRepeatModeChanged(Player.EventListener eventListener, int i) {
    }

    @Deprecated
    public static void $default$onSeekProcessed(Player.EventListener eventListener) {
    }

    public static void $default$onShuffleModeEnabledChanged(Player.EventListener eventListener, boolean z) {
    }

    public static void $default$onTimelineChanged(Player.EventListener _this, Timeline timeline, int i) {
        _this.onTimelineChanged(timeline, timeline.getWindowCount() == 1 ? timeline.getWindow(0, new Timeline.Window()).manifest : null, i);
    }

    @Deprecated
    public static void $default$onTimelineChanged(Player.EventListener eventListener, @Nullable Timeline timeline, Object obj, int i) {
    }

    public static void $default$onTracksChanged(Player.EventListener eventListener, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }
}
