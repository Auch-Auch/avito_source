package kotlinx.coroutines.internal;

import com.avito.android.analytics.screens.PublicConstantsKt;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u000e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0019\u001a\u00020\u00188F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/internal/AtomicOp;", "T", "Lkotlinx/coroutines/internal/OpDescriptor;", "", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "affected", "prepare", PublicConstantsKt.FAILURE, "", Tracker.Events.CREATIVE_COMPLETE, "(Ljava/lang/Object;Ljava/lang/Object;)V", "perform", "", "getOpSequence", "()J", "opSequence", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "getConsensus", "()Ljava/lang/Object;", "consensus", "", "isDecided", "()Z", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public abstract class AtomicOp<T> extends OpDescriptor {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    private volatile Object _consensus = AtomicKt.NO_DECISION;

    public abstract void complete(T t, @Nullable Object obj);

    @Nullable
    public final Object decide(@Nullable Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = AtomicKt.NO_DECISION;
        if (obj2 != obj3) {
            return obj2;
        }
        if (a.compareAndSet(this, obj3, obj)) {
            return obj;
        }
        return this._consensus;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlinx.coroutines.internal.AtomicOp<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    @NotNull
    public AtomicOp<?> getAtomicOp() {
        return this;
    }

    @Nullable
    public final Object getConsensus() {
        return this._consensus;
    }

    public long getOpSequence() {
        return 0;
    }

    public final boolean isDecided() {
        return this._consensus != AtomicKt.NO_DECISION;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    @Nullable
    public final Object perform(@Nullable Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == AtomicKt.NO_DECISION) {
            obj2 = decide(prepare(obj));
        }
        complete(obj, obj2);
        return obj2;
    }

    @Nullable
    public abstract Object prepare(T t);
}
