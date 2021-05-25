package kotlin.sequences;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0016"}, d2 = {"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "", "n", "drop", "(I)Lkotlin/sequences/Sequence;", "take", "", "iterator", "()Ljava/util/Iterator;", AuthSource.SEND_ABUSE, "Lkotlin/sequences/Sequence;", "sequence", AuthSource.BOOKING_ORDER, "I", "startIndex", "c", "endIndex", "<init>", "(Lkotlin/sequences/Sequence;II)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    public final Sequence<T> a;
    public final int b;
    public final int c;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public SubSequence(@NotNull Sequence<? extends T> sequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.a = sequence;
        this.b = i;
        this.c = i2;
        boolean z = true;
        if (i >= 0) {
            if (i2 >= 0) {
                if (!(i2 < i ? false : z)) {
                    throw new IllegalArgumentException(a.R2("endIndex should be not less than startIndex, but was ", i2, " < ", i).toString());
                }
                return;
            }
            throw new IllegalArgumentException(a.M2("endIndex should be non-negative, but is ", i2).toString());
        }
        throw new IllegalArgumentException(a.M2("startIndex should be non-negative, but is ", i).toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> drop(int i) {
        int i2 = this.c;
        int i3 = this.b;
        return i >= i2 - i3 ? SequencesKt__SequencesKt.emptySequence() : new SubSequence(this.a, i3 + i, i2);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new Object(this) { // from class: kotlin.sequences.SubSequence$iterator$1
            @NotNull
            public final Iterator<T> a;
            public int b;
            public final /* synthetic */ SubSequence c;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.c = r1;
                this.a = r1.a.iterator();
            }

            public final void a() {
                while (this.b < this.c.b && this.a.hasNext()) {
                    this.a.next();
                    this.b++;
                }
            }

            @NotNull
            public final Iterator<T> getIterator() {
                return this.a;
            }

            public final int getPosition() {
                return this.b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.b < this.c.c && this.a.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                a();
                if (this.b < this.c.c) {
                    this.b++;
                    return this.a.next();
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            public final void setPosition(int i) {
                this.b = i;
            }
        };
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> take(int i) {
        int i2 = this.c;
        int i3 = this.b;
        return i >= i2 - i3 ? this : new SubSequence(this.a, i3, i + i3);
    }
}
