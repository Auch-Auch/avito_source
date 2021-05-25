package kotlinx.coroutines.internal;

import com.avito.android.remote.model.AdvertStatus;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u0006\u001a\u0004\u0018\u00018\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\b¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0014\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0015\u0010\u0017\u001a\u0004\u0018\u00018\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0019\u001a\u0004\u0018\u00018\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "Lkotlin/Function0;", "", "onClosedAction", "nextOrIfClosed", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "value", "", "trySetNext", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "", "cleanPrev", "()V", "markAsClosed", "()Z", ProductAction.ACTION_REMOVE, "getRemoved", AdvertStatus.REMOVED, "isTail", "getNext", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "next", "getPrev", "prev", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev");
    private volatile Object _next = null;
    private volatile Object _prev;

    public ConcurrentLinkedListNode(@Nullable N n) {
        this._prev = n;
    }

    public static final Object access$getNextOrClosed$p(ConcurrentLinkedListNode concurrentLinkedListNode) {
        return concurrentLinkedListNode._next;
    }

    public final void cleanPrev() {
        b.lazySet(this, null);
    }

    @Nullable
    public final N getNext() {
        Object access$getNextOrClosed$p = access$getNextOrClosed$p(this);
        if (access$getNextOrClosed$p == ConcurrentLinkedListKt.access$getCLOSED$p()) {
            return null;
        }
        return (N) ((ConcurrentLinkedListNode) access$getNextOrClosed$p);
    }

    @Nullable
    public final N getPrev() {
        return (N) ((ConcurrentLinkedListNode) this._prev);
    }

    public abstract boolean getRemoved();

    public final boolean isTail() {
        return getNext() == null;
    }

    public final boolean markAsClosed() {
        return a.compareAndSet(this, null, ConcurrentLinkedListKt.access$getCLOSED$p());
    }

    @Nullable
    public final N nextOrIfClosed(@NotNull Function0 function0) {
        Object access$getNextOrClosed$p = access$getNextOrClosed$p(this);
        if (access$getNextOrClosed$p != ConcurrentLinkedListKt.access$getCLOSED$p()) {
            return (N) ((ConcurrentLinkedListNode) access$getNextOrClosed$p);
        }
        function0.invoke();
        throw new KotlinNothingValueException();
    }

    public final void remove() {
        while (true) {
            ConcurrentLinkedListNode prev = getPrev();
            while (prev != null && prev.getRemoved()) {
                prev = (ConcurrentLinkedListNode) prev._prev;
            }
            ConcurrentLinkedListNode next = getNext();
            Intrinsics.checkNotNull(next);
            while (next.getRemoved()) {
                next = next.getNext();
                Intrinsics.checkNotNull(next);
            }
            next._prev = prev;
            if (prev != null) {
                prev._next = next;
            }
            if (!next.getRemoved() && (prev == null || !prev.getRemoved())) {
                return;
            }
        }
    }

    public final boolean trySetNext(@NotNull N n) {
        return a.compareAndSet(this, null, n);
    }
}
