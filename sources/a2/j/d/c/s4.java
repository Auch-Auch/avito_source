package a2.j.d.c;

import java.util.Collection;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class s4<E> extends h4<E> implements Queue<E> {
    private static final long serialVersionUID = 0;

    public s4(Queue<E> queue, @NullableDecl Object obj) {
        super(queue, obj, null);
    }

    /* renamed from: e */
    public Queue<E> d() {
        return (Queue) ((Collection) this.a);
    }

    @Override // java.util.Queue
    public E element() {
        E element;
        synchronized (this.b) {
            element = d().element();
        }
        return element;
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        boolean offer;
        synchronized (this.b) {
            offer = d().offer(e);
        }
        return offer;
    }

    @Override // java.util.Queue
    public E peek() {
        E peek;
        synchronized (this.b) {
            peek = d().peek();
        }
        return peek;
    }

    @Override // java.util.Queue
    public E poll() {
        E poll;
        synchronized (this.b) {
            poll = d().poll();
        }
        return poll;
    }

    @Override // java.util.Queue
    public E remove() {
        E remove;
        synchronized (this.b) {
            remove = d().remove();
        }
        return remove;
    }
}
