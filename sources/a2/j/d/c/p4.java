package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@VisibleForTesting
@GwtIncompatible
public class p4<K, V> extends w4<K, V> implements NavigableMap<K, V> {
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    public transient NavigableSet<K> f;
    @MonotonicNonNullDecl
    public transient NavigableMap<K, V> g;
    @MonotonicNonNullDecl
    public transient NavigableSet<K> h;

    public p4(NavigableMap<K, V> navigableMap, @NullableDecl Object obj) {
        super(navigableMap, obj);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k) {
        Map.Entry<K, V> f2;
        synchronized (this.b) {
            f2 = AppCompatDelegateImpl.i.f(e().ceilingEntry(k), this.b);
        }
        return f2;
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        K ceilingKey;
        synchronized (this.b) {
            ceilingKey = e().ceilingKey(k);
        }
        return ceilingKey;
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        synchronized (this.b) {
            NavigableSet<K> navigableSet = this.f;
            if (navigableSet != null) {
                return navigableSet;
            }
            q4 q4Var = new q4(e().descendingKeySet(), this.b);
            this.f = q4Var;
            return q4Var;
        }
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        synchronized (this.b) {
            NavigableMap<K, V> navigableMap = this.g;
            if (navigableMap != null) {
                return navigableMap;
            }
            p4 p4Var = new p4(e().descendingMap(), this.b);
            this.g = p4Var;
            return p4Var;
        }
    }

    /* renamed from: f */
    public NavigableMap<K, V> e() {
        return (NavigableMap) super.d();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        Map.Entry<K, V> f2;
        synchronized (this.b) {
            f2 = AppCompatDelegateImpl.i.f(e().firstEntry(), this.b);
        }
        return f2;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k) {
        Map.Entry<K, V> f2;
        synchronized (this.b) {
            f2 = AppCompatDelegateImpl.i.f(e().floorEntry(k), this.b);
        }
        return f2;
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        K floorKey;
        synchronized (this.b) {
            floorKey = e().floorKey(k);
        }
        return floorKey;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K k, boolean z) {
        p4 p4Var;
        synchronized (this.b) {
            p4Var = new p4(e().headMap(k, z), this.b);
        }
        return p4Var;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k) {
        Map.Entry<K, V> f2;
        synchronized (this.b) {
            f2 = AppCompatDelegateImpl.i.f(e().higherEntry(k), this.b);
        }
        return f2;
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        K higherKey;
        synchronized (this.b) {
            higherKey = e().higherKey(k);
        }
        return higherKey;
    }

    @Override // a2.j.d.c.m4, java.util.Map
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        Map.Entry<K, V> f2;
        synchronized (this.b) {
            f2 = AppCompatDelegateImpl.i.f(e().lastEntry(), this.b);
        }
        return f2;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k) {
        Map.Entry<K, V> f2;
        synchronized (this.b) {
            f2 = AppCompatDelegateImpl.i.f(e().lowerEntry(k), this.b);
        }
        return f2;
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        K lowerKey;
        synchronized (this.b) {
            lowerKey = e().lowerKey(k);
        }
        return lowerKey;
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        synchronized (this.b) {
            NavigableSet<K> navigableSet = this.h;
            if (navigableSet != null) {
                return navigableSet;
            }
            q4 q4Var = new q4(e().navigableKeySet(), this.b);
            this.h = q4Var;
            return q4Var;
        }
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        Map.Entry<K, V> f2;
        synchronized (this.b) {
            f2 = AppCompatDelegateImpl.i.f(e().pollFirstEntry(), this.b);
        }
        return f2;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        Map.Entry<K, V> f2;
        synchronized (this.b) {
            f2 = AppCompatDelegateImpl.i.f(e().pollLastEntry(), this.b);
        }
        return f2;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        p4 p4Var;
        synchronized (this.b) {
            p4Var = new p4(e().subMap(k, z, k2, z2), this.b);
        }
        return p4Var;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K k, boolean z) {
        p4 p4Var;
        synchronized (this.b) {
            p4Var = new p4(e().tailMap(k, z), this.b);
        }
        return p4Var;
    }

    @Override // a2.j.d.c.w4, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> headMap(K k) {
        return headMap(k, false);
    }

    @Override // a2.j.d.c.w4, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> subMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    @Override // a2.j.d.c.w4, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> tailMap(K k) {
        return tailMap(k, true);
    }
}
