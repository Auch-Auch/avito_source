package com.google.android.exoplayer2.analytics;

import a2.j.b.b.q0.b;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.analytics.PlaybackStats;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
public final class PlaybackStatsListener implements AnalyticsListener, PlaybackSessionManager.Listener {
    public final PlaybackSessionManager a;
    public final Map<String, a> b = new HashMap();
    public final Map<String, AnalyticsListener.EventTime> c = new HashMap();
    @Nullable
    public final Callback d;
    public final boolean e;
    public final Timeline.Period f = new Timeline.Period();
    public PlaybackStats g = PlaybackStats.EMPTY;
    @Nullable
    public String h;
    @Nullable
    public String i;
    public boolean j = false;
    public int k = 1;
    public boolean l;
    public float m = 1.0f;
    public boolean n;

    public interface Callback {
        void onPlaybackStatsReady(AnalyticsListener.EventTime eventTime, PlaybackStats playbackStats);
    }

    public static final class a {
        public long A;
        public long B;
        public long C;
        public long D;
        public long E;
        public int F;
        public int G;
        public int H;
        public long I;
        public boolean J;
        public boolean K;
        public boolean L;
        public boolean M;
        public boolean N;
        public int O;
        public boolean P;
        public boolean Q;
        public boolean R;
        public long S;
        @Nullable
        public Format T;
        @Nullable
        public Format U;
        public long V;
        public long W;
        public float X;
        public final boolean a;
        public final long[] b = new long[16];
        public final List<PlaybackStats.EventTimeAndPlaybackState> c;
        public final List<long[]> d;
        public final List<PlaybackStats.EventTimeAndFormat> e;
        public final List<PlaybackStats.EventTimeAndFormat> f;
        public final List<PlaybackStats.EventTimeAndException> g;
        public final List<PlaybackStats.EventTimeAndException> h;
        public final boolean i;
        public long j;
        public boolean k;
        public boolean l;
        public boolean m;
        public int n;
        public int o;
        public int p;
        public int q;
        public long r;
        public int s;
        public long t;
        public long u;
        public long v;
        public long w;
        public long x;
        public long y;
        public long z;

        public a(boolean z2, AnalyticsListener.EventTime eventTime) {
            this.a = z2;
            this.c = z2 ? new ArrayList<>() : Collections.emptyList();
            this.d = z2 ? new ArrayList<>() : Collections.emptyList();
            this.e = z2 ? new ArrayList<>() : Collections.emptyList();
            this.f = z2 ? new ArrayList<>() : Collections.emptyList();
            this.g = z2 ? new ArrayList<>() : Collections.emptyList();
            this.h = z2 ? new ArrayList<>() : Collections.emptyList();
            boolean z3 = false;
            this.H = 0;
            this.I = eventTime.realtimeMs;
            this.O = 1;
            this.j = C.TIME_UNSET;
            this.r = C.TIME_UNSET;
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
            if (mediaPeriodId != null && mediaPeriodId.isAd()) {
                z3 = true;
            }
            this.i = z3;
            this.u = -1;
            this.t = -1;
            this.s = -1;
            this.X = 1.0f;
        }

        public static boolean c(int i2) {
            return i2 == 6 || i2 == 7 || i2 == 10;
        }

