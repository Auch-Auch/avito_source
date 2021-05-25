package com.google.android.exoplayer2.analytics;

import a2.j.b.b.k0;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
public class AnalyticsCollector implements Player.EventListener, MetadataOutput, AudioRendererEventListener, VideoRendererEventListener, MediaSourceEventListener, BandwidthMeter.EventListener, DrmSessionEventListener, VideoListener, AudioListener {
    public final CopyOnWriteArraySet<AnalyticsListener> a = new CopyOnWriteArraySet<>();
    public final Clock b;
    public final Timeline.Period c;
    public final Timeline.Window d;
    public final a e;
    public Player f;
    public boolean g;

    public static final class a {
        public final Timeline.Period a;
        public ImmutableList<MediaSource.MediaPeriodId> b = ImmutableList.of();
        public ImmutableMap<MediaSource.MediaPeriodId, Timeline> c = ImmutableMap.of();
        @Nullable
        public MediaSource.MediaPeriodId d;
        public MediaSource.MediaPeriodId e;
        public MediaSource.MediaPeriodId f;

        public a(Timeline.Period period) {
            this.a = period;
        }

        @Nullable
        public static MediaSource.MediaPeriodId b(Player player, ImmutableList<MediaSource.MediaPeriodId> immutableList, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Timeline.Period period) {
            Timeline currentTimeline = player.getCurrentTimeline();
            int currentPeriodIndex = player.getCurrentPeriodIndex();
            Object uidOfPeriod = currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(currentPeriodIndex);
            int adGroupIndexAfterPositionUs = (player.isPlayingAd() || currentTimeline.isEmpty()) ? -1 : currentTimeline.getPeriod(currentPeriodIndex, period).getAdGroupIndexAfterPositionUs(C.msToUs(player.getCurrentPosition()) - period.getPositionInWindowUs());
            for (int i = 0; i < immutableList.size(); i++) {
                MediaSource.MediaPeriodId mediaPeriodId2 = immutableList.get(i);
                if (c(mediaPeriodId2, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodId2;
                }
            }
            if (!immutableList.isEmpty() || mediaPeriodId == null || !c(mediaPeriodId, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                return null;
            }
            return mediaPeriodId;
        }

        public static boolean c(MediaSource.MediaPeriodId mediaPeriodId, @Nullable Object obj, boolean z, int i, int i2, int i3) {
            if (!mediaPeriodId.periodUid.equals(obj)) {
                return false;
            }
            if ((z && mediaPeriodId.adGroupIndex == i && mediaPeriodId.adIndexInAdGroup == i2) || (!z && mediaPeriodId.adGroupIndex == -1 && mediaPeriodId.nextAdGroupIndex == i3)) {
                return true;
            }
            return false;
        }

        public final void a(ImmutableMap.Builder<MediaSource.MediaPeriodId, Timeline> builder, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            if (mediaPeriodId != null) {
                if (timeline.getIndexOfPeriod(mediaPeriodId.periodUid) != -1) {
                    builder.put(mediaPeriodId, timeline);
                    return;
                }
                Timeline timeline2 = this.c.get(mediaPeriodId);
                if (timeline2 != null) {
                    builder.put(mediaPeriodId, timeline2);
                }
            }
        }

        public final void d(Timeline timeline) {
            ImmutableMap.Builder<MediaSource.MediaPeriodId, Timeline> builder = ImmutableMap.builder();
            if (this.b.isEmpty()) {
                a(builder, this.e, timeline);
                if (!Objects.equal(this.f, this.e)) {
                    a(builder, this.f, timeline);
                }
                if (!Objects.equal(this.d, this.e) && !Objects.equal(this.d, this.f)) {
                    a(builder, this.d, timeline);
                }
            } else {
                for (int i = 0; i < this.b.size(); i++) {
                    a(builder, this.b.get(i), timeline);
                }
                if (!this.b.contains(this.d)) {
                    a(builder, this.d, timeline);
                }
            }
            this.c = builder.build();
        }
    }

    public AnalyticsCollector(Clock clock) {
        this.b = (Clock) Assertions.checkNotNull(clock);
        Timeline.Period period = new Timeline.Period();
        this.c = period;
        this.d = new Timeline.Window();
        this.e = new a(period);
    }

    public final AnalyticsListener.EventTime a() {
        return b(this.e.d);
    }

    public void addListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.a.add(analyticsListener);
    }

    public final AnalyticsListener.EventTime b(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline;
        Assertions.checkNotNull(this.f);
        if (mediaPeriodId == null) {
            timeline = null;
        } else {
            timeline = this.e.c.get(mediaPeriodId);
        }
        if (mediaPeriodId != null && timeline != null) {
            return generateEventTime(timeline, timeline.getPeriodByUid(mediaPeriodId.periodUid, this.c).windowIndex, mediaPeriodId);
        }
        int currentWindowIndex = this.f.getCurrentWindowIndex();
        Timeline currentTimeline = this.f.getCurrentTimeline();
        if (!(currentWindowIndex < currentTimeline.getWindowCount())) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, currentWindowIndex, null);
    }

