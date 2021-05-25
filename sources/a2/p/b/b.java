package a2.p.b;

import com.squareup.tape2.ObjectQueue;
import com.squareup.tape2.QueueFile;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
public final class b<T> extends ObjectQueue<T> {
    public final Deque<T> a = new ArrayDeque();
    public int b = 0;
    public boolean c;

    public final class a implements Iterator<T> {
        public final Iterator<T> a;
        public int b = 0;
        public int c;

        public a(Iterator<T> it) {
            this.c = b.this.b;
            this.a = it;
        }

        public final void a() {
            if (b.this.b != this.c) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!b.this.c) {
                a();
                T next = this.a.next();
                this.b++;
                return next;
            }
            throw new IllegalStateException("closed");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!b.this.c) {
                a();
                if (b.this.size() == 0) {
                    throw new NoSuchElementException();
                } else if (this.b == 1) {
                    try {
                        b.this.remove();
                        this.c = b.this.b;
                        this.b--;
                    } catch (IOException e) {
                        throw new RuntimeException("todo: throw a proper error", e);
                    }
                } else {
                    throw new UnsupportedOperationException("Removal is only permitted from the head.");
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    @Override // com.squareup.tape2.ObjectQueue
    public void add(T t) throws IOException {
        if (!this.c) {
            this.b++;
            this.a.addLast(t);
            return;
        }
        throw new IOException("closed");
    }

    @Override // com.squareup.tape2.ObjectQueue
    public List<T> asList() throws IOException {
        return new ArrayList(this.a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c = true;
    }

    @Override // com.squareup.tape2.ObjectQueue
    public QueueFile file() {
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.a.iterator());
    }

    @Override // com.squareup.tape2.ObjectQueue
    public T peek() throws IOException {
        if (!this.c) {
            return this.a.peekFirst();
        }
        throw new IOException("closed");
    }

    @Override // com.squareup.tape2.ObjectQueue
    public void remove(int i) throws IOException {
        if (!this.c) {
            this.b++;
            for (int i2 = 0; i2 < i; i2++) {
                this.a.removeFirst();
            }
            return;
        }
        throw new IOException("closed");
    }

    @Override // com.squareup.tape2.ObjectQueue
    public int size() {
        return this.a.size();
    }
}
