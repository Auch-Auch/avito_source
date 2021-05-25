package com.google.common.collect;

import a2.j.d.c.b5;
import a2.j.d.c.r2;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
@GwtIncompatible
public final class MutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    public final Map<Class<? extends B>, B> a;

    public class a extends ForwardingSet<Map.Entry<Class<? extends B>, B>> {

        /* renamed from: com.google.common.collect.MutableClassToInstanceMap$a$a  reason: collision with other inner class name */
        public class C0285a extends b5<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>> {
            public C0285a(a aVar, Iterator it) {
                super(it);
            }

            @Override // a2.j.d.c.b5
            public Object a(Object obj) {
                return new r2((Map.Entry) obj);
            }
        }

        public a() {
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            return new C0285a(this, mo147delegate().iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Set<Map.Entry<Class<? extends B>, B>> mo147delegate() {
            return MutableClassToInstanceMap.this.mo147delegate().entrySet();
        }
    }

    public static final class b<B> implements Serializable {
        private static final long serialVersionUID = 0;
        public final Map<Class<? extends B>, B> a;

        public b(Map<Class<? extends B>, B> map) {
            this.a = map;
        }

        public Object readResolve() {
            return MutableClassToInstanceMap.create(this.a);
        }
    }

    public MutableClassToInstanceMap(Map<Class<? extends B>, B> map) {
        this.a = (Map) Preconditions.checkNotNull(map);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap<>(new HashMap());
    }

    @CanIgnoreReturnValue
    public static <B, T extends B> T d(Class<T> cls, B b2) {
        return (T) Primitives.wrap(cls).cast(b2);
    }

    private Object writeReplace() {
        return new b(mo147delegate());
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new a();
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    public <T extends B> T getInstance(Class<T> cls) {
        return (T) d(cls, get(cls));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((Class<? extends Class<? extends B>>) ((Class) obj), (Class<? extends B>) obj2);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public void putAll(Map<? extends Class<? extends B>, ? extends B> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            d((Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: T extends B */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ClassToInstanceMap
    @CanIgnoreReturnValue
    public <T extends B> T putInstance(Class<T> cls, T t) {
        return (T) d(cls, put((Class<? extends Class<T>>) cls, (Class<T>) t));
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> map) {
        return new MutableClassToInstanceMap<>(map);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public Map<Class<? extends B>, B> mo147delegate() {
        return this.a;
    }

    @CanIgnoreReturnValue
    public B put(Class<? extends B> cls, B b2) {
        return (B) super.put((MutableClassToInstanceMap<B>) cls, (Class<? extends B>) d(cls, b2));
    }
}