    public final AnalyticsListener.EventTime c(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.checkNotNull(this.f);
        boolean z = false;
        if (mediaPeriodId != null) {
            if (this.e.c.get(mediaPeriodId) != null) {
                z = true;
            }
            if (z) {
                return b(mediaPeriodId);
            }
            return generateEventTime(Timeline.EMPTY, i, mediaPeriodId);
        }
        Timeline currentTimeline = this.f.getCurrentTimeline();
        if (i < currentTimeline.getWindowCount()) {
            z = true;
        }
        if (!z) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, i, null);
    }

    public final AnalyticsListener.EventTime d() {
        return b(this.e.e);
    }

    public final AnalyticsListener.EventTime e() {
        return b(this.e.f);
    }

    @RequiresNonNull({ScreenPublicConstsKt.CONTENT_TYPE_PLAYER})
    public AnalyticsListener.EventTime generateEventTime(Timeline timeline, int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        long j;
        MediaSource.MediaPeriodId mediaPeriodId2 = timeline.isEmpty() ? null : mediaPeriodId;
        long elapsedRealtime = this.b.elapsedRealtime();
        boolean z = false;
        boolean z2 = timeline.equals(this.f.getCurrentTimeline()) && i == this.f.getCurrentWindowIndex();
        long j2 = 0;
        if (mediaPeriodId2 != null && mediaPeriodId2.isAd()) {
            if (z2 && this.f.getCurrentAdGroupIndex() == mediaPeriodId2.adGroupIndex && this.f.getCurrentAdIndexInAdGroup() == mediaPeriodId2.adIndexInAdGroup) {
                z = true;
            }
            if (z) {
                j2 = this.f.getCurrentPosition();
            }
        } else if (z2) {
            j = this.f.getContentPosition();
            return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i, mediaPeriodId2, j, this.f.getCurrentTimeline(), this.f.getCurrentWindowIndex(), this.e.d, this.f.getCurrentPosition(), this.f.getTotalBufferedDuration());
        } else if (!timeline.isEmpty()) {
            j2 = timeline.getWindow(i, this.d).getDefaultPositionMs();
        }
        j = j2;
        return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i, mediaPeriodId2, j, this.f.getCurrentTimeline(), this.f.getCurrentWindowIndex(), this.e.d, this.f.getCurrentPosition(), this.f.getTotalBufferedDuration());
    }

    public final void notifySeekStarted() {
        if (!this.g) {
            AnalyticsListener.EventTime a3 = a();
            this.g = true;
            Iterator<AnalyticsListener> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onSeekStarted(a3);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioListener
    public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onAudioAttributesChanged(e2, audioAttributes);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDecoderInitialized(String str, long j, long j2) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            AnalyticsListener next = it.next();
            next.onAudioDecoderInitialized(e2, str, j2);
            next.onDecoderInitialized(e2, 1, str, j2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime d2 = d();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            AnalyticsListener next = it.next();
            next.onAudioDisabled(d2, decoderCounters);
            next.onDecoderDisabled(d2, 1, decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            AnalyticsListener next = it.next();
            next.onAudioEnabled(e2, decoderCounters);
            next.onDecoderEnabled(e2, 1, decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioInputFormatChanged(Format format) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            AnalyticsListener next = it.next();
            next.onAudioInputFormatChanged(e2, format);
            next.onDecoderInputFormatChanged(e2, 1, format);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioPositionAdvancing(long j) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onAudioPositionAdvancing(e2, j);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioSessionId(int i) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onAudioSessionId(e2, i);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioUnderrun(int i, long j, long j2) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onAudioUnderrun(e2, i, j, j2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener
    public final void onBandwidthSample(int i, long j, long j2) {
        a aVar = this.e;
        AnalyticsListener.EventTime b2 = b(aVar.b.isEmpty() ? null : (MediaSource.MediaPeriodId) Iterables.getLast(aVar.b));
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onBandwidthEstimate(b2, i, j, j2);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onDownstreamFormatChanged(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime c2 = c(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDownstreamFormatChanged(c2, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysLoaded(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime c2 = c(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysLoaded(c2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRemoved(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime c2 = c(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysRemoved(c2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRestored(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime c2 = c(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysRestored(c2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionAcquired(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime c2 = c(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionAcquired(c2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionManagerError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        AnalyticsListener.EventTime c2 = c(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionManagerError(c2, exc);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionReleased(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime c2 = c(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionReleased(c2);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onDroppedFrames(int i, long j) {
        AnalyticsListener.EventTime d2 = d();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDroppedVideoFrames(d2, i, j);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
        k0.$default$onExperimentalOffloadSchedulingEnabledChanged(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onIsLoadingChanged(boolean z) {
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onIsLoadingChanged(a3, z);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onIsPlayingChanged(boolean z) {
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onIsPlayingChanged(a3, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCanceled(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime c2 = c(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onLoadCanceled(c2, loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCompleted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime c2 = c(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onLoadCompleted(c2, loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        AnalyticsListener.EventTime c2 = c(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onLoadError(c2, loadEventInfo, mediaLoadData, iOException, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadStarted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime c2 = c(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onLoadStarted(c2, loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onLoadingChanged(boolean z) {
        k0.$default$onLoadingChanged(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onMediaItemTransition(@Nullable MediaItem mediaItem, int i) {
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onMediaItemTransition(a3, mediaItem, i);
        }
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataOutput
    public final void onMetadata(Metadata metadata) {
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onMetadata(a3, metadata);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayWhenReadyChanged(boolean z, int i) {
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onPlayWhenReadyChanged(a3, z, i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackParametersChanged(a3, playbackParameters);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlaybackStateChanged(int i) {
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackStateChanged(a3, i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackSuppressionReasonChanged(int i) {
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackSuppressionReasonChanged(a3, i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayerError(ExoPlaybackException exoPlaybackException) {
        AnalyticsListener.EventTime eventTime;
        MediaSource.MediaPeriodId mediaPeriodId = exoPlaybackException.mediaPeriodId;
        if (mediaPeriodId != null) {
            eventTime = b(mediaPeriodId);
        } else {
            eventTime = a();
        }
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onPlayerError(eventTime, exoPlaybackException);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayerStateChanged(boolean z, int i) {
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onPlayerStateChanged(a3, z, i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPositionDiscontinuity(int i) {
        if (i == 1) {
            this.g = false;
        }
        a aVar = this.e;
        aVar.d = a.b((Player) Assertions.checkNotNull(this.f), aVar.b, aVar.e, aVar.a);
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity(a3, i);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public final void onRenderedFirstFrame() {
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onRenderedFirstFrame(@Nullable Surface surface) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onRenderedFirstFrame(e2, surface);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onRepeatModeChanged(int i) {
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onRepeatModeChanged(a3, i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onSeekProcessed() {
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onSeekProcessed(a3);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onShuffleModeEnabledChanged(boolean z) {
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onShuffleModeChanged(a3, z);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onSkipSilenceEnabledChanged(boolean z) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onSkipSilenceEnabledChanged(e2, z);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onSurfaceSizeChanged(int i, int i2) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceSizeChanged(e2, i, i2);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onTimelineChanged(Timeline timeline, int i) {
        a aVar = this.e;
        Player player = (Player) Assertions.checkNotNull(this.f);
        aVar.d = a.b(player, aVar.b, aVar.e, aVar.a);
        aVar.d(player.getCurrentTimeline());
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onTimelineChanged(a3, i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
        k0.$default$onTimelineChanged(this, timeline, obj, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        AnalyticsListener.EventTime a3 = a();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onTracksChanged(a3, trackGroupArray, trackSelectionArray);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onUpstreamDiscarded(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime c2 = c(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onUpstreamDiscarded(c2, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDecoderInitialized(String str, long j, long j2) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            AnalyticsListener next = it.next();
            next.onVideoDecoderInitialized(e2, str, j2);
            next.onDecoderInitialized(e2, 2, str, j2);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime d2 = d();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            AnalyticsListener next = it.next();
            next.onVideoDisabled(d2, decoderCounters);
            next.onDecoderDisabled(d2, 2, decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            AnalyticsListener next = it.next();
            next.onVideoEnabled(e2, decoderCounters);
            next.onDecoderEnabled(e2, 2, decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoFrameProcessingOffset(long j, int i) {
        AnalyticsListener.EventTime d2 = d();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onVideoFrameProcessingOffset(d2, j, i);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoInputFormatChanged(Format format) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            AnalyticsListener next = it.next();
            next.onVideoInputFormatChanged(e2, format);
            next.onDecoderInputFormatChanged(e2, 2, format);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoSizeChanged(int i, int i2, int i3, float f2) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(e2, i, i2, i3, f2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioListener
    public void onVolumeChanged(float f2) {
        AnalyticsListener.EventTime e2 = e();
        Iterator<AnalyticsListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onVolumeChanged(e2, f2);
        }
    }

    public void removeListener(AnalyticsListener analyticsListener) {
        this.a.remove(analyticsListener);
    }

    public final void resetForNewPlaylist() {
    }

    public void setPlayer(Player player) {
        Assertions.checkState(this.f == null || this.e.b.isEmpty());
        this.f = (Player) Assertions.checkNotNull(player);
    }

    public void updateMediaPeriodQueueInfo(List<MediaSource.MediaPeriodId> list, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        a aVar = this.e;
        Player player = (Player) Assertions.checkNotNull(this.f);
        java.util.Objects.requireNonNull(aVar);
        aVar.b = ImmutableList.copyOf((Collection) list);
        if (!list.isEmpty()) {
            aVar.e = list.get(0);
            aVar.f = (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId);
        }
        if (aVar.d == null) {
            aVar.d = a.b(player, aVar.b, aVar.e, aVar.a);
        }
        aVar.d(player.getCurrentTimeline());
    }
}
