package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzey<E> extends zzer<E> implements Set<E> {
    @NullableDecl
    private transient zzeq<E> zza;

    public static int zza(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z = false;
        }
        zzdq.zza(z, "collection too large");
        return 1073741824;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzey) || !zza() || !((zzey) obj).zza() || hashCode() == obj.hashCode()) {
            return zzfv.zza(this, obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        return zzfv.zza(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzer, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public zzeq<E> zzc() {
        zzeq<E> zzeq = this.zza;
        if (zzeq != null) {
            return zzeq;
        }
        zzeq<E> zzd = zzd();
        this.zza = zzd;
        return zzd;
    }

    public zzeq<E> zzd() {
        return zzeq.zza(toArray());
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    public static <E> com.google.android.gms.internal.measurement.zzey<E> zza(java.util.Collection<? extends E> r14) {
        /*
            boolean r0 = r14 instanceof com.google.android.gms.internal.measurement.zzey
            if (r0 == 0) goto L_0x0012
            boolean r0 = r14 instanceof java.util.SortedSet
            if (r0 != 0) goto L_0x0012
            r0 = r14
            com.google.android.gms.internal.measurement.zzey r0 = (com.google.android.gms.internal.measurement.zzey) r0
            boolean r1 = r0.zzh()
            if (r1 != 0) goto L_0x0012
            return r0
        L_0x0012:
            java.lang.Object[] r14 = r14.toArray()
            int r0 = r14.length
        L_0x0017:
            if (r0 == 0) goto L_0x0087
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x007f
            int r3 = zza(r0)
            java.lang.Object[] r7 = new java.lang.Object[r3]
            int r8 = r3 + -1
            r4 = 0
            r6 = 0
            r9 = 0
        L_0x0028:
            if (r4 >= r0) goto L_0x0053
            r5 = r14[r4]
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzfl.zza(r5, r4)
            int r10 = r5.hashCode()
            int r11 = com.google.android.gms.internal.measurement.zzeo.zza(r10)
        L_0x0038:
            r12 = r11 & r8
            r13 = r7[r12]
            if (r13 != 0) goto L_0x0047
            int r11 = r9 + 1
            r14[r9] = r5
            r7[r12] = r5
            int r6 = r6 + r10
            r9 = r11
            goto L_0x0050
        L_0x0047:
            boolean r12 = r13.equals(r5)
            if (r12 != 0) goto L_0x0050
            int r11 = r11 + 1
            goto L_0x0038
        L_0x0050:
            int r4 = r4 + 1
            goto L_0x0028
        L_0x0053:
            r4 = 0
            java.util.Arrays.fill(r14, r9, r0, r4)
            if (r9 != r2) goto L_0x0061
            r14 = r14[r1]
            com.google.android.gms.internal.measurement.zzfu r0 = new com.google.android.gms.internal.measurement.zzfu
            r0.<init>(r14, r6)
            return r0
        L_0x0061:
            int r0 = zza(r9)
            int r3 = r3 / 2
            if (r0 >= r3) goto L_0x006b
            r0 = r9
            goto L_0x0017
        L_0x006b:
            int r0 = r14.length
            int r1 = r0 >> 1
            int r0 = r0 >> 2
            int r1 = r1 + r0
            if (r9 >= r1) goto L_0x0077
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r9)
        L_0x0077:
            r5 = r14
            com.google.android.gms.internal.measurement.zzft r14 = new com.google.android.gms.internal.measurement.zzft
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9)
            return r14
        L_0x007f:
            r14 = r14[r1]
            com.google.android.gms.internal.measurement.zzfu r0 = new com.google.android.gms.internal.measurement.zzfu
            r0.<init>(r14)
            return r0
        L_0x0087:
            com.google.android.gms.internal.measurement.zzft<java.lang.Object> r14 = com.google.android.gms.internal.measurement.zzft.zza
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzey.zza(java.util.Collection):com.google.android.gms.internal.measurement.zzey");
    }
}
