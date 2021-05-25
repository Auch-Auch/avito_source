package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
public final class ConcatenatingMediaSource extends CompositeMediaSource<e> {
    public static final MediaItem v = new MediaItem.Builder().setUri(Uri.EMPTY).build();
    @GuardedBy("this")
    public final List<e> j;
    @GuardedBy("this")
    public final Set<d> k;
    @Nullable
    @GuardedBy("this")
    public Handler l;
    public final List<e> m;
    public final IdentityHashMap<MediaPeriod, e> n;
    public final Map<Object, e> o;
    public final Set<e> p;
    public final boolean q;
    public final boolean r;
    public boolean s;
    public Set<d> t;
    public ShuffleOrder u;

    public static final class b extends AbstractConcatenatedTimeline {
        public final int d;
        public final int e;
        public final int[] f;
        public final int[] g;
        public final Timeline[] h;
        public final Object[] i;
        public final HashMap<Object, Integer> j = new HashMap<>();

        public b(Collection<e> collection, ShuffleOrder shuffleOrder, boolean z) {
            super(z, shuffleOrder);
            int size = collection.size();
            this.f = new int[size];
            this.g = new int[size];
            this.h = new Timeline[size];
            this.i = new Object[size];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (e eVar : collection) {
                this.h[i4] = eVar.a.getTimeline();
                this.g[i4] = i2;
                this.f[i4] = i3;
                i2 += this.h[i4].getWindowCount();
                i3 += this.h[i4].getPeriodCount();
                Object[] objArr = this.i;
                objArr[i4] = eVar.b;
                this.j.put(objArr[i4], Integer.valueOf(i4));
                i4++;
            }
            this.d = i2;
            this.e = i3;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByChildUid(Object obj) {
            Integer num = this.j.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByPeriodIndex(int i2) {
            return Util.binarySearchFloor(this.f, i2 + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByWindowIndex(int i2) {
            return Util.binarySearchFloor(this.g, i2 + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public Object getChildUidByChildIndex(int i2) {
            return this.i[i2];
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getFirstPeriodIndexByChildIndex(int i2) {
            return this.f[i2];
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getFirstWindowIndexByChildIndex(int i2) {
            return this.g[i2];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.e;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public Timeline getTimelineByChildIndex(int i2) {
            return this.h[i2];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.d;
        }
    }

    public static final class c extends BaseMediaSource {
        public c(a aVar) {
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public MediaItem getMediaItem() {
            return ConcatenatingMediaSource.v;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public void maybeThrowSourceInfoRefreshError() {
        }

        @Override // com.google.android.exoplayer2.source.BaseMediaSource
        public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public void releasePeriod(MediaPeriod mediaPeriod) {
        }

        @Override // com.google.android.exoplayer2.source.BaseMediaSource
        public void releaseSourceInternal() {
        }
    }

    public static final class d {
        public final Handler a;
        public final Runnable b;

        public d(Handler handler, Runnable runnable) {
            this.a = handler;
            this.b = runnable;
        }
    }

    public static final class e {
        public final MaskingMediaSource a;
        public final Object b = new Object();
        public final List<MediaSource.MediaPeriodId> c = new ArrayList();
        public int d;
        public int e;
        public boolean f;

        public e(MediaSource mediaSource, boolean z) {
            this.a = new MaskingMediaSource(mediaSource, z);
        }
    }

    public static final class f<T> {
        public final int a;
        public final T b;
        @Nullable
        public final d c;

        public f(int i, T t, @Nullable d dVar) {
            this.a = i;
            this.b = t;
            this.c = dVar;
        }
    }

    public ConcatenatingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    public final void a(int i, Collection<e> collection) {
        for (e eVar : collection) {
            int i2 = i + 1;
            if (i > 0) {
                e eVar2 = this.m.get(i - 1);
                Timeline timeline = eVar2.a.getTimeline();
                int i3 = eVar2.e;
                eVar.d = i;
                eVar.e = timeline.getWindowCount() + i3;
                eVar.f = false;
                eVar.c.clear();
            } else {
                eVar.d = i;
                eVar.e = 0;
                eVar.f = false;
                eVar.c.clear();
            }
            c(i, 1, eVar.a.getTimeline().getWindowCount());
            this.m.add(i, eVar);
            this.o.put(eVar.b, eVar);
            prepareChildSource(eVar, eVar.a);
            if (!isEnabled() || !this.n.isEmpty()) {
                disableChildSource(eVar);
            } else {
                this.p.add(eVar);
            }
            i = i2;
        }
    }

    public synchronized void addMediaSource(MediaSource mediaSource) {
        addMediaSource(this.j.size(), mediaSource);
    }

    public synchronized void addMediaSources(Collection<MediaSource> collection) {
        b(this.j.size(), collection, null, null);
    }

    @GuardedBy("this")
    public final void b(int i, Collection<MediaSource> collection, @Nullable Handler handler, @Nullable Runnable runnable) {
        boolean z = true;
        if ((handler == null) != (runnable == null)) {
            z = false;
        }
        Assertions.checkArgument(z);
        Handler handler2 = this.l;
        for (MediaSource mediaSource : collection) {
            Assertions.checkNotNull(mediaSource);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (MediaSource mediaSource2 : collection) {
            arrayList.add(new e(mediaSource2, this.r));
        }
        this.j.addAll(i, arrayList);
        if (handler2 != null && !collection.isEmpty()) {
            handler2.obtainMessage(0, new f(i, arrayList, d(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    public final void c(int i, int i2, int i3) {
        while (i < this.m.size()) {
            e eVar = this.m.get(i);
            eVar.d += i2;
            eVar.e += i3;
            i++;
        }
    }

    public synchronized void clear() {
        removeMediaSourceRange(0, getSize());
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        Object childTimelineUidFromConcatenatedUid = AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(mediaPeriodId.periodUid);
        MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(mediaPeriodId.periodUid));
        e eVar = this.o.get(childTimelineUidFromConcatenatedUid);
        if (eVar == null) {
            eVar = new e(new c(null), this.r);
            eVar.f = true;
            prepareChildSource(eVar, eVar.a);
        }
        this.p.add(eVar);
        enableChildSource(eVar);
        eVar.c.add(copyWithPeriodUid);
        MaskingMediaPeriod createPeriod = eVar.a.createPeriod(copyWithPeriodUid, allocator, j2);
        this.n.put(createPeriod, eVar);
        e();
        return createPeriod;
    }

    @Nullable
    @GuardedBy("this")
    public final d d(@Nullable Handler handler, @Nullable Runnable runnable) {
        if (handler == null || runnable == null) {
            return null;
        }
        d dVar = new d(handler, runnable);
        this.k.add(dVar);
        return dVar;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void disableInternal() {
        super.disableInternal();
        this.p.clear();
    }

    public final void e() {
        Iterator<e> it = this.p.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.c.isEmpty()) {
                disableChildSource(next);
                it.remove();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void enableInternal() {
    }

    public final synchronized void f(Set<d> set) {
        for (d dVar : set) {
            dVar.a.post(dVar.b);
        }
        this.k.removeAll(set);
    }

    @GuardedBy("this")
    public final void g(int i, int i2, @Nullable Handler handler, @Nullable Runnable runnable) {
        boolean z = true;
        if ((handler == null) != (runnable == null)) {
            z = false;
        }
        Assertions.checkArgument(z);
        Handler handler2 = this.l;
        List<e> list = this.j;
        list.add(i2, list.remove(i));
        if (handler2 != null) {
            handler2.obtainMessage(2, new f(i, Integer.valueOf(i2), d(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    public synchronized Timeline getInitialTimeline() {
        ShuffleOrder shuffleOrder;
        if (this.u.getLength() != this.j.size()) {
            shuffleOrder = this.u.cloneAndClear().cloneAndInsert(0, this.j.size());
        } else {
            shuffleOrder = this.u;
        }
        return new b(this.j, shuffleOrder, this.q);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return v;
    }

    public synchronized MediaSource getMediaSource(int i) {
        return this.j.get(i).a;
    }

    public synchronized int getSize() {
        return this.j.size();
    }

    @GuardedBy("this")
    public final void h(int i, int i2, @Nullable Handler handler, @Nullable Runnable runnable) {
        boolean z = false;
        if ((handler == null) == (runnable == null)) {
            z = true;
        }
        Assertions.checkArgument(z);
        Handler handler2 = this.l;
        Util.removeRange(this.j, i, i2);
        if (handler2 != null) {
            handler2.obtainMessage(1, new f(i, Integer.valueOf(i2), d(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    public final void i(@Nullable d dVar) {
        if (!this.s) {
            ((Handler) Assertions.checkNotNull(this.l)).obtainMessage(4).sendToTarget();
            this.s = true;
        }
        if (dVar != null) {
            this.t.add(dVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    public boolean isSingleWindow() {
        return false;
    }

    @GuardedBy("this")
    public final void j(ShuffleOrder shuffleOrder, @Nullable Handler handler, @Nullable Runnable runnable) {
        boolean z = true;
        if ((handler == null) != (runnable == null)) {
            z = false;
        }
        Assertions.checkArgument(z);
        Handler handler2 = this.l;
        if (handler2 != null) {
            int size = getSize();
            if (shuffleOrder.getLength() != size) {
                shuffleOrder = shuffleOrder.cloneAndClear().cloneAndInsert(0, size);
            }
            handler2.obtainMessage(3, new f(0, shuffleOrder, d(handler, runnable))).sendToTarget();
            return;
        }
        if (shuffleOrder.getLength() > 0) {
            shuffleOrder = shuffleOrder.cloneAndClear();
        }
        this.u = shuffleOrder;
        if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    public final void k() {
        this.s = false;
        Set<d> set = this.t;
        this.t = new HashSet();
        refreshSourceInfo(new b(this.m, this.u, this.q));
        ((Handler) Assertions.checkNotNull(this.l)).obtainMessage(5, set).sendToTarget();
    }

    public synchronized void moveMediaSource(int i, int i2) {
        g(i, i2, null, null);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public synchronized void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        this.l = new Handler(new Handler.Callback() { // from class: a2.j.b.b.z0.b
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                ConcatenatingMediaSource concatenatingMediaSource = ConcatenatingMediaSource.this;
                MediaItem mediaItem = ConcatenatingMediaSource.v;
                Objects.requireNonNull(concatenatingMediaSource);
                int i = message.what;
                if (i == 0) {
                    ConcatenatingMediaSource.f fVar = (ConcatenatingMediaSource.f) Util.castNonNull(message.obj);
                    concatenatingMediaSource.u = concatenatingMediaSource.u.cloneAndInsert(fVar.a, fVar.b.size());
                    concatenatingMediaSource.a(fVar.a, fVar.b);
                    concatenatingMediaSource.i(fVar.c);
                } else if (i == 1) {
                    ConcatenatingMediaSource.f fVar2 = (ConcatenatingMediaSource.f) Util.castNonNull(message.obj);
                    int i2 = fVar2.a;
                    int intValue = fVar2.b.intValue();
                    if (i2 == 0 && intValue == concatenatingMediaSource.u.getLength()) {
                        concatenatingMediaSource.u = concatenatingMediaSource.u.cloneAndClear();
                    } else {
                        concatenatingMediaSource.u = concatenatingMediaSource.u.cloneAndRemove(i2, intValue);
                    }
                    for (int i3 = intValue - 1; i3 >= i2; i3--) {
                        ConcatenatingMediaSource.e remove = concatenatingMediaSource.m.remove(i3);
                        concatenatingMediaSource.o.remove(remove.b);
                        concatenatingMediaSource.c(i3, -1, -remove.a.getTimeline().getWindowCount());
                        remove.f = true;
                        if (remove.c.isEmpty()) {
                            concatenatingMediaSource.p.remove(remove);
                            concatenatingMediaSource.releaseChildSource(remove);
                        }
                    }
                    concatenatingMediaSource.i(fVar2.c);
                } else if (i == 2) {
                    ConcatenatingMediaSource.f fVar3 = (ConcatenatingMediaSource.f) Util.castNonNull(message.obj);
                    ShuffleOrder shuffleOrder = concatenatingMediaSource.u;
                    int i4 = fVar3.a;
                    ShuffleOrder cloneAndRemove = shuffleOrder.cloneAndRemove(i4, i4 + 1);
                    concatenatingMediaSource.u = cloneAndRemove;
                    concatenatingMediaSource.u = cloneAndRemove.cloneAndInsert(fVar3.b.intValue(), 1);
                    int i5 = fVar3.a;
                    int intValue2 = fVar3.b.intValue();
                    int min = Math.min(i5, intValue2);
                    int max = Math.max(i5, intValue2);
                    int i6 = concatenatingMediaSource.m.get(min).e;
                    List<ConcatenatingMediaSource.e> list = concatenatingMediaSource.m;
                    list.add(intValue2, list.remove(i5));
                    while (min <= max) {
                        ConcatenatingMediaSource.e eVar = concatenatingMediaSource.m.get(min);
                        eVar.d = min;
                        eVar.e = i6;
                        i6 += eVar.a.getTimeline().getWindowCount();
                        min++;
                    }
                    concatenatingMediaSource.i(fVar3.c);
                } else if (i == 3) {
                    ConcatenatingMediaSource.f fVar4 = (ConcatenatingMediaSource.f) Util.castNonNull(message.obj);
                    concatenatingMediaSource.u = fVar4.b;
                    concatenatingMediaSource.i(fVar4.c);
                } else if (i == 4) {
                    concatenatingMediaSource.k();
                } else if (i == 5) {
                    concatenatingMediaSource.f((Set) Util.castNonNull(message.obj));
                } else {
                    throw new IllegalStateException();
                }
                return true;
            }
        });
        if (this.j.isEmpty()) {
            k();
        } else {
            this.u = this.u.cloneAndInsert(0, this.j.size());
            a(0, this.j);
            i(null);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        e eVar = (e) Assertions.checkNotNull(this.n.remove(mediaPeriod));
        eVar.a.releasePeriod(mediaPeriod);
        eVar.c.remove(((MaskingMediaPeriod) mediaPeriod).id);
        if (!this.n.isEmpty()) {
            e();
        }
        if (eVar.f && eVar.c.isEmpty()) {
            this.p.remove(eVar);
            releaseChildSource(eVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public synchronized void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.m.clear();
        this.p.clear();
        this.o.clear();
        this.u = this.u.cloneAndClear();
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.l = null;
        }
        this.s = false;
        this.t.clear();
        f(this.k);
    }

    public synchronized MediaSource removeMediaSource(int i) {
        MediaSource mediaSource;
        mediaSource = getMediaSource(i);
        h(i, i + 1, null, null);
        return mediaSource;
    }

    public synchronized void removeMediaSourceRange(int i, int i2) {
        h(i, i2, null, null);
    }

    public synchronized void setShuffleOrder(ShuffleOrder shuffleOrder) {
        j(shuffleOrder, null, null);
    }

    public ConcatenatingMediaSource(boolean z, MediaSource... mediaSourceArr) {
        this(z, new ShuffleOrder.DefaultShuffleOrder(0), mediaSourceArr);
    }

    @Nullable
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(e eVar, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i = 0; i < eVar.c.size(); i++) {
            if (eVar.c.get(i).windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return mediaPeriodId.copyWithPeriodUid(AbstractConcatenatedTimeline.getConcatenatedUid(eVar.b, mediaPeriodId.periodUid));
            }
        }
        return null;
    }

    public int getWindowIndexForChildWindowIndex(e eVar, int i) {
        return i + eVar.e;
    }

    public void onChildSourceInfoRefreshed(e eVar, MediaSource mediaSource, Timeline timeline) {
        int windowCount;
        if (eVar.d + 1 < this.m.size() && (windowCount = timeline.getWindowCount() - (this.m.get(eVar.d + 1).e - eVar.e)) != 0) {
            c(eVar.d + 1, 0, windowCount);
        }
        i(null);
    }

    public ConcatenatingMediaSource(boolean z, ShuffleOrder shuffleOrder, MediaSource... mediaSourceArr) {
        this(z, false, shuffleOrder, mediaSourceArr);
    }

    public synchronized void addMediaSource(MediaSource mediaSource, Handler handler, Runnable runnable) {
        addMediaSource(this.j.size(), mediaSource, handler, runnable);
    }

    public synchronized void clear(Handler handler, Runnable runnable) {
        removeMediaSourceRange(0, getSize(), handler, runnable);
    }

    public synchronized void moveMediaSource(int i, int i2, Handler handler, Runnable runnable) {
        g(i, i2, handler, runnable);
    }

    public synchronized void removeMediaSourceRange(int i, int i2, Handler handler, Runnable runnable) {
        h(i, i2, handler, runnable);
    }

    public synchronized void setShuffleOrder(ShuffleOrder shuffleOrder, Handler handler, Runnable runnable) {
        j(shuffleOrder, handler, runnable);
    }

    public ConcatenatingMediaSource(boolean z, boolean z2, ShuffleOrder shuffleOrder, MediaSource... mediaSourceArr) {
        for (MediaSource mediaSource : mediaSourceArr) {
            Assertions.checkNotNull(mediaSource);
        }
        this.u = shuffleOrder.getLength() > 0 ? shuffleOrder.cloneAndClear() : shuffleOrder;
        this.n = new IdentityHashMap<>();
        this.o = new HashMap();
        this.j = new ArrayList();
        this.m = new ArrayList();
        this.t = new HashSet();
        this.k = new HashSet();
        this.p = new HashSet();
        this.q = z;
        this.r = z2;
        addMediaSources(Arrays.asList(mediaSourceArr));
    }

    public synchronized MediaSource removeMediaSource(int i, Handler handler, Runnable runnable) {
        MediaSource mediaSource;
        mediaSource = getMediaSource(i);
        h(i, i + 1, handler, runnable);
        return mediaSource;
    }

    public synchronized void addMediaSource(int i, MediaSource mediaSource) {
        b(i, Collections.singletonList(mediaSource), null, null);
    }

    public synchronized void addMediaSources(Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        b(this.j.size(), collection, handler, runnable);
    }

    public synchronized void addMediaSources(int i, Collection<MediaSource> collection) {
        b(i, collection, null, null);
    }

    public synchronized void addMediaSource(int i, MediaSource mediaSource, Handler handler, Runnable runnable) {
        b(i, Collections.singletonList(mediaSource), handler, runnable);
    }

    public synchronized void addMediaSources(int i, Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        b(i, collection, handler, runnable);
    }
}
