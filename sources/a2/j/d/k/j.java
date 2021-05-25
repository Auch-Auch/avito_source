package a2.j.d.k;

import com.avito.android.BuildConfig;
import com.avito.android.lib.design.input.FormatterType;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.reflect.Reflection;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.Typography;
import okhttp3.HttpUrl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class j {
    public static final Function<Type, String> a = new a();
    public static final Joiner b = Joiner.on(", ").useForNull(BuildConfig.ADJUST_DEFAULT_TRACKER);

    public static class a implements Function<Type, String> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Function
        public String apply(Type type) {
            return e.e.c(type);
        }
    }

    public static class b extends i {
        public final /* synthetic */ AtomicReference b;

        public b(AtomicReference atomicReference) {
            this.b = atomicReference;
        }

        @Override // a2.j.d.k.i
        public void b(Class<?> cls) {
            this.b.set(cls.getComponentType());
        }

        @Override // a2.j.d.k.i
        public void c(GenericArrayType genericArrayType) {
            this.b.set(genericArrayType.getGenericComponentType());
        }

        @Override // a2.j.d.k.i
        public void e(TypeVariable<?> typeVariable) {
            this.b.set(j.a(typeVariable.getBounds()));
        }

        @Override // a2.j.d.k.i
        public void f(WildcardType wildcardType) {
            this.b.set(j.a(wildcardType.getUpperBounds()));
        }
    }

    public enum c {
        OWNED_BY_ENCLOSING_CLASS {
            @Override // a2.j.d.k.j.c
            @NullableDecl
            public Class<?> a(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER {
            @Override // a2.j.d.k.j.c
            @NullableDecl
            public Class<?> a(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };
        
        public static final c c;

        /* access modifiers changed from: public */
        static {
            ParameterizedType parameterizedType = (ParameterizedType) l.class.getGenericSuperclass();
            c[] values = values();
            for (int i = 0; i < 2; i++) {
                c cVar = values[i];
                if (cVar.a(k.class) == parameterizedType.getOwnerType()) {
                    c = cVar;
                    return;
                }
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: public */
        c(a aVar) {
        }

        @NullableDecl
        public abstract Class<?> a(Class<?> cls);
    }

    public static final class d implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        public final Type a;

        public d(Type type) {
            this.a = e.e.e(type);
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return Objects.equal(this.a, ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            return j.h(this.a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    public enum e {
        JAVA6 {
            @Override // a2.j.d.k.j.e
            public Type b(Type type) {
                return new d(type);
            }

            @Override // a2.j.d.k.j.e
            public Type e(Type type) {
                Preconditions.checkNotNull(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new d(cls.getComponentType()) : type;
            }
        },
        JAVA7 {
            @Override // a2.j.d.k.j.e
            public Type b(Type type) {
                if (!(type instanceof Class)) {
                    return new d(type);
                }
                Function<Type, String> function = j.a;
                return Array.newInstance((Class) type, 0).getClass();
            }

            @Override // a2.j.d.k.j.e
            public Type e(Type type) {
                return (Type) Preconditions.checkNotNull(type);
            }
        },
        JAVA8 {
            @Override // a2.j.d.k.j.e
            public Type b(Type type) {
                return e.JAVA7.b(type);
            }

            @Override // a2.j.d.k.j.e
            public String c(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                }
            }

            @Override // a2.j.d.k.j.e
            public Type e(Type type) {
                return e.JAVA7.e(type);
            }
        },
        JAVA9 {
            @Override // a2.j.d.k.j.e
            public boolean a() {
                return false;
            }

            @Override // a2.j.d.k.j.e
            public Type b(Type type) {
                return e.JAVA8.b(type);
            }

            @Override // a2.j.d.k.j.e
            public String c(Type type) {
                return e.JAVA8.c(type);
            }

            @Override // a2.j.d.k.j.e
            public Type e(Type type) {
                return e.JAVA8.e(type);
            }
        };
        
        public static final e e;

        /* renamed from: a2.j.d.k.j$e$e  reason: collision with other inner class name */
        public static class C0075e extends d<Map.Entry<String, int[][]>> {
        }

        public static class f extends d<int[]> {
        }

        /* access modifiers changed from: public */
        static {
            a aVar;
            b bVar;
            c cVar;
            d dVar;
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new C0075e().a().toString().contains("java.util.Map.java.util.Map")) {
                    e = cVar;
                } else {
                    e = dVar;
                }
            } else if (new f().a() instanceof Class) {
                e = bVar;
            } else {
                e = aVar;
            }
        }

        /* access modifiers changed from: public */
        e(a aVar) {
        }

        public boolean a() {
            return true;
        }

        public abstract Type b(Type type);

        public String c(Type type) {
            return j.h(type);
        }

        public final ImmutableList<Type> d(Type[] typeArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (Type type : typeArr) {
                builder.add((ImmutableList.Builder) e(type));
            }
            return builder.build();
        }

        public abstract Type e(Type type);
    }

    public static final class f<X> {
        public static final boolean a = (!f.class.getTypeParameters()[0].equals(j.f(f.class, "X", new Type[0])));
    }

    public static final class g implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        @NullableDecl
        public final Type a;
        public final ImmutableList<Type> b;
        public final Class<?> c;

        public g(@NullableDecl Type type, Class<?> cls, Type[] typeArr) {
            Preconditions.checkNotNull(cls);
            Preconditions.checkArgument(typeArr.length == cls.getTypeParameters().length);
            j.b(typeArr, "type parameter");
            this.a = type;
            this.c = cls;
            this.b = e.e.d(typeArr);
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (!this.c.equals(parameterizedType.getRawType()) || !Objects.equal(this.a, parameterizedType.getOwnerType()) || !Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return false;
            }
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return j.c(this.b);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.c;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Type type = this.a;
            return ((type == null ? 0 : type.hashCode()) ^ this.b.hashCode()) ^ this.c.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.a != null) {
                e eVar = e.e;
                if (eVar.a()) {
                    sb.append(eVar.c(this.a));
                    sb.append(FormatterType.defaultDecimalSeparator);
                }
            }
            sb.append(this.c.getName());
            sb.append(Typography.less);
            Joiner joiner = j.b;
            ImmutableList<Type> immutableList = this.b;
            Function<Type, String> function = j.a;
            sb.append(joiner.join(Iterables.transform(immutableList, j.a)));
            sb.append(Typography.greater);
            return sb.toString();
        }
    }

    public static final class h<D extends GenericDeclaration> {
        public final D a;
        public final String b;
        public final ImmutableList<Type> c;

        public h(D d, String str, Type[] typeArr) {
            j.b(typeArr, "bound for type variable");
            this.a = (D) ((GenericDeclaration) Preconditions.checkNotNull(d));
            this.b = (String) Preconditions.checkNotNull(str);
            this.c = ImmutableList.copyOf(typeArr);
        }

        public boolean equals(Object obj) {
            if (f.a) {
                if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof i)) {
                    return false;
                }
                h<?> hVar = ((i) Proxy.getInvocationHandler(obj)).a;
                if (!this.b.equals(hVar.b) || !this.a.equals(hVar.a) || !this.c.equals(hVar.c)) {
                    return false;
                }
                return true;
            } else if (!(obj instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) obj;
                if (!this.b.equals(typeVariable.getName()) || !this.a.equals(typeVariable.getGenericDeclaration())) {
                    return false;
                }
                return true;
            }
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        public String toString() {
            return this.b;
        }
    }

    public static final class i implements InvocationHandler {
        public static final ImmutableMap<String, Method> b;
        public final h<?> a;

        static {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            Method[] methods = h.class.getMethods();
            for (Method method : methods) {
                if (method.getDeclaringClass().equals(h.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.put(method.getName(), method);
                }
            }
            b = builder.build();
        }

        public i(h<?> hVar) {
            this.a = hVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = b.get(name);
            if (method2 != null) {
                try {
                    return method2.invoke(this.a, objArr);
                } catch (InvocationTargetException e) {
                    throw e.getCause();
                }
            } else {
                throw new UnsupportedOperationException(name);
            }
        }
    }

    /* renamed from: a2.j.d.k.j$j  reason: collision with other inner class name */
    public static final class C0076j implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        public final ImmutableList<Type> a;
        public final ImmutableList<Type> b;

        public C0076j(Type[] typeArr, Type[] typeArr2) {
            j.b(typeArr, "lower bound for wildcard");
            j.b(typeArr2, "upper bound for wildcard");
            e eVar = e.e;
            this.a = eVar.d(typeArr);
            this.b = eVar.d(typeArr2);
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            if (!this.a.equals(Arrays.asList(wildcardType.getLowerBounds())) || !this.b.equals(Arrays.asList(wildcardType.getUpperBounds()))) {
                return false;
            }
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return j.c(this.a);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return j.c(this.b);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder sb = new StringBuilder("?");
            UnmodifiableIterator<Type> it = this.a.mo99iterator();
            while (it.hasNext()) {
                sb.append(" super ");
                sb.append(e.e.c(it.next()));
            }
            ImmutableList<Type> immutableList = this.b;
            Function<Type, String> function = j.a;
            for (Type type : Iterables.filter(immutableList, Predicates.not(Predicates.equalTo(Object.class)))) {
                sb.append(" extends ");
                sb.append(e.e.c(type));
            }
            return sb.toString();
        }
    }

    public static Type a(Type[] typeArr) {
        for (Type type : typeArr) {
            Type d2 = d(type);
            if (d2 != null) {
                if (d2 instanceof Class) {
                    Class cls = (Class) d2;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return new C0076j(new Type[0], new Type[]{d2});
            }
        }
        return null;
    }

    public static void b(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                Preconditions.checkArgument(!cls.isPrimitive(), "Primitive type '%s' used as %s", cls, str);
            }
        }
    }

    public static Type[] c(Collection collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    @NullableDecl
    public static Type d(Type type) {
        Preconditions.checkNotNull(type);
        AtomicReference atomicReference = new AtomicReference();
        new b(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    public static Type e(Type type) {
        if (!(type instanceof WildcardType)) {
            return e.e.b(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Preconditions.checkArgument(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return new C0076j(new Type[]{e(lowerBounds[0])}, new Type[]{Object.class});
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        Preconditions.checkArgument(upperBounds.length == 1, "Wildcard should have only one upper bound.");
        return new C0076j(new Type[0], new Type[]{e(upperBounds[0])});
    }

    public static <D extends GenericDeclaration> TypeVariable<D> f(D d2, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return (TypeVariable) Reflection.newProxy(TypeVariable.class, new i(new h(d2, str, typeArr)));
    }

    public static ParameterizedType g(@NullableDecl Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return new g(c.c.a(cls), cls, typeArr);
        }
        Preconditions.checkNotNull(typeArr);
        Preconditions.checkArgument(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new g(type, cls, typeArr);
    }

    public static String h(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
