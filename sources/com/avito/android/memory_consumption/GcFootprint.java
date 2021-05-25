package com.avito.android.memory_consumption;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JV\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010\u0004¨\u0006/"}, d2 = {"Lcom/avito/android/memory_consumption/GcFootprint;", "", "", "component1", "()J", "component2", "component3", "component4", "component5", "component6", "component7", "gcCount", "gcTime", "blockingGcCount", "blockingGcTime", "allocatedSize", "freedSize", "timestamp", "copy", "(JJJJJJJ)Lcom/avito/android/memory_consumption/GcFootprint;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "J", "getBlockingGcTime", "c", "getBlockingGcCount", "e", "getAllocatedSize", "f", "getFreedSize", g.a, "getTimestamp", AuthSource.SEND_ABUSE, "getGcCount", AuthSource.BOOKING_ORDER, "getGcTime", "<init>", "(JJJJJJJ)V", "memory-consumption_release"}, k = 1, mv = {1, 4, 2})
public final class GcFootprint {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;

    public GcFootprint(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
        this.g = j7;
    }

    public static /* synthetic */ GcFootprint copy$default(GcFootprint gcFootprint, long j, long j2, long j3, long j4, long j5, long j6, long j7, int i, Object obj) {
        return gcFootprint.copy((i & 1) != 0 ? gcFootprint.a : j, (i & 2) != 0 ? gcFootprint.b : j2, (i & 4) != 0 ? gcFootprint.c : j3, (i & 8) != 0 ? gcFootprint.d : j4, (i & 16) != 0 ? gcFootprint.e : j5, (i & 32) != 0 ? gcFootprint.f : j6, (i & 64) != 0 ? gcFootprint.g : j7);
    }

    public final long component1() {
        return this.a;
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

    @NotNull
    public final GcFootprint copy(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        return new GcFootprint(j, j2, j3, j4, j5, j6, j7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GcFootprint)) {
            return false;
        }
        GcFootprint gcFootprint = (GcFootprint) obj;
        return this.a == gcFootprint.a && this.b == gcFootprint.b && this.c == gcFootprint.c && this.d == gcFootprint.d && this.e == gcFootprint.e && this.f == gcFootprint.f && this.g == gcFootprint.g;
    }

    public final long getAllocatedSize() {
        return this.e;
    }

    public final long getBlockingGcCount() {
        return this.c;
    }

    public final long getBlockingGcTime() {
        return this.d;
    }

    public final long getFreedSize() {
        return this.f;
    }

    public final long getGcCount() {
        return this.a;
    }

    public final long getGcTime() {
        return this.b;
    }

    public final long getTimestamp() {
        return this.g;
    }

    public int hashCode() {
        return (((((((((((c.a(this.a) * 31) + c.a(this.b)) * 31) + c.a(this.c)) * 31) + c.a(this.d)) * 31) + c.a(this.e)) * 31) + c.a(this.f)) * 31) + c.a(this.g);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("GcFootprint(gcCount=");
        L.append(this.a);
        L.append(", gcTime=");
        L.append(this.b);
        L.append(", blockingGcCount=");
        L.append(this.c);
        L.append(", blockingGcTime=");
        L.append(this.d);
        L.append(", allocatedSize=");
        L.append(this.e);
        L.append(", freedSize=");
        L.append(this.f);
        L.append(", timestamp=");
        return a.l(L, this.g, ")");
    }
}
