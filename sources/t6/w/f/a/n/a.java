package t6.w.f.a.n;

import java.util.Iterator;
import java.util.NoSuchElementException;
public final class a<E> implements Iterable<E> {
    public static final a<Object> d = new a<>();
    public final E a;
    public final a<E> b;
    public final int c;

    /* renamed from: t6.w.f.a.n.a$a  reason: collision with other inner class name */
    public static class C0686a<E> implements Iterator<E> {
        public a<E> a;

        public C0686a(a<E> aVar) {
            this.a = aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.c > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a<E> aVar = this.a;
            E e = aVar.a;
            this.a = aVar.b;
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public a() {
        this.c = 0;
        this.a = null;
        this.b = null;
    }

    public a<E> a(int i) {
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return b(c(i).a);
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException(a2.b.a.a.a.M2("Index: ", i));
        }
    }

    public final a<E> b(Object obj) {
        if (this.c == 0) {
            return this;
        }
        if (this.a.equals(obj)) {
            return this.b;
        }
        a<E> b2 = this.b.b(obj);
        if (b2 == this.b) {
            return this;
        }
        return new a<>(this.a, b2);
    }

    public final a<E> c(int i) {
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException();
        } else if (i == 0) {
            return this;
        } else {
            return this.b.c(i - 1);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new C0686a(c(0));
    }

    public a(E e, a<E> aVar) {
        this.a = e;
        this.b = aVar;
        this.c = aVar.c + 1;
    }
}
