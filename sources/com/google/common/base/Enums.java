package com.google.common.base;

import a2.j.d.a.i;
import a2.j.d.a.j;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class Enums {
    @GwtIncompatible
    public static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> a = new WeakHashMap();

    public static final class a<T extends Enum<T>> extends Converter<String, T> implements Serializable {
        private static final long serialVersionUID = 0;
        public final Class<T> c;

        public a(Class<T> cls) {
            this.c = (Class) Preconditions.checkNotNull(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Converter
        public String doBackward(Object obj) {
            return ((Enum) obj).name();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Converter
        public Object doForward(String str) {
            return Enum.valueOf(this.c, str);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof a) {
                return this.c.equals(((a) obj).c);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.c.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            return a2.b.a.a.a.D2(this.c, a2.b.a.a.a.L("Enums.stringConverter("), ".class)");
        }
    }

    @GwtIncompatible
    public static Field getField(Enum<?> r1) {
        try {
            return r1.getDeclaringClass().getDeclaredField(r1.name());
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> cls, String str) {
        HashMap hashMap;
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(str);
        i iVar = j.a;
        Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> map = a;
        synchronized (map) {
            Map<String, WeakReference<? extends Enum<?>>> map2 = map.get(cls);
            hashMap = map2;
            if (map2 == null) {
                HashMap hashMap2 = new HashMap();
                Iterator it = EnumSet.allOf(cls).iterator();
                while (it.hasNext()) {
                    Enum r3 = (Enum) it.next();
                    hashMap2.put(r3.name(), new WeakReference(r3));
                }
                a.put(cls, hashMap2);
                hashMap = hashMap2;
            }
        }
        WeakReference<? extends Enum<?>> weakReference = hashMap.get(str);
        return weakReference == null ? Optional.absent() : Optional.of(cls.cast(weakReference.get()));
    }

    public static <T extends Enum<T>> Converter<String, T> stringConverter(Class<T> cls) {
        return new a(cls);
    }
}
