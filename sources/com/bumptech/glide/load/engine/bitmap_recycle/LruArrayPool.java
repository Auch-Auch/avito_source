package com.bumptech.glide.load.engine.bitmap_recycle;

import a2.d.a.d.b.u.c;
import a2.d.a.d.b.u.e;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
public final class LruArrayPool implements ArrayPool {
    public final c<a, Object> a;
    public final b b;
    public final Map<Class<?>, NavigableMap<Integer, Integer>> c;
    public final Map<Class<?>, a2.d.a.d.b.u.a<?>> d;
    public final int e;
    public int f;

    public static final class a implements e {
        public final b a;
        public int b;
        public Class<?> c;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // a2.d.a.d.b.u.e
        public void a() {
            this.a.c(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b == aVar.b && this.c == aVar.c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = this.b * 31;
            Class<?> cls = this.c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Key{size=");
            L.append(this.b);
            L.append("array=");
            L.append(this.c);
            L.append('}');
            return L.toString();
        }
    }

    public static final class b extends a2.d.a.d.b.u.b<a> {
        /* Return type fixed from 'a2.d.a.d.b.u.e' to match base method */
        @Override // a2.d.a.d.b.u.b
        public a a() {
            return new a(this);
        }

        public a d(int i, Class<?> cls) {
            a aVar = (a) b();
            aVar.b = i;
            aVar.c = cls;
            return aVar;
        }
    }

    @VisibleForTesting
    public LruArrayPool() {
        this.a = new c<>();
        this.b = new b();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = 4194304;
    }

    public final void a(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> e2 = e(cls);
        Integer num = (Integer) e2.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        } else if (num.intValue() == 1) {
            e2.remove(Integer.valueOf(i));
        } else {
            e2.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    public final void b(int i) {
        while (this.f > i) {
            Object c2 = this.a.c();
            Preconditions.checkNotNull(c2);
            a2.d.a.d.b.u.a c3 = c(c2.getClass());
            this.f -= c3.getElementSizeInBytes() * c3.getArrayLength(c2);
            a(c3.getArrayLength(c2), c2.getClass());
            if (Log.isLoggable(c3.getTag(), 2)) {
                c3.getTag();
                c3.getArrayLength(c2);
            }
        }
    }

    public final <T> a2.d.a.d.b.u.a<T> c(Class<T> cls) {
        ByteArrayAdapter byteArrayAdapter = (a2.d.a.d.b.u.a<T>) this.d.get(cls);
        if (byteArrayAdapter == null) {
            if (cls.equals(int[].class)) {
                byteArrayAdapter = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                byteArrayAdapter = new ByteArrayAdapter();
            } else {
                StringBuilder L = a2.b.a.a.a.L("No array pool found for: ");
                L.append(cls.getSimpleName());
                throw new IllegalArgumentException(L.toString());
            }
            this.d.put(cls, byteArrayAdapter);
        }
        return byteArrayAdapter;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void clearMemory() {
        b(0);
    }

    public final <T> T d(a aVar, Class<T> cls) {
        a2.d.a.d.b.u.a<T> c2 = c(cls);
        T t = (T) this.a.a(aVar);
        if (t != null) {
            this.f -= c2.getElementSizeInBytes() * c2.getArrayLength(t);
            a(c2.getArrayLength(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(c2.getTag(), 2)) {
            c2.getTag();
        }
        return c2.newArray(aVar.b);
    }

    public final NavigableMap<Integer, Integer> e(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(cls, treeMap);
        return treeMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Class<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T get(int i, Class<T> cls) {
        a aVar;
        boolean z;
        Integer ceilingKey = e(cls).ceilingKey(Integer.valueOf(i));
        boolean z2 = false;
        if (ceilingKey != null) {
            int i2 = this.f;
            if (i2 != 0) {
                if (this.e / i2 < 2) {
                    z = false;
                    if (z || ceilingKey.intValue() <= i * 8) {
                        z2 = true;
                    }
                }
            }
            z = true;
            z2 = true;
        }
        if (z2) {
            aVar = this.b.d(ceilingKey.intValue(), cls);
        } else {
            a aVar2 = (a) this.b.b();
            aVar2.b = i;
            aVar2.c = cls;
            aVar = aVar2;
        }
        return (T) d(aVar, cls);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Class<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T getExact(int i, Class<T> cls) {
        a aVar;
        aVar = (a) this.b.b();
        aVar.b = i;
        aVar.c = cls;
        return (T) d(aVar, cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @Deprecated
    public <T> void put(T t, Class<T> cls) {
        put(t);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void trimMemory(int i) {
        if (i >= 40) {
            try {
                clearMemory();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i >= 20 || i == 15) {
            b(this.e / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        a2.d.a.d.b.u.a<T> c2 = c(cls);
        int arrayLength = c2.getArrayLength(t);
        int elementSizeInBytes = c2.getElementSizeInBytes() * arrayLength;
        int i = 1;
        if (elementSizeInBytes <= this.e / 2) {
            a d2 = this.b.d(arrayLength, cls);
            this.a.b(d2, t);
            NavigableMap<Integer, Integer> e2 = e(cls);
            Integer num = (Integer) e2.get(Integer.valueOf(d2.b));
            Integer valueOf = Integer.valueOf(d2.b);
            if (num != null) {
                i = 1 + num.intValue();
            }
            e2.put(valueOf, Integer.valueOf(i));
            this.f += elementSizeInBytes;
            b(this.e);
        }
    }

    public LruArrayPool(int i) {
        this.a = new c<>();
        this.b = new b();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = i;
    }
}
