package com.avito.android.memory_consumption;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/memory_consumption/GcUsageCollector;", "", "Lcom/avito/android/memory_consumption/GcFootprint;", "lastFootprint", "", "reportStart", "(Lcom/avito/android/memory_consumption/GcFootprint;)V", "reportStop", "restart", "()V", "Lcom/avito/android/memory_consumption/GcAccumulator;", "getTotalGcUsage", "()Lcom/avito/android/memory_consumption/GcAccumulator;", "totalGcUsage", "", "isMeasured", "()Z", "Impl", "memory-consumption_release"}, k = 1, mv = {1, 4, 2})
public interface GcUsageCollector {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0016@RX\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/memory_consumption/GcUsageCollector$Impl;", "Lcom/avito/android/memory_consumption/GcUsageCollector;", "Lcom/avito/android/memory_consumption/GcFootprint;", "lastFootprint", "", "reportStart", "(Lcom/avito/android/memory_consumption/GcFootprint;)V", "reportStop", "restart", "()V", "", "isMeasured", "()Z", "Lcom/avito/android/memory_consumption/GcAccumulator;", "<set-?>", AuthSource.SEND_ABUSE, "Lcom/avito/android/memory_consumption/GcAccumulator;", "getTotalGcUsage", "()Lcom/avito/android/memory_consumption/GcAccumulator;", "totalGcUsage", AuthSource.BOOKING_ORDER, "Lcom/avito/android/memory_consumption/GcFootprint;", "startFootprint", "<init>", "memory-consumption_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements GcUsageCollector {
        @NotNull
        public GcAccumulator a = new GcAccumulator();
        public GcFootprint b;

        @Override // com.avito.android.memory_consumption.GcUsageCollector
        @NotNull
        public GcAccumulator getTotalGcUsage() {
            return this.a;
        }

        @Override // com.avito.android.memory_consumption.GcUsageCollector
        public boolean isMeasured() {
            return this.b == null;
        }

        @Override // com.avito.android.memory_consumption.GcUsageCollector
        public void reportStart(@NotNull GcFootprint gcFootprint) {
            Intrinsics.checkNotNullParameter(gcFootprint, "lastFootprint");
            if (this.b == null) {
                this.b = gcFootprint;
                return;
            }
            throw new IllegalArgumentException("Should not be present during this call!".toString());
        }

        @Override // com.avito.android.memory_consumption.GcUsageCollector
        public void reportStop(@NotNull GcFootprint gcFootprint) {
            Intrinsics.checkNotNullParameter(gcFootprint, "lastFootprint");
            GcFootprint gcFootprint2 = this.b;
            if (!(gcFootprint2 != null)) {
                throw new IllegalArgumentException("Should be present during this call!".toString());
            } else if (gcFootprint2 != null) {
                getTotalGcUsage().addDiff(gcFootprint2, gcFootprint);
                this.b = null;
            }
        }

        @Override // com.avito.android.memory_consumption.GcUsageCollector
        public void restart() {
            this.a = new GcAccumulator();
            this.b = null;
        }
    }

    @NotNull
    GcAccumulator getTotalGcUsage();

    boolean isMeasured();

    void reportStart(@NotNull GcFootprint gcFootprint);

    void reportStop(@NotNull GcFootprint gcFootprint);

    void restart();
}
