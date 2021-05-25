package com.google.common.base;

import a2.j.d.a.b;
import a2.j.d.a.k;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(serializable = true)
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public static class a implements Iterable<T> {
        public final /* synthetic */ Iterable a;

        /* renamed from: com.google.common.base.Optional$a$a  reason: collision with other inner class name */
        public class C0276a extends b<T> {
            public final Iterator<? extends Optional<? extends T>> c;

            public C0276a() {
                this.c = (Iterator) Preconditions.checkNotNull(a.this.a.iterator());
            }

            @Override // a2.j.d.a.b
            public T a() {
                while (this.c.hasNext()) {
                    Optional optional = (Optional) this.c.next();
                    if (optional.isPresent()) {
                        return (T) optional.get();
                    }
                }
                this.a = b.a.DONE;
                return null;
            }
        }

        public a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C0276a();
        }
    }

    public static <T> Optional<T> absent() {
        return a2.j.d.a.a.a;
    }

    public static <T> Optional<T> fromNullable(@NullableDecl T t) {
        return t == null ? absent() : new k(t);
    }

    public static <T> Optional<T> of(T t) {
        return new k(Preconditions.checkNotNull(t));
    }

    @Beta
    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new a(iterable);
    }

    public abstract Set<T> asSet();

    @Override // java.lang.Object
    public abstract boolean equals(@NullableDecl Object obj);

    public abstract T get();

    @Override // java.lang.Object
    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    @Beta
    public abstract T or(Supplier<? extends T> supplier);

    public abstract T or(T t);

    @NullableDecl
    public abstract T orNull();

    @Override // java.lang.Object
    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);
}
