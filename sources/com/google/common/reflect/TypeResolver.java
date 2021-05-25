package com.google.common.reflect;

import a2.j.d.k.f;
import a2.j.d.k.i;
import a2.j.d.k.j;
import com.google.common.annotations.Beta;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.Typography;
@Beta
public final class TypeResolver {
    public final c a;

    public static class a extends i {
        public final /* synthetic */ Map b;
        public final /* synthetic */ Type c;

        public a(Map map, Type type) {
            this.b = map;
            this.c = type;
        }

        @Override // a2.j.d.k.i
        public void b(Class<?> cls) {
            if (!(this.c instanceof WildcardType)) {
                throw new IllegalArgumentException("No type mapping from " + cls + " to " + this.c);
            }
        }

        @Override // a2.j.d.k.i
        public void c(GenericArrayType genericArrayType) {
            Type type = this.c;
            if (!(type instanceof WildcardType)) {
                Type d = j.d(type);
                Preconditions.checkArgument(d != null, "%s is not an array type.", this.c);
                TypeResolver.a(this.b, genericArrayType.getGenericComponentType(), d);
            }
        }

        @Override // a2.j.d.k.i
        public void d(ParameterizedType parameterizedType) {
            Type type = this.c;
            if (!(type instanceof WildcardType)) {
                try {
                    ParameterizedType parameterizedType2 = (ParameterizedType) ParameterizedType.class.cast(type);
                    if (!(parameterizedType.getOwnerType() == null || parameterizedType2.getOwnerType() == null)) {
                        TypeResolver.a(this.b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
                    }
                    Preconditions.checkArgument(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.c);
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                    Preconditions.checkArgument(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
                    for (int i = 0; i < actualTypeArguments.length; i++) {
                        TypeResolver.a(this.b, actualTypeArguments[i], actualTypeArguments2[i]);
                    }
                } catch (ClassCastException unused) {
                    throw new IllegalArgumentException(type + " is not a " + ParameterizedType.class.getSimpleName());
                }
            }
        }

        @Override // a2.j.d.k.i
        public void e(TypeVariable<?> typeVariable) {
            this.b.put(new d(typeVariable), this.c);
        }

        @Override // a2.j.d.k.i
        public void f(WildcardType wildcardType) {
            Type type = this.c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                Preconditions.checkArgument(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.c);
                for (int i = 0; i < upperBounds.length; i++) {
                    TypeResolver.a(this.b, upperBounds[i], upperBounds2[i]);
                }
                for (int i2 = 0; i2 < lowerBounds.length; i2++) {
                    TypeResolver.a(this.b, lowerBounds[i2], lowerBounds2[i2]);
                }
            }
        }
    }

    public static final class b extends i {
        public final Map<d, Type> b = Maps.newHashMap();

        public static ImmutableMap<d, Type> g(Type type) {
            Preconditions.checkNotNull(type);
            b bVar = new b();
            bVar.a(type);
            return ImmutableMap.copyOf(bVar.b);
        }

