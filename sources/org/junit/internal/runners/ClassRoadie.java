package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import x6.c.b.e.a;
@Deprecated
public class ClassRoadie {
    public RunNotifier a;
    public TestClass b;
    public Description c;
    public final Runnable d;

    public ClassRoadie(RunNotifier runNotifier, TestClass testClass, Description description, Runnable runnable) {
        this.a = runNotifier;
        this.b = testClass;
        this.c = description;
        this.d = runnable;
    }

    public final void a() {
        TestClass testClass = this.b;
        Objects.requireNonNull(testClass);
        for (Method method : testClass.getAnnotatedMethods(AfterClass.class)) {
            try {
                method.invoke(null, new Object[0]);
            } catch (InvocationTargetException e) {
                addFailure(e.getTargetException());
            } catch (Throwable th) {
                addFailure(th);
            }
        }
    }

    public void addFailure(Throwable th) {
        this.a.fireTestFailure(new Failure(this.c, th));
    }

    public final void b() throws a {
        try {
            TestClass testClass = this.b;
            Objects.requireNonNull(testClass);
            for (Method method : testClass.getAnnotatedMethods(BeforeClass.class)) {
                method.invoke(null, new Object[0]);
            }
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (AssumptionViolatedException unused) {
            throw new a();
        } catch (Throwable th) {
            addFailure(th);
            throw new a();
        }
    }

    public void runProtected() {
        try {
            b();
            runUnprotected();
        } catch (a unused) {
        } catch (Throwable th) {
            a();
            throw th;
        }
        a();
    }

    public void runUnprotected() {
        this.d.run();
    }
}
