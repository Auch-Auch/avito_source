package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;
public final class CachedRegionTracker implements Cache.Listener {
    public static final int CACHED_TO_END = -2;
    public static final int NOT_CACHED = -1;
    public final Cache a;
    public final String b;
    public final ChunkIndex c;
    public final TreeSet<a> d = new TreeSet<>();
    public final a e = new a(0, 0);

    public static class a implements Comparable<a> {
        public long a;
        public long b;
        public int c;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(a aVar) {
            return Util.compareLong(this.a, aVar.a);
        }
    }

    public CachedRegionTracker(Cache cache, String str, ChunkIndex chunkIndex) {
        this.a = cache;
        this.b = str;
        this.c = chunkIndex;
        synchronized (this) {
            Iterator<CacheSpan> descendingIterator = cache.addListener(str, this).descendingIterator();
            while (descendingIterator.hasNext()) {
                a(descendingIterator.next());
            }
        }
    }

    public final void a(CacheSpan cacheSpan) {
        long j = cacheSpan.position;
        a aVar = new a(j, cacheSpan.length + j);
        a floor = this.d.floor(aVar);
        a ceiling = this.d.ceiling(aVar);
        boolean z = false;
        boolean z2 = floor != null && floor.b == aVar.a;
        if (ceiling != null && aVar.b == ceiling.a) {
            z = true;
        }
        if (z) {
            if (z2) {
                floor.b = ceiling.b;
                floor.c = ceiling.c;
            } else {
                aVar.b = ceiling.b;
                aVar.c = ceiling.c;
                this.d.add(aVar);
            }
            this.d.remove(ceiling);
        } else if (z2) {
            floor.b = aVar.b;
            int i = floor.c;
            while (true) {
                ChunkIndex chunkIndex = this.c;
                if (i >= chunkIndex.length - 1) {
                    break;
                }
                int i2 = i + 1;
                if (chunkIndex.offsets[i2] > floor.b) {
                    break;
                }
                i = i2;
            }
            floor.c = i;
        } else {
            int binarySearch = Arrays.binarySearch(this.c.offsets, aVar.b);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            aVar.c = binarySearch;
            this.d.add(aVar);
        }
    }

    public synchronized int getRegionEndTimeMs(long j) {
        a aVar = this.e;
        aVar.a = j;
        a floor = this.d.floor(aVar);
        if (floor != null) {
            long j2 = floor.b;
            if (j <= j2) {
                int i = floor.c;
                if (i != -1) {
                    ChunkIndex chunkIndex = this.c;
                    if (i == chunkIndex.length - 1) {
                        if (j2 == chunkIndex.offsets[i] + ((long) chunkIndex.sizes[i])) {
                            return -2;
                        }
                    }
                    long j3 = chunkIndex.durationsUs[i];
                    return (int) ((chunkIndex.timesUs[i] + (((j2 - chunkIndex.offsets[i]) * j3) / ((long) chunkIndex.sizes[i]))) / 1000);
                }
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        a(cacheSpan);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        long j = cacheSpan.position;
        a aVar = new a(j, cacheSpan.length + j);
        a floor = this.d.floor(aVar);
        if (floor == null) {
            Log.e("CachedRegionTracker", "Removed a span we were not aware of");
            return;
        }
        this.d.remove(floor);
        long j2 = floor.a;
        long j3 = aVar.a;
        if (j2 < j3) {
            a aVar2 = new a(j2, j3);
            int binarySearch = Arrays.binarySearch(this.c.offsets, aVar2.b);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            aVar2.c = binarySearch;
            this.d.add(aVar2);
        }
        long j4 = floor.b;
        long j5 = aVar.b;
        if (j4 > j5) {
            a aVar3 = new a(j5 + 1, j4);
            aVar3.c = floor.c;
            this.d.add(aVar3);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }

    public void release() {
        this.a.removeListener(this.b, this);
    }
}
