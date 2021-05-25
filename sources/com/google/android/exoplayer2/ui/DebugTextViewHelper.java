package com.google.android.exoplayer2.ui;

import a2.b.a.a.a;
import a2.j.b.b.k0;
import android.annotation.SuppressLint;
import android.os.Looper;
import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Locale;
import net.gotev.uploadservice.logger.UploadServiceLogger;
public class DebugTextViewHelper implements Player.EventListener, Runnable {
    public final SimpleExoPlayer a;
    public final TextView b;
    public boolean c;

    public DebugTextViewHelper(SimpleExoPlayer simpleExoPlayer, TextView textView) {
        Assertions.checkArgument(simpleExoPlayer.getApplicationLooper() == Looper.getMainLooper());
        this.a = simpleExoPlayer;
        this.b = textView;
    }

    public static String a(DecoderCounters decoderCounters) {
        decoderCounters.ensureUpdated();
        return " sib:" + decoderCounters.skippedInputBufferCount + " sb:" + decoderCounters.skippedOutputBufferCount + " rb:" + decoderCounters.renderedOutputBufferCount + " db:" + decoderCounters.droppedBufferCount + " mcdb:" + decoderCounters.maxConsecutiveDroppedBufferCount + " dk:" + decoderCounters.droppedToKeyframeCount;
    }

    public String getAudioString() {
        Format audioFormat = this.a.getAudioFormat();
        DecoderCounters audioDecoderCounters = this.a.getAudioDecoderCounters();
        if (audioFormat == null || audioDecoderCounters == null) {
            return "";
        }
        StringBuilder L = a.L("\n");
        L.append(audioFormat.sampleMimeType);
        L.append("(id:");
        L.append(audioFormat.id);
        L.append(" hz:");
        L.append(audioFormat.sampleRate);
        L.append(" ch:");
        L.append(audioFormat.channelCount);
        L.append(a(audioDecoderCounters));
        L.append(")");
        return L.toString();
    }

    public String getDebugString() {
        return getPlayerStateString() + getVideoString() + getAudioString();
    }

    public String getPlayerStateString() {
        int playbackState = this.a.getPlaybackState();
        return String.format("playWhenReady:%s playbackState:%s window:%s", Boolean.valueOf(this.a.getPlayWhenReady()), playbackState != 1 ? playbackState != 2 ? playbackState != 3 ? playbackState != 4 ? "unknown" : "ended" : "ready" : "buffering" : "idle", Integer.valueOf(this.a.getCurrentWindowIndex()));
    }

    public String getVideoString() {
        String str;
        Format videoFormat = this.a.getVideoFormat();
        DecoderCounters videoDecoderCounters = this.a.getVideoDecoderCounters();
        String str2 = "";
        if (videoFormat == null || videoDecoderCounters == null) {
            return str2;
        }
        StringBuilder L = a.L("\n");
        L.append(videoFormat.sampleMimeType);
        L.append("(id:");
        L.append(videoFormat.id);
        L.append(" r:");
        L.append(videoFormat.width);
        L.append("x");
        L.append(videoFormat.height);
        float f = videoFormat.pixelWidthHeightRatio;
        if (!(f == -1.0f || f == 1.0f)) {
            StringBuilder L2 = a.L(" par:");
            L2.append(String.format(Locale.US, "%.02f", Float.valueOf(f)));
            str2 = L2.toString();
        }
        L.append(str2);
        L.append(a(videoDecoderCounters));
        L.append(" vfpo: ");
        long j = videoDecoderCounters.totalVideoFrameProcessingOffsetUs;
        int i = videoDecoderCounters.videoFrameProcessingOffsetCount;
        if (i == 0) {
            str = UploadServiceLogger.NA;
        } else {
            str = String.valueOf((long) (((double) j) / ((double) i)));
        }
        return a.t(L, str, ")");
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
    public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
        k0.$default$onMediaItemTransition(this, mediaItem, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayWhenReadyChanged(boolean z, int i) {
        updateAndPost();
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        k0.$default$onPlaybackParametersChanged(this, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlaybackStateChanged(int i) {
        updateAndPost();
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
        k0.$default$onPlaybackSuppressionReasonChanged(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
        k0.$default$onPlayerError(this, exoPlaybackException);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
        k0.$default$onPlayerStateChanged(this, z, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPositionDiscontinuity(int i) {
        updateAndPost();
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onRepeatModeChanged(int i) {
        k0.$default$onRepeatModeChanged(this, i);
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
    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
        k0.$default$onTimelineChanged(this, timeline, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
        k0.$default$onTimelineChanged(this, timeline, obj, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        k0.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
    }

    @Override // java.lang.Runnable
    public final void run() {
        updateAndPost();
    }

    public final void start() {
        if (!this.c) {
            this.c = true;
            this.a.addListener(this);
            updateAndPost();
        }
    }

    public final void stop() {
        if (this.c) {
            this.c = false;
            this.a.removeListener(this);
            this.b.removeCallbacks(this);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void updateAndPost() {
        this.b.setText(getDebugString());
        this.b.removeCallbacks(this);
        this.b.postDelayed(this, 1000);
    }
}
