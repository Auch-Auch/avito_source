package kotlinx.coroutines.internal;

import androidx.core.internal.view.SupportMenu;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.model.AdvertStatus;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\b\u0010\u0018\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0006\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\u0005J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R\u0016\u0010\u0011\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/Segment;", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "", "tryIncPointers$kotlinx_coroutines_core", "()Z", "tryIncPointers", "decPointers$kotlinx_coroutines_core", "decPointers", "", "onSlotCleaned", "()V", "getRemoved", AdvertStatus.REMOVED, "", "getMaxSlots", "()I", "maxSlots", "", "c", "J", "getId", "()J", "id", "prev", "pointers", "<init>", "(JLkotlinx/coroutines/internal/Segment;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public abstract class Segment<S extends Segment<S>> extends ConcurrentLinkedListNode<S> {
    public static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers");
    public final long c;
    private volatile int cleanedAndPointers;

    public Segment(long j, @Nullable S s, int i) {
        super(s);
        this.c = j;
        this.cleanedAndPointers = i << 16;
    }

    public final boolean decPointers$kotlinx_coroutines_core() {
        return d.addAndGet(this, SupportMenu.CATEGORY_MASK) == getMaxSlots() && !isTail();
    }

    public final long getId() {
        return this.c;
    }

    public abstract int getMaxSlots();

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public boolean getRemoved() {
        return this.cleanedAndPointers == getMaxSlots() && !isTail();
    }

    public final void onSlotCleaned() {
        if (d.incrementAndGet(this) == getMaxSlots() && !isTail()) {
            remove();
        }
    }

    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        int i;
        do {
            i = this.cleanedAndPointers;
            if (!(i != getMaxSlots() || isTail())) {
                return false;
            }
        } while (!d.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
