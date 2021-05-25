package com.google.common.reflect;

import a2.j.d.k.j;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Primitives;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeResolver;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public abstract class TypeToken<T> extends a2.j.d.k.d<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;
    public final Type a;
    @MonotonicNonNullDecl
    public transient TypeResolver b;
    @MonotonicNonNullDecl
    public transient TypeResolver c;

    public class a extends Invokable.b<T> {
        public a(Method method) {
            super(method);
        }

        @Override // com.google.common.reflect.Invokable.b, com.google.common.reflect.Invokable
        public Type[] a() {
            TypeResolver h = TypeToken.this.h();
            Type[] genericExceptionTypes = this.c.getGenericExceptionTypes();
            h.c(genericExceptionTypes);
            return genericExceptionTypes;
        }

        @Override // com.google.common.reflect.Invokable.b, com.google.common.reflect.Invokable
        public Type[] b() {
            TypeResolver i = TypeToken.this.i();
            Type[] genericParameterTypes = this.c.getGenericParameterTypes();
            i.c(genericParameterTypes);
            return genericParameterTypes;
        }

        @Override // com.google.common.reflect.Invokable.b, com.google.common.reflect.Invokable
        public Type c() {
            return TypeToken.this.h().resolveType(this.c.getGenericReturnType());
        }

        @Override // com.google.common.reflect.Invokable, a2.j.d.k.a
        public TypeToken<T> getOwnerType() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.Invokable, a2.j.d.k.a, java.lang.Object
        public String toString() {
            return TypeToken.this + "." + super.toString();
        }
    }

    public class b extends Invokable.a<T> {
        public b(Constructor constructor) {
            super(constructor);
        }

        @Override // com.google.common.reflect.Invokable.a, com.google.common.reflect.Invokable
        public Type[] a() {
            TypeResolver h = TypeToken.this.h();
            Type[] genericExceptionTypes = this.c.getGenericExceptionTypes();
            h.c(genericExceptionTypes);
            return genericExceptionTypes;
        }

        @Override // com.google.common.reflect.Invokable.a, com.google.common.reflect.Invokable
        public Type[] b() {
            TypeResolver i = TypeToken.this.i();
            Type[] b = super.b();
            i.c(b);
            return b;
        }

        @Override // com.google.common.reflect.Invokable.a, com.google.common.reflect.Invokable
        public Type c() {
            return TypeToken.this.h().resolveType(super.c());
        }

        @Override // com.google.common.reflect.Invokable, a2.j.d.k.a
        public TypeToken<T> getOwnerType() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.Invokable, a2.j.d.k.a, java.lang.Object
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(TypeToken.this);
            sb.append("(");
            Joiner on = Joiner.on(", ");
            TypeResolver i = TypeToken.this.i();
            Type[] b = super.b();
            i.c(b);
            return a2.b.a.a.a.t(sb, on.join(b), ")");
        }
    }

    public class c extends a2.j.d.k.i {
        public c() {
        }

        @Override // a2.j.d.k.i
        public void c(GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        @Override // a2.j.d.k.i
        public void d(ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        @Override // a2.j.d.k.i
        public void e(TypeVariable<?> typeVariable) {
            throw new IllegalArgumentException(TypeToken.this.a + "contains a type variable and is not safe for the operation");
        }

        @Override // a2.j.d.k.i
        public void f(WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    public class d extends a2.j.d.k.i {
        public final /* synthetic */ ImmutableSet.Builder b;

        public d(TypeToken typeToken, ImmutableSet.Builder builder) {
            this.b = builder;
        }

        @Override // a2.j.d.k.i
        public void b(Class<?> cls) {
            this.b.add((ImmutableSet.Builder) cls);
        }

        @Override // a2.j.d.k.i
        public void c(GenericArrayType genericArrayType) {
            ImmutableSet.Builder builder = this.b;
            Class<? super Object> rawType = TypeToken.of(genericArrayType.getGenericComponentType()).getRawType();
            Function<Type, String> function = a2.j.d.k.j.a;
            builder.add((ImmutableSet.Builder) Array.newInstance(rawType, 0).getClass());
        }

        @Override // a2.j.d.k.i
        public void d(ParameterizedType parameterizedType) {
            this.b.add((ImmutableSet.Builder) ((Class) parameterizedType.getRawType()));
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

    public static class e {
        public final Type[] a;
        public final boolean b;

        public e(Type[] typeArr, boolean z) {
            this.a = typeArr;
            this.b = z;
        }

        public boolean a(Type type) {
            for (Type type2 : this.a) {
                boolean isSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z = this.b;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.b;
        }

        public boolean b(Type type) {
            TypeToken<?> of = TypeToken.of(type);
            for (Type type2 : this.a) {
                boolean isSubtypeOf = of.isSubtypeOf(type2);
                boolean z = this.b;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.b;
        }
    }

    public static final class h<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        public h(Type type) {
            super(type, null);
        }
    }

    public static abstract class i<K> {
        public static final i<TypeToken<?>> a = new a();
        public static final i<Class<?>> b = new b();

        public static class a extends i<TypeToken<?>> {
            public a() {
                super(null);
            }

            /* Return type fixed from 'java.lang.Iterable' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.reflect.TypeToken.i
            public Iterable<? extends TypeToken<?>> c(TypeToken<?> typeToken) {
                TypeToken<?> typeToken2 = typeToken;
                Type type = typeToken2.a;
                if (type instanceof TypeVariable) {
                    return typeToken2.c(((TypeVariable) type).getBounds());
                }
                if (type instanceof WildcardType) {
                    return typeToken2.c(((WildcardType) type).getUpperBounds());
                }
                ImmutableList.Builder builder = ImmutableList.builder();
                for (Type type2 : typeToken2.getRawType().getGenericInterfaces()) {
                    builder.add((ImmutableList.Builder) typeToken2.n(type2));
                }
                return builder.build();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.reflect.TypeToken.i
            public Class d(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.reflect.TypeToken.i
            @NullableDecl
            public TypeToken<?> e(TypeToken<?> typeToken) {
                TypeToken<?> of;
                TypeToken<?> typeToken2 = typeToken;
                Type type = typeToken2.a;
                if (type instanceof TypeVariable) {
                    of = TypeToken.of(((TypeVariable) type).getBounds()[0]);
                    if (of.getRawType().isInterface()) {
                        return null;
                    }
                } else if (type instanceof WildcardType) {
                    of = TypeToken.of(((WildcardType) type).getUpperBounds()[0]);
                    if (of.getRawType().isInterface()) {
                        return null;
                    }
                } else {
                    Type genericSuperclass = typeToken2.getRawType().getGenericSuperclass();
                    if (genericSuperclass == null) {
                        return null;
                    }
                    return typeToken2.n(genericSuperclass);
                }
                return of;
            }
        }

        public static class b extends i<Class<?>> {
            public b() {
                super(null);
            }

            /* Return type fixed from 'java.lang.Iterable' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.reflect.TypeToken.i
            public Iterable<? extends Class<?>> c(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.reflect.TypeToken.i
            public Class d(Class<?> cls) {
                return cls;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.reflect.TypeToken.i
            @NullableDecl
            public Class<?> e(Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        public static class c<K> extends i<K> {
            public final i<K> c;

            public c(i<K> iVar) {
                super(null);
                this.c = iVar;
            }

            @Override // com.google.common.reflect.TypeToken.i
            public Class<?> d(K k) {
                return this.c.d(k);
            }

            @Override // com.google.common.reflect.TypeToken.i
            public K e(K k) {
                return this.c.e(k);
            }
        }

        public i(a aVar) {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public final int a(K k, Map<? super K, Integer> map) {
            Integer num = map.get(k);
            if (num != null) {
                return num.intValue();
            }
            boolean isInterface = d(k).isInterface();
            Iterator<? extends K> it = c(k).iterator();
            int i = isInterface;
            while (it.hasNext()) {
                i = Math.max(i, a(it.next(), map));
            }
            K e = e(k);
            int i2 = i;
            if (e != null) {
                i2 = Math.max(i, a(e, map));
            }
            int i3 = (i2 == 1 ? 1 : 0) + 1;
            map.put(k, Integer.valueOf(i3));
            return i3;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.reflect.TypeToken$i<K> */
        /* JADX WARN: Multi-variable type inference failed */
        public ImmutableList<K> b(Iterable<? extends K> iterable) {
            HashMap newHashMap = Maps.newHashMap();
            Iterator<? extends K> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next(), newHashMap);
            }
            return new a2.j.d.k.h(Ordering.natural().reverse(), newHashMap).immutableSortedCopy(newHashMap.keySet());
        }

        public abstract Iterable<? extends K> c(K k);

        public abstract Class<?> d(K k);

        @NullableDecl
        public abstract K e(K k);
    }

    public enum j implements Predicate<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD {
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.base.Predicate
            public boolean apply(TypeToken<?> typeToken) {
                Type type = typeToken.a;
                return !(type instanceof TypeVariable) && !(type instanceof WildcardType);
            }
        },
        INTERFACE_ONLY {
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.base.Predicate
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        };

        /* access modifiers changed from: public */
        j(a aVar) {
        }
    }

    public TypeToken() {
        Type a3 = a();
        this.a = a3;
        Preconditions.checkState(!(a3 instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", a3);
    }

    public static e b(Type[] typeArr) {
        return new e(typeArr, true);
    }

    public static Type d(TypeVariable<?> typeVariable, Type type) {
        if (type instanceof WildcardType) {
            return e(typeVariable, (WildcardType) type);
        }
        return f(type);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    public static WildcardType e(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        Type[] upperBounds = wildcardType.getUpperBounds();
        for (Type type : upperBounds) {
            if (!b(bounds).a(type)) {
                arrayList.add(f(type));
            }
        }
        return new j.C0076j(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    public static Type f(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return type instanceof GenericArrayType ? a2.j.d.k.j.e(f(((GenericArrayType) type).getGenericComponentType())) : type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
            actualTypeArguments[i2] = d(typeParameters[i2], actualTypeArguments[i2]);
        }
        return a2.j.d.k.j.g(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new h(cls);
    }

    @VisibleForTesting
    public static <T> TypeToken<? extends T> p(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(a2.j.d.k.j.e(p(cls.getComponentType()).a));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : p(cls.getEnclosingClass()).a;
        return (typeParameters.length > 0 || !(type == null || type == cls.getEnclosingClass())) ? (TypeToken<? extends T>) of(a2.j.d.k.j.g(type, cls, typeParameters)) : of((Class) cls);
    }

    public final ImmutableList<TypeToken<? super T>> c(Type[] typeArr) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.getRawType().isInterface()) {
                builder.add((ImmutableList.Builder) of);
            }
        }
        return builder.build();
    }

    public final Invokable<T, T> constructor(Constructor<?> constructor) {
        Preconditions.checkArgument(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new b(constructor);
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof TypeToken) {
            return this.a.equals(((TypeToken) obj).a);
        }
        return false;
    }

    @NullableDecl
    public final TypeToken<?> getComponentType() {
        Type d2 = a2.j.d.k.j.d(this.a);
        if (d2 == null) {
            return null;
        }
        return of(d2);
    }

    public final Class<? super T> getRawType() {
        return j().mo99iterator().next();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0082, code lost:
        if (getRawType().getTypeParameters().length != 0) goto L_0x00a4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.common.reflect.TypeToken<? extends T> getSubtype(java.lang.Class<?> r4) {
        /*
            r3 = this;
            java.lang.reflect.Type r0 = r3.a
            boolean r0 = r0 instanceof java.lang.reflect.TypeVariable
            r0 = r0 ^ 1
            java.lang.String r1 = "Cannot get subtype of type variable <%s>"
            com.google.common.base.Preconditions.checkArgument(r0, r1, r3)
            java.lang.reflect.Type r0 = r3.a
            boolean r1 = r0 instanceof java.lang.reflect.WildcardType
            if (r1 == 0) goto L_0x0040
            java.lang.reflect.WildcardType r0 = (java.lang.reflect.WildcardType) r0
            java.lang.reflect.Type[] r0 = r0.getLowerBounds()
            int r1 = r0.length
            if (r1 <= 0) goto L_0x0026
            r1 = 0
            r0 = r0[r1]
            com.google.common.reflect.TypeToken r0 = of(r0)
            com.google.common.reflect.TypeToken r4 = r0.getSubtype(r4)
            return r4
        L_0x0026:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r4 = " isn't a subclass of "
            r1.append(r4)
            r1.append(r3)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x0040:
            boolean r0 = r3.isArray()
            if (r0 == 0) goto L_0x005f
            com.google.common.reflect.TypeToken r0 = r3.getComponentType()
            java.lang.Class r4 = r4.getComponentType()
            com.google.common.reflect.TypeToken r4 = r0.getSubtype(r4)
            java.lang.reflect.Type r4 = r4.a
            a2.j.d.k.j$e r0 = a2.j.d.k.j.e.JAVA7
            java.lang.reflect.Type r4 = r0.b(r4)
            com.google.common.reflect.TypeToken r4 = of(r4)
            return r4
        L_0x005f:
            java.lang.Class r0 = r3.getRawType()
            boolean r0 = r0.isAssignableFrom(r4)
            java.lang.String r1 = "%s isn't a subclass of %s"
            com.google.common.base.Preconditions.checkArgument(r0, r1, r4, r3)
            java.lang.reflect.Type r0 = r3.a
            boolean r0 = r0 instanceof java.lang.Class
            if (r0 == 0) goto L_0x0085
            java.lang.reflect.TypeVariable[] r0 = r4.getTypeParameters()
            int r0 = r0.length
            if (r0 == 0) goto L_0x00a4
            java.lang.Class r0 = r3.getRawType()
            java.lang.reflect.TypeVariable[] r0 = r0.getTypeParameters()
            int r0 = r0.length
            if (r0 == 0) goto L_0x0085
            goto L_0x00a4
        L_0x0085:
            com.google.common.reflect.TypeToken r4 = p(r4)
            java.lang.Class r0 = r3.getRawType()
            com.google.common.reflect.TypeToken r0 = r4.getSupertype(r0)
            java.lang.reflect.Type r0 = r0.a
            com.google.common.reflect.TypeResolver r1 = new com.google.common.reflect.TypeResolver
            r1.<init>()
            java.lang.reflect.Type r2 = r3.a
            com.google.common.reflect.TypeResolver r0 = r1.where(r0, r2)
            java.lang.reflect.Type r4 = r4.a
            java.lang.reflect.Type r4 = r0.resolveType(r4)
        L_0x00a4:
            com.google.common.reflect.TypeToken r4 = of(r4)
            boolean r0 = r4.isSubtypeOf(r3)
            java.lang.String r1 = "%s does not appear to be a subtype of %s"
            com.google.common.base.Preconditions.checkArgument(r0, r1, r4, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.reflect.TypeToken.getSubtype(java.lang.Class):com.google.common.reflect.TypeToken");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.google.common.reflect.TypeToken */
    /* JADX WARN: Multi-variable type inference failed */
    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        Preconditions.checkArgument(o(cls), "%s is not a super class of %s", cls, this);
        Type type = this.a;
        if (type instanceof TypeVariable) {
            return l(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return l(cls, ((WildcardType) type).getUpperBounds());
        }
        if (!cls.isArray()) {
            return (TypeToken<? super T>) n(p(cls).a);
        }
        return (TypeToken<? super T>) of(j.e.JAVA7.b(((TypeToken) Preconditions.checkNotNull(getComponentType(), "%s isn't a super type of %s", cls, this)).getSupertype(cls.getComponentType()).a));
    }

    public final Type getType() {
        return this.a;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public final TypeResolver h() {
        TypeResolver typeResolver = this.c;
        if (typeResolver != null) {
            return typeResolver;
        }
        TypeResolver d2 = new TypeResolver().d(TypeResolver.b.g(this.a));
        this.c = d2;
        return d2;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    public final TypeResolver i() {
        TypeResolver typeResolver = this.b;
        if (typeResolver != null) {
            return typeResolver;
        }
        TypeResolver d2 = new TypeResolver().d(TypeResolver.b.g(TypeResolver.e.b.a(this.a)));
        this.b = d2;
        return d2;
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        Type type = this.a;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final ImmutableSet<Class<? super T>> j() {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        new d(this, builder).a(this.a);
        return builder.build();
    }

    public final TypeToken<? super T> l(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) of.getSupertype(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    @CanIgnoreReturnValue
    public final TypeToken<T> m() {
        new c().a(this.a);
        return this;
    }

    public final Invokable<T, Object> method(Method method) {
        Preconditions.checkArgument(o(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new a(method);
    }

    public final TypeToken<?> n(Type type) {
        TypeToken<?> of = of(h().resolveType(type));
        of.c = this.c;
        of.b = this.b;
        return of;
    }

    public final boolean o(Class<?> cls) {
        UnmodifiableIterator<Class<? super T>> it = j().mo99iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    public final TypeToken<?> resolveType(Type type) {
        Preconditions.checkNotNull(type);
        return of(i().resolveType(type));
    }

    @Override // java.lang.Object
    public String toString() {
        return a2.j.d.k.j.h(this.a);
    }

    public final TypeToken<T> unwrap() {
        return Primitives.allWrapperTypes().contains(this.a) ? of(Primitives.unwrap((Class) this.a)) : this;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, TypeToken<X> typeToken) {
        return new h(new TypeResolver().d(ImmutableMap.of(new TypeResolver.d(typeParameter.a), typeToken.a)).resolveType(this.a));
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? of(Primitives.wrap((Class) this.a)) : this;
    }

    public Object writeReplace() {
        return of(new TypeResolver().resolveType(this.a));
    }

    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        @MonotonicNonNullDecl
        public transient ImmutableSet<TypeToken<? super T>> a;

        public TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new f(null);
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new g(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) i.b.b(TypeToken.this.j()));
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Set<TypeToken<? super T>> mo147delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.a;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> set = FluentIterable.from(i.a.b(ImmutableList.of(TypeToken.this))).filter(j.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.a = set;
            return set;
        }
    }

    public final class f extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        @MonotonicNonNullDecl
        public transient ImmutableSet<TypeToken<? super T>> c;

        public f(a aVar) {
            super();
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            i<Class<?>> iVar = i.b;
            return ImmutableSet.copyOf((Collection) new a2.j.d.k.g(iVar, iVar).b(TypeToken.this.j()));
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Set<TypeToken<? super T>> mo147delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.c;
            if (immutableSet != null) {
                return immutableSet;
            }
            i<TypeToken<?>> iVar = i.a;
            ImmutableSet<TypeToken<? super T>> set = FluentIterable.from(new a2.j.d.k.g(iVar, iVar).b(ImmutableList.of(TypeToken.this))).filter(j.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.c = set;
            return set;
        }
    }

    public final class g extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        public final transient TypeToken<T>.TypeSet c;
        @MonotonicNonNullDecl
        public transient ImmutableSet<TypeToken<? super T>> d;

        public class a implements Predicate<Class<?>> {
            public a(g gVar) {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.base.Predicate
            public boolean apply(Class<?> cls) {
                return cls.isInterface();
            }
        }

        public g(TypeToken<T>.TypeSet typeSet) {
            super();
            this.c = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return FluentIterable.from(i.b.b(TypeToken.this.j())).filter(new a(this)).toSet();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Set<TypeToken<? super T>> mo147delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.d;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> set = FluentIterable.from(this.c).filter(j.INTERFACE_ONLY).toSet();
            this.d = set;
            return set;
        }
    }

    public static TypeToken<?> of(Type type) {
        return new h(type);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0127, code lost:
        if (r5 != false) goto L_0x0129;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x013e A[LOOP:0: B:35:0x00c3->B:61:0x013e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x019c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isSubtypeOf(java.lang.reflect.Type r13) {
        /*
        // Method dump skipped, instructions count: 474
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.reflect.TypeToken.isSubtypeOf(java.lang.reflect.Type):boolean");
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public TypeToken(Class<?> cls) {
        Type a3 = a();
        if (a3 instanceof Class) {
            this.a = a3;
        } else {
            this.a = new TypeResolver().d(TypeResolver.b.g(cls)).resolveType(a3);
        }
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, Class<X> cls) {
        return where(typeParameter, of((Class) cls));
    }

    public TypeToken(Type type, a aVar) {
        this.a = (Type) Preconditions.checkNotNull(type);
    }
}
