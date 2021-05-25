package com.google.common.collect;

import a2.j.d.c.b;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends b<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    public transient Class<K> f;
    public transient Class<V> g;

    public EnumBiMap(Class<K> cls, Class<V> cls2) {
        super(new EnumMap(cls), new EnumMap(cls2));
        this.f = cls;
        this.g = cls2;
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> cls, Class<V> cls2) {
        return new EnumBiMap<>(cls, cls2);
    }

    public static <K extends Enum<K>> Class<K> j(Map<K, ?> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).keyType();
        }
        if (map instanceof EnumHashBiMap) {
            return ((EnumHashBiMap) map).keyType();
        }
        Preconditions.checkArgument(!map.isEmpty());
        return map.keySet().iterator().next().getDeclaringClass();
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f = (Class) objectInputStream.readObject();
        this.g = (Class) objectInputStream.readObject();
        i(new EnumMap(this.f), new EnumMap(this.g));
        AppCompatDelegateImpl.i.z1(this, objectInputStream);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f);
        objectOutputStream.writeObject(this.g);
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

    @Override // a2.j.d.c.b
    public Object e(Object obj) {
        return (Enum) Preconditions.checkNotNull((Enum) obj);
    }

    @Override // a2.j.d.c.b, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
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

    @Override // a2.j.d.c.b, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    public Class<V> valueType() {
        return this.g;
    }

    @Override // a2.j.d.c.b, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> map) {
        Class<V> cls;
        Class j = j(map);
        if (map instanceof EnumBiMap) {
            cls = ((EnumBiMap) map).g;
        } else {
            Preconditions.checkArgument(!map.isEmpty());
            cls = map.values().iterator().next().getDeclaringClass();
        }
        EnumBiMap<K, V> create = create(j, cls);
        create.putAll(map);
        return create;
    }
}