        public PlaybackStats a(boolean z2) {
            ArrayList arrayList;
            long[] jArr;
            long j2;
            long[] jArr2 = this.b;
            List<long[]> list = this.d;
            if (!z2) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long[] copyOf = Arrays.copyOf(this.b, 16);
                long max = Math.max(0L, elapsedRealtime - this.I);
                int i2 = this.H;
                copyOf[i2] = copyOf[i2] + max;
                g(elapsedRealtime);
                e(elapsedRealtime);
                d(elapsedRealtime);
                ArrayList arrayList2 = new ArrayList(this.d);
                if (this.a && this.H == 3) {
                    arrayList2.add(b(elapsedRealtime));
                }
                jArr = copyOf;
                arrayList = arrayList2;
            } else {
                jArr = jArr2;
                arrayList = list;
            }
            int i3 = (this.m || !this.k) ? 1 : 0;
            if (i3 != 0) {
                j2 = C.TIME_UNSET;
            } else {
                j2 = jArr[2];
            }
            int i4 = jArr[1] > 0 ? 1 : 0;
            List arrayList3 = z2 ? this.e : new ArrayList(this.e);
            List arrayList4 = z2 ? this.f : new ArrayList(this.f);
            List arrayList5 = z2 ? this.c : new ArrayList(this.c);
            long j3 = this.j;
            boolean z3 = this.K;
            int i5 = !this.k ? 1 : 0;
            boolean z4 = this.l;
            int i6 = i3 ^ 1;
            int i7 = this.n;
            int i8 = this.o;
            int i9 = this.p;
            int i10 = this.q;
            long j4 = this.r;
            boolean z5 = this.i;
            long j5 = this.v;
            long j6 = this.w;
            long j7 = this.x;
            long j8 = this.y;
            long j9 = this.z;
            long j10 = this.A;
            int i11 = this.s;
            int i12 = i11 == -1 ? 0 : 1;
            long j11 = this.t;
            int i13 = j11 == -1 ? 0 : 1;
            long j12 = this.u;
            int i14 = j12 == -1 ? 0 : 1;
            long j13 = this.B;
            long j14 = this.C;
            long j15 = this.D;
            long j16 = this.E;
            int i15 = this.F;
            return new PlaybackStats(1, jArr, arrayList5, arrayList, j3, z3 ? 1 : 0, i5, z4 ? 1 : 0, i4, j2, i6, i7, i8, i9, i10, j4, z5 ? 1 : 0, arrayList3, arrayList4, j5, j6, j7, j8, j9, j10, i12, i13, i11, j11, i14, j12, j13, j14, j15, j16, i15 > 0 ? 1 : 0, i15, this.G, this.g, this.h);
        }

        public final long[] b(long j2) {
            long[] jArr = (long[]) a2.b.a.a.a.j2(this.d, 1);
            return new long[]{j2, jArr[1] + ((long) (((float) (j2 - jArr[0])) * this.X))};
        }

        public final void d(long j2) {
            Format format;
            int i2;
            if (!(this.H != 3 || (format = this.U) == null || (i2 = format.bitrate) == -1)) {
                long j3 = (long) (((float) (j2 - this.W)) * this.X);
                this.z += j3;
                this.A = (j3 * ((long) i2)) + this.A;
            }
            this.W = j2;
        }

        public final void e(long j2) {
            Format format;
            if (this.H == 3 && (format = this.T) != null) {
                long j3 = (long) (((float) (j2 - this.V)) * this.X);
                int i2 = format.height;
                if (i2 != -1) {
                    this.v += j3;
                    this.w = (((long) i2) * j3) + this.w;
                }
                int i3 = format.bitrate;
                if (i3 != -1) {
                    this.x += j3;
                    this.y = (j3 * ((long) i3)) + this.y;
                }
            }
            this.V = j2;
        }

        public final void f(AnalyticsListener.EventTime eventTime, @Nullable Format format) {
            int i2;
            if (!Util.areEqual(this.U, format)) {
                d(eventTime.realtimeMs);
                if (!(format == null || this.u != -1 || (i2 = format.bitrate) == -1)) {
                    this.u = (long) i2;
                }
                this.U = format;
                if (this.a) {
                    this.f.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
                }
            }
        }

        public final void g(long j2) {
            if (c(this.H)) {
                long j3 = j2 - this.S;
                long j4 = this.r;
                if (j4 == C.TIME_UNSET || j3 > j4) {
                    this.r = j3;
                }
            }
        }

