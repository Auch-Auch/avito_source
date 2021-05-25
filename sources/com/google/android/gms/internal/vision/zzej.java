package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzej<E> extends zzeb<E> implements Set<E> {
    @NullableDecl
    private transient zzee<E> zznf;

    public static int zzy(int i) {
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
        zzde.checkArgument(z, "collection too large");
        return 1073741824;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzej) || !zzcz() || !((zzej) obj).zzcz() || hashCode() == obj.hashCode()) {
            return zzey.zza(this, obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        return zzey.zza(this);
    }

    @Override // com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public zzee<E> zzct() {
        zzee<E> zzee = this.zznf;
        if (zzee != null) {
            return zzee;
        }
        zzee<E> zzda = zzda();
        this.zznf = zzda;
        return zzda;
    }

    public boolean zzcz() {
        return false;
    }

    public zzee<E> zzda() {
        return zzee.zza(toArray());
    }
}
