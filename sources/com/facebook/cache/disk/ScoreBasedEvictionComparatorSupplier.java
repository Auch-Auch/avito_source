package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.internal.VisibleForTesting;
public class ScoreBasedEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
    public final float a;
    public final float b;

    public class a implements EntryEvictionComparator {
        public long a = System.currentTimeMillis();

        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(DiskStorage.Entry entry, DiskStorage.Entry entry2) {
            float a3 = ScoreBasedEvictionComparatorSupplier.this.a(entry, this.a);
            float a4 = ScoreBasedEvictionComparatorSupplier.this.a(entry2, this.a);
            if (a3 < a4) {
                return 1;
            }
            return a4 == a3 ? 0 : -1;
        }
    }

    public ScoreBasedEvictionComparatorSupplier(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    @VisibleForTesting
    public float a(DiskStorage.Entry entry, long j) {
        long timestamp = j - entry.getTimestamp();
        long size = entry.getSize();
        return (this.b * ((float) size)) + (this.a * ((float) timestamp));
    }

    @Override // com.facebook.cache.disk.EntryEvictionComparatorSupplier
    public EntryEvictionComparator get() {
        return new a();
    }
}
