package a2.p.b;

import com.squareup.tape2.ObjectQueue;
import com.squareup.tape2.QueueFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
public final class a<T> extends ObjectQueue<T> {
    public final QueueFile a;
    public final C0102a b = new C0102a();
    public final ObjectQueue.Converter<T> c;

    /* renamed from: a2.p.b.a$a  reason: collision with other inner class name */
    public static class C0102a extends ByteArrayOutputStream {
        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public final class b implements Iterator<T> {
        public final Iterator<byte[]> a;

        public b(Iterator<byte[]> it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            try {
                return a.this.c.from(this.a.next());
            } catch (IOException e) {
                throw new RuntimeException("todo: throw a proper error", e);
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            this.a.remove();
        }
    }

    public a(QueueFile queueFile, ObjectQueue.Converter<T> converter) {
        this.a = queueFile;
        this.c = converter;
    }

    @Override // com.squareup.tape2.ObjectQueue
    public void add(T t) throws IOException {
        this.b.reset();
        this.c.toStream(t, this.b);
        this.a.add(this.b.a(), 0, this.b.size());
    }

    @Override // com.squareup.tape2.ObjectQueue
    public void clear() throws IOException {
        this.a.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // com.squareup.tape2.ObjectQueue
    public QueueFile file() {
        return this.a;
    }

    @Override // com.squareup.tape2.ObjectQueue
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new b(this.a.iterator());
    }

    @Override // com.squareup.tape2.ObjectQueue
    public T peek() throws IOException {
        byte[] peek = this.a.peek();
        if (peek == null) {
            return null;
        }
        return this.c.from(peek);
    }

    @Override // com.squareup.tape2.ObjectQueue
    public void remove() throws IOException {
        this.a.remove();
    }

    @Override // com.squareup.tape2.ObjectQueue
    public int size() {
        return this.a.size();
    }

    @Override // com.squareup.tape2.ObjectQueue
    public void remove(int i) throws IOException {
        this.a.remove(i);
    }
}
