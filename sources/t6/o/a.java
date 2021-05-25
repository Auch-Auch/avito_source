package t6.o;

import java.util.Comparator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class a {

    /* renamed from: t6.o.a$a  reason: collision with other inner class name */
    public static final class C0680a<T> implements Comparator<T> {
        public final /* synthetic */ Function1[] a;

        public C0680a(Function1[] function1Arr) {
            this.a = function1Arr;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.a(t, t2, this.a);
        }
    }

    public static final class b<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;

        public b(Comparator comparator) {
            this.a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@Nullable T t, @Nullable T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return -1;
            }
            if (t2 == null) {
                return 1;
            }
            return this.a.compare(t, t2);
        }
    }

    public static final class c<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;

        public c(Comparator comparator) {
            this.a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@Nullable T t, @Nullable T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return 1;
            }
            if (t2 == null) {
                return -1;
            }
            return this.a.compare(t, t2);
        }
    }

    public static final class d<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;
        public final /* synthetic */ Comparator b;

        public d(Comparator comparator, Comparator comparator2) {
            this.a = comparator;
            this.b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.a.compare(t, t2);
            return compare != 0 ? compare : this.b.compare(t, t2);
        }
    }

    public static final class e<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;
        public final /* synthetic */ Comparator b;

        public e(Comparator comparator, Comparator comparator2) {
            this.a = comparator;
            this.b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.a.compare(t, t2);
            return compare != 0 ? compare : this.b.compare(t2, t);
        }
    }

    public static final <T> int a(T t, T t2, Function1<? super T, ? extends Comparable<?>>[] function1Arr) {
        for (Function1<? super T, ? extends Comparable<?>> function1 : function1Arr) {
            int compareValues = compareValues((Comparable) function1.invoke(t), (Comparable) function1.invoke(t2));
            if (compareValues != 0) {
                return compareValues;
            }
        }
        return 0;
    }

    @NotNull
    public static final <T> Comparator<T> compareBy(@NotNull Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.checkNotNullParameter(function1Arr, "selectors");
        if (function1Arr.length > 0) {
            return new C0680a(function1Arr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final <T extends Comparable<?>> int compareValues(@Nullable T t, @Nullable T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static final <T> int compareValuesBy(T t, T t2, @NotNull Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.checkNotNullParameter(function1Arr, "selectors");
        if (function1Arr.length > 0) {
            return a(t, t2, function1Arr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return d.a;
    }

    @NotNull
    public static final <T> Comparator<T> nullsFirst(@NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new b(comparator);
    }

    @NotNull
    public static final <T> Comparator<T> nullsLast(@NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new c(comparator);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        return e.a;
    }

    @NotNull
    public static final <T> Comparator<T> reversed(@NotNull Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "$this$reversed");
        if (comparator instanceof f) {
            return ((f) comparator).a;
        }
        Comparator<T> comparator2 = d.a;
        if (Intrinsics.areEqual(comparator, comparator2)) {
            return e.a;
        }
        if (!Intrinsics.areEqual(comparator, e.a)) {
            comparator2 = new f<>(comparator);
        }
        return comparator2;
    }

    @NotNull
    public static final <T> Comparator<T> then(@NotNull Comparator<T> comparator, @NotNull Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "$this$then");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new d(comparator, comparator2);
    }

    @NotNull
    public static final <T> Comparator<T> thenDescending(@NotNull Comparator<T> comparator, @NotNull Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "$this$thenDescending");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new e(comparator, comparator2);
    }
}
