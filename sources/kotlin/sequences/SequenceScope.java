package kotlin.sequences;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H¦@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ!\u0010\t\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\rJ!\u0010\t\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlin/sequences/SequenceScope;", "T", "", "value", "", "yield", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "iterator", "yieldAll", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", MessengerShareContentUtility.ELEMENTS, "(Ljava/lang/Iterable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/sequences/Sequence;", "sequence", "(Lkotlin/sequences/Sequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@RestrictsSuspension
public abstract class SequenceScope<T> {
    @Nullable
    public abstract Object yield(T t, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    public final Object yieldAll(@NotNull Iterable<? extends T> iterable, @NotNull Continuation<? super Unit> continuation) {
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return Unit.INSTANCE;
        }
        Object yieldAll = yieldAll(iterable.iterator(), continuation);
        return yieldAll == a.getCOROUTINE_SUSPENDED() ? yieldAll : Unit.INSTANCE;
    }

    @Nullable
    public abstract Object yieldAll(@NotNull Iterator<? extends T> it, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    public final Object yieldAll(@NotNull Sequence<? extends T> sequence, @NotNull Continuation<? super Unit> continuation) {
        Object yieldAll = yieldAll(sequence.iterator(), continuation);
        return yieldAll == a.getCOROUTINE_SUSPENDED() ? yieldAll : Unit.INSTANCE;
    }
}
