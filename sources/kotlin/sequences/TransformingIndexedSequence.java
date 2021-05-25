package kotlin.sequences;

import com.avito.android.remote.auth.AuthSource;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B/\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R(\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlin/sequences/TransformingIndexedSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/Function2;", "", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function2;", "transformer", AuthSource.SEND_ABUSE, "Lkotlin/sequences/Sequence;", "sequence", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class TransformingIndexedSequence<T, R> implements Sequence<R> {
    public final Sequence<T> a;
    public final Function2<Integer, T, R> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super T, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public TransformingIndexedSequence(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(function2, "transformer");
        this.a = sequence;
        this.b = function2;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<R> iterator() {
        return new Object(this) { // from class: kotlin.sequences.TransformingIndexedSequence$iterator$1
            @NotNull
            public final Iterator<T> a;
            public int b;
            public final /* synthetic */ TransformingIndexedSequence c;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.c = r1;
                this.a = TransformingIndexedSequence.access$getSequence$p(r1).iterator();
            }

            public final int getIndex() {
                return this.b;
            }

            @NotNull
            public final Iterator<T> getIterator() {
                return this.a;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public R next() {
                Function2 access$getTransformer$p = TransformingIndexedSequence.access$getTransformer$p(this.c);
                int i = this.b;
                this.b = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                return (R) access$getTransformer$p.invoke(Integer.valueOf(i), this.a.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            public final void setIndex(int i) {
                this.b = i;
            }
        };
    }
}