        public final void h(long j2, long j3) {
            if (this.a) {
                if (this.H != 3) {
                    if (j3 != C.TIME_UNSET) {
                        if (!this.d.isEmpty()) {
                            long j4 = ((long[]) a2.b.a.a.a.j2(this.d, 1))[1];
                            if (j4 != j3) {
                                this.d.add(new long[]{j2, j4});
                            }
                        }
                    } else {
                        return;
                    }
                }
                this.d.add(j3 == C.TIME_UNSET ? b(j2) : new long[]{j2, j3});
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v24, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0080 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0081  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void i(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime r21, boolean r22) {
            /*
            // Method dump skipped, instructions count: 349
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.analytics.PlaybackStatsListener.a.i(com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime, boolean):void");
        }

        public final void j(AnalyticsListener.EventTime eventTime, @Nullable Format format) {
            int i2;
            int i3;
            if (!Util.areEqual(this.T, format)) {
                e(eventTime.realtimeMs);
                if (format != null) {
                    if (this.s == -1 && (i3 = format.height) != -1) {
                        this.s = i3;
                    }
                    if (this.t == -1 && (i2 = format.bitrate) != -1) {
                        this.t = (long) i2;
                    }
                }
                this.T = format;
                if (this.a) {
                    this.e.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
                }
            }
        }

        public void k(AnalyticsListener.EventTime eventTime, int i2, boolean z2) {
            this.O = i2;
            if (i2 != 1) {
                this.Q = false;
            }
            if (i2 != 2) {
                this.J = false;
            }
            if (i2 == 1 || i2 == 4) {
                this.L = false;
            }
            i(eventTime, z2);
        }
    }

    public PlaybackStatsListener(boolean z, @Nullable Callback callback) {
        this.d = callback;
        this.e = z;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.a = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.setListener(this);
    }

    public final void a(AnalyticsListener.EventTime eventTime) {
        boolean z = true;
        if (!eventTime.timeline.isEmpty() || this.k != 1) {
            z = false;
        }
        if (!z) {
            this.a.updateSessions(eventTime);
        }
    }

    public void finishAllSessions() {
        PlaybackSessionManager playbackSessionManager = this.a;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Timeline timeline = Timeline.EMPTY;
        playbackSessionManager.finishAllSessions(new AnalyticsListener.EventTime(elapsedRealtime, timeline, 0, null, 0, timeline, 0, null, 0, 0));
    }

    public PlaybackStats getCombinedPlaybackStats() {
        int i2 = 1;
        PlaybackStats[] playbackStatsArr = new PlaybackStats[(this.b.size() + 1)];
        playbackStatsArr[0] = this.g;
        for (a aVar : this.b.values()) {
            playbackStatsArr[i2] = aVar.a(false);
            i2++;
        }
        return PlaybackStats.merge(playbackStatsArr);
    }

    @Nullable
    public PlaybackStats getPlaybackStats() {
        a aVar;
        String str = this.i;
        if (str != null) {
            aVar = this.b.get(str);
        } else {
            String str2 = this.h;
            aVar = str2 != null ? this.b.get(str2) : null;
        }
        if (aVar == null) {
            return null;
        }
        return aVar.a(false);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onAdPlaybackStarted(AnalyticsListener.EventTime eventTime, String str, String str2) {
        Assertions.checkState(((MediaSource.MediaPeriodId) Assertions.checkNotNull(eventTime.mediaPeriodId)).isAd());
        long adGroupTimeUs = eventTime.timeline.getPeriodByUid(eventTime.mediaPeriodId.periodUid, this.f).getAdGroupTimeUs(eventTime.mediaPeriodId.adGroupIndex);
        long j2 = Long.MIN_VALUE;
        if (adGroupTimeUs != Long.MIN_VALUE) {
            j2 = this.f.getPositionInWindowUs() + adGroupTimeUs;
        }
        long j3 = eventTime.realtimeMs;
        Timeline timeline = eventTime.timeline;
        int i2 = eventTime.windowIndex;
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        AnalyticsListener.EventTime eventTime2 = new AnalyticsListener.EventTime(j3, timeline, i2, new MediaSource.MediaPeriodId(mediaPeriodId.periodUid, mediaPeriodId.windowSequenceNumber, mediaPeriodId.adGroupIndex), C.usToMs(j2), eventTime.timeline, eventTime.currentWindowIndex, eventTime.currentMediaPeriodId, eventTime.currentPlaybackPositionMs, eventTime.totalBufferedDurationMs);
        a aVar = (a) Assertions.checkNotNull(this.b.get(str));
        aVar.L = true;
        aVar.J = false;
        aVar.i(eventTime2, true);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        b.$default$onAudioAttributesChanged(this, eventTime, audioAttributes);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j2) {
        b.$default$onAudioDecoderInitialized(this, eventTime, str, j2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        b.$default$onAudioDisabled(this, eventTime, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        b.$default$onAudioEnabled(this, eventTime, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        b.$default$onAudioInputFormatChanged(this, eventTime, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j2) {
        b.$default$onAudioPositionAdvancing(this, eventTime, j2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioSessionId(AnalyticsListener.EventTime eventTime, int i2) {
        b.$default$onAudioSessionId(this, eventTime, i2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        a(eventTime);
        for (String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).E++;
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        a(eventTime);
        for (String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                a aVar = this.b.get(str);
                aVar.B += (long) i2;
                aVar.C += j2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i2, DecoderCounters decoderCounters) {
        b.$default$onDecoderDisabled(this, eventTime, i2, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i2, DecoderCounters decoderCounters) {
        b.$default$onDecoderEnabled(this, eventTime, i2, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i2, String str, long j2) {
        b.$default$onDecoderInitialized(this, eventTime, i2, str, j2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i2, Format format) {
        b.$default$onDecoderInputFormatChanged(this, eventTime, i2, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        a(eventTime);
        for (String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                a aVar = this.b.get(str);
                Objects.requireNonNull(aVar);
                int i2 = mediaLoadData.trackType;
                if (i2 == 2 || i2 == 0) {
                    aVar.j(eventTime, mediaLoadData.trackFormat);
                } else if (i2 == 1) {
                    aVar.f(eventTime, mediaLoadData.trackFormat);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        b.$default$onDrmKeysLoaded(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        b.$default$onDrmKeysRemoved(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        b.$default$onDrmKeysRestored(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        b.$default$onDrmSessionAcquired(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        a(eventTime);
        for (String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                a aVar = this.b.get(str);
                aVar.G++;
                if (aVar.a) {
                    aVar.h.add(new PlaybackStats.EventTimeAndException(eventTime, exc));
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        b.$default$onDrmSessionReleased(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i2, long j2) {
        a(eventTime);
        for (String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).D += (long) i2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        b.$default$onIsLoadingChanged(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        b.$default$onIsPlayingChanged(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        b.$default$onLoadCanceled(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        b.$default$onLoadCompleted(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        a(eventTime);
        for (String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                a aVar = this.b.get(str);
                aVar.G++;
                if (aVar.a) {
                    aVar.h.add(new PlaybackStats.EventTimeAndException(eventTime, iOException));
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        a(eventTime);
        for (String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                a aVar = this.b.get(str);
                aVar.R = true;
                aVar.i(eventTime, true);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        b.$default$onLoadingChanged(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i2) {
        b.$default$onMediaItemTransition(this, eventTime, mediaItem, i2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        b.$default$onMetadata(this, eventTime, metadata);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, int i2) {
        this.j = z;
        a(eventTime);
        for (String str : this.b.keySet()) {
            boolean belongsToSession = this.a.belongsToSession(eventTime, str);
            a aVar = this.b.get(str);
            aVar.N = z;
            aVar.i(eventTime, belongsToSession);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        this.m = playbackParameters.speed;
        a(eventTime);
        for (a aVar : this.b.values()) {
            float f2 = this.m;
            Objects.requireNonNull(aVar);
            aVar.h(eventTime.realtimeMs, eventTime.eventPlaybackPositionMs);
            aVar.e(eventTime.realtimeMs);
            aVar.d(eventTime.realtimeMs);
            aVar.X = f2;
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i2) {
        this.k = i2;
        a(eventTime);
        for (String str : this.b.keySet()) {
            this.b.get(str).k(eventTime, this.k, this.a.belongsToSession(eventTime, str));
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i2) {
        this.l = i2 != 0;
        a(eventTime);
        for (String str : this.b.keySet()) {
            boolean belongsToSession = this.a.belongsToSession(eventTime, str);
            a aVar = this.b.get(str);
            aVar.P = this.l;
            aVar.i(eventTime, belongsToSession);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        a(eventTime);
        for (String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                a aVar = this.b.get(str);
                aVar.F++;
                if (aVar.a) {
                    aVar.g.add(new PlaybackStats.EventTimeAndException(eventTime, exoPlaybackException));
                }
                aVar.Q = true;
                aVar.L = false;
                aVar.J = false;
                aVar.i(eventTime, true);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int i2) {
        b.$default$onPlayerStateChanged(this, eventTime, z, i2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i2) {
        if (!(eventTime.timeline.isEmpty() && this.k == 1)) {
            this.a.updateSessionsWithDiscontinuity(eventTime, i2);
        }
        if (i2 == 1) {
            this.n = false;
        }
        for (String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                a aVar = this.b.get(str);
                if ((i2 == 1) && aVar.O == 1) {
                    aVar.J = false;
                }
                aVar.L = false;
                aVar.i(eventTime, true);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
        b.$default$onRenderedFirstFrame(this, eventTime, surface);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i2) {
        b.$default$onRepeatModeChanged(this, eventTime, i2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        b.$default$onSeekProcessed(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        a(eventTime);
        for (String str : this.b.keySet()) {
            boolean belongsToSession = this.a.belongsToSession(eventTime, str);
            a aVar = this.b.get(str);
            aVar.J = true;
            aVar.i(eventTime, belongsToSession);
        }
        this.n = true;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionActive(AnalyticsListener.EventTime eventTime, String str) {
        a aVar = (a) Assertions.checkNotNull(this.b.get(str));
        aVar.K = true;
        aVar.i(eventTime, true);
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId == null || !mediaPeriodId.isAd()) {
            this.h = str;
        } else {
            this.i = str;
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionCreated(AnalyticsListener.EventTime eventTime, String str) {
        a aVar = new a(this.e, eventTime);
        if (this.n) {
            aVar.J = true;
            aVar.i(eventTime, true);
        }
        aVar.k(eventTime, this.k, true);
        aVar.N = this.j;
        aVar.i(eventTime, true);
        aVar.P = this.l;
        aVar.i(eventTime, true);
        float f2 = this.m;
        aVar.h(eventTime.realtimeMs, eventTime.eventPlaybackPositionMs);
        aVar.e(eventTime.realtimeMs);
        aVar.d(eventTime.realtimeMs);
        aVar.X = f2;
        this.b.put(str, aVar);
        this.c.put(str, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionFinished(AnalyticsListener.EventTime eventTime, String str, boolean z) {
        if (str.equals(this.i)) {
            this.i = null;
        } else if (str.equals(this.h)) {
            this.h = null;
        }
        a aVar = (a) Assertions.checkNotNull(this.b.remove(str));
        AnalyticsListener.EventTime eventTime2 = (AnalyticsListener.EventTime) Assertions.checkNotNull(this.c.remove(str));
        if (z) {
            aVar.k(eventTime, 4, false);
        }
        aVar.M = true;
        aVar.i(eventTime, false);
        PlaybackStats a3 = aVar.a(true);
        this.g = PlaybackStats.merge(this.g, a3);
        Callback callback = this.d;
        if (callback != null) {
            callback.onPlaybackStatsReady(eventTime2, a3);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        b.$default$onShuffleModeChanged(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        b.$default$onSkipSilenceEnabledChanged(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i2, int i3) {
        b.$default$onSurfaceSizeChanged(this, eventTime, i2, i3);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i2) {
        this.a.updateSessionsWithTimelineChange(eventTime);
        for (String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                a aVar = this.b.get(str);
                aVar.L = false;
                aVar.i(eventTime, true);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        a(eventTime);
        for (String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                a aVar = this.b.get(str);
                Objects.requireNonNull(aVar);
                TrackSelection[] all = trackSelectionArray.getAll();
                boolean z = false;
                boolean z2 = false;
                for (TrackSelection trackSelection : all) {
                    if (trackSelection != null && trackSelection.length() > 0) {
                        int trackType = MimeTypes.getTrackType(trackSelection.getFormat(0).sampleMimeType);
                        if (trackType == 2) {
                            z = true;
                        } else if (trackType == 1) {
                            z2 = true;
                        }
                    }
                }
                if (!z) {
                    aVar.j(eventTime, null);
                }
                if (!z2) {
                    aVar.f(eventTime, null);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        b.$default$onUpstreamDiscarded(this, eventTime, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j2) {
        b.$default$onVideoDecoderInitialized(this, eventTime, str, j2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        b.$default$onVideoDisabled(this, eventTime, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        b.$default$onVideoEnabled(this, eventTime, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j2, int i2) {
        b.$default$onVideoFrameProcessingOffset(this, eventTime, j2, i2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        b.$default$onVideoInputFormatChanged(this, eventTime, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i2, int i3, int i4, float f2) {
        a aVar;
        Format format;
        a(eventTime);
        for (String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str) && (format = (aVar = this.b.get(str)).T) != null && format.height == -1) {
                aVar.j(eventTime, format.buildUpon().setWidth(i2).setHeight(i3).build());
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f2) {
        b.$default$onVolumeChanged(this, eventTime, f2);
    }
}
