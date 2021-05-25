package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B=\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R(\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0013"}, d2 = {"Lkotlin/sequences/MergingSequence;", "T1", "T2", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/Function2;", "c", "Lkotlin/jvm/functions/Function2;", "transform", AuthSource.BOOKING_ORDER, "Lkotlin/sequences/Sequence;", "sequence2", AuthSource.SEND_ABUSE, "sequence1", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class MergingSequence<T1, T2, V> implements Sequence<V> {
    public final Sequence<T1> a;
    public final Sequence<T2> b;
    public final Function2<T1, T2, V> c;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T1> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.sequences.Sequence<? extends T2> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super T1, ? super T2, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public MergingSequence(@NotNull Sequence<? extends T1> sequence, @NotNull Sequence<? extends T2> sequence2, @NotNull Function2<? super T1, ? super T2, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(sequence, "sequence1");
        Intrinsics.checkNotNullParameter(sequence2, "sequence2");
        Intrinsics.checkNotNullParameter(function2, "transform");
        this.a = sequence;
        this.b = sequence2;
        this.c = function2;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<V> iterator() {
        return new Object(this) { // from class: kotlin.sequences.MergingSequence$iterator$1
            @NotNull
            public final Iterator<T1> a;
            @NotNull
            public final Iterator<T2> b;
            public final /* synthetic */ MergingSequence c;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.c = r2;
                this.a = MergingSequence.access$getSequence1$p(r2).iterator();
                this.b = MergingSequence.access$getSequence2$p(r2).iterator();
            }

            @NotNull
            public final Iterator<T1> getIterator1() {
                return this.a;
            }

            @NotNull
            public final Iterator<T2> getIterator2() {
                return this.b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext() && this.b.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return (V) MergingSequence.access$getTransform$p(this.c).invoke(this.a.next(), this.b.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }
}
