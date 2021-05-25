package com.google.common.graph;

import a2.j.d.f.k;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public abstract class Traverser<N> {

    public enum c {
        PREORDER,
        POSTORDER
    }

    public Traverser() {
    }

    public static <N> Traverser<N> forGraph(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        return new b(successorsFunction);
    }

    public static <N> Traverser<N> forTree(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        if (successorsFunction instanceof k) {
            Preconditions.checkArgument(((k) successorsFunction).isDirected(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            Preconditions.checkArgument(((Network) successorsFunction).isDirected(), "Undirected networks can never be trees.");
        }
        return new d(successorsFunction);
    }

    public abstract Iterable<N> breadthFirst(Iterable<? extends N> iterable);

    public abstract Iterable<N> breadthFirst(N n);

    public abstract Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPostOrder(N n);

    public abstract Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPreOrder(N n);

    public Traverser(a aVar) {
    }

    public static final class b<N> extends Traverser<N> {
        public final SuccessorsFunction<N> a;

        public class a implements Iterable<N> {
            public final /* synthetic */ Iterable a;

            public a(Iterable iterable) {
                this.a = iterable;
            }

            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return new d(this.a);
            }
        }

        /* renamed from: com.google.common.graph.Traverser$b$b  reason: collision with other inner class name */
        public class C0292b implements Iterable<N> {
            public final /* synthetic */ Iterable a;

            public C0292b(Iterable iterable) {
                this.a = iterable;
            }

            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return new e(this.a, c.PREORDER);
            }
        }

        public class c implements Iterable<N> {
            public final /* synthetic */ Iterable a;

            public c(Iterable iterable) {
                this.a = iterable;
            }

            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return new e(this.a, c.POSTORDER);
            }
        }

        public final class d extends UnmodifiableIterator<N> {
            public final Queue<N> a = new ArrayDeque();
            public final Set<N> b = new HashSet();

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.Set<N> */
            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.Queue<N> */
            /* JADX WARN: Multi-variable type inference failed */
            public d(Iterable<? extends N> iterable) {
                for (Object obj : iterable) {
                    if (this.b.add(obj)) {
                        this.a.add(obj);
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.a.isEmpty();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Set<N> */
            /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.util.Queue<N> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public N next() {
                N remove = this.a.remove();
                for (Object obj : b.this.a.mo140successors(remove)) {
                    if (this.b.add(obj)) {
                        this.a.add(obj);
                    }
                }
                return remove;
            }
        }

        public final class e extends AbstractIterator<N> {
            public final Deque<b<N>.e.a> c;
            public final Set<N> d = new HashSet();
            public final c e;

            /* JADX WARN: Field signature parse error: a */
            public final class a {
                @NullableDecl
                public final Object a;
                public final Iterator<? extends N> b;

                public a(@NullableDecl e eVar, N n, Iterable<? extends N> iterable) {
                    this.a = n;
                    this.b = iterable.iterator();
                }
            }

            public e(Iterable<? extends N> iterable, c cVar) {
                ArrayDeque arrayDeque = new ArrayDeque();
                this.c = arrayDeque;
                arrayDeque.push(new a(this, null, iterable));
                this.e = cVar;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Set<N> */
            /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: com.google.common.graph.SuccessorsFunction<N> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.AbstractIterator
            public N computeNext() {
                N n;
                while (!this.c.isEmpty()) {
                    b<N>.e.a first = this.c.getFirst();
                    boolean add = this.d.add(first.a);
                    boolean z = true;
                    boolean z2 = !first.b.hasNext();
                    if ((!add || this.e != c.PREORDER) && (!z2 || this.e != c.POSTORDER)) {
                        z = false;
                    }
                    if (z2) {
                        this.c.pop();
                    } else {
                        Object next = first.b.next();
                        if (!this.d.contains(next)) {
                            this.c.push(new a(this, next, b.this.a.mo140successors(next)));
                        }
                    }
                    if (z && (n = (N) first.a) != null) {
                        return n;
                    }
                }
                return (N) endOfData();
            }
        }

        public b(SuccessorsFunction<N> successorsFunction) {
            super(null);
            this.a = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.graph.SuccessorsFunction<N> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(N n) {
            Preconditions.checkNotNull(n);
            ImmutableSet<Object> of = ImmutableSet.of(n);
            Preconditions.checkNotNull(of);
            if (Iterables.isEmpty(of)) {
                return ImmutableSet.of();
            }
            for (Object obj : of) {
                this.a.mo140successors(obj);
            }
            return new a(of);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.graph.SuccessorsFunction<N> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(N n) {
            Preconditions.checkNotNull(n);
            ImmutableSet<Object> of = ImmutableSet.of(n);
            Preconditions.checkNotNull(of);
            if (Iterables.isEmpty(of)) {
                return ImmutableSet.of();
            }
            for (Object obj : of) {
                this.a.mo140successors(obj);
            }
            return new c(of);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.graph.SuccessorsFunction<N> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(N n) {
            Preconditions.checkNotNull(n);
            ImmutableSet<Object> of = ImmutableSet.of(n);
            Preconditions.checkNotNull(of);
            if (Iterables.isEmpty(of)) {
                return ImmutableSet.of();
            }
            for (Object obj : of) {
                this.a.mo140successors(obj);
            }
            return new C0292b(of);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.graph.SuccessorsFunction<N> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                this.a.mo140successors(it.next());
            }
            return new a(iterable);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.graph.SuccessorsFunction<N> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                this.a.mo140successors(it.next());
            }
            return new c(iterable);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.graph.SuccessorsFunction<N> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                this.a.mo140successors(it.next());
            }
            return new C0292b(iterable);
        }
    }

    public static final class d<N> extends Traverser<N> {
        public final SuccessorsFunction<N> a;

        public class a implements Iterable<N> {
            public final /* synthetic */ Iterable a;

            public a(Iterable iterable) {
                this.a = iterable;
            }

            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return new C0293d(this.a);
            }
        }

        public class b implements Iterable<N> {
            public final /* synthetic */ Iterable a;

            public b(Iterable iterable) {
                this.a = iterable;
            }

            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return new f(this.a);
            }
        }

        public class c implements Iterable<N> {
            public final /* synthetic */ Iterable a;

            public c(Iterable iterable) {
                this.a = iterable;
            }

            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return new e(this.a);
            }
        }

        /* renamed from: com.google.common.graph.Traverser$d$d  reason: collision with other inner class name */
        public final class C0293d extends UnmodifiableIterator<N> {
            public final Queue<N> a = new ArrayDeque();

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.Queue<N> */
            /* JADX WARN: Multi-variable type inference failed */
            public C0293d(Iterable<? extends N> iterable) {
                Iterator<? extends N> it = iterable.iterator();
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.a.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N remove = this.a.remove();
                Iterables.addAll(this.a, d.this.a.mo140successors(remove));
                return remove;
            }
        }

        public final class e extends AbstractIterator<N> {
            public final ArrayDeque<d<N>.e.a> c;

            /* JADX WARN: Field signature parse error: a */
            public final class a {
                @NullableDecl
                public final Object a;
                public final Iterator<? extends N> b;

                public a(@NullableDecl e eVar, N n, Iterable<? extends N> iterable) {
                    this.a = n;
                    this.b = iterable.iterator();
                }
            }

            public e(Iterable<? extends N> iterable) {
                ArrayDeque<d<N>.e.a> arrayDeque = new ArrayDeque<>();
                this.c = arrayDeque;
                arrayDeque.addLast(new a(this, null, iterable));
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: com.google.common.graph.SuccessorsFunction<N> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.AbstractIterator
            public N computeNext() {
                while (!this.c.isEmpty()) {
                    d<N>.e.a last = this.c.getLast();
                    if (last.b.hasNext()) {
                        Object next = last.b.next();
                        this.c.addLast(new a(this, next, d.this.a.mo140successors(next)));
                    } else {
                        this.c.removeLast();
                        N n = (N) last.a;
                        if (n != null) {
                            return n;
                        }
                    }
                }
                return (N) endOfData();
            }
        }

        public final class f extends UnmodifiableIterator<N> {
            public final Deque<Iterator<? extends N>> a;

            public f(Iterable<? extends N> iterable) {
                ArrayDeque arrayDeque = new ArrayDeque();
                this.a = arrayDeque;
                arrayDeque.addLast(iterable.iterator());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.a.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                Iterator<? extends N> last = this.a.getLast();
                N n = (N) Preconditions.checkNotNull(last.next());
                if (!last.hasNext()) {
                    this.a.removeLast();
                }
                Iterator<? extends N> it = d.this.a.mo140successors(n).iterator();
                if (it.hasNext()) {
                    this.a.addLast(it);
                }
                return n;
            }
        }

        public d(SuccessorsFunction<N> successorsFunction) {
            super(null);
            this.a = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.graph.SuccessorsFunction<N> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(N n) {
            Preconditions.checkNotNull(n);
            ImmutableSet<Object> of = ImmutableSet.of(n);
            Preconditions.checkNotNull(of);
            if (Iterables.isEmpty(of)) {
                return ImmutableSet.of();
            }
            for (Object obj : of) {
                this.a.mo140successors(obj);
            }
            return new a(of);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.graph.SuccessorsFunction<N> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(N n) {
            Preconditions.checkNotNull(n);
            ImmutableSet<Object> of = ImmutableSet.of(n);
            Preconditions.checkNotNull(of);
            if (Iterables.isEmpty(of)) {
                return ImmutableSet.of();
            }
            for (Object obj : of) {
                this.a.mo140successors(obj);
            }
            return new c(of);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.graph.SuccessorsFunction<N> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(N n) {
            Preconditions.checkNotNull(n);
            ImmutableSet<Object> of = ImmutableSet.of(n);
            Preconditions.checkNotNull(of);
            if (Iterables.isEmpty(of)) {
                return ImmutableSet.of();
            }
            for (Object obj : of) {
                this.a.mo140successors(obj);
            }
            return new b(of);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.graph.SuccessorsFunction<N> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                this.a.mo140successors(it.next());
            }
            return new a(iterable);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.graph.SuccessorsFunction<N> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                this.a.mo140successors(it.next());
            }
            return new c(iterable);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.graph.SuccessorsFunction<N> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                this.a.mo140successors(it.next());
            }
            return new b(iterable);
        }
    }
}
