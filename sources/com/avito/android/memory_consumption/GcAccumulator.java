package com.avito.android.memory_consumption;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR$\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR$\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR$\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\rR$\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR$\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r¨\u0006#"}, d2 = {"Lcom/avito/android/memory_consumption/GcAccumulator;", "", "Lcom/avito/android/memory_consumption/GcFootprint;", "previous", "last", "", "addDiff", "(Lcom/avito/android/memory_consumption/GcFootprint;Lcom/avito/android/memory_consumption/GcFootprint;)V", "", "<set-?>", "e", "J", "getAllocatedSize", "()J", "allocatedSize", AuthSource.SEND_ABUSE, "getGcCount", "gcCount", AuthSource.BOOKING_ORDER, "getGcTime", "gcTime", "d", "getBlockingGcTime", "blockingGcTime", "c", "getBlockingGcCount", "blockingGcCount", g.a, "getTimeRange", "timeRange", "f", "getFreedSize", "freedSize", "<init>", "()V", "memory-consumption_release"}, k = 1, mv = {1, 4, 2})
public final class GcAccumulator {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;

    public final void addDiff(@NotNull GcFootprint gcFootprint, @NotNull GcFootprint gcFootprint2) {
        Intrinsics.checkNotNullParameter(gcFootprint, "previous");
        Intrinsics.checkNotNullParameter(gcFootprint2, "last");
        this.a = (gcFootprint2.getGcCount() - gcFootprint.getGcCount()) + this.a;
        this.b = (gcFootprint2.getGcTime() - gcFootprint.getGcTime()) + this.b;
        this.c = (gcFootprint2.getBlockingGcCount() - gcFootprint.getBlockingGcCount()) + this.c;
        this.d = (gcFootprint2.getBlockingGcTime() - gcFootprint.getBlockingGcTime()) + this.d;
        this.e = (gcFootprint2.getAllocatedSize() - gcFootprint.getAllocatedSize()) + this.e;
        this.f = (gcFootprint2.getFreedSize() - gcFootprint.getFreedSize()) + this.f;
        this.g = (gcFootprint2.getTimestamp() - gcFootprint.getTimestamp()) + this.g;
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

    public final long getTimeRange() {
        return this.g;
    }
}
