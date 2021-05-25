package com.google.android.exoplayer2;

import a2.j.b.b.e0;
import a2.j.b.b.f0;
import a2.j.b.b.g0;
import a2.j.b.b.h0;
import a2.j.b.b.j0;
import a2.j.b.b.l0;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.DefaultMediaClock;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
public final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackParametersListener, PlayerMessage.Sender {
    public boolean A;
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    @Nullable
    public e H;
    public long I;
    public int J;
    public boolean K;
    public long L;
    public boolean M = true;
    public final Renderer[] a;
    public final RendererCapabilities[] b;
    public final TrackSelector c;
    public final TrackSelectorResult d;
    public final LoadControl e;
    public final BandwidthMeter f;
    public final HandlerWrapper g;
    public final HandlerThread h;
    public final Looper i;
    public final Timeline.Window j;
    public final Timeline.Period k;
    public final long l;
    public final boolean m;
    public final DefaultMediaClock n;
    public final ArrayList<c> o;
    public final Clock p;
    public final PlaybackInfoUpdateListener q;
    public final h0 r;
    public final MediaSourceList s;
    public SeekParameters t;
    public j0 u;
    public PlaybackInfoUpdate v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static final class PlaybackInfoUpdate {
        public boolean a;
        public int discontinuityReason;
        public boolean hasPlayWhenReadyChangeReason;
        public int operationAcks;
        public int playWhenReadyChangeReason;
        public j0 playbackInfo;
        public boolean positionDiscontinuity;

        public PlaybackInfoUpdate(j0 j0Var) {
            this.playbackInfo = j0Var;
        }

        public void incrementPendingOperationAcks(int i) {
            this.a |= i > 0;
            this.operationAcks += i;
        }

        public void setPlayWhenReadyChangeReason(int i) {
            this.a = true;
            this.hasPlayWhenReadyChangeReason = true;
            this.playWhenReadyChangeReason = i;
        }

        public void setPlaybackInfo(j0 j0Var) {
            this.a |= this.playbackInfo != j0Var;
            this.playbackInfo = j0Var;
        }

        public void setPositionDiscontinuity(int i) {
            boolean z = true;
            if (!this.positionDiscontinuity || this.discontinuityReason == 4) {
                this.a = true;
                this.positionDiscontinuity = true;
                this.discontinuityReason = i;
                return;
            }
            if (i != 4) {
                z = false;
            }
            Assertions.checkArgument(z);
        }
    }

    public interface PlaybackInfoUpdateListener {
        void onPlaybackInfoUpdate(PlaybackInfoUpdate playbackInfoUpdate);
    }

    public static final class a {
        public final List<MediaSourceList.c> a;
        public final ShuffleOrder b;
        public final int c;
        public final long d;

        public a(List list, ShuffleOrder shuffleOrder, int i, long j, e0 e0Var) {
            this.a = list;
            this.b = shuffleOrder;
            this.c = i;
            this.d = j;
        }
    }

    public static class b {
        public final int a;
        public final int b;
        public final int c;
        public final ShuffleOrder d;

        public b(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = shuffleOrder;
        }
    }

    public static final class c implements Comparable<c> {
        public final PlayerMessage a;
        public int b;
        public long c;
        @Nullable
        public Object d;

        public c(PlayerMessage playerMessage) {
            this.a = playerMessage;
        }

        public void a(int i, long j, Object obj) {
            this.b = i;
            this.c = j;
            this.d = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            c cVar2 = cVar;
            Object obj = this.d;
            if ((obj == null) != (cVar2.d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.b - cVar2.b;
            return i != 0 ? i : Util.compareLong(this.c, cVar2.c);
        }
    }

    public static final class d {
        public final MediaSource.MediaPeriodId a;
        public final long b;
        public final long c;
        public final boolean d;
        public final boolean e;

        public d(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, boolean z, boolean z2) {
            this.a = mediaPeriodId;
            this.b = j;
            this.c = j2;
            this.d = z;
            this.e = z2;
        }
    }

    public static final class e {
        public final Timeline a;
        public final int b;
        public final long c;

        public e(Timeline timeline, int i, long j) {
            this.a = timeline;
            this.b = i;
            this.c = j;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i2, boolean z2, @Nullable AnalyticsCollector analyticsCollector, SeekParameters seekParameters, boolean z3, Looper looper, Clock clock, PlaybackInfoUpdateListener playbackInfoUpdateListener) {
        this.q = playbackInfoUpdateListener;
        this.a = rendererArr;
        this.c = trackSelector;
        this.d = trackSelectorResult;
        this.e = loadControl;
        this.f = bandwidthMeter;
        this.B = i2;
        this.C = z2;
        this.t = seekParameters;
        this.x = z3;
        this.p = clock;
        this.l = loadControl.getBackBufferDurationUs();
        this.m = loadControl.retainBackBufferFromKeyframe();
        j0 i3 = j0.i(trackSelectorResult);
        this.u = i3;
        this.v = new PlaybackInfoUpdate(i3);
        this.b = new RendererCapabilities[rendererArr.length];
        for (int i4 = 0; i4 < rendererArr.length; i4++) {
            rendererArr[i4].setIndex(i4);
            this.b[i4] = rendererArr[i4].getCapabilities();
        }
        this.n = new DefaultMediaClock(this, clock);
        this.o = new ArrayList<>();
        this.j = new Timeline.Window();
        this.k = new Timeline.Period();
        trackSelector.init(this, bandwidthMeter);
        this.K = true;
        Handler handler = new Handler(looper);
        this.r = new h0(analyticsCollector, handler);
        this.s = new MediaSourceList(this, analyticsCollector, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.h = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.i = looper2;
        this.g = clock.createHandler(looper2, this);
    }

    public static void E(Timeline timeline, c cVar, Timeline.Window window, Timeline.Period period) {
        int i2 = timeline.getWindow(timeline.getPeriodByUid(cVar.d, period).windowIndex, window).lastPeriodIndex;
        Object obj = timeline.getPeriod(i2, period, true).uid;
        long j2 = period.durationUs;
        cVar.a(i2, j2 != C.TIME_UNSET ? j2 - 1 : Long.MAX_VALUE, obj);
    }

    public static boolean F(c cVar, Timeline timeline, Timeline timeline2, int i2, boolean z2, Timeline.Window window, Timeline.Period period) {
        long j2;
        Object obj = cVar.d;
        if (obj == null) {
            if (cVar.a.getPositionMs() == Long.MIN_VALUE) {
                j2 = C.TIME_UNSET;
            } else {
                j2 = C.msToUs(cVar.a.getPositionMs());
            }
            Pair<Object, Long> H2 = H(timeline, new e(cVar.a.getTimeline(), cVar.a.getWindowIndex(), j2), false, i2, z2, window, period);
            if (H2 == null) {
                return false;
            }
            cVar.a(timeline.getIndexOfPeriod(H2.first), ((Long) H2.second).longValue(), H2.first);
            if (cVar.a.getPositionMs() == Long.MIN_VALUE) {
                E(timeline, cVar, window, period);
            }
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        if (indexOfPeriod == -1) {
            return false;
        }
        if (cVar.a.getPositionMs() == Long.MIN_VALUE) {
            E(timeline, cVar, window, period);
            return true;
        }
        cVar.b = indexOfPeriod;
        timeline2.getPeriodByUid(cVar.d, period);
        if (timeline2.getWindow(period.windowIndex, window).isPlaceholder) {
            Pair<Object, Long> periodPosition = timeline.getPeriodPosition(window, period, timeline.getPeriodByUid(cVar.d, period).windowIndex, period.getPositionInWindowUs() + cVar.c);
            cVar.a(timeline.getIndexOfPeriod(periodPosition.first), ((Long) periodPosition.second).longValue(), periodPosition.first);
        }
        return true;
    }

    @Nullable
    public static Pair<Object, Long> H(Timeline timeline, e eVar, boolean z2, int i2, boolean z3, Timeline.Window window, Timeline.Period period) {
        Object I2;
        Timeline timeline2 = eVar.a;
        if (timeline.isEmpty()) {
            return null;
        }
        Timeline timeline3 = timeline2.isEmpty() ? timeline : timeline2;
        try {
            Pair<Object, Long> periodPosition = timeline3.getPeriodPosition(window, period, eVar.b, eVar.c);
            if (timeline.equals(timeline3)) {
                return periodPosition;
            }
            if (timeline.getIndexOfPeriod(periodPosition.first) != -1) {
                timeline3.getPeriodByUid(periodPosition.first, period);
                return timeline3.getWindow(period.windowIndex, window).isPlaceholder ? timeline.getPeriodPosition(window, period, timeline.getPeriodByUid(periodPosition.first, period).windowIndex, eVar.c) : periodPosition;
            }
            if (z2 && (I2 = I(window, period, i2, z3, periodPosition.first, timeline3, timeline)) != null) {
                return timeline.getPeriodPosition(window, period, timeline.getPeriodByUid(I2, period).windowIndex, C.TIME_UNSET);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    @Nullable
    public static Object I(Timeline.Window window, Timeline.Period period, int i2, boolean z2, Object obj, Timeline timeline, Timeline timeline2) {
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int i3 = indexOfPeriod;
        int i4 = -1;
        for (int i5 = 0; i5 < periodCount && i4 == -1; i5++) {
            i3 = timeline.getNextPeriodIndex(i3, period, window, i2, z2);
            if (i3 == -1) {
                break;
            }
            i4 = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i3));
        }
        if (i4 == -1) {
            return null;
        }
        return timeline2.getUidOfPeriod(i4);
    }

    public static boolean c0(j0 j0Var, Timeline.Period period, Timeline.Window window) {
        MediaSource.MediaPeriodId mediaPeriodId = j0Var.b;
        Timeline timeline = j0Var.a;
        return mediaPeriodId.isAd() || timeline.isEmpty() || timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, period).windowIndex, window).isPlaceholder;
    }

    public static Format[] g(TrackSelection trackSelection) {
        int length = trackSelection != null ? trackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i2 = 0; i2 < length; i2++) {
            formatArr[i2] = trackSelection.getFormat(i2);
        }
        return formatArr;
    }

    public static boolean s(Renderer renderer) {
        return renderer.getState() != 0;
    }

    public final void A() throws ExoPlaybackException {
        int i2;
        float f2 = this.n.getPlaybackParameters().speed;
        h0 h0Var = this.r;
        f0 f0Var = h0Var.h;
        f0 f0Var2 = h0Var.i;
        f0 f0Var3 = f0Var;
        boolean z2 = true;
        while (f0Var3 != null && f0Var3.d) {
            TrackSelectorResult i3 = f0Var3.i(f2, this.u.a);
            int i4 = 0;
            if (!i3.isEquivalent(f0Var3.n)) {
                if (z2) {
                    h0 h0Var2 = this.r;
                    f0 f0Var4 = h0Var2.h;
                    boolean m2 = h0Var2.m(f0Var4);
                    boolean[] zArr = new boolean[this.a.length];
                    long a3 = f0Var4.a(i3, this.u.p, m2, zArr);
                    j0 j0Var = this.u;
                    i2 = 4;
                    j0 q2 = q(j0Var.b, a3, j0Var.c);
                    this.u = q2;
                    if (!(q2.d == 4 || a3 == q2.p)) {
                        this.v.setPositionDiscontinuity(4);
                        D(a3);
                    }
                    boolean[] zArr2 = new boolean[this.a.length];
                    while (true) {
                        Renderer[] rendererArr = this.a;
                        if (i4 >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i4];
                        zArr2[i4] = s(renderer);
                        SampleStream sampleStream = f0Var4.c[i4];
                        if (zArr2[i4]) {
                            if (sampleStream != renderer.getStream()) {
                                c(renderer);
                            } else if (zArr[i4]) {
                                renderer.resetPosition(this.I);
                            }
                        }
                        i4++;
                    }
                    f(zArr2);
                } else {
                    i2 = 4;
                    this.r.m(f0Var3);
                    if (f0Var3.d) {
                        f0Var3.a(i3, Math.max(f0Var3.f.b, this.I - f0Var3.o), false, new boolean[f0Var3.i.length]);
                    }
                }
                m(true);
                if (this.u.d != i2) {
                    u();
                    h0();
                    this.g.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (f0Var3 == f0Var2) {
                z2 = false;
            }
            f0Var3 = f0Var3.l;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void B(boolean r26, boolean r27, boolean r28, boolean r29) {
        /*
        // Method dump skipped, instructions count: 283
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.B(boolean, boolean, boolean, boolean):void");
    }

    public final void C() {
        f0 f0Var = this.r.h;
        this.y = f0Var != null && f0Var.f.g && this.x;
    }

    public final void D(long j2) throws ExoPlaybackException {
        f0 f0Var = this.r.h;
        if (f0Var != null) {
            j2 += f0Var.o;
        }
        this.I = j2;
        this.n.a.resetPosition(j2);
        Renderer[] rendererArr = this.a;
        for (Renderer renderer : rendererArr) {
            if (s(renderer)) {
                renderer.resetPosition(this.I);
            }
        }
        for (f0 f0Var2 = this.r.h; f0Var2 != null; f0Var2 = f0Var2.l) {
            TrackSelection[] all = f0Var2.n.selections.getAll();
            for (TrackSelection trackSelection : all) {
                if (trackSelection != null) {
                    trackSelection.onDiscontinuity();
                }
            }
        }
    }

    public final void G(Timeline timeline, Timeline timeline2) {
        if (!timeline.isEmpty() || !timeline2.isEmpty()) {
            int size = this.o.size();
            while (true) {
                size--;
                if (size < 0) {
                    Collections.sort(this.o);
                    return;
                } else if (!F(this.o.get(size), timeline, timeline2, this.B, this.C, this.j, this.k)) {
                    this.o.get(size).a.markAsProcessed(false);
                    this.o.remove(size);
                }
            }
        }
    }

    public final void J(long j2, long j3) {
        this.g.removeMessages(2);
        this.g.sendEmptyMessageAtTime(2, j2 + j3);
    }

    public final void K(boolean z2) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.r.h.f.a;
        long N = N(mediaPeriodId, this.u.p, true, false);
        if (N != this.u.p) {
            this.u = q(mediaPeriodId, N, this.u.c);
            if (z2) {
                this.v.setPositionDiscontinuity(4);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0138 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void L(com.google.android.exoplayer2.ExoPlayerImplInternal.e r23) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
        // Method dump skipped, instructions count: 338
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.L(com.google.android.exoplayer2.ExoPlayerImplInternal$e):void");
    }

    public final long M(MediaSource.MediaPeriodId mediaPeriodId, long j2, boolean z2) throws ExoPlaybackException {
        h0 h0Var = this.r;
        return N(mediaPeriodId, j2, h0Var.h != h0Var.i, z2);
    }

    public final long N(MediaSource.MediaPeriodId mediaPeriodId, long j2, boolean z2, boolean z3) throws ExoPlaybackException {
        h0 h0Var;
        f0();
        this.z = false;
        if (z3 || this.u.d == 3) {
            a0(2);
        }
        f0 f0Var = this.r.h;
        f0 f0Var2 = f0Var;
        while (f0Var2 != null && !mediaPeriodId.equals(f0Var2.f.a)) {
            f0Var2 = f0Var2.l;
        }
        if (z2 || f0Var != f0Var2 || (f0Var2 != null && f0Var2.o + j2 < 0)) {
            for (Renderer renderer : this.a) {
                c(renderer);
            }
            if (f0Var2 != null) {
                while (true) {
                    h0Var = this.r;
                    if (h0Var.h == f0Var2) {
                        break;
                    }
                    h0Var.a();
                }
                h0Var.m(f0Var2);
                f0Var2.o = 0;
                e();
            }
        }
        if (f0Var2 != null) {
            this.r.m(f0Var2);
            if (!f0Var2.d) {
                f0Var2.f = f0Var2.f.a(j2);
            } else {
                long j3 = f0Var2.f.e;
                if (j3 != C.TIME_UNSET && j2 >= j3) {
                    j2 = Math.max(0L, j3 - 1);
                }
                if (f0Var2.e) {
                    long seekToUs = f0Var2.a.seekToUs(j2);
                    f0Var2.a.discardBuffer(seekToUs - this.l, this.m);
                    j2 = seekToUs;
                }
            }
            D(j2);
            u();
        } else {
            this.r.b();
            D(j2);
        }
        m(false);
        this.g.sendEmptyMessage(2);
        return j2;
    }

    public final void O(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == C.TIME_UNSET) {
            P(playerMessage);
        } else if (this.u.a.isEmpty()) {
            this.o.add(new c(playerMessage));
        } else {
            c cVar = new c(playerMessage);
            Timeline timeline = this.u.a;
            if (F(cVar, timeline, timeline, this.B, this.C, this.j, this.k)) {
                this.o.add(cVar);
                Collections.sort(this.o);
                return;
            }
            playerMessage.markAsProcessed(false);
        }
    }

    public final void P(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getHandler().getLooper() == this.i) {
            b(playerMessage);
            int i2 = this.u.d;
            if (i2 == 3 || i2 == 2) {
                this.g.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.g.obtainMessage(15, playerMessage).sendToTarget();
    }

    public final void Q(PlayerMessage playerMessage) {
        Handler handler = playerMessage.getHandler();
        if (!handler.getLooper().getThread().isAlive()) {
            Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
            return;
        }
        handler.post(new Runnable(playerMessage) { // from class: a2.j.b.b.w
            public final /* synthetic */ PlayerMessage b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ExoPlayerImplInternal exoPlayerImplInternal = ExoPlayerImplInternal.this;
                PlayerMessage playerMessage2 = this.b;
                Objects.requireNonNull(exoPlayerImplInternal);
                try {
                    exoPlayerImplInternal.b(playerMessage2);
                } catch (ExoPlaybackException e2) {
                    Log.e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
                    throw new RuntimeException(e2);
                }
            }
        });
    }

    public final void R(boolean z2, @Nullable AtomicBoolean atomicBoolean) {
        if (this.D != z2) {
            this.D = z2;
            if (!z2) {
                Renderer[] rendererArr = this.a;
                for (Renderer renderer : rendererArr) {
                    if (!s(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    public final void S(a aVar) throws ExoPlaybackException {
        this.v.incrementPendingOperationAcks(1);
        if (aVar.c != -1) {
            this.H = new e(new l0(aVar.a, aVar.b), aVar.c, aVar.d);
        }
        MediaSourceList mediaSourceList = this.s;
        List<MediaSourceList.c> list = aVar.a;
        ShuffleOrder shuffleOrder = aVar.b;
        mediaSourceList.i(0, mediaSourceList.a.size());
        n(mediaSourceList.a(mediaSourceList.a.size(), list, shuffleOrder));
    }

    public final void T(boolean z2) {
        if (z2 != this.F) {
            this.F = z2;
            j0 j0Var = this.u;
            int i2 = j0Var.d;
            if (z2 || i2 == 4 || i2 == 1) {
                this.u = j0Var.c(z2);
            } else {
                this.g.sendEmptyMessage(2);
            }
        }
    }

    public final void U(boolean z2) throws ExoPlaybackException {
        this.x = z2;
        C();
        if (this.y) {
            h0 h0Var = this.r;
            if (h0Var.i != h0Var.h) {
                K(true);
                m(false);
            }
        }
    }

    public final void V(boolean z2, int i2, boolean z3, int i3) throws ExoPlaybackException {
        this.v.incrementPendingOperationAcks(z3 ? 1 : 0);
        this.v.setPlayWhenReadyChangeReason(i3);
        this.u = this.u.d(z2, i2);
        this.z = false;
        if (!b0()) {
            f0();
            h0();
            return;
        }
        int i4 = this.u.d;
        if (i4 == 3) {
            d0();
            this.g.sendEmptyMessage(2);
        } else if (i4 == 2) {
            this.g.sendEmptyMessage(2);
        }
    }

    public final void W(PlaybackParameters playbackParameters) {
        this.n.setPlaybackParameters(playbackParameters);
        this.g.obtainMessage(16, 1, 0, this.n.getPlaybackParameters()).sendToTarget();
    }

    public final void X(int i2) throws ExoPlaybackException {
        this.B = i2;
        h0 h0Var = this.r;
        Timeline timeline = this.u.a;
        h0Var.f = i2;
        if (!h0Var.p(timeline)) {
            K(true);
        }
        m(false);
    }

    public final void Y(boolean z2) throws ExoPlaybackException {
        this.C = z2;
        h0 h0Var = this.r;
        Timeline timeline = this.u.a;
        h0Var.g = z2;
        if (!h0Var.p(timeline)) {
            K(true);
        }
        m(false);
    }

    public final void Z(ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.v.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.s;
        int e2 = mediaSourceList.e();
        if (shuffleOrder.getLength() != e2) {
            shuffleOrder = shuffleOrder.cloneAndClear().cloneAndInsert(0, e2);
        }
        mediaSourceList.i = shuffleOrder;
        n(mediaSourceList.c());
    }

    public final void a(a aVar, int i2) throws ExoPlaybackException {
        this.v.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.s;
        if (i2 == -1) {
            i2 = mediaSourceList.e();
        }
        n(mediaSourceList.a(i2, aVar.a, aVar.b));
    }

    public final void a0(int i2) {
        j0 j0Var = this.u;
        if (j0Var.d != i2) {
            this.u = j0Var.g(i2);
        }
    }

    public final void b(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (!playerMessage.isCanceled()) {
            boolean z2 = true;
            try {
                playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
            } finally {
                playerMessage.markAsProcessed(z2);
            }
        }
    }

    public final boolean b0() {
        j0 j0Var = this.u;
        return j0Var.j && j0Var.k == 0;
    }

    public final void c(Renderer renderer) throws ExoPlaybackException {
        if (renderer.getState() != 0) {
            DefaultMediaClock defaultMediaClock = this.n;
            if (renderer == defaultMediaClock.c) {
                defaultMediaClock.d = null;
                defaultMediaClock.c = null;
                defaultMediaClock.e = true;
            }
            if (renderer.getState() == 2) {
                renderer.stop();
            }
            renderer.disable();
            this.G--;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:249:0x03e9, code lost:
        if (r23.e.shouldStartPlayback(j(), r23.n.getPlaybackParameters().speed, r23.z) == false) goto L_0x03ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        if (r13 != com.google.android.exoplayer2.C.TIME_UNSET) goto L_0x00a4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() throws com.google.android.exoplayer2.ExoPlaybackException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1220
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.d():void");
    }

    public final void d0() throws ExoPlaybackException {
        this.z = false;
        DefaultMediaClock defaultMediaClock = this.n;
        defaultMediaClock.f = true;
        defaultMediaClock.a.start();
        Renderer[] rendererArr = this.a;
        for (Renderer renderer : rendererArr) {
            if (s(renderer)) {
                renderer.start();
            }
        }
    }

    public final void e() throws ExoPlaybackException {
        f(new boolean[this.a.length]);
    }

    public final void e0(boolean z2, boolean z3) {
        B(z2 || !this.D, false, true, false);
        this.v.incrementPendingOperationAcks(z3 ? 1 : 0);
        this.e.onStopped();
        a0(1);
    }

    public final void f(boolean[] zArr) throws ExoPlaybackException {
        MediaClock mediaClock;
        f0 f0Var = this.r.i;
        TrackSelectorResult trackSelectorResult = f0Var.n;
        for (int i2 = 0; i2 < this.a.length; i2++) {
            if (!trackSelectorResult.isRendererEnabled(i2)) {
                this.a[i2].reset();
            }
        }
        for (int i3 = 0; i3 < this.a.length; i3++) {
            if (trackSelectorResult.isRendererEnabled(i3)) {
                boolean z2 = zArr[i3];
                Renderer renderer = this.a[i3];
                if (!s(renderer)) {
                    h0 h0Var = this.r;
                    f0 f0Var2 = h0Var.i;
                    boolean z3 = f0Var2 == h0Var.h;
                    TrackSelectorResult trackSelectorResult2 = f0Var2.n;
                    RendererConfiguration rendererConfiguration = trackSelectorResult2.rendererConfigurations[i3];
                    Format[] g2 = g(trackSelectorResult2.selections.get(i3));
                    boolean z4 = b0() && this.u.d == 3;
                    boolean z5 = !z2 && z4;
                    this.G++;
                    renderer.enable(rendererConfiguration, g2, f0Var2.c[i3], this.I, z5, z3, f0Var2.e(), f0Var2.o);
                    renderer.handleMessage(103, new e0(this));
                    DefaultMediaClock defaultMediaClock = this.n;
                    Objects.requireNonNull(defaultMediaClock);
                    MediaClock mediaClock2 = renderer.getMediaClock();
                    if (!(mediaClock2 == null || mediaClock2 == (mediaClock = defaultMediaClock.d))) {
                        if (mediaClock == null) {
                            defaultMediaClock.d = mediaClock2;
                            defaultMediaClock.c = renderer;
                            mediaClock2.setPlaybackParameters(defaultMediaClock.a.getPlaybackParameters());
                        } else {
                            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                    }
                    if (z4) {
                        renderer.start();
                    }
                } else {
                    continue;
                }
            }
        }
        f0Var.g = true;
    }

    public final void f0() throws ExoPlaybackException {
        DefaultMediaClock defaultMediaClock = this.n;
        defaultMediaClock.f = false;
        defaultMediaClock.a.stop();
        Renderer[] rendererArr = this.a;
        for (Renderer renderer : rendererArr) {
            if (s(renderer) && renderer.getState() == 2) {
                renderer.stop();
            }
        }
    }

    public final void g0() {
        f0 f0Var = this.r.j;
        boolean z2 = this.A || (f0Var != null && f0Var.a.isLoading());
        j0 j0Var = this.u;
        if (z2 != j0Var.f) {
            this.u = new j0(j0Var.a, j0Var.b, j0Var.c, j0Var.d, j0Var.e, z2, j0Var.g, j0Var.h, j0Var.i, j0Var.j, j0Var.k, j0Var.l, j0Var.n, j0Var.o, j0Var.p, j0Var.m);
        }
    }

    public final long h() {
        f0 f0Var = this.r.i;
        if (f0Var == null) {
            return 0;
        }
        long j2 = f0Var.o;
        if (!f0Var.d) {
            return j2;
        }
        int i2 = 0;
        while (true) {
            Renderer[] rendererArr = this.a;
            if (i2 >= rendererArr.length) {
                return j2;
            }
            if (s(rendererArr[i2]) && this.a[i2].getStream() == f0Var.c[i2]) {
                long readingPositionUs = this.a[i2].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j2 = Math.max(readingPositionUs, j2);
            }
            i2++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0139 A[EDGE_INSN: B:112:0x0139->B:64:0x0139 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x014a A[EDGE_INSN: B:116:0x014a->B:67:0x014a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01b3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01aa A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0172  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h0() throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
        // Method dump skipped, instructions count: 487
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.h0():void");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        f0 f0Var;
        ExoPlaybackException exoPlaybackException;
        try {
            switch (message.what) {
                case 0:
                    x();
                    break;
                case 1:
                    V(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    d();
                    break;
                case 3:
                    L((e) message.obj);
                    break;
                case 4:
                    W((PlaybackParameters) message.obj);
                    break;
                case 5:
                    this.t = (SeekParameters) message.obj;
                    break;
                case 6:
                    e0(false, true);
                    break;
                case 7:
                    y();
                    return true;
                case 8:
                    o((MediaPeriod) message.obj);
                    break;
                case 9:
                    l((MediaPeriod) message.obj);
                    break;
                case 10:
                    A();
                    break;
                case 11:
                    X(message.arg1);
                    break;
                case 12:
                    Y(message.arg1 != 0);
                    break;
                case 13:
                    R(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    O((PlayerMessage) message.obj);
                    break;
                case 15:
                    Q((PlayerMessage) message.obj);
                    break;
                case 16:
                    p((PlaybackParameters) message.obj, message.arg1 != 0);
                    break;
                case 17:
                    S((a) message.obj);
                    break;
                case 18:
                    a((a) message.obj, message.arg1);
                    break;
                case 19:
                    w((b) message.obj);
                    break;
                case 20:
                    z(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    Z((ShuffleOrder) message.obj);
                    break;
                case 22:
                    n(this.s.c());
                    break;
                case 23:
                    U(message.arg1 != 0);
                    break;
                case 24:
                    T(message.arg1 == 1);
                    break;
                default:
                    return false;
            }
            v();
        } catch (ExoPlaybackException e2) {
            e = e2;
            if (e.type == 1 && (f0Var = this.r.i) != null) {
                e = e.a(f0Var.f.a);
            }
            Log.e("ExoPlayerImplInternal", "Playback error", e);
            e0(true, false);
            this.u = this.u.e(e);
            v();
        } catch (IOException e3) {
            ExoPlaybackException createForSource = ExoPlaybackException.createForSource(e3);
            f0 f0Var2 = this.r.h;
            if (f0Var2 != null) {
                createForSource = createForSource.a(f0Var2.f.a);
            }
            Log.e("ExoPlayerImplInternal", "Playback error", createForSource);
            e0(false, false);
            this.u = this.u.e(createForSource);
            v();
        } catch (OutOfMemoryError | RuntimeException e4) {
            if (e4 instanceof OutOfMemoryError) {
                exoPlaybackException = ExoPlaybackException.createForOutOfMemory((OutOfMemoryError) e4);
            } else {
                exoPlaybackException = ExoPlaybackException.createForUnexpected((RuntimeException) e4);
            }
            Log.e("ExoPlayerImplInternal", "Playback error", exoPlaybackException);
            e0(true, false);
            this.u = this.u.e(exoPlaybackException);
            v();
        }
        return true;
    }

    public final Pair<MediaSource.MediaPeriodId, Long> i(Timeline timeline) {
        long j2 = 0;
        if (timeline.isEmpty()) {
            return Pair.create(j0.q, 0L);
        }
        Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.j, this.k, timeline.getFirstWindowIndex(this.C), C.TIME_UNSET);
        MediaSource.MediaPeriodId n2 = this.r.n(timeline, periodPosition.first, 0);
        long longValue = ((Long) periodPosition.second).longValue();
        if (n2.isAd()) {
            timeline.getPeriodByUid(n2.periodUid, this.k);
            if (n2.adIndexInAdGroup == this.k.getFirstAdIndexToPlay(n2.adGroupIndex)) {
                j2 = this.k.getAdResumePositionUs();
            }
            longValue = j2;
        }
        return Pair.create(n2, Long.valueOf(longValue));
    }

    public final synchronized void i0(Supplier<Boolean> supplier) {
        boolean z2 = false;
        while (!supplier.get().booleanValue()) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public final long j() {
        return k(this.u.n);
    }

    public final synchronized void j0(Supplier<Boolean> supplier, long j2) {
        long elapsedRealtime = this.p.elapsedRealtime() + j2;
        boolean z2 = false;
        while (!supplier.get().booleanValue() && j2 > 0) {
            try {
                wait(j2);
            } catch (InterruptedException unused) {
                z2 = true;
            }
            j2 = elapsedRealtime - this.p.elapsedRealtime();
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public final long k(long j2) {
        f0 f0Var = this.r.j;
        if (f0Var == null) {
            return 0;
        }
        return Math.max(0L, j2 - (this.I - f0Var.o));
    }

    public final void l(MediaPeriod mediaPeriod) {
        h0 h0Var = this.r;
        f0 f0Var = h0Var.j;
        if (f0Var != null && f0Var.a == mediaPeriod) {
            h0Var.l(this.I);
            u();
        }
    }

    public final void m(boolean z2) {
        long j2;
        f0 f0Var = this.r.j;
        MediaSource.MediaPeriodId mediaPeriodId = f0Var == null ? this.u.b : f0Var.f.a;
        boolean z3 = !this.u.i.equals(mediaPeriodId);
        if (z3) {
            this.u = this.u.a(mediaPeriodId);
        }
        j0 j0Var = this.u;
        if (f0Var == null) {
            j2 = j0Var.p;
        } else {
            j2 = f0Var.d();
        }
        j0Var.n = j2;
        this.u.o = j();
        if ((z3 || z2) && f0Var != null && f0Var.d) {
            this.e.onTracksSelected(this.a, f0Var.m, f0Var.n.selections);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(com.google.android.exoplayer2.Timeline r34) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
        // Method dump skipped, instructions count: 685
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.n(com.google.android.exoplayer2.Timeline):void");
    }

    public final void o(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        f0 f0Var = this.r.j;
        if (f0Var != null && f0Var.a == mediaPeriod) {
            float f2 = this.n.getPlaybackParameters().speed;
            Timeline timeline = this.u.a;
            f0Var.d = true;
            f0Var.m = f0Var.a.getTrackGroups();
            TrackSelectorResult i2 = f0Var.i(f2, timeline);
            g0 g0Var = f0Var.f;
            long j2 = g0Var.b;
            long j3 = g0Var.e;
            if (j3 != C.TIME_UNSET && j2 >= j3) {
                j2 = Math.max(0L, j3 - 1);
            }
            long a3 = f0Var.a(i2, j2, false, new boolean[f0Var.i.length]);
            long j4 = f0Var.o;
            g0 g0Var2 = f0Var.f;
            f0Var.o = (g0Var2.b - a3) + j4;
            f0Var.f = g0Var2.a(a3);
            this.e.onTracksSelected(this.a, f0Var.m, f0Var.n.selections);
            if (f0Var == this.r.h) {
                D(f0Var.f.b);
                e();
                j0 j0Var = this.u;
                this.u = q(j0Var.b, f0Var.f.b, j0Var.c);
            }
            u();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.source.SequenceableLoader] */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.g.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.DefaultMediaClock.PlaybackParametersListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.g.obtainMessage(16, 0, 0, playbackParameters).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.MediaSourceList.MediaSourceListInfoRefreshListener
    public void onPlaylistUpdateRequested() {
        this.g.sendEmptyMessage(22);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.g.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.g.sendEmptyMessage(10);
    }

    public final void p(PlaybackParameters playbackParameters, boolean z2) throws ExoPlaybackException {
        int i2;
        this.v.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.u = this.u.f(playbackParameters);
        float f2 = playbackParameters.speed;
        f0 f0Var = this.r.h;
        while (true) {
            i2 = 0;
            if (f0Var == null) {
                break;
            }
            TrackSelection[] all = f0Var.n.selections.getAll();
            int length = all.length;
            while (i2 < length) {
                TrackSelection trackSelection = all[i2];
                if (trackSelection != null) {
                    trackSelection.onPlaybackSpeed(f2);
                }
                i2++;
            }
            f0Var = f0Var.l;
        }
        Renderer[] rendererArr = this.a;
        int length2 = rendererArr.length;
        while (i2 < length2) {
            Renderer renderer = rendererArr[i2];
            if (renderer != null) {
                renderer.setOperatingRate(playbackParameters.speed);
            }
            i2++;
        }
    }

    @CheckResult
    public final j0 q(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3) {
        TrackSelectorResult trackSelectorResult;
        TrackGroupArray trackGroupArray;
        TrackGroupArray trackGroupArray2;
        TrackSelectorResult trackSelectorResult2;
        this.K = this.K || j2 != this.u.p || !mediaPeriodId.equals(this.u.b);
        C();
        j0 j0Var = this.u;
        TrackGroupArray trackGroupArray3 = j0Var.g;
        TrackSelectorResult trackSelectorResult3 = j0Var.h;
        if (this.s.j) {
            f0 f0Var = this.r.h;
            if (f0Var == null) {
                trackGroupArray2 = TrackGroupArray.EMPTY;
            } else {
                trackGroupArray2 = f0Var.m;
            }
            if (f0Var == null) {
                trackSelectorResult2 = this.d;
            } else {
                trackSelectorResult2 = f0Var.n;
            }
            trackSelectorResult = trackSelectorResult2;
            trackGroupArray = trackGroupArray2;
        } else if (!mediaPeriodId.equals(j0Var.b)) {
            trackGroupArray = TrackGroupArray.EMPTY;
            trackSelectorResult = this.d;
        } else {
            trackGroupArray = trackGroupArray3;
            trackSelectorResult = trackSelectorResult3;
        }
        return this.u.b(mediaPeriodId, j2, j3, j(), trackGroupArray, trackSelectorResult);
    }

    public final boolean r() {
        f0 f0Var = this.r.j;
        if (f0Var == null) {
            return false;
        }
        if ((!f0Var.d ? 0 : f0Var.a.getNextLoadPositionUs()) == Long.MIN_VALUE) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Sender
    public synchronized void sendMessage(PlayerMessage playerMessage) {
        if (!this.w) {
            if (this.h.isAlive()) {
                this.g.obtainMessage(14, playerMessage).sendToTarget();
                return;
            }
        }
        Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        playerMessage.markAsProcessed(false);
    }

    public final boolean t() {
        f0 f0Var = this.r.h;
        long j2 = f0Var.f.e;
        return f0Var.d && (j2 == C.TIME_UNSET || this.u.p < j2 || !b0());
    }

    public final void u() {
        boolean z2;
        long j2;
        long j3;
        if (!r()) {
            z2 = false;
        } else {
            f0 f0Var = this.r.j;
            long k2 = k(!f0Var.d ? 0 : f0Var.a.getNextLoadPositionUs());
            if (f0Var == this.r.h) {
                j3 = this.I;
                j2 = f0Var.o;
            } else {
                j3 = this.I - f0Var.o;
                j2 = f0Var.f.b;
            }
            z2 = this.e.shouldContinueLoading(j3 - j2, k2, this.n.getPlaybackParameters().speed);
        }
        this.A = z2;
        if (z2) {
            f0 f0Var2 = this.r.j;
            long j4 = this.I;
            Assertions.checkState(f0Var2.g());
            f0Var2.a.continueLoading(j4 - f0Var2.o);
        }
        g0();
    }

    public final void v() {
        this.v.setPlaybackInfo(this.u);
        PlaybackInfoUpdate playbackInfoUpdate = this.v;
        if (playbackInfoUpdate.a) {
            this.q.onPlaybackInfoUpdate(playbackInfoUpdate);
            this.v = new PlaybackInfoUpdate(this.u);
        }
    }

    public final void w(b bVar) throws ExoPlaybackException {
        Timeline timeline;
        this.v.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.s;
        int i2 = bVar.a;
        int i3 = bVar.b;
        int i4 = bVar.c;
        ShuffleOrder shuffleOrder = bVar.d;
        Objects.requireNonNull(mediaSourceList);
        Assertions.checkArgument(i2 >= 0 && i2 <= i3 && i3 <= mediaSourceList.e() && i4 >= 0);
        mediaSourceList.i = shuffleOrder;
        if (i2 == i3 || i2 == i4) {
            timeline = mediaSourceList.c();
        } else {
            int min = Math.min(i2, i4);
            int max = Math.max(((i3 - i2) + i4) - 1, i3 - 1);
            int i5 = mediaSourceList.a.get(min).d;
            Util.moveItems(mediaSourceList.a, i2, i3, i4);
            while (min <= max) {
                MediaSourceList.c cVar = mediaSourceList.a.get(min);
                cVar.d = i5;
                i5 += cVar.a.getTimeline().getWindowCount();
                min++;
            }
            timeline = mediaSourceList.c();
        }
        n(timeline);
    }

    public final void x() {
        this.v.incrementPendingOperationAcks(1);
        B(false, false, false, true);
        this.e.onPrepared();
        a0(this.u.a.isEmpty() ? 4 : 2);
        MediaSourceList mediaSourceList = this.s;
        TransferListener transferListener = this.f.getTransferListener();
        Assertions.checkState(!mediaSourceList.j);
        mediaSourceList.k = transferListener;
        for (int i2 = 0; i2 < mediaSourceList.a.size(); i2++) {
            MediaSourceList.c cVar = mediaSourceList.a.get(i2);
            mediaSourceList.g(cVar);
            mediaSourceList.h.add(cVar);
        }
        mediaSourceList.j = true;
        this.g.sendEmptyMessage(2);
    }

    public final void y() {
        B(true, false, true, false);
        this.e.onReleased();
        a0(1);
        this.h.quit();
        synchronized (this) {
            this.w = true;
            notifyAll();
        }
    }

    public final void z(int i2, int i3, ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        boolean z2 = true;
        this.v.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.s;
        Objects.requireNonNull(mediaSourceList);
        if (i2 < 0 || i2 > i3 || i3 > mediaSourceList.e()) {
            z2 = false;
        }
        Assertions.checkArgument(z2);
        mediaSourceList.i = shuffleOrder;
        mediaSourceList.i(i2, i3);
        n(mediaSourceList.c());
    }
}
