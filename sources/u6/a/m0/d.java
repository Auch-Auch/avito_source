package u6.a.m0;

import a2.b.a.a.a;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class d extends Segment<d> {
    @NotNull
    public AtomicReferenceArray e = new AtomicReferenceArray(SemaphoreKt.f);

    public d(long j, @Nullable d dVar, int i) {
        super(j, dVar, i);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public int getMaxSlots() {
        return SemaphoreKt.f;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SemaphoreSegment[id=");
        L.append(getId());
        L.append(", hashCode=");
        L.append(hashCode());
        L.append(']');
        return L.toString();
    }
}
