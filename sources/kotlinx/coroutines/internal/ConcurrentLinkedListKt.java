package kotlinx.coroutines.internal;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a#\u0010\u0002\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001c\u0010\t\u001a\u00020\u00048\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "close", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/coroutines/internal/Symbol;", AuthSource.SEND_ABUSE, "Lkotlinx/coroutines/internal/Symbol;", "getCLOSED$annotations", "()V", "CLOSED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class ConcurrentLinkedListKt {
    public static final Symbol a = new Symbol("CLOSED");

    public static final Object access$findSegmentInternal(Segment segment, long j, Function2 function2) {
        while (true) {
            if (segment.getId() >= j && !segment.getRemoved()) {
                return SegmentOrClosed.m530constructorimpl(segment);
            }
            Object access$getNextOrClosed$p = ConcurrentLinkedListNode.access$getNextOrClosed$p(segment);
            if (access$getNextOrClosed$p == a) {
                return SegmentOrClosed.m530constructorimpl(a);
            }
            Segment segment2 = (Segment) ((ConcurrentLinkedListNode) access$getNextOrClosed$p);
            if (segment2 == null) {
                segment2 = (Segment) function2.invoke(Long.valueOf(segment.getId() + 1), segment);
                if (segment.trySetNext(segment2)) {
                    if (segment.getRemoved()) {
                        segment.remove();
                    }
                }
            }
            segment = segment2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <N extends kotlinx.coroutines.internal.ConcurrentLinkedListNode<N>> N close(@org.jetbrains.annotations.NotNull N r2) {
        /*
        L_0x0000:
            java.lang.Object r0 = kotlinx.coroutines.internal.ConcurrentLinkedListNode.access$getNextOrClosed$p(r2)
            kotlinx.coroutines.internal.Symbol r1 = access$getCLOSED$p()
            if (r0 != r1) goto L_0x000b
            return r2
        L_0x000b:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r0
            if (r0 != 0) goto L_0x0016
            boolean r0 = r2.markAsClosed()
            if (r0 == 0) goto L_0x0000
            return r2
        L_0x0016:
            r2 = r0
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ConcurrentLinkedListKt.close(kotlinx.coroutines.internal.ConcurrentLinkedListNode):kotlinx.coroutines.internal.ConcurrentLinkedListNode");
    }
}
