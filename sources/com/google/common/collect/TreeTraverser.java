package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
@Beta
@GwtCompatible
@Deprecated
public abstract class TreeTraverser<T> {

    public static class a extends TreeTraverser<T> {
        public final /* synthetic */ Function a;

        public a(Function function) {
            this.a = function;
        }

        @Override // com.google.common.collect.TreeTraverser
        public Iterable<T> children(T t) {
            return (Iterable) this.a.apply(t);
        }
    }

    public class b extends FluentIterable<T> {
        public final /* synthetic */ Object b;

        public b(Object obj) {
            this.b = obj;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            TreeTraverser treeTraverser = TreeTraverser.this;
            Object obj = this.b;
            Objects.requireNonNull(treeTraverser);
            return new h(obj);
        }
    }

    public class c extends FluentIterable<T> {
        public final /* synthetic */ Object b;

        public c(Object obj) {
            this.b = obj;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            TreeTraverser treeTraverser = TreeTraverser.this;
            Object obj = this.b;
            Objects.requireNonNull(treeTraverser);
            return new f(obj);
        }
    }

    public class d extends FluentIterable<T> {
        public final /* synthetic */ Object b;

        public d(Object obj) {
            this.b = obj;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new e(this.b);
        }
    }

    public final class e extends UnmodifiableIterator<T> implements PeekingIterator<T> {
        public final Queue<T> a;

        public e(T t) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.a = arrayDeque;
            arrayDeque.add(t);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.a.isEmpty();
        }

        @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
        public T next() {
            T remove = this.a.remove();
            Iterables.addAll(this.a, TreeTraverser.this.children(remove));
            return remove;
        }

        @Override // com.google.common.collect.PeekingIterator
        public T peek() {
            return this.a.element();
        }
    }

    public final class f extends AbstractIterator<T> {
        public final ArrayDeque<g<T>> c;

        public f(T t) {
            ArrayDeque<g<T>> arrayDeque = new ArrayDeque<>();
            this.c = arrayDeque;
            arrayDeque.addLast(new g<>(t, TreeTraverser.this.children(t).iterator()));
        }

        @Override // com.google.common.collect.AbstractIterator
        public T computeNext() {
            while (!this.c.isEmpty()) {
                g<T> last = this.c.getLast();
                if (last.b.hasNext()) {
                    T next = last.b.next();
                    this.c.addLast(new g<>(next, TreeTraverser.this.children(next).iterator()));
                } else {
                    this.c.removeLast();
                    return last.a;
                }
            }
            return (T) endOfData();
        }
    }

    public static final class g<T> {
        public final T a;
        public final Iterator<T> b;

        public g(T t, Iterator<T> it) {
            this.a = (T) Preconditions.checkNotNull(t);
            this.b = (Iterator) Preconditions.checkNotNull(it);
        }
    }

    public final class h extends UnmodifiableIterator<T> {
        public final Deque<Iterator<T>> a;

        public h(T t) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.a = arrayDeque;
            arrayDeque.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(t)));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            Iterator<T> last = this.a.getLast();
            T t = (T) Preconditions.checkNotNull(last.next());
            if (!last.hasNext()) {
                this.a.removeLast();
            }
            Iterator<T> it = TreeTraverser.this.children(t).iterator();
            if (it.hasNext()) {
                this.a.addLast(it);
            }
            return t;
        }
    }

    @Deprecated
    public static <T> TreeTraverser<T> using(Function<T, ? extends Iterable<T>> function) {
        Preconditions.checkNotNull(function);
        return new a(function);
    }

    @Deprecated
    public final FluentIterable<T> breadthFirstTraversal(T t) {
        Preconditions.checkNotNull(t);
        return new d(t);
    }

    public abstract Iterable<T> children(T t);

    @Deprecated
    public final FluentIterable<T> postOrderTraversal(T t) {
        Preconditions.checkNotNull(t);
        return new c(t);
    }

    @Deprecated
    public final FluentIterable<T> preOrderTraversal(T t) {
        Preconditions.checkNotNull(t);
        return new b(t);
    }
}
