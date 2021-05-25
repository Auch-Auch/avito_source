package com.google.common.collect;

import a2.j.d.c.b;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class EnumHashBiMap<K extends Enum<K>, V> extends b<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    public transient Class<K> f;

    public EnumHashBiMap(Class<K> cls) {
        super(new EnumMap(cls), Maps.newHashMapWithExpectedSize(cls.getEnumConstants().length));
        this.f = cls;
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> cls) {
        return new EnumHashBiMap<>(cls);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f = (Class) objectInputStream.readObject();
        i(new EnumMap(this.f), new HashMap((this.f.getEnumConstants().length * 3) / 2));
        AppCompatDelegateImpl.i.z1(this, objectInputStream);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f);
        AppCompatDelegateImpl.i.p2(this, objectOutputStream);
    }

    @Override // a2.j.d.c.b, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // a2.j.d.c.b, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object obj) {
        return super.containsValue(obj);
    }

    @Override // a2.j.d.c.b
    public Object d(Object obj) {
        return (Enum) Preconditions.checkNotNull((Enum) obj);
    }

    @Override // a2.j.d.c.b, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.EnumHashBiMap<K extends java.lang.Enum<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.b, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object forcePut(Object obj, @NullableDecl Object obj2) {
        return forcePut((EnumHashBiMap<K, V>) ((Enum) obj), (Enum) obj2);
    }

    @Override // a2.j.d.c.b, com.google.common.collect.BiMap
    /* renamed from: inverse */
    public /* bridge */ /* synthetic */ BiMap mo35inverse() {
        return super.mo35inverse();
    }

    @Override // a2.j.d.c.b, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public Class<K> keyType() {
        return this.f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.EnumHashBiMap<K extends java.lang.Enum<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.b, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(Object obj, @NullableDecl Object obj2) {
        return put((EnumHashBiMap<K, V>) ((Enum) obj), (Enum) obj2);
    }

    @Override // a2.j.d.c.b, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @Override // a2.j.d.c.b, com.google.common.collect.ForwardingMap, java.util.Map
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object remove(@NullableDecl Object obj) {
        return super.remove(obj);
    }

    @Override // a2.j.d.c.b, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> map) {
        EnumHashBiMap<K, V> create = create(EnumBiMap.j(map));
        create.putAll(map);
        return create;
    }

    @CanIgnoreReturnValue
    public V forcePut(K k, @NullableDecl V v) {
        return (V) super.forcePut((EnumHashBiMap<K, V>) k, (K) v);
    }

    @CanIgnoreReturnValue
    public V put(K k, @NullableDecl V v) {
        return (V) super.put((EnumHashBiMap<K, V>) k, (K) v);
    }
}
