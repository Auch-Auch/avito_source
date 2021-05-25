package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import org.junit.internal.runners.model.ReflectiveCallable;
public class FrameworkMethod extends FrameworkMember<FrameworkMethod> {
    public final Method a;

    public class a extends ReflectiveCallable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ Object[] b;

        public a(Object obj, Object[] objArr) {
            this.a = obj;
            this.b = objArr;
        }

        @Override // org.junit.internal.runners.model.ReflectiveCallable
        public Object runReflectiveCall() throws Throwable {
            return FrameworkMethod.this.a.invoke(this.a, this.b);
        }
    }

    public FrameworkMethod(Method method) {
        Objects.requireNonNull(method, "FrameworkMethod cannot be created without an underlying method.");
        this.a = method;
        if (isPublic()) {
            try {
                method.setAccessible(true);
            } catch (SecurityException unused) {
            }
        }
    }

    @Override // org.junit.runners.model.FrameworkMember
    public boolean a() {
        return this.a.isBridge();
    }

    public final Class<?>[] b() {
        return this.a.getParameterTypes();
    }

    public boolean equals(Object obj) {
        if (!FrameworkMethod.class.isInstance(obj)) {
            return false;
        }
        return ((FrameworkMethod) obj).a.equals(this.a);
    }

    @Override // org.junit.runners.model.Annotatable
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.a.getAnnotation(cls);
    }

    @Override // org.junit.runners.model.Annotatable
    public Annotation[] getAnnotations() {
        return this.a.getAnnotations();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public Class<?> getDeclaringClass() {
        return this.a.getDeclaringClass();
    }

    public Method getMethod() {
        return this.a;
    }

    @Override // org.junit.runners.model.FrameworkMember
    public int getModifiers() {
        return this.a.getModifiers();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public String getName() {
        return this.a.getName();
    }

    public Class<?> getReturnType() {
        return this.a.getReturnType();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public Class<?> getType() {
        return getReturnType();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Object invokeExplosively(Object obj, Object... objArr) throws Throwable {
        return new a(obj, objArr).run();
    }

    @Deprecated
    public boolean producesType(Type type) {
        return b().length == 0 && (type instanceof Class) && ((Class) type).isAssignableFrom(this.a.getReturnType());
    }

    public String toString() {
        return this.a.toString();
    }

    public void validateNoTypeParametersOnArgs(List<Throwable> list) {
        Method method = this.a;
        x6.c.e.d.a aVar = new x6.c.e.d.a(method);
        for (Type type : method.getGenericParameterTypes()) {
            aVar.a(type, list);
        }
    }

    public void validatePublicVoid(boolean z, List<Throwable> list) {
        if (isStatic() != z) {
            String str = z ? "should" : "should not";
            StringBuilder L = a2.b.a.a.a.L("Method ");
            L.append(this.a.getName());
            L.append("() ");
            L.append(str);
            L.append(" be static");
            list.add(new Exception(L.toString()));
        }
        if (!isPublic()) {
            StringBuilder L2 = a2.b.a.a.a.L("Method ");
            L2.append(this.a.getName());
            L2.append("() should be public");
            list.add(new Exception(L2.toString()));
        }
        if (this.a.getReturnType() != Void.TYPE) {
            StringBuilder L3 = a2.b.a.a.a.L("Method ");
            L3.append(this.a.getName());
            L3.append("() should be void");
            list.add(new Exception(L3.toString()));
        }
    }

    public void validatePublicVoidNoArg(boolean z, List<Throwable> list) {
        validatePublicVoid(z, list);
        if (this.a.getParameterTypes().length != 0) {
            StringBuilder L = a2.b.a.a.a.L("Method ");
            L.append(this.a.getName());
            L.append(" should have no parameters");
            list.add(new Exception(L.toString()));
        }
    }

    public boolean isShadowedBy(FrameworkMethod frameworkMethod) {
        if (!(frameworkMethod.getName().equals(getName()) && frameworkMethod.b().length == b().length)) {
            return false;
        }
        for (int i = 0; i < frameworkMethod.b().length; i++) {
            if (!frameworkMethod.b()[i].equals(b()[i])) {
                return false;
            }
        }
        return true;
    }
}
