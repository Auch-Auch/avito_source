package com.avito.android.memory_consumption;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004Jt\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010%\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010%\u001a\u0004\b.\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b0\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010%\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010%\u001a\u0004\b4\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010%\u001a\u0004\b6\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010%\u001a\u0004\b8\u0010\u0004¨\u0006;"}, d2 = {"Lcom/avito/android/memory_consumption/MemoryMetrics;", "", "", "component1", "()J", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "nativeHeapSize", "javaHeapSize", "totalPrivateSize", "gcCount", "gcTime", "blockingGcCount", "blockingGcTime", "allocatedSize", "freedSize", "timeRange", "copy", "(JJJJJJJJJJ)Lcom/avito/android/memory_consumption/MemoryMetrics;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "J", "getJavaHeapSize", "h", "getAllocatedSize", "d", "getGcCount", "j", "getTimeRange", "i", "getFreedSize", "e", "getGcTime", "c", "getTotalPrivateSize", AuthSource.SEND_ABUSE, "getNativeHeapSize", g.a, "getBlockingGcTime", "f", "getBlockingGcCount", "<init>", "(JJJJJJJJJJ)V", "memory-consumption_release"}, k = 1, mv = {1, 4, 2})
public final class MemoryMetrics {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;

    public MemoryMetrics(long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11) {
        this.a = j2;
        this.b = j3;
        this.c = j4;
        this.d = j5;
        this.e = j6;
        this.f = j7;
        this.g = j8;
        this.h = j9;
        this.i = j10;
        this.j = j11;
    }

    public static /* synthetic */ MemoryMetrics copy$default(MemoryMetrics memoryMetrics, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, int i2, Object obj) {
        return memoryMetrics.copy((i2 & 1) != 0 ? memoryMetrics.a : j2, (i2 & 2) != 0 ? memoryMetrics.b : j3, (i2 & 4) != 0 ? memoryMetrics.c : j4, (i2 & 8) != 0 ? memoryMetrics.d : j5, (i2 & 16) != 0 ? memoryMetrics.e : j6, (i2 & 32) != 0 ? memoryMetrics.f : j7, (i2 & 64) != 0 ? memoryMetrics.g : j8, (i2 & 128) != 0 ? memoryMetrics.h : j9, (i2 & 256) != 0 ? memoryMetrics.i : j10, (i2 & 512) != 0 ? memoryMetrics.j : j11);
    }

    public final long component1() {
        return this.a;
    }

    public final long component10() {
        return this.j;
    }

    public final long component2() {
        return this.b;
    }

    public final long component3() {
        return this.c;
    }

    public final long component4() {
        return this.d;
    }

    public final long component5() {
        return this.e;
    }

    public final long component6() {
        return this.f;
    }

    public final long component7() {
        return this.g;
    }

    public final long component8() {
        return this.h;
    }

    public final long component9() {
        return this.i;
    }

    @NotNull
    public final MemoryMetrics copy(long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11) {
        return new MemoryMetrics(j2, j3, j4, j5, j6, j7, j8, j9, j10, j11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemoryMetrics)) {
            return false;
        }
        MemoryMetrics memoryMetrics = (MemoryMetrics) obj;
        return this.a == memoryMetrics.a && this.b == memoryMetrics.b && this.c == memoryMetrics.c && this.d == memoryMetrics.d && this.e == memoryMetrics.e && this.f == memoryMetrics.f && this.g == memoryMetrics.g && this.h == memoryMetrics.h && this.i == memoryMetrics.i && this.j == memoryMetrics.j;
    }

    public final long getAllocatedSize() {
        return this.h;
    }

    public final long getBlockingGcCount() {
        return this.f;
    }

    public final long getBlockingGcTime() {
        return this.g;
    }

    public final long getFreedSize() {
        return this.i;
    }

    public final long getGcCount() {
        return this.d;
    }

    public final long getGcTime() {
        return this.e;
    }

    public final long getJavaHeapSize() {
        return this.b;
    }

    public final long getNativeHeapSize() {
        return this.a;
    }

    public final long getTimeRange() {
        return this.j;
    }

    public final long getTotalPrivateSize() {
        return this.c;
    }

    public int hashCode() {
        return (((((((((((((((((c.a(this.a) * 31) + c.a(this.b)) * 31) + c.a(this.c)) * 31) + c.a(this.d)) * 31) + c.a(this.e)) * 31) + c.a(this.f)) * 31) + c.a(this.g)) * 31) + c.a(this.h)) * 31) + c.a(this.i)) * 31) + c.a(this.j);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MemoryMetrics(nativeHeapSize=");
        L.append(this.a);
        L.append(", javaHeapSize=");
        L.append(this.b);
        L.append(", totalPrivateSize=");
        L.append(this.c);
        L.append(", gcCount=");
        L.append(this.d);
        L.append(", gcTime=");
        L.append(this.e);
        L.append(", blockingGcCount=");
        L.append(this.f);
        L.append(", blockingGcTime=");
        L.append(this.g);
        L.append(", allocatedSize=");
        L.append(this.h);
        L.append(", freedSize=");
        L.append(this.i);
        L.append(", timeRange=");
        return a.l(L, this.j, ")");
    }
}
