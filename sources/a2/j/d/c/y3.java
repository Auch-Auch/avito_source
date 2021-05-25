package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public class y3<R, C, V> extends q<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Map<R, Map<C, V>> c;
    public final Supplier<? extends Map<C, V>> d;
    @MonotonicNonNullDecl
    public transient Set<C> e;
    @MonotonicNonNullDecl
    public transient Map<R, Map<C, V>> f;
    @MonotonicNonNullDecl
    public transient y3<R, C, V>.f g;

    public class b implements Iterator<Table.Cell<R, C, V>> {
        public final Iterator<Map.Entry<R, Map<C, V>>> a;
        @NullableDecl
        public Map.Entry<R, Map<C, V>> b;
        public Iterator<Map.Entry<C, V>> c = Iterators.l.INSTANCE;

        public b(a aVar) {
            this.a = y3.this.c.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext() || this.c.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.c.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.a.next();
                this.b = next;
                this.c = next.getValue().entrySet().iterator();
            }
            Map.Entry<C, V> next2 = this.c.next();
            return Tables.immutableCell(this.b.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.c.remove();
            if (this.b.getValue().isEmpty()) {
                this.a.remove();
                this.b = null;
            }
        }
    }

    public class c extends Maps.g0<R, V> {
        public final C d;

        public class a extends Sets.k<Map.Entry<R, V>> {
            public a(a aVar) {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.e(Predicates.alwaysTrue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                y3 y3Var = y3.this;
                Object key = entry.getKey();
                C c = c.this.d;
                Object value = entry.getValue();
                Objects.requireNonNull(y3Var);
                if (value == null || !value.equals(y3Var.get(key, c))) {
                    return false;
                }
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !y3.this.containsColumn(cVar.d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<R, V>> iterator() {
                return new b(null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                y3 y3Var = y3.this;
                Object key = entry.getKey();
                C c = c.this.d;
                Object value = entry.getValue();
                Objects.requireNonNull(y3Var);
                if (!(value != null && value.equals(y3Var.get(key, c)))) {
                    return false;
                }
                y3Var.remove(key, c);
                return true;
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.e(Predicates.not(Predicates.in(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int i = 0;
                for (Map<C, V> map : y3.this.c.values()) {
                    if (map.containsKey(c.this.d)) {
                        i++;
                    }
                }
                return i;
            }
        }

        public class b extends AbstractIterator<Map.Entry<R, V>> {
            public final Iterator<Map.Entry<R, Map<C, V>>> c;

            public b(a aVar) {
                this.c = y3.this.c.entrySet().iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                while (this.c.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.c.next();
                    if (next.getValue().containsKey(c.this.d)) {
                        return new z3(this, next);
                    }
                }
                return (Map.Entry) endOfData();
            }
        }

        /* renamed from: a2.j.d.c.y3$c$c  reason: collision with other inner class name */
        public class C0064c extends Maps.q<R, V> {
            public C0064c() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                c cVar = c.this;
                return y3.this.contains(obj, cVar.d);
            }

            @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                c cVar = c.this;
                return y3.this.remove(obj, cVar.d) != null;
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.e(Maps.j(Predicates.not(Predicates.in(collection))));
            }
        }

        public class d extends Maps.f0<R, V> {
            public d() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && c.this.e(Maps.o(Predicates.equalTo(obj)));
            }

            @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return c.this.e(Maps.o(Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return c.this.e(Maps.o(Predicates.not(Predicates.in(collection))));
            }
        }

        public c(C c) {
            this.d = (C) Preconditions.checkNotNull(c);
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<Map.Entry<R, V>> a() {
            return new a(null);
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<R> c() {
            return new C0064c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return y3.this.contains(obj, this.d);
        }

        @Override // com.google.common.collect.Maps.g0
        public Collection<V> d() {
            return new d();
        }

        @CanIgnoreReturnValue
        public boolean e(Predicate<? super Map.Entry<R, V>> predicate) {
            Iterator<Map.Entry<R, Map<C, V>>> it = y3.this.c.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v = value.get(this.d);
                if (v != null && predicate.apply(Maps.immutableEntry(next.getKey(), v))) {
                    value.remove(this.d);
                    z = true;
                    if (value.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return (V) y3.this.get(obj, this.d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r, V v) {
            return (V) y3.this.put(r, this.d, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return (V) y3.this.remove(obj, this.d);
        }
    }

    public class d extends AbstractIterator<C> {
        public final Map<C, V> c;
        public final Iterator<Map<C, V>> d;
        public Iterator<Map.Entry<C, V>> e = Iterators.j.e;

        public d(a aVar) {
            this.c = (Map) y3.this.d.get();
            this.d = y3.this.c.values().iterator();
        }

        @Override // com.google.common.collect.AbstractIterator
        public C computeNext() {
            while (true) {
                if (this.e.hasNext()) {
                    Map.Entry<C, V> next = this.e.next();
                    if (!this.c.containsKey(next.getKey())) {
                        this.c.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else if (!this.d.hasNext()) {
                    return (C) endOfData();
                } else {
                    this.e = this.d.next().entrySet().iterator();
                }
            }
        }
    }

    public class e extends y3<R, C, V>.i {
        public e(a aVar) {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return y3.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<C> iterator() {
            return y3.this.f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = y3.this.c.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            Iterator<Map<C, V>> it = y3.this.c.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (Iterators.removeAll(next.keySet().iterator(), collection)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            Iterator<Map<C, V>> it = y3.this.c.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.size(iterator());
        }
    }

    public class f extends Maps.g0<C, Map<R, V>> {

        public class a extends y3<R, C, V>.i {

            /* renamed from: a2.j.d.c.y3$f$a$a  reason: collision with other inner class name */
            public class C0065a implements Function<C, Map<R, V>> {
                public C0065a() {
                }

                @Override // com.google.common.base.Function
                public Object apply(Object obj) {
                    return y3.this.column(obj);
                }
            }

            public a() {
                super(null);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: a2.j.d.c.y3 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!y3.this.containsColumn(entry.getKey())) {
                    return false;
                }
                Object key = entry.getKey();
                f fVar = f.this;
                return (y3.this.containsColumn(key) ? y3.this.column(key) : null).equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.d(y3.this.columnKeySet(), new C0065a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                y3.e(y3.this, ((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                return Sets.d(this, collection.iterator());
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: a2.j.d.c.y3 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                Iterator it = Lists.newArrayList(y3.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(Maps.immutableEntry(next, y3.this.column(next)))) {
                        y3.e(y3.this, next);
                        z = true;
                    }
                }
                return z;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return y3.this.columnKeySet().size();
            }
        }

        public class b extends Maps.f0<C, Map<R, V>> {
            public b() {
                super(f.this);
            }

            @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry entry : f.this.entrySet()) {
                    if (((Map) entry.getValue()).equals(obj)) {
                        y3.e(y3.this, entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: a2.j.d.c.y3 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                Iterator it = Lists.newArrayList(y3.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (collection.contains(y3.this.column(next))) {
                        y3.e(y3.this, next);
                        z = true;
                    }
                }
                return z;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: a2.j.d.c.y3 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                Iterator it = Lists.newArrayList(y3.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(y3.this.column(next))) {
                        y3.e(y3.this, next);
                        z = true;
                    }
                }
                return z;
            }
        }

        public f(a aVar) {
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return y3.this.containsColumn(obj);
        }

        @Override // com.google.common.collect.Maps.g0
        public Collection<Map<R, V>> d() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            if (y3.this.containsColumn(obj)) {
                return y3.this.column(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.g0, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return y3.this.columnKeySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (y3.this.containsColumn(obj)) {
                return y3.e(y3.this, obj);
            }
            return null;
        }
    }

    public class g extends Maps.p<C, V> {
        public final R a;
        @NullableDecl
        public Map<C, V> b;

        public class a implements Iterator<Map.Entry<C, V>> {
            public final /* synthetic */ Iterator a;

            public a(Iterator it) {
                this.a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                g gVar = g.this;
                Objects.requireNonNull(gVar);
                return new a4(gVar, (Map.Entry) this.a.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.a.remove();
                g.this.e();
            }
        }

        public g(R r) {
            this.a = (R) Preconditions.checkNotNull(r);
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<C, V>> a() {
            Map<C, V> c2 = c();
            if (c2 == null) {
                return Iterators.l.INSTANCE;
            }
            return new a(c2.entrySet().iterator());
        }

        public Map<C, V> c() {
            Map<C, V> map = this.b;
            if (map != null && (!map.isEmpty() || !y3.this.c.containsKey(this.a))) {
                return this.b;
            }
            Map<C, V> d = d();
            this.b = d;
            return d;
        }

        @Override // com.google.common.collect.Maps.p, java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<C, V> c2 = c();
            if (c2 != null) {
                c2.clear();
            }
            e();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> c2 = c();
            return (obj == null || c2 == null || !Maps.k(c2, obj)) ? false : true;
        }

        public Map<C, V> d() {
            return y3.this.c.get(this.a);
        }

        public void e() {
            if (c() != null && this.b.isEmpty()) {
                y3.this.c.remove(this.a);
                this.b = null;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> c2 = c();
            if (obj == null || c2 == null) {
                return null;
            }
            return (V) Maps.l(c2, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c2, V v) {
            Preconditions.checkNotNull(c2);
            Preconditions.checkNotNull(v);
            Map<C, V> map = this.b;
            return (map == null || map.isEmpty()) ? (V) y3.this.put(this.a, c2, v) : this.b.put(c2, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            Map<C, V> c2 = c();
            V v = null;
            if (c2 == null) {
                return null;
            }
            Preconditions.checkNotNull(c2);
            try {
                v = c2.remove(obj);
            } catch (ClassCastException | NullPointerException unused) {
            }
            e();
            return v;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            Map<C, V> c2 = c();
            if (c2 == null) {
                return 0;
            }
            return c2.size();
        }
    }

    public class h extends Maps.g0<R, Map<C, V>> {

        public class a extends y3<R, C, V>.i {

            /* renamed from: a2.j.d.c.y3$h$a$a  reason: collision with other inner class name */
            public class C0066a implements Function<R, Map<C, V>> {
                public C0066a() {
                }

                @Override // com.google.common.base.Function
                public Object apply(Object obj) {
                    return y3.this.row(obj);
                }
            }

            public a() {
                super(null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getKey() == null || !(entry.getValue() instanceof Map) || !Collections2.e(y3.this.c.entrySet(), entry)) {
                    return false;
                }
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.d(y3.this.c.keySet(), new C0066a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getKey() == null || !(entry.getValue() instanceof Map) || !y3.this.c.entrySet().remove(entry)) {
                    return false;
                }
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return y3.this.c.size();
            }
        }

        public h() {
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<Map.Entry<R, Map<C, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return y3.this.containsRow(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            if (y3.this.containsRow(obj)) {
                return y3.this.row(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return y3.this.c.remove(obj);
        }
    }

    public abstract class i<T> extends Sets.k<T> {
        public i(a aVar) {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            y3.this.c.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return y3.this.c.isEmpty();
        }
    }

    public y3(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        this.c = map;
        this.d = supplier;
    }

    public static Map e(y3 y3Var, Object obj) {
        Objects.requireNonNull(y3Var);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = y3Var.c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V remove = next.getValue().remove(obj);
            if (remove != null) {
                linkedHashMap.put(next.getKey(), remove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    @Override // a2.j.d.c.q
    public Iterator<Table.Cell<R, C, V>> a() {
        return new b(null);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public void clear() {
        this.c.clear();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c2) {
        return new c(c2);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public Set<C> columnKeySet() {
        Set<C> set = this.e;
        if (set != null) {
            return set;
        }
        e eVar = new e(null);
        this.e = eVar;
        return eVar;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        y3<R, C, V>.f fVar = this.g;
        if (fVar != null) {
            return fVar;
        }
        y3<R, C, V>.f fVar2 = new f(null);
        this.g = fVar2;
        return fVar2;
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public boolean containsColumn(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        for (Map<C, V> map : this.c.values()) {
            if (Maps.k(map, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object obj) {
        return obj != null && Maps.k(this.c, obj);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public Iterator<C> f() {
        return new d(null);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    public Map<R, Map<C, V>> h() {
        return new h();
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R r, C c2, V v) {
        Preconditions.checkNotNull(r);
        Preconditions.checkNotNull(c2);
        Preconditions.checkNotNull(v);
        Map<C, V> map = this.c.get(r);
        if (map == null) {
            map = (Map) this.d.get();
            this.c.put(r, map);
        }
        return map.put(c2, v);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.l(this.c, obj)) == null) {
            return null;
        }
        V v = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.c.remove(obj);
        }
        return v;
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r) {
        return new g(r);
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    /* renamed from: rowKeySet */
    public Set<R> mo128rowKeySet() {
        return mo129rowMap().keySet();
    }

    @Override // com.google.common.collect.Table
    /* renamed from: rowMap */
    public Map<R, Map<C, V>> mo129rowMap() {
        Map<R, Map<C, V>> map = this.f;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> h2 = h();
        this.f = h2;
        return h2;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        int i2 = 0;
        for (Map<C, V> map : this.c.values()) {
            i2 += map.size();
        }
        return i2;
    }

    @Override // a2.j.d.c.q, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }
}
