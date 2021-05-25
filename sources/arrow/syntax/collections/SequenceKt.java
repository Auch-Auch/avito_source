package arrow.syntax.collections;

import arrow.core.Option;
import arrow.core.OptionKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001aA\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007¢\u0006\u0004\b\u0003\u0010\t¨\u0006\n"}, d2 = {"T", "Lkotlin/sequences/Sequence;", "Larrow/core/Option;", "firstOption", "(Lkotlin/sequences/Sequence;)Larrow/core/Option;", "Lkotlin/Function1;", "", "Larrow/core/Predicate;", "predicate", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Larrow/core/Option;", "arrow-syntax"}, k = 2, mv = {1, 4, 0})
public final class SequenceKt {
    @NotNull
    public static final <T> Option<T> firstOption(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "$receiver");
        return OptionKt.toOption(SequencesKt___SequencesKt.firstOrNull(sequence));
    }

    @NotNull
    public static final <T> Option<T> firstOption(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(sequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Iterator<? extends T> it = sequence.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (function1.invoke(obj).booleanValue()) {
                break;
            }
        }
        return OptionKt.toOption(obj);
    }
}
