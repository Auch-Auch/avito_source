package a2.j.b.b.q0;

import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import java.io.IOException;
/* compiled from: AnalyticsListener */
public final /* synthetic */ class b {
    public static void $default$onAudioAttributesChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
    }

    public static void $default$onAudioDecoderInitialized(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str, long j) {
    }

    public static void $default$onAudioDisabled(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
    }

    public static void $default$onAudioEnabled(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
    }

    public static void $default$onAudioInputFormatChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Format format) {
    }

    public static void $default$onAudioPositionAdvancing(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, long j) {
    }

    public static void $default$onAudioSessionId(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    public static void $default$onAudioUnderrun(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
    }

    public static void $default$onBandwidthEstimate(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
    }

    @Deprecated
    public static void $default$onDecoderDisabled(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
    }

    @Deprecated
    public static void $default$onDecoderEnabled(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
    }

    @Deprecated
    public static void $default$onDecoderInitialized(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, String str, long j) {
    }

    @Deprecated
    public static void $default$onDecoderInputFormatChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, Format format) {
    }

    public static void $default$onDownstreamFormatChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
    }

    public static void $default$onDrmKeysLoaded(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    public static void $default$onDrmKeysRemoved(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    public static void $default$onDrmKeysRestored(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    public static void $default$onDrmSessionAcquired(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    public static void $default$onDrmSessionManagerError(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Exception exc) {
    }

    public static void $default$onDrmSessionReleased(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    public static void $default$onDroppedVideoFrames(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, long j) {
    }

    public static void $default$onIsLoadingChanged(AnalyticsListener _this, AnalyticsListener.EventTime eventTime, boolean z) {
        _this.onLoadingChanged(eventTime, z);
    }

    public static void $default$onIsPlayingChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    public static void $default$onLoadCanceled(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public static void $default$onLoadCompleted(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public static void $default$onLoadError(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
    }

    public static void $default$onLoadStarted(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    @Deprecated
    public static void $default$onLoadingChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    public static void $default$onMediaItemTransition(AnalyticsListener analyticsListener, @Nullable AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i) {
    }

    public static void $default$onMetadata(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Metadata metadata) {
    }

    public static void $default$onPlayWhenReadyChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z, int i) {
    }

    public static void $default$onPlaybackParametersChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
    }

    public static void $default$onPlaybackStateChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    public static void $default$onPlaybackSuppressionReasonChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    public static void $default$onPlayerError(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
    }

    @Deprecated
    public static void $default$onPlayerStateChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z, int i) {
    }

    public static void $default$onPositionDiscontinuity(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    public static void $default$onRenderedFirstFrame(AnalyticsListener analyticsListener, @Nullable AnalyticsListener.EventTime eventTime, Surface surface) {
    }

    public static void $default$onRepeatModeChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    @Deprecated
    public static void $default$onSeekProcessed(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    public static void $default$onSeekStarted(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    public static void $default$onShuffleModeChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    public static void $default$onSkipSilenceEnabledChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    public static void $default$onSurfaceSizeChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, int i2) {
    }

    public static void $default$onTimelineChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    public static void $default$onTracksChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    public static void $default$onUpstreamDiscarded(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
    }

    public static void $default$onVideoDecoderInitialized(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str, long j) {
    }

    public static void $default$onVideoDisabled(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
    }

    public static void $default$onVideoEnabled(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
    }

    public static void $default$onVideoFrameProcessingOffset(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, long j, int i) {
    }

    public static void $default$onVideoInputFormatChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Format format) {
    }

    public static void $default$onVideoSizeChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
    }

    public static void $default$onVolumeChanged(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, float f) {
    }
}
