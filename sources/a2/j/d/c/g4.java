package a2.j.d.c;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.BiMap;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@VisibleForTesting
public class g4<K, V> extends m4<K, V> implements BiMap<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    public transient Set<V> f;
    @RetainedWith
    @MonotonicNonNullDecl
    public transient BiMap<V, K> g;

    public g4(BiMap<K, V> biMap, @NullableDecl Object obj, @NullableDecl BiMap<V, K> biMap2) {
        super(biMap, obj);
        this.g = biMap2;
    }

    /* renamed from: e */
    public BiMap<K, V> d() {
        return (BiMap) ((Map) this.a);
    }

    @Override // com.google.common.collect.BiMap
    public V forcePut(K k, V v) {
        V forcePut;
        synchronized (this.b) {
            forcePut = d().forcePut(k, v);
        }
        return forcePut;
    }

    @Override // com.google.common.collect.BiMap
    /* renamed from: inverse */
    public BiMap<V, K> mo35inverse() {
        BiMap<V, K> biMap;
        synchronized (this.b) {
            if (this.g == null) {
                this.g = new g4(d().mo35inverse(), this.b, this);
            }
            biMap = this.g;
        }
        return biMap;
    }

    @Override // a2.j.d.c.m4, java.util.Map
    public Set<V> values() {
        Set<V> set;
        synchronized (this.b) {
            if (this.f == null) {
                this.f = new u4(d().values(), this.b);
            }
            set = this.f;
        }
        return set;
    }

    public g4(BiMap biMap, Object obj, BiMap biMap2, b4 b4Var) {
        super(biMap, obj);
        this.g = null;
    }
}
