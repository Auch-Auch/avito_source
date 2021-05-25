package a2.j.d.c;

import java.util.Deque;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class i4<E> extends s4<E> implements Deque<E> {
    private static final long serialVersionUID = 0;

    public i4(Deque<E> deque, @NullableDecl Object obj) {
        super(deque, obj);
    }

    @Override // java.util.Deque
    public void addFirst(E e) {
        synchronized (this.b) {
            e().addFirst(e);
        }
    }

    @Override // java.util.Deque
    public void addLast(E e) {
        synchronized (this.b) {
            e().addLast(e);
        }
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        Iterator<E> descendingIterator;
        synchronized (this.b) {
            descendingIterator = e().descendingIterator();
        }
        return descendingIterator;
    }

    /* renamed from: f */
    public Deque<E> e() {
        return (Deque) super.d();
    }

    @Override // java.util.Deque
    public E getFirst() {
        E first;
        synchronized (this.b) {
            first = e().getFirst();
        }
        return first;
    }

    @Override // java.util.Deque
    public E getLast() {
        E last;
        synchronized (this.b) {
            last = e().getLast();
        }
        return last;
    }

    @Override // java.util.Deque
    public boolean offerFirst(E e) {
        boolean offerFirst;
        synchronized (this.b) {
            offerFirst = e().offerFirst(e);
        }
        return offerFirst;
    }

    @Override // java.util.Deque
    public boolean offerLast(E e) {
        boolean offerLast;
        synchronized (this.b) {
            offerLast = e().offerLast(e);
        }
        return offerLast;
    }

    @Override // java.util.Deque
    public E peekFirst() {
        E peekFirst;
        synchronized (this.b) {
            peekFirst = e().peekFirst();
        }
        return peekFirst;
    }

    @Override // java.util.Deque
    public E peekLast() {
        E peekLast;
        synchronized (this.b) {
            peekLast = e().peekLast();
        }
        return peekLast;
    }

    @Override // java.util.Deque
    public E pollFirst() {
        E pollFirst;
        synchronized (this.b) {
            pollFirst = e().pollFirst();
        }
        return pollFirst;
    }

    @Override // java.util.Deque
    public E pollLast() {
        E pollLast;
        synchronized (this.b) {
            pollLast = e().pollLast();
        }
        return pollLast;
    }

    @Override // java.util.Deque
    public E pop() {
        E pop;
        synchronized (this.b) {
            pop = e().pop();
        }
        return pop;
    }

    @Override // java.util.Deque
    public void push(E e) {
        synchronized (this.b) {
            e().push(e);
        }
    }

    @Override // java.util.Deque
    public E removeFirst() {
        E removeFirst;
        synchronized (this.b) {
            removeFirst = e().removeFirst();
        }
        return removeFirst;
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object obj) {
        boolean removeFirstOccurrence;
        synchronized (this.b) {
            removeFirstOccurrence = e().removeFirstOccurrence(obj);
        }
        return removeFirstOccurrence;
    }

    @Override // java.util.Deque
    public E removeLast() {
        E removeLast;
        synchronized (this.b) {
            removeLast = e().removeLast();
        }
        return removeLast;
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object obj) {
        boolean removeLastOccurrence;
        synchronized (this.b) {
            removeLastOccurrence = e().removeLastOccurrence(obj);
        }
        return removeLastOccurrence;
    }
}
