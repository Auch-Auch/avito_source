package com.google.common.reflect;

import a2.j.d.k.j;
import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public abstract class Invokable<T, R> extends a2.j.d.k.a implements GenericDeclaration {

    public static class a<T> extends Invokable<T, T> {
        public final Constructor<?> c;

        public a(Constructor<?> constructor) {
            super(constructor);
            this.c = constructor;
        }

        @Override // com.google.common.reflect.Invokable
        public Type[] a() {
            return this.c.getGenericExceptionTypes();
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // com.google.common.reflect.Invokable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.reflect.Type[] b() {
            /*
                r6 = this;
                java.lang.reflect.Constructor<?> r0 = r6.c
                java.lang.reflect.Type[] r0 = r0.getGenericParameterTypes()
                int r1 = r0.length
                if (r1 <= 0) goto L_0x005a
                java.lang.reflect.Constructor<?> r1 = r6.c
                java.lang.Class r1 = r1.getDeclaringClass()
                java.lang.reflect.Constructor r2 = r1.getEnclosingConstructor()
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L_0x0018
                goto L_0x0038
            L_0x0018:
                java.lang.reflect.Method r2 = r1.getEnclosingMethod()
                if (r2 == 0) goto L_0x0028
                int r1 = r2.getModifiers()
                boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
                r1 = r1 ^ r4
                goto L_0x003b
            L_0x0028:
                java.lang.Class r2 = r1.getEnclosingClass()
                if (r2 == 0) goto L_0x003a
                int r1 = r1.getModifiers()
                boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
                if (r1 != 0) goto L_0x003a
            L_0x0038:
                r1 = 1
                goto L_0x003b
            L_0x003a:
                r1 = 0
            L_0x003b:
                if (r1 == 0) goto L_0x005a
                java.lang.reflect.Constructor<?> r1 = r6.c
                java.lang.Class[] r1 = r1.getParameterTypes()
                int r2 = r0.length
                int r5 = r1.length
                if (r2 != r5) goto L_0x005a
                r1 = r1[r3]
                java.lang.Class r2 = r6.getDeclaringClass()
                java.lang.Class r2 = r2.getEnclosingClass()
                if (r1 != r2) goto L_0x005a
                int r1 = r0.length
                java.lang.Object[] r0 = java.util.Arrays.copyOfRange(r0, r4, r1)
                java.lang.reflect.Type[] r0 = (java.lang.reflect.Type[]) r0
            L_0x005a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.reflect.Invokable.a.b():java.lang.reflect.Type[]");
        }

        @Override // com.google.common.reflect.Invokable
        public Type c() {
            Class<? super T> declaringClass = getDeclaringClass();
            TypeVariable<Class<? super T>>[] typeParameters = declaringClass.getTypeParameters();
            if (typeParameters.length <= 0) {
                return declaringClass;
            }
            Function<Type, String> function = j.a;
            return new j.g(j.c.c.a(declaringClass), declaringClass, typeParameters);
        }

        @Override // com.google.common.reflect.Invokable
        public final Annotation[][] d() {
            return this.c.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.Invokable
        public final Object e(@NullableDecl Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            try {
                return this.c.newInstance(objArr);
            } catch (InstantiationException e) {
                throw new RuntimeException(this.c + " failed.", e);
            }
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.c.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[(typeParameters.length + typeParameters2.length)];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return false;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.c.isVarArgs();
        }
    }

    public static class b<T> extends Invokable<T, Object> {
        public final Method c;

        public b(Method method) {
            super(method);
            this.c = method;
        }

        @Override // com.google.common.reflect.Invokable
        public Type[] a() {
            return this.c.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public Type[] b() {
            return this.c.getGenericParameterTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public Type c() {
            return this.c.getGenericReturnType();
        }

        @Override // com.google.common.reflect.Invokable
        public final Annotation[][] d() {
            return this.c.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.Invokable
        public final Object e(@NullableDecl Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            return this.c.invoke(obj, objArr);
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.c.getTypeParameters();
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return !isFinal() && !isPrivate() && !isStatic() && !Modifier.isFinal(getDeclaringClass().getModifiers());
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.c.isVarArgs();
        }
    }

    public <M extends AccessibleObject & Member> Invokable(M m) {
        super(m);
    }

    public static Invokable<?, Object> from(Method method) {
        return new b(method);
    }

    public abstract Type[] a();

    public abstract Type[] b();

    public abstract Type c();

    public abstract Annotation[][] d();

    public abstract Object e(@NullableDecl Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException;

    @Override // a2.j.d.k.a, java.lang.Object
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // a2.j.d.k.a, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) super.getDeclaringClass();
    }

    public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : a()) {
            builder.add((ImmutableList.Builder) TypeToken.of(type));
        }
        return builder.build();
    }

    @Override // a2.j.d.k.a
    public TypeToken<T> getOwnerType() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    public final ImmutableList<Parameter> getParameters() {
        Type[] b2 = b();
        Annotation[][] d = d();
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < b2.length; i++) {
            builder.add((ImmutableList.Builder) new Parameter(this, i, TypeToken.of(b2[i]), d[i]));
        }
        return builder.build();
    }

    public final TypeToken<? extends R> getReturnType() {
        return (TypeToken<? extends R>) TypeToken.of(c());
    }

    @Override // a2.j.d.k.a, java.lang.Object
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @CanIgnoreReturnValue
    public final R invoke(@NullableDecl T t, Object... objArr) throws InvocationTargetException, IllegalAccessException {
        return (R) e(t, (Object[]) Preconditions.checkNotNull(objArr));
    }

    public abstract boolean isOverridable();

    public abstract boolean isVarArgs();

    public final <R1 extends R> Invokable<T, R1> returning(Class<R1> cls) {
        return returning(TypeToken.of((Class) cls));
    }

    @Override // a2.j.d.k.a, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <T> Invokable<T, T> from(Constructor<T> constructor) {
        return new a(constructor);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.reflect.Invokable<T, R> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> typeToken) {
        if (typeToken.isSupertypeOf(getReturnType())) {
            return this;
        }
        StringBuilder L = a2.b.a.a.a.L("Invokable is known to return ");
        L.append(getReturnType());
        L.append(", not ");
        L.append(typeToken);
        throw new IllegalArgumentException(L.toString());
    }
}
