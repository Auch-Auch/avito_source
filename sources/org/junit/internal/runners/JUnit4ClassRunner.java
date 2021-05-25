package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
@Deprecated
public class JUnit4ClassRunner extends Runner implements Filterable, Sortable {
    public final List<Method> a = getTestMethods();
    public TestClass b;

    public class a implements Runnable {
        public final /* synthetic */ RunNotifier a;

        public a(RunNotifier runNotifier) {
            this.a = runNotifier;
        }

        @Override // java.lang.Runnable
        public void run() {
            JUnit4ClassRunner.this.runMethods(this.a);
        }
    }

    public class b implements Comparator<Method> {
        public final /* synthetic */ Sorter a;

        public b(Sorter sorter) {
            this.a = sorter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Method method, Method method2) {
            return this.a.compare(JUnit4ClassRunner.this.methodDescription(method), JUnit4ClassRunner.this.methodDescription(method2));
        }
    }

    public JUnit4ClassRunner(Class<?> cls) throws InitializationError {
        this.b = new TestClass(cls);
        validate();
    }

    public Annotation[] classAnnotations() {
        return this.b.getJavaClass().getAnnotations();
    }

    public Object createTest() throws Exception {
        return getTestClass().getConstructor().newInstance(new Object[0]);
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        Iterator<Method> it = this.a.iterator();
        while (it.hasNext()) {
            if (!filter.shouldRun(methodDescription(it.next()))) {
                it.remove();
            }
        }
        if (this.a.isEmpty()) {
            throw new NoTestsRemainException();
        }
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        Description createSuiteDescription = Description.createSuiteDescription(getName(), classAnnotations());
        for (Method method : this.a) {
            createSuiteDescription.addChild(methodDescription(method));
        }
        return createSuiteDescription;
    }

    public String getName() {
        return getTestClass().getName();
    }

    public TestClass getTestClass() {
        return this.b;
    }

    public List<Method> getTestMethods() {
        return this.b.getTestMethods();
    }

    public void invokeTestMethod(Method method, RunNotifier runNotifier) {
        Description methodDescription = methodDescription(method);
        try {
            new MethodRoadie(createTest(), wrapMethod(method), runNotifier, methodDescription).run();
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            runNotifier.fireTestStarted(methodDescription);
            runNotifier.fireTestFailure(new Failure(methodDescription, cause));
            runNotifier.fireTestFinished(methodDescription);
        } catch (Exception e2) {
            runNotifier.fireTestStarted(methodDescription);
            runNotifier.fireTestFailure(new Failure(methodDescription, e2));
            runNotifier.fireTestFinished(methodDescription);
        }
    }

    public Description methodDescription(Method method) {
        return Description.createTestDescription(getTestClass().getJavaClass(), testName(method), testAnnotations(method));
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        new ClassRoadie(runNotifier, this.b, getDescription(), new a(runNotifier)).runProtected();
    }

    public void runMethods(RunNotifier runNotifier) {
        for (Method method : this.a) {
            invokeTestMethod(method, runNotifier);
        }
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        Collections.sort(this.a, new b(sorter));
    }

    public Annotation[] testAnnotations(Method method) {
        return method.getAnnotations();
    }

    public String testName(Method method) {
        return method.getName();
    }

    public void validate() throws InitializationError {
        MethodValidator methodValidator = new MethodValidator(this.b);
        methodValidator.validateMethodsForDefaultRunner();
        methodValidator.assertValid();
    }

    public TestMethod wrapMethod(Method method) {
        return new TestMethod(method, this.b);
    }
}
