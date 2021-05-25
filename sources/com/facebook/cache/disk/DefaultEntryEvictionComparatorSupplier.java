package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage;
public class DefaultEntryEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {

    public class a implements EntryEvictionComparator {
        public a(DefaultEntryEvictionComparatorSupplier defaultEntryEvictionComparatorSupplier) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(DiskStorage.Entry entry, DiskStorage.Entry entry2) {
            long timestamp = entry.getTimestamp();
            long timestamp2 = entry2.getTimestamp();
            if (timestamp < timestamp2) {
                return -1;
            }
            return timestamp2 == timestamp ? 0 : 1;
        }
    }

    @Override // com.facebook.cache.disk.EntryEvictionComparatorSupplier
    public EntryEvictionComparator get() {
        return new a(this);
    }
}
