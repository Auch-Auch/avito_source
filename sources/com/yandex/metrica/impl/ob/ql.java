package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.Nullable;
public class ql {
    public final long a;
    public final float b;
    public final int c;
    public final int d;
    public final long e;
    public final int f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public final boolean j;
    @Nullable
    public final pt k;
    @Nullable
    public final pt l;
    @Nullable
    public final pt m;
    @Nullable
    public final pt n;
    @Nullable
    public final py o;

    public ql(long j2, float f2, int i2, int i3, long j3, int i4, boolean z, long j4, boolean z2, boolean z3, @Nullable pt ptVar, @Nullable pt ptVar2, @Nullable pt ptVar3, @Nullable pt ptVar4, @Nullable py pyVar) {
        this.a = j2;
        this.b = f2;
        this.c = i2;
        this.d = i3;
        this.e = j3;
        this.f = i4;
        this.g = z;
        this.h = j4;
        this.i = z2;
        this.j = z3;
        this.k = ptVar;
        this.l = ptVar2;
        this.m = ptVar3;
        this.n = ptVar4;
        this.o = pyVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ql qlVar = (ql) obj;
        if (this.a != qlVar.a || Float.compare(qlVar.b, this.b) != 0 || this.c != qlVar.c || this.d != qlVar.d || this.e != qlVar.e || this.f != qlVar.f || this.g != qlVar.g || this.h != qlVar.h || this.i != qlVar.i || this.j != qlVar.j) {
            return false;
        }
        pt ptVar = this.k;
        if (ptVar == null ? qlVar.k != null : !ptVar.equals(qlVar.k)) {
            return false;
        }
        pt ptVar2 = this.l;
        if (ptVar2 == null ? qlVar.l != null : !ptVar2.equals(qlVar.l)) {
            return false;
        }
        pt ptVar3 = this.m;
        if (ptVar3 == null ? qlVar.m != null : !ptVar3.equals(qlVar.m)) {
            return false;
        }
        pt ptVar4 = this.n;
        if (ptVar4 == null ? qlVar.n != null : !ptVar4.equals(qlVar.n)) {
            return false;
        }
        py pyVar = this.o;
        py pyVar2 = qlVar.o;
        if (pyVar != null) {
            return pyVar.equals(pyVar2);
        }
        if (pyVar2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.a;
        int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        float f2 = this.b;
        int i3 = 0;
        int floatToIntBits = f2 != 0.0f ? Float.floatToIntBits(f2) : 0;
        long j3 = this.e;
        long j4 = this.h;
        int i4 = (((((((((((((((((i2 + floatToIntBits) * 31) + this.c) * 31) + this.d) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.f) * 31) + (this.g ? 1 : 0)) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.i ? 1 : 0)) * 31) + (this.j ? 1 : 0)) * 31;
        pt ptVar = this.k;
        int hashCode = (i4 + (ptVar != null ? ptVar.hashCode() : 0)) * 31;
        pt ptVar2 = this.l;
        int hashCode2 = (hashCode + (ptVar2 != null ? ptVar2.hashCode() : 0)) * 31;
        pt ptVar3 = this.m;
        int hashCode3 = (hashCode2 + (ptVar3 != null ? ptVar3.hashCode() : 0)) * 31;
        pt ptVar4 = this.n;
        int hashCode4 = (hashCode3 + (ptVar4 != null ? ptVar4.hashCode() : 0)) * 31;
        py pyVar = this.o;
        if (pyVar != null) {
            i3 = pyVar.hashCode();
        }
        return hashCode4 + i3;
    }

    public String toString() {
        StringBuilder L = a.L("Arguments{updateTimeInterval=");
        L.append(this.a);
        L.append(", updateDistanceInterval=");
        L.append(this.b);
        L.append(", recordsCountToForceFlush=");
        L.append(this.c);
        L.append(", maxBatchSize=");
        L.append(this.d);
        L.append(", maxAgeToForceFlush=");
        L.append(this.e);
        L.append(", maxRecordsToStoreLocally=");
        L.append(this.f);
        L.append(", collectionEnabled=");
        L.append(this.g);
        L.append(", lbsUpdateTimeInterval=");
        L.append(this.h);
        L.append(", lbsCollectionEnabled=");
        L.append(this.i);
        L.append(", passiveCollectionEnabled=");
        L.append(this.j);
        L.append(", wifiAccessConfig=");
        L.append(this.k);
        L.append(", lbsAccessConfig=");
        L.append(this.l);
        L.append(", gpsAccessConfig=");
        L.append(this.m);
        L.append(", passiveAccessConfig=");
        L.append(this.n);
        L.append(", gplConfig=");
        L.append(this.o);
        L.append('}');
        return L.toString();
    }
}
