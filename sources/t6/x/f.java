package t6.x;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
public class f extends SequencesKt__SequencesKt {

    public static final class a extends Lambda implements Function1<Object, Boolean> {
        public final /* synthetic */ Class a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Class cls) {
            super(1);
            this.a = cls;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    @NotNull
    public static final <R> Sequence<R> filterIsInstance(@NotNull Sequence<?> sequence, @NotNull Class<R> cls) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterIsInstance");
        Intrinsics.checkNotNullParameter(cls, "klass");
        Sequence<R> filter = SequencesKt___SequencesKt.filter(sequence, new a(cls));
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        return filter;
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(@NotNull Sequence<?> sequence, @NotNull C c, @NotNull Class<R> cls) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterIsInstanceTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(cls, "klass");
        for (Object obj : sequence) {
            if (cls.isInstance(obj)) {
                c.add(obj);
            }
        }
        return c;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toSortedSet");
        return (SortedSet) SequencesKt___SequencesKt.toCollection(sequence, new TreeSet());
    }

    @NotNull
    public static final <T> SortedSet<T> toSortedSet(@NotNull Sequence<? extends T> sequence, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toSortedSet");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) SequencesKt___SequencesKt.toCollection(sequence, new TreeSet(comparator));
    }
}
