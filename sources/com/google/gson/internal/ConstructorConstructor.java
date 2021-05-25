package com.google.gson.internal;

import a2.j.f.a.c;
import a2.j.f.a.d;
import a2.j.f.a.e;
import a2.j.f.a.f;
import a2.j.f.a.g;
import a2.j.f.a.h;
import a2.j.f.a.i;
import a2.j.f.a.j;
import a2.j.f.a.k;
import a2.j.f.a.l;
import com.google.gson.InstanceCreator;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
public final class ConstructorConstructor {
    public final Map<Type, InstanceCreator<?>> a;
    public final ReflectionAccessor b = ReflectionAccessor.getInstance();

    public class a implements ObjectConstructor<T> {
        public final /* synthetic */ InstanceCreator a;
        public final /* synthetic */ Type b;

        public a(ConstructorConstructor constructorConstructor, InstanceCreator instanceCreator, Type type) {
            this.a = instanceCreator;
            this.b = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) this.a.createInstance(this.b);
        }
    }

    public class b implements ObjectConstructor<T> {
        public final /* synthetic */ InstanceCreator a;
        public final /* synthetic */ Type b;

        public b(ConstructorConstructor constructorConstructor, InstanceCreator instanceCreator, Type type) {
            this.a = instanceCreator;
            this.b = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) this.a.createInstance(this.b);
        }
    }

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.a = map;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        f fVar;
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        InstanceCreator<?> instanceCreator = this.a.get(type);
        if (instanceCreator != null) {
            return new a(this, instanceCreator, type);
        }
        InstanceCreator<?> instanceCreator2 = this.a.get(rawType);
        if (instanceCreator2 != null) {
            return new b(this, instanceCreator2, type);
        }
        ObjectConstructor<T> objectConstructor = null;
        try {
            Constructor<? super T> declaredConstructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.b.makeAccessible(declaredConstructor);
            }
            fVar = new f(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            fVar = null;
        }
        if (fVar != null) {
            return fVar;
        }
        if (Collection.class.isAssignableFrom(rawType)) {
            if (SortedSet.class.isAssignableFrom(rawType)) {
                objectConstructor = new g(this);
            } else if (EnumSet.class.isAssignableFrom(rawType)) {
                objectConstructor = new h(this, type);
            } else if (Set.class.isAssignableFrom(rawType)) {
                objectConstructor = new i(this);
            } else if (Queue.class.isAssignableFrom(rawType)) {
                objectConstructor = new j(this);
            } else {
                objectConstructor = new k(this);
            }
        } else if (Map.class.isAssignableFrom(rawType)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(rawType)) {
                objectConstructor = new l(this);
            } else if (ConcurrentMap.class.isAssignableFrom(rawType)) {
                objectConstructor = new a2.j.f.a.a(this);
            } else if (SortedMap.class.isAssignableFrom(rawType)) {
                objectConstructor = new a2.j.f.a.b(this);
            } else if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                objectConstructor = new d(this);
            } else {
                objectConstructor = new c(this);
            }
        }
        if (objectConstructor != null) {
            return objectConstructor;
        }
        return new e(this, rawType, type);
    }

    public String toString() {
        return this.a.toString();
    }
}
