package a2.j.d.c;

import a2.j.d.c.b3;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public final class z2<K, V> extends ImmutableBiMap<K, V> {
    public static final z2<Object, Object> k = new z2<>();
    public final transient Object f;
    @VisibleForTesting
    public final transient Object[] g;
    public final transient int h;
    public final transient int i;
    public final transient z2<V, K> j;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: a2.j.d.c.z2<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public z2() {
        this.f = null;
        this.g = new Object[0];
        this.h = 0;
        this.i = 0;
        this.j = this;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> a() {
        return new b3.a(this, this.g, this.h, this.i);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> c() {
        return new b3.b(this, new b3.c(this.g, this.h, this.i));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        return (V) b3.n(this.f, this.g, this.i, this.h, obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean h() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    /* renamed from: inverse */
    public BiMap mo35inverse() {
        return this.j;
    }

    @Override // java.util.Map
    public int size() {
        return this.i;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    /* renamed from: inverse  reason: collision with other method in class */
    public ImmutableBiMap<V, K> mo35inverse() {
        return this.j;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: a2.j.d.c.z2<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public z2(Object[] objArr, int i2) {
        this.g = objArr;
        this.i = i2;
        this.h = 0;
        int f2 = i2 >= 2 ? ImmutableSet.f(i2) : 0;
        this.f = b3.l(objArr, i2, f2, 0);
        Object l = b3.l(objArr, i2, f2, 1);
        z2<V, K> z2Var = (z2<V, K>) new ImmutableBiMap();
        z2Var.f = l;
        z2Var.g = objArr;
        z2Var.h = 1;
        z2Var.i = i2;
        z2Var.j = this;
        this.j = z2Var;
    }
}
