package com.google.android.exoplayer2;

import a2.j.b.b.i0;
import a2.j.b.b.l0;
import a2.j.b.b.z;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MaskingMediaSource;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
public final class MediaSourceList {
    public final List<c> a = new ArrayList();
    public final IdentityHashMap<MediaPeriod, c> b = new IdentityHashMap<>();
    public final Map<Object, c> c = new HashMap();
    public final MediaSourceListInfoRefreshListener d;
    public final MediaSourceEventListener.EventDispatcher e;
    public final DrmSessionEventListener.EventDispatcher f;
    public final HashMap<c, b> g;
    public final Set<c> h;
    public ShuffleOrder i = new ShuffleOrder.DefaultShuffleOrder(0);
    public boolean j;
    @Nullable
    public TransferListener k;

    public interface MediaSourceListInfoRefreshListener {
        void onPlaylistUpdateRequested();
    }

    public final class a implements MediaSourceEventListener, DrmSessionEventListener {
        public final c a;
        public MediaSourceEventListener.EventDispatcher b;
        public DrmSessionEventListener.EventDispatcher c;

        public a(c cVar) {
            this.b = MediaSourceList.this.e;
            this.c = MediaSourceList.this.f;
            this.a = cVar;
        }

        public final boolean a(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2 = null;
            if (mediaPeriodId != null) {
                c cVar = this.a;
                int i2 = 0;
                while (true) {
                    if (i2 >= cVar.c.size()) {
                        break;
                    } else if (cVar.c.get(i2).windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                        mediaPeriodId2 = mediaPeriodId.copyWithPeriodUid(AbstractConcatenatedTimeline.getConcatenatedUid(cVar.b, mediaPeriodId.periodUid));
                        break;
                    } else {
                        i2++;
                    }
                }
                if (mediaPeriodId2 == null) {
                    return false;
                }
            }
            int i3 = i + this.a.d;
            MediaSourceEventListener.EventDispatcher eventDispatcher = this.b;
            if (eventDispatcher.windowIndex != i3 || !Util.areEqual(eventDispatcher.mediaPeriodId, mediaPeriodId2)) {
                this.b = MediaSourceList.this.e.withParameters(i3, mediaPeriodId2, 0);
            }
            DrmSessionEventListener.EventDispatcher eventDispatcher2 = this.c;
            if (eventDispatcher2.windowIndex == i3 && Util.areEqual(eventDispatcher2.mediaPeriodId, mediaPeriodId2)) {
                return true;
            }
            this.c = MediaSourceList.this.f.withParameters(i3, mediaPeriodId2);
            return true;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onDownstreamFormatChanged(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.b.downstreamFormatChanged(mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysLoaded(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.c.drmKeysLoaded();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysRemoved(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.c.drmKeysRemoved();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysRestored(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.c.drmKeysRestored();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionAcquired(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.c.drmSessionAcquired();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionManagerError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            if (a(i, mediaPeriodId)) {
                this.c.drmSessionManagerError(exc);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionReleased(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.c.drmSessionReleased();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCanceled(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.b.loadCanceled(loadEventInfo, mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCompleted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.b.loadCompleted(loadEventInfo, mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            if (a(i, mediaPeriodId)) {
                this.b.loadError(loadEventInfo, mediaLoadData, iOException, z);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadStarted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.b.loadStarted(loadEventInfo, mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onUpstreamDiscarded(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.b.upstreamDiscarded(mediaLoadData);
            }
        }
    }

    public static final class b {
        public final MediaSource a;
        public final MediaSource.MediaSourceCaller b;
        public final MediaSourceEventListener c;

        public b(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, MediaSourceEventListener mediaSourceEventListener) {
            this.a = mediaSource;
            this.b = mediaSourceCaller;
            this.c = mediaSourceEventListener;
        }
    }

    public static final class c implements i0 {
        public final MaskingMediaSource a;
        public final Object b = new Object();
        public final List<MediaSource.MediaPeriodId> c = new ArrayList();
        public int d;
        public boolean e;

        public c(MediaSource mediaSource, boolean z) {
            this.a = new MaskingMediaSource(mediaSource, z);
        }

        @Override // a2.j.b.b.i0
        public Timeline a() {
            return this.a.getTimeline();
        }

        @Override // a2.j.b.b.i0
        public Object getUid() {
            return this.b;
        }
    }

    public MediaSourceList(MediaSourceListInfoRefreshListener mediaSourceListInfoRefreshListener, @Nullable AnalyticsCollector analyticsCollector, Handler handler) {
        this.d = mediaSourceListInfoRefreshListener;
        MediaSourceEventListener.EventDispatcher eventDispatcher = new MediaSourceEventListener.EventDispatcher();
        this.e = eventDispatcher;
        DrmSessionEventListener.EventDispatcher eventDispatcher2 = new DrmSessionEventListener.EventDispatcher();
        this.f = eventDispatcher2;
        this.g = new HashMap<>();
        this.h = new HashSet();
        if (analyticsCollector != null) {
            eventDispatcher.addEventListener(handler, analyticsCollector);
            eventDispatcher2.addEventListener(handler, analyticsCollector);
        }
    }

    public Timeline a(int i2, List<c> list, ShuffleOrder shuffleOrder) {
        if (!list.isEmpty()) {
            this.i = shuffleOrder;
            for (int i3 = i2; i3 < list.size() + i2; i3++) {
                c cVar = list.get(i3 - i2);
                if (i3 > 0) {
                    c cVar2 = this.a.get(i3 - 1);
                    Timeline timeline = cVar2.a.getTimeline();
                    cVar.d = timeline.getWindowCount() + cVar2.d;
                    cVar.e = false;
                    cVar.c.clear();
                } else {
                    cVar.d = 0;
                    cVar.e = false;
                    cVar.c.clear();
                }
                b(i3, cVar.a.getTimeline().getWindowCount());
                this.a.add(i3, cVar);
                this.c.put(cVar.b, cVar);
                if (this.j) {
                    g(cVar);
                    if (this.b.isEmpty()) {
                        this.h.add(cVar);
                    } else {
                        b bVar = this.g.get(cVar);
                        if (bVar != null) {
                            bVar.a.disable(bVar.b);
                        }
                    }
                }
            }
        }
        return c();
    }

    public final void b(int i2, int i3) {
        while (i2 < this.a.size()) {
            this.a.get(i2).d += i3;
            i2++;
        }
    }

    public Timeline c() {
        if (this.a.isEmpty()) {
            return Timeline.EMPTY;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            c cVar = this.a.get(i3);
            cVar.d = i2;
            i2 += cVar.a.getTimeline().getWindowCount();
        }
        return new l0(this.a, this.i);
    }

    public final void d() {
        Iterator<c> it = this.h.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.c.isEmpty()) {
                b bVar = this.g.get(next);
                if (bVar != null) {
                    bVar.a.disable(bVar.b);
                }
                it.remove();
            }
        }
    }

    public int e() {
        return this.a.size();
    }

    public final void f(c cVar) {
        if (cVar.e && cVar.c.isEmpty()) {
            b bVar = (b) Assertions.checkNotNull(this.g.remove(cVar));
            bVar.a.releaseSource(bVar.b);
            bVar.a.removeEventListener(bVar.c);
            this.h.remove(cVar);
        }
    }

    public final void g(c cVar) {
        MaskingMediaSource maskingMediaSource = cVar.a;
        z zVar = new MediaSource.MediaSourceCaller() { // from class: a2.j.b.b.z
            @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
            public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
                MediaSourceList.this.d.onPlaylistUpdateRequested();
            }
        };
        a aVar = new a(cVar);
        this.g.put(cVar, new b(maskingMediaSource, zVar, aVar));
        maskingMediaSource.addEventListener(Util.createHandlerForCurrentOrMainLooper(), aVar);
        maskingMediaSource.addDrmEventListener(Util.createHandlerForCurrentOrMainLooper(), aVar);
        maskingMediaSource.prepareSource(zVar, this.k);
    }

    public void h(MediaPeriod mediaPeriod) {
        c cVar = (c) Assertions.checkNotNull(this.b.remove(mediaPeriod));
        cVar.a.releasePeriod(mediaPeriod);
        cVar.c.remove(((MaskingMediaPeriod) mediaPeriod).id);
        if (!this.b.isEmpty()) {
            d();
        }
        f(cVar);
    }

    public final void i(int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            c remove = this.a.remove(i4);
            this.c.remove(remove.b);
            b(i4, -remove.a.getTimeline().getWindowCount());
            remove.e = true;
            if (this.j) {
                f(remove);
            }
        }
    }
}
