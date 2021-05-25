package com.google.android.exoplayer2.util;

import a2.b.a.a.a;
import a2.j.b.b.n0;
import a2.j.b.b.q0.b;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import okhttp3.HttpUrl;
public class EventLogger implements AnalyticsListener {
    public static final NumberFormat f;
    @Nullable
    public final MappingTrackSelector a;
    public final String b;
    public final Timeline.Window c;
    public final Timeline.Period d;
    public final long e;

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        f = instance;
        instance.setMinimumFractionDigits(2);
        instance.setMaximumFractionDigits(2);
        instance.setGroupingUsed(false);
    }

    public EventLogger(@Nullable MappingTrackSelector mappingTrackSelector) {
        this(mappingTrackSelector, "EventLogger");
    }

    public static String c(long j) {
        return j == C.TIME_UNSET ? "?" : f.format((double) (((float) j) / 1000.0f));
    }

    public final String a(AnalyticsListener.EventTime eventTime, String str, @Nullable String str2, @Nullable Throwable th) {
        StringBuilder Q = a.Q(str, " [");
        Q.append(b(eventTime));
        String sb = Q.toString();
        if (str2 != null) {
            sb = a.e3(sb, ", ", str2);
        }
        String throwableString = Log.getThrowableString(th);
        if (!TextUtils.isEmpty(throwableString)) {
            StringBuilder Q2 = a.Q(sb, "\n  ");
            Q2.append(throwableString.replace("\n", "\n  "));
            Q2.append('\n');
            sb = Q2.toString();
        }
        return a.c3(sb, "]");
    }

    public final String b(AnalyticsListener.EventTime eventTime) {
        StringBuilder L = a.L("window=");
        L.append(eventTime.windowIndex);
        String sb = L.toString();
        if (eventTime.mediaPeriodId != null) {
            StringBuilder Q = a.Q(sb, ", period=");
            Q.append(eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid));
            sb = Q.toString();
            if (eventTime.mediaPeriodId.isAd()) {
                StringBuilder Q2 = a.Q(sb, ", adGroup=");
                Q2.append(eventTime.mediaPeriodId.adGroupIndex);
                StringBuilder Q3 = a.Q(Q2.toString(), ", ad=");
                Q3.append(eventTime.mediaPeriodId.adIndexInAdGroup);
                sb = Q3.toString();
            }
        }
        StringBuilder L2 = a.L("eventTime=");
        L2.append(c(eventTime.realtimeMs - this.e));
        L2.append(", mediaPos=");
        L2.append(c(eventTime.eventPlaybackPositionMs));
        L2.append(", ");
        L2.append(sb);
        return L2.toString();
    }

    public final void d(Metadata metadata, String str) {
        for (int i = 0; i < metadata.length(); i++) {
            StringBuilder L = a.L(str);
            L.append(metadata.get(i));
            logd(L.toString());
        }
    }

    public void logd(String str) {
        Log.d(this.b, str);
    }

    public void loge(String str) {
        Log.e(this.b, str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        logd(a(eventTime, "audioAttributes", audioAttributes.contentType + "," + audioAttributes.flags + "," + audioAttributes.usage + "," + audioAttributes.allowedCapturePolicy, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
        logd(a(eventTime, "audioDecoderInitialized", str, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(a(eventTime, "audioDisabled", null, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(a(eventTime, "audioEnabled", null, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        logd(a(eventTime, "audioInputFormat", Format.toLogString(format), null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j) {
        b.$default$onAudioPositionAdvancing(this, eventTime, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioSessionId(AnalyticsListener.EventTime eventTime, int i) {
        logd(a(eventTime, "audioSessionId", Integer.toString(i), null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        loge(a(eventTime, "audioTrackUnderrun", i + ", " + j + ", " + j2, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        b.$default$onDecoderDisabled(this, eventTime, i, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        b.$default$onDecoderEnabled(this, eventTime, i, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i, String str, long j) {
        b.$default$onDecoderInitialized(this, eventTime, i, str, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i, Format format) {
        b.$default$onDecoderInputFormatChanged(this, eventTime, i, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        logd(a(eventTime, "downstreamFormat", Format.toLogString(mediaLoadData.trackFormat), null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        logd(a(eventTime, "drmKeysLoaded", null, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        logd(a(eventTime, "drmKeysRemoved", null, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        logd(a(eventTime, "drmKeysRestored", null, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        logd(a(eventTime, "drmSessionAcquired", null, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        loge(a(eventTime, "internalError", "drmSessionManagerError", exc));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        logd(a(eventTime, "drmSessionReleased", null, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
        logd(a(eventTime, "droppedFrames", Integer.toString(i), null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        logd(a(eventTime, "loading", Boolean.toString(z), null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        logd(a(eventTime, "isPlaying", Boolean.toString(z), null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        loge(a(eventTime, "internalError", "loadError", iOException));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        b.$default$onLoadingChanged(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onMediaItemTransition(AnalyticsListener.EventTime eventTime, @Nullable MediaItem mediaItem, int i) {
        StringBuilder L = a.L("mediaItem [");
        L.append(b(eventTime));
        L.append(", reason=");
        L.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? "?" : "PLAYLIST_CHANGED" : "SEEK" : "AUTO" : "REPEAT");
        L.append("]");
        logd(L.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        StringBuilder L = a.L("metadata [");
        L.append(b(eventTime));
        logd(L.toString());
        d(metadata, "  ");
        logd("]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        sb.append(", ");
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "?" : "END_OF_MEDIA_ITEM" : "REMOTE" : "AUDIO_BECOMING_NOISY" : "AUDIO_FOCUS_LOSS" : "USER_REQUEST");
        logd(a(eventTime, "playWhenReady", sb.toString(), null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        logd(a(eventTime, "playbackParameters", playbackParameters.toString(), null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i) {
        logd(a(eventTime, "state", i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE", null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i) {
        logd(a(eventTime, "playbackSuppressionReason", i != 0 ? i != 1 ? "?" : "TRANSIENT_AUDIO_FOCUS_LOSS" : "NONE", null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        loge(a(eventTime, "playerFailed", null, exoPlaybackException));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        b.$default$onPlayerStateChanged(this, eventTime, z, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
        logd(a(eventTime, "positionDiscontinuity", i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION", null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, @Nullable Surface surface) {
        logd(a(eventTime, "renderedFirstFrame", String.valueOf(surface), null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i) {
        logd(a(eventTime, "repeatMode", i != 0 ? i != 1 ? i != 2 ? "?" : "ALL" : "ONE" : "OFF", null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        b.$default$onSeekProcessed(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        logd(a(eventTime, "seekStarted", null, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        logd(a(eventTime, "shuffleModeEnabled", Boolean.toString(z), null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        logd(a(eventTime, "skipSilenceEnabled", Boolean.toString(z), null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2) {
        logd(a(eventTime, "surfaceSize", i + ", " + i2, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i) {
        int periodCount = eventTime.timeline.getPeriodCount();
        int windowCount = eventTime.timeline.getWindowCount();
        StringBuilder L = a.L("timeline [");
        L.append(b(eventTime));
        L.append(", periodCount=");
        L.append(periodCount);
        L.append(", windowCount=");
        L.append(windowCount);
        L.append(", reason=");
        L.append(i != 0 ? i != 1 ? "?" : "SOURCE_UPDATE" : "PLAYLIST_CHANGED");
        logd(L.toString());
        for (int i2 = 0; i2 < Math.min(periodCount, 3); i2++) {
            eventTime.timeline.getPeriod(i2, this.d);
            logd("  period [" + c(this.d.getDurationMs()) + "]");
        }
        if (periodCount > 3) {
            logd("  ...");
        }
        for (int i3 = 0; i3 < Math.min(windowCount, 3); i3++) {
            eventTime.timeline.getWindow(i3, this.c);
            logd("  window [" + c(this.c.getDurationMs()) + ", " + this.c.isSeekable + ", " + this.c.isDynamic + "]");
        }
        if (windowCount > 3) {
            logd("  ...");
        }
        logd("]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        String str;
        MappingTrackSelector mappingTrackSelector = this.a;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = mappingTrackSelector != null ? mappingTrackSelector.getCurrentMappedTrackInfo() : null;
        if (currentMappedTrackInfo == null) {
            logd(a(eventTime, "tracks", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, null));
            return;
        }
        StringBuilder L = a.L("tracks [");
        L.append(b(eventTime));
        logd(L.toString());
        int rendererCount = currentMappedTrackInfo.getRendererCount();
        int i = 0;
        while (true) {
            String str2 = "[ ]";
            String str3 = "  ]";
            if (i < rendererCount) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
                TrackSelection trackSelection = trackSelectionArray.get(i);
                if (trackGroups.length == 0) {
                    StringBuilder L2 = a.L("  ");
                    L2.append(currentMappedTrackInfo.getRendererName(i));
                    L2.append(" []");
                    logd(L2.toString());
                } else {
                    StringBuilder L3 = a.L("  ");
                    L3.append(currentMappedTrackInfo.getRendererName(i));
                    L3.append(" [");
                    logd(L3.toString());
                    int i2 = 0;
                    while (i2 < trackGroups.length) {
                        TrackGroup trackGroup = trackGroups.get(i2);
                        int i3 = trackGroup.length;
                        int adaptiveSupport = currentMappedTrackInfo.getAdaptiveSupport(i, i2, false);
                        if (i3 < 2) {
                            str = UploadServiceLogger.NA;
                        } else if (adaptiveSupport == 0) {
                            str = "NO";
                        } else if (adaptiveSupport == 8) {
                            str = "YES_NOT_SEAMLESS";
                        } else if (adaptiveSupport == 16) {
                            str = "YES";
                        } else {
                            throw new IllegalStateException();
                        }
                        logd("    Group:" + i2 + ", adaptive_supported=" + str + " [");
                        int i4 = 0;
                        while (i4 < trackGroup.length) {
                            String str4 = trackSelection != null && trackSelection.getTrackGroup() == trackGroup && trackSelection.indexOf(i4) != -1 ? "[X]" : str2;
                            String a3 = n0.a(currentMappedTrackInfo.getTrackSupport(i, i2, i4));
                            StringBuilder S = a.S("      ", str4, " Track:", i4, ", ");
                            S.append(Format.toLogString(trackGroup.getFormat(i4)));
                            S.append(", supported=");
                            S.append(a3);
                            logd(S.toString());
                            i4++;
                            trackGroup = trackGroup;
                        }
                        logd("    ]");
                        i2++;
                        trackGroups = trackGroups;
                        str2 = str2;
                        str3 = str3;
                    }
                    if (trackSelection != null) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= trackSelection.length()) {
                                break;
                            }
                            Metadata metadata = trackSelection.getFormat(i5).metadata;
                            if (metadata != null) {
                                logd("    Metadata [");
                                d(metadata, "      ");
                                logd("    ]");
                                break;
                            }
                            i5++;
                        }
                    }
                    logd(str3);
                }
                i++;
                rendererCount = rendererCount;
            } else {
                String str5 = str2;
                TrackGroupArray unmappedTrackGroups = currentMappedTrackInfo.getUnmappedTrackGroups();
                if (unmappedTrackGroups.length > 0) {
                    logd("  Unmapped [");
                    for (int i6 = 0; i6 < unmappedTrackGroups.length; i6++) {
                        logd("    Group:" + i6 + " [");
                        TrackGroup trackGroup2 = unmappedTrackGroups.get(i6);
                        int i7 = 0;
                        while (i7 < trackGroup2.length) {
                            String a4 = n0.a(0);
                            StringBuilder S2 = a.S("      ", str5, " Track:", i7, ", ");
                            S2.append(Format.toLogString(trackGroup2.getFormat(i7)));
                            S2.append(", supported=");
                            S2.append(a4);
                            logd(S2.toString());
                            i7++;
                            unmappedTrackGroups = unmappedTrackGroups;
                            str5 = str5;
                        }
                        logd("    ]");
                    }
                    logd(str3);
                }
                logd("]");
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        logd(a(eventTime, "upstreamDiscarded", Format.toLogString(mediaLoadData.trackFormat), null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
        logd(a(eventTime, "videoDecoderInitialized", str, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(a(eventTime, "videoDisabled", null, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(a(eventTime, "videoEnabled", null, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j, int i) {
        b.$default$onVideoFrameProcessingOffset(this, eventTime, j, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        logd(a(eventTime, "videoInputFormat", Format.toLogString(format), null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f2) {
        logd(a(eventTime, "videoSize", i + ", " + i2, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f2) {
        logd(a(eventTime, "volume", Float.toString(f2), null));
    }

    public EventLogger(@Nullable MappingTrackSelector mappingTrackSelector, String str) {
        this.a = mappingTrackSelector;
        this.b = str;
        this.c = new Timeline.Window();
        this.d = new Timeline.Period();
        this.e = SystemClock.elapsedRealtime();
    }
}
