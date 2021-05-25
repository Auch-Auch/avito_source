package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.After;
import org.junit.Before;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import x6.c.b.e.b;
@Deprecated
public class MethodRoadie {
    public final Object a;
    public final RunNotifier b;
    public final Description c;
    public TestMethod d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MethodRoadie.this.runTestMethod();
        }
    }

    public MethodRoadie(Object obj, TestMethod testMethod, RunNotifier runNotifier, Description description) {
        this.a = obj;
        this.b = runNotifier;
        this.c = description;
        this.d = testMethod;
    }

    public final void a() {
        for (Method method : this.d.b.getAnnotatedMethods(After.class)) {
            try {
                method.invoke(this.a, new Object[0]);
            } catch (InvocationTargetException e) {
                addFailure(e.getTargetException());
            } catch (Throwable th) {
                addFailure(th);
            }
        }
    }

    public void addFailure(Throwable th) {
        this.b.fireTestFailure(new Failure(this.c, th));
    }

    public final void b() throws x6.c.b.e.a {
        try {
            for (Method method : this.d.b.getAnnotatedMethods(Before.class)) {
                method.invoke(this.a, new Object[0]);
            }
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (AssumptionViolatedException unused) {
            throw new x6.c.b.e.a();
        } catch (Throwable th) {
            addFailure(th);
            throw new x6.c.b.e.a();
        }
    }

    public void run() {
        if (this.d.isIgnored()) {
            this.b.fireTestIgnored(this.c);
            return;
        }
        this.b.fireTestStarted(this.c);
        try {
            long timeout = this.d.getTimeout();
            if (timeout > 0) {
                runBeforesThenTestThenAfters(new b(this, timeout));
            } else {
                runTest();
            }
        } finally {
            this.b.fireTestFinished(this.c);
        }
    }

    public void runBeforesThenTestThenAfters(Runnable runnable) {
        try {
            b();
            runnable.run();
        } catch (x6.c.b.e.a unused) {
        } catch (Exception unused2) {
            throw new RuntimeException("test should never throw an exception to this level");
        } catch (Throwable th) {
            a();
            throw th;
        }
        a();
    }

    public void runTest() {
        runBeforesThenTestThenAfters(new a());
    }

    public void runTestMethod() {
        boolean z = false;
        try {
            this.d.invoke(this.a);
            if (this.d.getExpectedException() != null) {
                addFailure(new AssertionError("Expected exception: " + this.d.getExpectedException().getName()));
            }
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (!(targetException instanceof AssumptionViolatedException)) {
                if (this.d.getExpectedException() != null) {
                    z = true;
                }
                if (!z) {
                    addFailure(targetException);
                } else if (!this.d.getExpectedException().isAssignableFrom(targetException.getClass())) {
                    StringBuilder L = a2.b.a.a.a.L("Unexpected exception, expected<");
                    L.append(this.d.getExpectedException().getName());
                    L.append("> but was<");
                    L.append(targetException.getClass().getName());
                    L.append(">");
                    addFailure(new Exception(L.toString(), targetException));
                }
            }
        } catch (Throwable th) {
            addFailure(th);
        }
    }
}
