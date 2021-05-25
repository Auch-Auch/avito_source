package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class GeneratorSequence<T> implements Sequence<T> {
    public final Function0<T> a;
    public final Function1<T, T> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function0<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public GeneratorSequence(@NotNull Function0<? extends T> function0, @NotNull Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function0, "getInitialValue");
        Intrinsics.checkNotNullParameter(function1, "getNextValue");
        this.a = function0;
        this.b = function1;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new Object(this) { // from class: kotlin.sequences.GeneratorSequence$iterator$1
            @Nullable
            public T a;
            public int b = -2;
            public final /* synthetic */ GeneratorSequence c;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.c = r1;
            }

            public final void a() {
                T t;
                if (this.b == -2) {
                    t = this.c.a.invoke();
                } else {
                    Function1<T, T> function1 = this.c.b;
                    T t2 = this.a;
                    Intrinsics.checkNotNull(t2);
                    t = function1.invoke(t2);
                }
                this.a = t;
                this.b = t == null ? 0 : 1;
            }

            @Nullable
            public final T getNextItem() {
                return this.a;
            }

            public final int getNextState() {
                return this.b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.b < 0) {
                    a();
                }
                return this.b == 1;
            }

            @Override // java.util.Iterator
            @NotNull
            public T next() {
                if (this.b < 0) {
                    a();
                }
                if (this.b != 0) {
                    T t = this.a;
                    Objects.requireNonNull(t, "null cannot be cast to non-null type T");
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
                this.a = t;
            }

            public final void setNextState(int i) {
                this.b = i;
            }
        };
    }
}
