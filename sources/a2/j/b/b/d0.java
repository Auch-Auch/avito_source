package a2.j.b.b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
public final class d0 extends BasePlayer implements ExoPlayer {
    public boolean A;
    public j0 B;
    public int C;
    public long D;
    public final TrackSelectorResult a;
    public final Renderer[] b;
    public final TrackSelector c;
    public final Handler d;
    public final ExoPlayerImplInternal.PlaybackInfoUpdateListener e;
    public final ExoPlayerImplInternal f;
    public final Handler g;
    public final CopyOnWriteArrayList<BasePlayer.ListenerHolder> h;
    public final Timeline.Period i;
    public final ArrayDeque<Runnable> j;
    public final List<a> k;
    public final boolean l;
    public final MediaSourceFactory m;
    @Nullable
    public final AnalyticsCollector n;
    public final Looper o;
    public final BandwidthMeter p;
    public int q;
    public boolean r;
    public int s;
    public boolean t;
    public int u;
    public int v;
    public boolean w;
    public SeekParameters x;
    public ShuffleOrder y;
    public boolean z;

    public static final class a implements i0 {
        public final Object a;
        public Timeline b;

        public a(Object obj, Timeline timeline) {
            this.a = obj;
            this.b = timeline;
        }

        @Override // a2.j.b.b.i0
        public Timeline a() {
            return this.b;
        }

        @Override // a2.j.b.b.i0
        public Object getUid() {
            return this.a;
        }
    }

    public static final class b implements Runnable {
        public final j0 a;
        public final CopyOnWriteArrayList<BasePlayer.ListenerHolder> b;
        public final TrackSelector c;
        public final boolean d;
        public final int e;
        public final int f;
        public final boolean g;
        public final int h;
        @Nullable
        public final MediaItem i;
        public final int j;
        public final boolean k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final boolean o;
        public final boolean p;
        public final boolean q;
        public final boolean r;
        public final boolean s;
        public final boolean t;
        public final boolean u;

        public b(j0 j0Var, j0 j0Var2, CopyOnWriteArrayList<BasePlayer.ListenerHolder> copyOnWriteArrayList, TrackSelector trackSelector, boolean z, int i2, int i3, boolean z2, int i4, @Nullable MediaItem mediaItem, int i5, boolean z3) {
            this.a = j0Var;
            this.b = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
            this.c = trackSelector;
            this.d = z;
            this.e = i2;
            this.f = i3;
            this.g = z2;
            this.h = i4;
            this.i = mediaItem;
            this.j = i5;
            this.k = z3;
            boolean z4 = false;
            this.l = j0Var2.d != j0Var.d;
            ExoPlaybackException exoPlaybackException = j0Var2.e;
            ExoPlaybackException exoPlaybackException2 = j0Var.e;
            this.m = (exoPlaybackException == exoPlaybackException2 || exoPlaybackException2 == null) ? false : true;
            this.n = j0Var2.f != j0Var.f;
            this.o = !j0Var2.a.equals(j0Var.a);
            this.p = j0Var2.h != j0Var.h;
            this.q = j0Var2.j != j0Var.j;
            this.r = j0Var2.k != j0Var.k;
            this.s = a(j0Var2) != a(j0Var);
            this.t = !j0Var2.l.equals(j0Var.l);
            this.u = j0Var2.m != j0Var.m ? true : z4;
        }

