package kotlin.sequences;

import com.avito.android.remote.auth.AuthSource;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B3\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", AuthSource.SEND_ABUSE, "Lkotlin/sequences/Sequence;", "sequence", "", AuthSource.BOOKING_ORDER, "Z", "sendWhen", "Lkotlin/Function1;", "c", "Lkotlin/jvm/functions/Function1;", "predicate", "<init>", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class FilteringSequence<T> implements Sequence<T> {
    public final Sequence<T> a;
    public final boolean b;
    public final Function1<T, Boolean> c;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public FilteringSequence(@NotNull Sequence<? extends T> sequence, boolean z, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        this.a = sequence;
        this.b = z;
        this.c = function1;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new Object(this) { // from class: kotlin.sequences.FilteringSequence$iterator$1
            @NotNull
            public final Iterator<T> a;
            public int b = -1;
            @Nullable
            public T c;
            public final /* synthetic */ FilteringSequence d;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.d = r1;
                this.a = FilteringSequence.access$getSequence$p(r1).iterator();
            }

            public final void a() {
                while (this.a.hasNext()) {
                    T next = this.a.next();
                    if (((Boolean) FilteringSequence.access$getPredicate$p(this.d).invoke(next)).booleanValue() == FilteringSequence.access$getSendWhen$p(this.d)) {
                        this.c = next;
                        this.b = 1;
                        return;
                    }
                }
                this.b = 0;
            }

            @NotNull
            public final Iterator<T> getIterator() {
                return this.a;
            }

            @Nullable
            public final T getNextItem() {
                return this.c;
            }

            public final int getNextState() {
                return this.b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.b == -1) {
                    a();
                }
                return this.b == 1;
            }

            @Override // java.util.Iterator
            public T next() {
                if (this.b == -1) {
                    a();
                }
                if (this.b != 0) {
                    T t = this.c;
                    this.c = null;
                    this.b = -1;
                    return t;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            public final void setNextItem(@Nullable T t) {
                this.c = t;
            }

            public final void setNextState(int i) {
                this.b = i;
            }
        };
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilteringSequence(Sequence sequence, boolean z, Function1 function1, int i, j jVar) {
        this(sequence, (i & 2) != 0 ? true : z, function1);
    }
}
