package org.junit.internal.runners;

import a2.b.a.a.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
@Deprecated
public class MethodValidator {
    public final List<Throwable> a = new ArrayList();
    public TestClass b;

    public MethodValidator(TestClass testClass) {
        this.b = testClass;
    }

    public final void a(Class<? extends Annotation> cls, boolean z) {
        for (Method method : this.b.getAnnotatedMethods(cls)) {
            if (Modifier.isStatic(method.getModifiers()) != z) {
                String str = z ? "should" : "should not";
                List<Throwable> list = this.a;
                StringBuilder L = a.L("Method ");
                L.append(method.getName());
                L.append("() ");
                L.append(str);
                L.append(" be static");
                list.add(new Exception(L.toString()));
            }
            if (!Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
                List<Throwable> list2 = this.a;
                StringBuilder L2 = a.L("Class ");
                L2.append(method.getDeclaringClass().getName());
                L2.append(" should be public");
                list2.add(new Exception(L2.toString()));
            }
            if (!Modifier.isPublic(method.getModifiers())) {
                List<Throwable> list3 = this.a;
                StringBuilder L3 = a.L("Method ");
                L3.append(method.getName());
                L3.append(" should be public");
                list3.add(new Exception(L3.toString()));
            }
            if (method.getReturnType() != Void.TYPE) {
                List<Throwable> list4 = this.a;
                StringBuilder L4 = a.L("Method ");
                L4.append(method.getName());
                L4.append("should have a return type of void");
                list4.add(new Exception(L4.toString()));
            }
            if (method.getParameterTypes().length != 0) {
                List<Throwable> list5 = this.a;
                StringBuilder L5 = a.L("Method ");
                L5.append(method.getName());
                L5.append(" should have no parameters");
                list5.add(new Exception(L5.toString()));
            }
        }
    }

    public void assertValid() throws InitializationError {
        if (!this.a.isEmpty()) {
            throw new InitializationError(this.a);
        }
    }

    public void validateInstanceMethods() {
        a(After.class, false);
        a(Before.class, false);
        a(Test.class, false);
        if (this.b.getAnnotatedMethods(Test.class).size() == 0) {
            this.a.add(new Exception("No runnable methods"));
        }
    }

    public List<Throwable> validateMethodsForDefaultRunner() {
        validateNoArgConstructor();
        validateStaticMethods();
        validateInstanceMethods();
        return this.a;
    }

    public void validateNoArgConstructor() {
        try {
            this.b.getConstructor();
        } catch (Exception e) {
            this.a.add(new Exception("Test class should have public zero-argument constructor", e));
        }
    }

    public void validateStaticMethods() {
        a(BeforeClass.class, true);
        a(AfterClass.class, true);
    }
}