        public static boolean a(j0 j0Var) {
            return j0Var.d == 3 && j0Var.j && j0Var.k == 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.o) {
                d0.g(this.b, new f(this));
            }
            if (this.d) {
                d0.g(this.b, new h(this));
            }
            if (this.g) {
                d0.g(this.b, new e(this));
            }
            if (this.m) {
                d0.g(this.b, new l(this));
            }
            if (this.p) {
                this.c.onSelectionActivated(this.a.h.info);
                d0.g(this.b, new g(this));
            }
            if (this.n) {
                d0.g(this.b, new q(this));
            }
            if (this.l || this.q) {
                d0.g(this.b, new o(this));
            }
            if (this.l) {
                d0.g(this.b, new j(this));
            }
            if (this.q) {
                d0.g(this.b, new i(this));
            }
            if (this.r) {
                d0.g(this.b, new n(this));
            }
            if (this.s) {
                d0.g(this.b, new k(this));
            }
            if (this.t) {
                d0.g(this.b, new p(this));
            }
            if (this.k) {
                d0.g(this.b, c0.a);
            }
            if (this.u) {
                d0.g(this.b, new m(this));
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    public d0(Renderer[] rendererArr, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, @Nullable AnalyticsCollector analyticsCollector, boolean z2, SeekParameters seekParameters, boolean z3, Clock clock, Looper looper) {
        StringBuilder L = a2.b.a.a.a.L("Init ");
        L.append(Integer.toHexString(System.identityHashCode(this)));
        L.append(" [");
        L.append(ExoPlayerLibraryInfo.VERSION_SLASHY);
        L.append("] [");
        L.append(Util.DEVICE_DEBUG_INFO);
        L.append("]");
        Log.i("ExoPlayerImpl", L.toString());
        Assertions.checkState(rendererArr.length > 0);
        this.b = (Renderer[]) Assertions.checkNotNull(rendererArr);
        this.c = (TrackSelector) Assertions.checkNotNull(trackSelector);
        this.m = mediaSourceFactory;
        this.p = bandwidthMeter;
        this.n = analyticsCollector;
        this.l = z2;
        this.x = seekParameters;
        this.z = z3;
        this.o = looper;
        this.q = 0;
        this.h = new CopyOnWriteArrayList<>();
        this.k = new ArrayList();
        this.y = new ShuffleOrder.DefaultShuffleOrder(0);
        TrackSelectorResult trackSelectorResult = new TrackSelectorResult(new RendererConfiguration[rendererArr.length], new TrackSelection[rendererArr.length], null);
        this.a = trackSelectorResult;
        this.i = new Timeline.Period();
        this.C = -1;
        this.d = new Handler(looper);
        b bVar = new ExoPlayerImplInternal.PlaybackInfoUpdateListener() { // from class: a2.j.b.b.b
            @Override // com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdateListener
            public final void onPlaybackInfoUpdate(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
                d0 d0Var = d0.this;
                d0Var.d.post(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE  
                      (wrap: android.os.Handler : 0x0002: IGET  (r1v0 android.os.Handler) = (r0v0 'd0Var' a2.j.b.b.d0) a2.j.b.b.d0.d android.os.Handler)
                      (wrap: a2.j.b.b.d : 0x0006: CONSTRUCTOR  (r2v0 a2.j.b.b.d) = 
                      (r0v0 'd0Var' a2.j.b.b.d0)
                      (r4v0 'playbackInfoUpdate' com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate)
                     call: a2.j.b.b.d.<init>(a2.j.b.b.d0, com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: a2.j.b.b.b.onPlaybackInfoUpdate(com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate):void, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: CONSTRUCTOR  (r2v0 a2.j.b.b.d) = 
                      (r0v0 'd0Var' a2.j.b.b.d0)
                      (r4v0 'playbackInfoUpdate' com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate)
                     call: a2.j.b.b.d.<init>(a2.j.b.b.d0, com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate):void type: CONSTRUCTOR in method: a2.j.b.b.b.onPlaybackInfoUpdate(com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate):void, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                    	... 15 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.j.b.b.d, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                    	... 21 more
                    */
                /*
                    this = this;
                    a2.j.b.b.d0 r0 = a2.j.b.b.d0.this
                    android.os.Handler r1 = r0.d
                    a2.j.b.b.d r2 = new a2.j.b.b.d
                    r2.<init>(r0, r4)
                    r1.post(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.b.onPlaybackInfoUpdate(com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate):void");
            }
        };
        this.e = bVar;
        this.B = j0.i(trackSelectorResult);
        this.j = new ArrayDeque<>();
        if (analyticsCollector != null) {
            analyticsCollector.setPlayer(this);
            addListener(analyticsCollector);
            bandwidthMeter.addEventListener(new Handler(looper), analyticsCollector);
        }
        ExoPlayerImplInternal exoPlayerImplInternal = new ExoPlayerImplInternal(rendererArr, trackSelector, trackSelectorResult, loadControl, bandwidthMeter, this.q, this.r, analyticsCollector, seekParameters, z3, looper, clock, bVar);
        this.f = exoPlayerImplInternal;
        this.g = new Handler(exoPlayerImplInternal.i);
    }

    public static void g(CopyOnWriteArrayList<BasePlayer.ListenerHolder> copyOnWriteArrayList, BasePlayer.ListenerInvocation listenerInvocation) {
        Iterator<BasePlayer.ListenerHolder> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().invoke(listenerInvocation);
        }
    }

    public final List<MediaSourceList.c> a(int i2, List<MediaSource> list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            MediaSourceList.c cVar = new MediaSourceList.c(list.get(i3), this.l);
            arrayList.add(cVar);
            this.k.add(i3 + i2, new a(cVar.b, cVar.a.getTimeline()));
        }
        this.y = this.y.cloneAndInsert(i2, arrayList.size());
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.EventListener eventListener) {
        Assertions.checkNotNull(eventListener);
        this.h.addIfAbsent(new BasePlayer.ListenerHolder(eventListener));
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(List<MediaItem> list) {
        addMediaItems(this.k.size(), list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSource(MediaSource mediaSource) {
        addMediaSources(this.k.size(), Collections.singletonList(mediaSource));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(List<MediaSource> list) {
        addMediaSources(this.k.size(), list);
    }

    public final Timeline b() {
        return new l0(this.k, this.y);
    }

    public final List<MediaSource> c(List<MediaItem> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(this.m.createMediaSource(list.get(i2)));
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearMediaItems() {
        removeMediaItems(0, this.k.size());
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public PlayerMessage createMessage(PlayerMessage.Target target) {
        return new PlayerMessage(this.f, target, this.B.a, getCurrentWindowIndex(), this.g);
    }

    public final int d() {
        if (this.B.a.isEmpty()) {
            return this.C;
        }
        j0 j0Var = this.B;
        return j0Var.a.getPeriodByUid(j0Var.b.periodUid, this.i).windowIndex;
    }

    @Nullable
    public final Pair<Object, Long> e(Timeline timeline, Timeline timeline2) {
        long contentPosition = getContentPosition();
        int i2 = -1;
        if (timeline.isEmpty() || timeline2.isEmpty()) {
            boolean z2 = !timeline.isEmpty() && timeline2.isEmpty();
            if (!z2) {
                i2 = d();
            }
            if (z2) {
                contentPosition = -9223372036854775807L;
            }
            return f(timeline2, i2, contentPosition);
        }
        Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.window, this.i, getCurrentWindowIndex(), C.msToUs(contentPosition));
        Object obj = ((Pair) Util.castNonNull(periodPosition)).first;
        if (timeline2.getIndexOfPeriod(obj) != -1) {
            return periodPosition;
        }
        Object I = ExoPlayerImplInternal.I(this.window, this.i, this.q, this.r, obj, timeline, timeline2);
        if (I == null) {
            return f(timeline2, -1, C.TIME_UNSET);
        }
        timeline2.getPeriodByUid(I, this.i);
        int i3 = this.i.windowIndex;
        return f(timeline2, i3, timeline2.getWindow(i3, this.window).getDefaultPositionMs());
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void experimentalSetOffloadSchedulingEnabled(boolean z2) {
        this.f.g.obtainMessage(24, z2 ? 1 : 0, 0).sendToTarget();
    }

    @Nullable
    public final Pair<Object, Long> f(Timeline timeline, int i2, long j2) {
        if (timeline.isEmpty()) {
            this.C = i2;
            if (j2 == C.TIME_UNSET) {
                j2 = 0;
            }
            this.D = j2;
            return null;
        }
        if (i2 == -1 || i2 >= timeline.getWindowCount()) {
            i2 = timeline.getFirstWindowIndex(this.r);
            j2 = timeline.getWindow(i2, this.window).getDefaultPositionMs();
        }
        return timeline.getPeriodPosition(this.window, this.i, i2, C.msToUs(j2));
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public Player.AudioComponent getAudioComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        if (!isPlayingAd()) {
            return getContentBufferedPosition();
        }
        j0 j0Var = this.B;
        if (j0Var.i.equals(j0Var.b)) {
            return C.usToMs(this.B.n);
        }
        return getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        if (this.B.a.isEmpty()) {
            return this.D;
        }
        j0 j0Var = this.B;
        if (j0Var.i.windowSequenceNumber != j0Var.b.windowSequenceNumber) {
            return j0Var.a.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
        }
        long j2 = j0Var.n;
        if (this.B.i.isAd()) {
            j0 j0Var2 = this.B;
            Timeline.Period periodByUid = j0Var2.a.getPeriodByUid(j0Var2.i.periodUid, this.i);
            long adGroupTimeUs = periodByUid.getAdGroupTimeUs(this.B.i.adGroupIndex);
            j2 = adGroupTimeUs == Long.MIN_VALUE ? periodByUid.durationUs : adGroupTimeUs;
        }
        return k(this.B.i, j2);
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        j0 j0Var = this.B;
        j0Var.a.getPeriodByUid(j0Var.b.periodUid, this.i);
        j0 j0Var2 = this.B;
        if (j0Var2.c == C.TIME_UNSET) {
            return j0Var2.a.getWindow(getCurrentWindowIndex(), this.window).getDefaultPositionMs();
        }
        return this.i.getPositionInWindowMs() + C.usToMs(this.B.c);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        if (isPlayingAd()) {
            return this.B.b.adGroupIndex;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        if (isPlayingAd()) {
            return this.B.b.adIndexInAdGroup;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        if (this.B.a.isEmpty()) {
            return 0;
        }
        j0 j0Var = this.B;
        return j0Var.a.getIndexOfPeriod(j0Var.b.periodUid);
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        if (this.B.a.isEmpty()) {
            return this.D;
        }
        if (this.B.b.isAd()) {
            return C.usToMs(this.B.p);
        }
        j0 j0Var = this.B;
        return k(j0Var.b, j0Var.p);
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        return this.B.a;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        return this.B.g;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        return this.B.h.selections;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        int d2 = d();
        if (d2 == -1) {
            return 0;
        }
        return d2;
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public Player.DeviceComponent getDeviceComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        if (!isPlayingAd()) {
            return getContentDuration();
        }
        j0 j0Var = this.B;
        MediaSource.MediaPeriodId mediaPeriodId = j0Var.b;
        j0Var.a.getPeriodByUid(mediaPeriodId.periodUid, this.i);
        return C.usToMs(this.i.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public Player.MetadataComponent getMetadataComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean getPauseAtEndOfMediaItems() {
        return this.z;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        return this.B.j;
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    @Deprecated
    public ExoPlaybackException getPlaybackError() {
        return this.B.e;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Looper getPlaybackLooper() {
        return this.f.i;
    }

    @Override // com.google.android.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        return this.B.l;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.B.d;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        return this.B.k;
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public ExoPlaybackException getPlayerError() {
        return this.B.e;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererCount() {
        return this.b.length;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererType(int i2) {
        return this.b[i2].getTrackType();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        return this.q;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public SeekParameters getSeekParameters() {
        return this.x;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public Player.TextComponent getTextComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        return C.usToMs(this.B.o);
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public TrackSelector getTrackSelector() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public Player.VideoComponent getVideoComponent() {
        return null;
    }

    public final j0 h(j0 j0Var, Timeline timeline, @Nullable Pair<Object, Long> pair) {
        int i2;
        long j2;
        Assertions.checkArgument(timeline.isEmpty() || pair != null);
        Timeline timeline2 = j0Var.a;
        j0 h2 = j0Var.h(timeline);
        if (timeline.isEmpty()) {
            MediaSource.MediaPeriodId mediaPeriodId = j0.q;
            j0 a3 = h2.b(mediaPeriodId, C.msToUs(this.D), C.msToUs(this.D), 0, TrackGroupArray.EMPTY, this.a).a(mediaPeriodId);
            a3.n = a3.p;
            return a3;
        }
        Object obj = h2.b.periodUid;
        boolean z2 = !obj.equals(((Pair) Util.castNonNull(pair)).first);
        MediaSource.MediaPeriodId mediaPeriodId2 = z2 ? new MediaSource.MediaPeriodId(pair.first) : h2.b;
        long longValue = ((Long) pair.second).longValue();
        long msToUs = C.msToUs(getContentPosition());
        if (!timeline2.isEmpty()) {
            msToUs -= timeline2.getPeriodByUid(obj, this.i).getPositionInWindowUs();
        }
        if (z2 || longValue < msToUs) {
            Assertions.checkState(!mediaPeriodId2.isAd());
            j0 a4 = h2.b(mediaPeriodId2, longValue, longValue, 0, z2 ? TrackGroupArray.EMPTY : h2.g, z2 ? this.a : h2.h).a(mediaPeriodId2);
            a4.n = longValue;
            return a4;
        } else if (i2 == 0) {
            int indexOfPeriod = timeline.getIndexOfPeriod(h2.i.periodUid);
            if (indexOfPeriod != -1 && timeline.getPeriod(indexOfPeriod, this.i).windowIndex == timeline.getPeriodByUid(mediaPeriodId2.periodUid, this.i).windowIndex) {
                return h2;
            }
            timeline.getPeriodByUid(mediaPeriodId2.periodUid, this.i);
            if (mediaPeriodId2.isAd()) {
                j2 = this.i.getAdDurationUs(mediaPeriodId2.adGroupIndex, mediaPeriodId2.adIndexInAdGroup);
            } else {
                j2 = this.i.durationUs;
            }
            j0 a5 = h2.b(mediaPeriodId2, h2.p, h2.p, j2 - h2.p, h2.g, h2.h).a(mediaPeriodId2);
            a5.n = j2;
            return a5;
        } else {
            Assertions.checkState(!mediaPeriodId2.isAd());
            long max = Math.max(0L, h2.o - (longValue - msToUs));
            long j3 = h2.n;
            if (h2.i.equals(h2.b)) {
                j3 = longValue + max;
            }
            j0 b2 = h2.b(mediaPeriodId2, longValue, longValue, max, h2.g, h2.h);
            b2.n = j3;
            return b2;
        }
    }

    public final void i(BasePlayer.ListenerInvocation listenerInvocation) {
        j(new Runnable(new CopyOnWriteArrayList(this.h), listenerInvocation) { // from class: a2.j.b.b.s
            public final /* synthetic */ CopyOnWriteArrayList a;
            public final /* synthetic */ BasePlayer.ListenerInvocation b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                d0.g(this.a, this.b);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        return this.B.f;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        return this.B.b.isAd();
    }

    public final void j(Runnable runnable) {
        boolean z2 = !this.j.isEmpty();
        this.j.addLast(runnable);
        if (!z2) {
            while (!this.j.isEmpty()) {
                this.j.peekFirst().run();
                this.j.removeFirst();
            }
        }
    }

    public final long k(MediaSource.MediaPeriodId mediaPeriodId, long j2) {
        long usToMs = C.usToMs(j2);
        this.B.a.getPeriodByUid(mediaPeriodId.periodUid, this.i);
        return this.i.getPositionInWindowMs() + usToMs;
    }

    public final j0 l(int i2, int i3) {
        boolean z2 = false;
        Assertions.checkArgument(i2 >= 0 && i3 >= i2 && i3 <= this.k.size());
        int currentWindowIndex = getCurrentWindowIndex();
        Timeline timeline = this.B.a;
        int size = this.k.size();
        this.s++;
        m(i2, i3);
        Timeline b2 = b();
        j0 h2 = h(this.B, b2, e(timeline, b2));
        int i4 = h2.d;
        if (i4 != 1 && i4 != 4 && i2 < i3 && i3 == size && currentWindowIndex >= h2.a.getWindowCount()) {
            z2 = true;
        }
        if (z2) {
            h2 = h2.g(4);
        }
        this.f.g.obtainMessage(20, i2, i3, this.y).sendToTarget();
        return h2;
    }

    public final void m(int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            this.k.remove(i4);
        }
        this.y = this.y.cloneAndRemove(i2, i3);
        if (this.k.isEmpty()) {
            this.A = false;
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItems(int i2, int i3, int i4) {
        Assertions.checkArgument(i2 >= 0 && i2 <= i3 && i3 <= this.k.size() && i4 >= 0);
        Timeline timeline = this.B.a;
        this.s++;
        int min = Math.min(i4, this.k.size() - (i3 - i2));
        Util.moveItems(this.k, i2, i3, min);
        Timeline b2 = b();
        j0 h2 = h(this.B, b2, e(timeline, b2));
        this.f.g.obtainMessage(19, new ExoPlayerImplInternal.b(i2, i3, min, this.y)).sendToTarget();
        p(h2, false, 4, 0, 1, false);
    }

    public final void n(List<MediaSource> list, int i2, long j2, boolean z2) {
        int i3;
        long j3;
        q(list, true);
        int d2 = d();
        long currentPosition = getCurrentPosition();
        this.s++;
        if (!this.k.isEmpty()) {
            m(0, this.k.size());
        }
        List<MediaSourceList.c> a3 = a(0, list);
        Timeline b2 = b();
        if (b2.isEmpty() || i2 < ((l0) b2).d) {
            if (z2) {
                int firstWindowIndex = b2.getFirstWindowIndex(this.r);
                j3 = C.TIME_UNSET;
                i3 = firstWindowIndex;
            } else if (i2 == -1) {
                i3 = d2;
                j3 = currentPosition;
            } else {
                i3 = i2;
                j3 = j2;
            }
            j0 h2 = h(this.B, b2, f(b2, i3, j3));
            int i4 = h2.d;
            if (!(i3 == -1 || i4 == 1)) {
                i4 = (b2.isEmpty() || i3 >= ((l0) b2).d) ? 4 : 2;
            }
            j0 g2 = h2.g(i4);
            this.f.g.obtainMessage(17, new ExoPlayerImplInternal.a(a3, this.y, i3, C.msToUs(j3), null)).sendToTarget();
            p(g2, false, 4, 0, 1, false);
            return;
        }
        throw new IllegalSeekPositionException(b2, i2, j2);
    }

    public void o(boolean z2, int i2, int i3) {
        j0 j0Var = this.B;
        if (j0Var.j != z2 || j0Var.k != i2) {
            this.s++;
            j0 d2 = j0Var.d(z2, i2);
            this.f.g.obtainMessage(1, z2 ? 1 : 0, i2).sendToTarget();
            p(d2, false, 4, 0, i3, false);
        }
    }

    public final void p(j0 j0Var, boolean z2, int i2, int i3, int i4, boolean z3) {
        Pair pair;
        j0 j0Var2 = this.B;
        this.B = j0Var;
        int i5 = 1;
        boolean z4 = !j0Var2.a.equals(j0Var.a);
        Timeline timeline = j0Var2.a;
        Timeline timeline2 = j0Var.a;
        if (timeline2.isEmpty() && timeline.isEmpty()) {
            pair = new Pair(Boolean.FALSE, -1);
        } else if (timeline2.isEmpty() != timeline.isEmpty()) {
            pair = new Pair(Boolean.TRUE, 3);
        } else {
            Object obj = timeline.getWindow(timeline.getPeriodByUid(j0Var2.b.periodUid, this.i).windowIndex, this.window).uid;
            Object obj2 = timeline2.getWindow(timeline2.getPeriodByUid(j0Var.b.periodUid, this.i).windowIndex, this.window).uid;
            int i6 = this.window.firstPeriodIndex;
            if (!obj.equals(obj2)) {
                if (!z2 || i2 != 0) {
                    if (z2 && i2 == 1) {
                        i5 = 2;
                    } else if (z4) {
                        i5 = 3;
                    } else {
                        throw new IllegalStateException();
                    }
                }
                pair = new Pair(Boolean.TRUE, Integer.valueOf(i5));
            } else if (z2 && i2 == 0 && timeline2.getIndexOfPeriod(j0Var.b.periodUid) == i6) {
                pair = new Pair(Boolean.TRUE, 0);
            } else {
                pair = new Pair(Boolean.FALSE, -1);
            }
        }
        boolean booleanValue = ((Boolean) pair.first).booleanValue();
        int intValue = ((Integer) pair.second).intValue();
        MediaItem mediaItem = null;
        if (booleanValue && !j0Var.a.isEmpty()) {
            mediaItem = j0Var.a.getWindow(j0Var.a.getPeriodByUid(j0Var.b.periodUid, this.i).windowIndex, this.window).mediaItem;
        }
        j(new b(j0Var, j0Var2, this.h, this.c, z2, i2, i3, booleanValue, intValue, mediaItem, i4, z3));
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        j0 j0Var = this.B;
        if (j0Var.d == 1) {
            j0 e2 = j0Var.e(null);
            j0 g2 = e2.g(e2.a.isEmpty() ? 4 : 2);
            this.s++;
            this.f.g.obtainMessage(0).sendToTarget();
            p(g2, false, 4, 1, 1, false);
        }
    }

    public final void q(List<MediaSource> list, boolean z2) {
        if (!this.A || z2 || list.isEmpty()) {
            int size = list.size() + (z2 ? 0 : this.k.size());
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((MediaSource) Assertions.checkNotNull(list.get(i2))) instanceof AdsMediaSource) {
                    if (size <= 1) {
                        this.A = true;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        boolean z2;
        StringBuilder L = a2.b.a.a.a.L("Release ");
        L.append(Integer.toHexString(System.identityHashCode(this)));
        L.append(" [");
        L.append(ExoPlayerLibraryInfo.VERSION_SLASHY);
        L.append("] [");
        L.append(Util.DEVICE_DEBUG_INFO);
        L.append("] [");
        L.append(ExoPlayerLibraryInfo.registeredModules());
        L.append("]");
        Log.i("ExoPlayerImpl", L.toString());
        ExoPlayerImplInternal exoPlayerImplInternal = this.f;
        synchronized (exoPlayerImplInternal) {
            if (!exoPlayerImplInternal.w) {
                if (exoPlayerImplInternal.h.isAlive()) {
                    exoPlayerImplInternal.g.sendEmptyMessage(7);
                    long j2 = exoPlayerImplInternal.L;
                    if (j2 > 0) {
                        exoPlayerImplInternal.j0(new Supplier() { // from class: a2.j.b.b.v
                            @Override // com.google.common.base.Supplier
                            public final Object get() {
                                return Boolean.valueOf(ExoPlayerImplInternal.this.w);
                            }
                        }, j2);
                    } else {
                        exoPlayerImplInternal.i0(new Supplier() { // from class: a2.j.b.b.x
                            @Override // com.google.common.base.Supplier
                            public final Object get() {
                                return Boolean.valueOf(ExoPlayerImplInternal.this.w);
                            }
                        });
                    }
                    z2 = exoPlayerImplInternal.w;
                }
            }
            z2 = true;
        }
        if (!z2) {
            i(c.a);
        }
        this.d.removeCallbacksAndMessages(null);
        AnalyticsCollector analyticsCollector = this.n;
        if (analyticsCollector != null) {
            this.p.removeEventListener(analyticsCollector);
        }
        j0 g2 = this.B.g(1);
        this.B = g2;
        j0 a3 = g2.a(g2.b);
        this.B = a3;
        a3.n = a3.p;
        this.B.o = 0;
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.EventListener eventListener) {
        Iterator<BasePlayer.ListenerHolder> it = this.h.iterator();
        while (it.hasNext()) {
            BasePlayer.ListenerHolder next = it.next();
            if (next.listener.equals(eventListener)) {
                next.release();
                this.h.remove(next);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItems(int i2, int i3) {
        p(l(i2, i3), false, 4, 0, 1, false);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void retry() {
        prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i2, long j2) {
        Timeline timeline = this.B.a;
        if (i2 < 0 || (!timeline.isEmpty() && i2 >= timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(timeline, i2, j2);
        }
        int i3 = 1;
        this.s++;
        if (isPlayingAd()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.e.onPlaybackInfoUpdate(new ExoPlayerImplInternal.PlaybackInfoUpdate(this.B));
            return;
        }
        j0 j0Var = this.B;
        if (j0Var.d != 1) {
            i3 = 2;
        }
        j0 h2 = h(j0Var.g(i3), timeline, f(timeline, i2, j2));
        this.f.g.obtainMessage(3, new ExoPlayerImplInternal.e(timeline, i2, C.msToUs(j2))).sendToTarget();
        p(h2, true, 1, 0, 1, true);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setForegroundMode(boolean z2) {
        boolean z3;
        if (this.w != z2) {
            this.w = z2;
            ExoPlayerImplInternal exoPlayerImplInternal = this.f;
            synchronized (exoPlayerImplInternal) {
                z3 = true;
                if (!exoPlayerImplInternal.w) {
                    if (exoPlayerImplInternal.h.isAlive()) {
                        if (z2) {
                            exoPlayerImplInternal.g.obtainMessage(13, 1, 0).sendToTarget();
                        } else {
                            AtomicBoolean atomicBoolean = new AtomicBoolean();
                            exoPlayerImplInternal.g.obtainMessage(13, 0, 0, atomicBoolean).sendToTarget();
                            long j2 = exoPlayerImplInternal.L;
                            if (j2 > 0) {
                                exoPlayerImplInternal.j0(new b0(atomicBoolean), j2);
                            } else {
                                exoPlayerImplInternal.i0(new b0(atomicBoolean));
                            }
                            z3 = atomicBoolean.get();
                        }
                    }
                }
            }
            if (!z3) {
                i(r.a);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, boolean z2) {
        n(c(list), -1, C.TIME_UNSET, z2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource) {
        n(Collections.singletonList(mediaSource), -1, C.TIME_UNSET, true);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list) {
        n(list, -1, C.TIME_UNSET, true);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setPauseAtEndOfMediaItems(boolean z2) {
        if (this.z != z2) {
            this.z = z2;
            this.f.g.obtainMessage(23, z2 ? 1 : 0, 0).sendToTarget();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z2) {
        o(z2, 0, 1);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(@Nullable PlaybackParameters playbackParameters) {
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        if (!this.B.l.equals(playbackParameters)) {
            j0 f2 = this.B.f(playbackParameters);
            this.s++;
            this.f.g.obtainMessage(4, playbackParameters).sendToTarget();
            p(f2, false, 4, 0, 1, false);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i2) {
        if (this.q != i2) {
            this.q = i2;
            this.f.g.obtainMessage(11, i2, 0).sendToTarget();
            i(new BasePlayer.ListenerInvocation(i2) { // from class: a2.j.b.b.u
                public final /* synthetic */ int a;

                {
                    this.a = r1;
                }

                @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                public final void invokeListener(Player.EventListener eventListener) {
                    eventListener.onRepeatModeChanged(this.a);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setSeekParameters(@Nullable SeekParameters seekParameters) {
        if (seekParameters == null) {
            seekParameters = SeekParameters.DEFAULT;
        }
        if (!this.x.equals(seekParameters)) {
            this.x = seekParameters;
            this.f.g.obtainMessage(5, seekParameters).sendToTarget();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z2) {
        if (this.r != z2) {
            this.r = z2;
            this.f.g.obtainMessage(12, z2 ? 1 : 0, 0).sendToTarget();
            i(new BasePlayer.ListenerInvocation(z2) { // from class: a2.j.b.b.t
                public final /* synthetic */ boolean a;

                {
                    this.a = r1;
                }

                @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                public final void invokeListener(Player.EventListener eventListener) {
                    eventListener.onShuffleModeEnabledChanged(this.a);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        Timeline b2 = b();
        j0 h2 = h(this.B, b2, f(b2, getCurrentWindowIndex(), getCurrentPosition()));
        this.s++;
        this.y = shuffleOrder;
        this.f.g.obtainMessage(21, shuffleOrder).sendToTarget();
        p(h2, false, 4, 0, 1, false);
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop(boolean z2) {
        j0 j0Var;
        if (z2) {
            j0Var = l(0, this.k.size()).e(null);
        } else {
            j0 j0Var2 = this.B;
            j0Var = j0Var2.a(j0Var2.b);
            j0Var.n = j0Var.p;
            j0Var.o = 0;
        }
        j0 g2 = j0Var.g(1);
        this.s++;
        this.f.g.obtainMessage(6).sendToTarget();
        p(g2, false, 4, 0, 1, false);
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(int i2, List<MediaItem> list) {
        addMediaSources(i2, c(list));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(int i2, List<MediaSource> list) {
        Assertions.checkArgument(i2 >= 0);
        q(list, false);
        Timeline timeline = this.B.a;
        this.s++;
        List<MediaSourceList.c> a3 = a(i2, list);
        Timeline b2 = b();
        j0 h2 = h(this.B, b2, e(timeline, b2));
        this.f.g.obtainMessage(18, i2, 0, new ExoPlayerImplInternal.a(a3, this.y, -1, C.TIME_UNSET, null)).sendToTarget();
        p(h2, false, 4, 0, 1, false);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, boolean z2) {
        n(list, -1, C.TIME_UNSET, z2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSource(int i2, MediaSource mediaSource) {
        addMediaSources(i2, Collections.singletonList(mediaSource));
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, int i2, long j2) {
        n(c(list), i2, j2, false);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource, long j2) {
        setMediaSources(Collections.singletonList(mediaSource), 0, j2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, int i2, long j2) {
        n(list, i2, j2, false);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource, boolean z2) {
        n(Collections.singletonList(mediaSource), -1, C.TIME_UNSET, z2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void prepare(MediaSource mediaSource) {
        n(Collections.singletonList(mediaSource), -1, C.TIME_UNSET, true);
        prepare();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void prepare(MediaSource mediaSource, boolean z2, boolean z3) {
        n(Collections.singletonList(mediaSource), -1, C.TIME_UNSET, z2);
        prepare();
    }
}