        @Override // a2.j.d.k.i
        public void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // a2.j.d.k.i
        public void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Preconditions.checkState(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                d dVar = new d(typeParameters[i]);
                Type type = actualTypeArguments[i];
                if (!this.b.containsKey(dVar)) {
                    Type type2 = type;
                    while (true) {
                        if (type2 == null) {
                            this.b.put(dVar, type);
                            break;
                        }
                        boolean z = type2 instanceof TypeVariable;
                        d dVar2 = null;
                        if (z ? dVar.a((TypeVariable) type2) : false) {
                            while (type != null) {
                                type = this.b.remove(type instanceof TypeVariable ? new d((TypeVariable) type) : null);
                            }
                        } else {
                            Map<d, Type> map = this.b;
                            if (z) {
                                dVar2 = new d((TypeVariable) type2);
                            }
                            type2 = map.get(dVar2);
                        }
                    }
                }
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // a2.j.d.k.i
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // a2.j.d.k.i
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    public static final class d {
        public final TypeVariable<?> a;

        public d(TypeVariable<?> typeVariable) {
            this.a = (TypeVariable) Preconditions.checkNotNull(typeVariable);
        }

        public final boolean a(TypeVariable<?> typeVariable) {
            return this.a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.a.getName().equals(typeVariable.getName());
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return a(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.a.getGenericDeclaration(), this.a.getName());
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public TypeResolver() {
        this.a = new c();
    }

    public static void a(Map<d, Type> map, Type type, Type type2) {
        if (!type.equals(type2)) {
            new a(map, type2).a(type);
        }
    }

    public final Type[] b(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = resolveType(typeArr[i]);
        }
        return typeArr2;
    }

    public Type[] c(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = resolveType(typeArr[i]);
        }
        return typeArr;
    }

    public TypeResolver d(Map<d, ? extends Type> map) {
        c cVar = this.a;
        java.util.Objects.requireNonNull(cVar);
        ImmutableMap.Builder builder = ImmutableMap.builder();
        builder.putAll(cVar.a);
        for (Map.Entry<d, ? extends Type> entry : map.entrySet()) {
            d key = entry.getKey();
            Type type = (Type) entry.getValue();
            java.util.Objects.requireNonNull(key);
            Preconditions.checkArgument(!(type instanceof TypeVariable ? key.a((TypeVariable) type) : false), "Type variable %s bound to itself", key);
            builder.put(key, type);
        }
        return new TypeResolver(new c(builder.build()));
    }

    public Type resolveType(Type type) {
        Type type2;
        Preconditions.checkNotNull(type);
        if (type instanceof TypeVariable) {
            c cVar = this.a;
            TypeVariable<?> typeVariable = (TypeVariable) type;
            java.util.Objects.requireNonNull(cVar);
            return cVar.a(typeVariable, new a2.j.d.k.e(cVar, typeVariable, cVar));
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType == null) {
                type2 = null;
            } else {
                type2 = resolveType(ownerType);
            }
            return j.g(type2, (Class) resolveType(parameterizedType.getRawType()), b(parameterizedType.getActualTypeArguments()));
        } else if (type instanceof GenericArrayType) {
            return j.e(resolveType(((GenericArrayType) type).getGenericComponentType()));
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new j.C0076j(b(wildcardType.getLowerBounds()), b(wildcardType.getUpperBounds()));
        }
    }

    public TypeResolver where(Type type, Type type2) {
        HashMap newHashMap = Maps.newHashMap();
        a(newHashMap, (Type) Preconditions.checkNotNull(type), (Type) Preconditions.checkNotNull(type2));
        return d(newHashMap);
    }

    public static class c {
        public final ImmutableMap<d, Type> a;

        public c() {
            this.a = ImmutableMap.of();
        }

        public Type a(TypeVariable<?> typeVariable, c cVar) {
            Type type = this.a.get(new d(typeVariable));
            if (type != null) {
                return new TypeResolver(cVar, null).resolveType(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] b = new TypeResolver(cVar, null).b(bounds);
            if (!j.f.a || !Arrays.equals(bounds, b)) {
                return j.f(typeVariable.getGenericDeclaration(), typeVariable.getName(), b);
            }
            return typeVariable;
        }

        public c(ImmutableMap<d, Type> immutableMap) {
            this.a = immutableMap;
        }
    }

    public static class e {
        public static final e b = new e();
        public final AtomicInteger a;

        public e() {
            this.a = new AtomicInteger();
        }

        public final Type a(Type type) {
            Type type2;
            Preconditions.checkNotNull(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return j.e(new e(this.a).a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    actualTypeArguments[i] = new f(this, this.a, typeParameters[i]).a(actualTypeArguments[i]);
                }
                e eVar = new e(this.a);
                Type ownerType = parameterizedType.getOwnerType();
                if (ownerType == null) {
                    type2 = null;
                } else {
                    type2 = eVar.a(ownerType);
                }
                return j.g(type2, cls, actualTypeArguments);
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        public TypeVariable<?> b(Type[] typeArr) {
            StringBuilder L = a2.b.a.a.a.L("capture#");
            L.append(this.a.incrementAndGet());
            L.append("-of ? extends ");
            L.append(Joiner.on((char) Typography.amp).join(typeArr));
            return j.f(e.class, L.toString(), typeArr);
        }

        public e(AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }

        public e(AtomicInteger atomicInteger, a aVar) {
            this.a = atomicInteger;
        }
    }

    public TypeResolver(c cVar) {
        this.a = cVar;
    }

    public TypeResolver(c cVar, a aVar) {
        this.a = cVar;
    }
}
