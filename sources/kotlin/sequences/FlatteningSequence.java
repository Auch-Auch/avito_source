package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004BC\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00050\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R(\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00050\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlin/sequences/FlatteningSequence;", "T", "R", ExifInterface.LONGITUDE_EAST, "Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/Function1;", "c", "Lkotlin/jvm/functions/Function1;", AuthSource.BOOKING_ORDER, "transformer", AuthSource.SEND_ABUSE, "Lkotlin/sequences/Sequence;", "sequence", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class FlatteningSequence<T, R, E> implements Sequence<E> {
    public final Sequence<T> a;
    public final Function1<T, R> b;
    public final Function1<R, Iterator<E>> c;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends R> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super R, ? extends java.util.Iterator<? extends E>> */
    /* JADX WARN: Multi-variable type inference failed */
    public FlatteningSequence(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1, @NotNull Function1<? super R, ? extends Iterator<? extends E>> function12) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(function1, "transformer");
        Intrinsics.checkNotNullParameter(function12, "iterator");
        this.a = sequence;
        this.b = function1;
        this.c = function12;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<E> iterator() {
        return new Object(this) { // from class: kotlin.sequences.FlatteningSequence$iterator$1
            @NotNull
            public final Iterator<T> a;
            @Nullable
            public Iterator<? extends E> b;
            public final /* synthetic */ FlatteningSequence c;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.c = r1;
                this.a = r1.a.iterator();
            }

            public final boolean a() {
                Iterator<? extends E> it = this.b;
                if (it != null && !it.hasNext()) {
                    this.b = null;
                }
                while (true) {
                    if (this.b == null) {
                        if (this.a.hasNext()) {
                            Iterator<? extends E> it2 = (Iterator) this.c.c.invoke(this.c.b.invoke(this.a.next()));
                            if (it2.hasNext()) {
                                this.b = it2;
                                break;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        break;
                    }
                }
                return true;
            }

            /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Iterator<? extends E>, java.util.Iterator<E> */
            @Nullable
            public final Iterator<E> getItemIterator() {
                return (Iterator<? extends E>) this.b;
            }

            @NotNull
            public final Iterator<T> getIterator() {
                return this.a;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return a();
            }

            @Override // java.util.Iterator
            public E next() {
                if (a()) {
                    Iterator<? extends E> it = this.b;
                    Intrinsics.checkNotNull(it);
                    return (E) it.next();
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            public final void setItemIterator(@Nullable Iterator<? extends E> it) {
                this.b = it;
            }
        };
    }
}
