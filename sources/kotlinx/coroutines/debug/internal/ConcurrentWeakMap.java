package kotlinx.coroutines.debug.internal;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0003\u0010\"#B\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u001a\u0010\u0006\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ#\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\b\u0010\b\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\nR(\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00120\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014¨\u0006$"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/AbstractMutableMap;", "key", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", ProductAction.ACTION_REMOVE, "", "clear", "()V", "runWeakRefQueueCleaningLoopUntilInterrupted", AuthSource.SEND_ABUSE, "", "", "getEntries", "()Ljava/util/Set;", "entries", "", "getSize", "()I", "size", "Ljava/lang/ref/ReferenceQueue;", "Ljava/lang/ref/ReferenceQueue;", "weakRefQueue", "getKeys", "keys", "", "<init>", "(Z)V", AuthSource.BOOKING_ORDER, "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {
    public static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    private volatile int _size;
    public final ReferenceQueue<K> a;
    public volatile Object core;

    public final class a {
        public static final AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load");
        public final int a;
        public final int b;
        public AtomicReferenceArray c;
        public AtomicReferenceArray d;
        public final int e;
        private volatile int load = 0;

        /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a  reason: collision with other inner class name */
        public final class C0516a<E> implements Iterator<E>, KMutableIterator {
            public int a = -1;
            public K b;
            public V c;
            public final Function2<K, V, E> d;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super K, ? super V, ? extends E> */
            /* JADX WARN: Multi-variable type inference failed */
            public C0516a(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
                this.d = function2;
                a();
            }

            public final void a() {
                K k;
                while (true) {
                    int i = this.a + 1;
                    this.a = i;
                    a aVar = a.this;
                    if (i < aVar.e) {
                        HashedWeakRef hashedWeakRef = (HashedWeakRef) aVar.c.get(i);
                        if (!(hashedWeakRef == null || (k = (K) hashedWeakRef.get()) == null)) {
                            this.b = k;
                            V v = (V) a.this.d.get(this.a);
                            if (v instanceof u6.a.i0.a.c) {
                                v = (V) v.a;
                            }
                            if (v != null) {
                                this.c = v;
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a < a.this.e;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.a < a.this.e) {
                    Function2<K, V, E> function2 = this.d;
                    K k = this.b;
                    if (k == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("key");
                    }
                    V v = this.c;
                    if (v == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("value");
                    }
                    E invoke = function2.invoke(k, v);
                    a();
                    return invoke;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                ConcurrentWeakMapKt.access$noImpl();
                throw new KotlinNothingValueException();
            }
        }

        public a(int i) {
            this.e = i;
            this.a = Integer.numberOfLeadingZeros(i) + 1;
            this.b = (i * 2) / 3;
            this.c = new AtomicReferenceArray(i);
            this.d = new AtomicReferenceArray(i);
        }

        public final int a(int i) {
            return (i * -1640531527) >>> this.a;
        }

        /* JADX WARN: Failed to parse method signature: (TKTVLkotlinx/coroutines/debug/internal/HashedWeakRef<TK;>;)Ljava/lang/Object; */
        @Nullable
        public final Object b(@NotNull Object obj, @Nullable Object obj2, @Nullable HashedWeakRef hashedWeakRef) {
            Object obj3;
            int i;
            int a3 = a(obj.hashCode());
            boolean z = false;
            while (true) {
                HashedWeakRef hashedWeakRef2 = (HashedWeakRef) this.c.get(a3);
                if (hashedWeakRef2 != null) {
                    Object obj4 = hashedWeakRef2.get();
                    if (!Intrinsics.areEqual(obj, obj4)) {
                        if (obj4 == null) {
                            d(a3);
                        }
                        if (a3 == 0) {
                            a3 = this.e;
                        }
                        a3--;
                    } else if (z) {
                        g.decrementAndGet(this);
                    }
                } else if (obj2 == null) {
                    return null;
                } else {
                    if (!z) {
                        do {
                            i = this.load;
                            if (i >= this.b) {
                                return ConcurrentWeakMapKt.a;
                            }
                        } while (!g.compareAndSet(this, i, i + 1));
                        z = true;
                    }
                    if (hashedWeakRef == null) {
                        hashedWeakRef = new HashedWeakRef(obj, ConcurrentWeakMap.this.a);
                    }
                    if (this.c.compareAndSet(a3, null, hashedWeakRef)) {
                        break;
                    }
                }
            }
            do {
                obj3 = this.d.get(a3);
                if (obj3 instanceof u6.a.i0.a.c) {
                    return ConcurrentWeakMapKt.a;
                }
            } while (!this.d.compareAndSet(a3, obj3, obj2));
            return obj3;
        }

        @NotNull
        public final ConcurrentWeakMap<K, V>.a c() {
            Object obj;
            while (true) {
                ConcurrentWeakMap<K, V>.a aVar = new a(Integer.highestOneBit(t6.v.e.coerceAtLeast(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i = 0;
                int i2 = this.e;
                while (true) {
                    if (i >= i2) {
                        return aVar;
                    }
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) this.c.get(i);
                    Object obj2 = hashedWeakRef != null ? hashedWeakRef.get() : null;
                    if (hashedWeakRef != null && obj2 == null) {
                        d(i);
                    }
                    while (true) {
                        obj = this.d.get(i);
                        if (!(obj instanceof u6.a.i0.a.c)) {
                            if (this.d.compareAndSet(i, obj, ConcurrentWeakMapKt.access$mark(obj))) {
                                break;
                            }
                        } else {
                            obj = ((u6.a.i0.a.c) obj).a;
                            break;
                        }
                    }
                    if (obj2 == null || obj == null || aVar.b(obj2, obj, hashedWeakRef) != ConcurrentWeakMapKt.a) {
                        i++;
                    }
                }
            }
        }

        public final void d(int i) {
            Object obj;
            do {
                obj = this.d.get(i);
                if (obj == null || (obj instanceof u6.a.i0.a.c)) {
                    return;
                }
            } while (!this.d.compareAndSet(i, obj, null));
            ConcurrentWeakMap.access$decrementSize(ConcurrentWeakMap.this);
        }
    }

    public static final class b<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        public final K a;
        public final V b;

        public b(K k, V v) {
            this.a = k;
            this.b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            ConcurrentWeakMapKt.access$noImpl();
            throw new KotlinNothingValueException();
        }
    }

    public final class c<E> extends AbstractMutableSet<E> {
        public final Function2<K, V, E> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super K, ? super V, ? extends E> */
        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            this.a = function2;
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            ConcurrentWeakMapKt.access$noImpl();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.AbstractMutableSet
        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        @NotNull
        public Iterator<E> iterator() {
            a aVar = (a) ConcurrentWeakMap.this.core;
            Function2<K, V, E> function2 = this.a;
            Objects.requireNonNull(aVar);
            return new a.C0516a(function2);
        }
    }

    public static final class d extends Lambda implements Function2<K, V, Map.Entry<K, V>> {
        public static final d a = new d();

        public d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Object obj, Object obj2) {
            return new b(obj, obj2);
        }
    }

    public static final class e extends Lambda implements Function2<K, V, K> {
        public static final e a = new e();

        public e() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        @NotNull
        public final K invoke(@NotNull K k, @NotNull V v) {
            return k;
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, j jVar) {
        this((i & 1) != 0 ? false : z);
    }

    public static final void access$decrementSize(ConcurrentWeakMap concurrentWeakMap) {
        Objects.requireNonNull(concurrentWeakMap);
        b.decrementAndGet(concurrentWeakMap);
    }

    public final synchronized V a(K k, V v) {
        V v2;
        ConcurrentWeakMap<K, V>.a aVar = (a) this.core;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = a.g;
            v2 = (V) aVar.b(k, v, null);
            if (v2 == ConcurrentWeakMapKt.a) {
                aVar = aVar.c();
                this.core = aVar;
            }
        }
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (K k : keySet()) {
            remove(k);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@NotNull Object obj) {
        if (obj == null) {
            return null;
        }
        a aVar = (a) this.core;
        Objects.requireNonNull(aVar);
        int a3 = aVar.a(obj.hashCode());
        while (true) {
            HashedWeakRef hashedWeakRef = (HashedWeakRef) aVar.c.get(a3);
            if (hashedWeakRef == null) {
                return null;
            }
            Object obj2 = hashedWeakRef.get();
            if (Intrinsics.areEqual(obj, obj2)) {
                V v = (V) aVar.d.get(a3);
                if (v instanceof u6.a.i0.a.c) {
                    v = (V) v.a;
                }
                return v;
            }
            if (obj2 == null) {
                aVar.d(a3);
            }
            if (a3 == 0) {
                a3 = aVar.e;
            }
            a3--;
        }
    }

    @Override // kotlin.collections.AbstractMutableMap
    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        return new c(d.a);
    }

    @Override // kotlin.collections.AbstractMutableMap
    @NotNull
    public Set<K> getKeys() {
        return new c(e.a);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return this._size;
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    @Nullable
    public V put(@NotNull K k, @NotNull V v) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = a.g;
        V v2 = (V) ((a) this.core).b(k, v, null);
        if (v2 == ConcurrentWeakMapKt.a) {
            v2 = a(k, v);
        }
        if (v2 == null) {
            b.incrementAndGet(this);
        }
        return v2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V remove(@NotNull Object obj) {
        if (obj == 0) {
            return null;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = a.g;
        V v = (V) ((a) this.core).b(obj, null, null);
        if (v == ConcurrentWeakMapKt.a) {
            v = a(obj, null);
        }
        if (v != null) {
            b.decrementAndGet(this);
        }
        return v;
    }

    public final void runWeakRefQueueCleaningLoopUntilInterrupted() {
        if (this.a != null) {
            while (true) {
                try {
                    Reference<? extends K> remove = this.a.remove();
                    if (remove != null) {
                        HashedWeakRef hashedWeakRef = (HashedWeakRef) remove;
                        a aVar = (a) this.core;
                        Objects.requireNonNull(aVar);
                        int a3 = aVar.a(hashedWeakRef.hash);
                        while (true) {
                            HashedWeakRef hashedWeakRef2 = (HashedWeakRef) aVar.c.get(a3);
                            if (hashedWeakRef2 == null) {
                                break;
                            } else if (hashedWeakRef2 == hashedWeakRef) {
                                aVar.d(a3);
                                break;
                            } else {
                                if (a3 == 0) {
                                    a3 = aVar.e;
                                }
                                a3--;
                            }
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
    }

    public ConcurrentWeakMap(boolean z) {
        this._size = 0;
        this.core = new a(16);
        this.a = z ? new ReferenceQueue<>() : null;
    }
}
